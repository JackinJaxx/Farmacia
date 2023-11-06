package com.klmj.ridi_api.deserialize;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.klmj.ridi_api.persistence.entity.location.Estado;
import com.klmj.ridi_api.persistence.entity.location.Municipio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Deserializa los estados y municipios en los documentos estados.json y estados-municipios.json en
 * la carpeta de recursos de la API; al final, hace un POST insertándolos a la base de datos.
 */
public class Deserializer {
    /**
     * Es el estado del que obtendremos los municipios.
     */
    public static final String nombreEstado = "CHIAPAS";

    public static void printFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            System.out.println(data);
        }
        System.out.println();
        scanner.close();
    }

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        String basePath = Objects.requireNonNull(Deserializer.class.getClassLoader().getResource("data_master")).getPath();
        File fileM = new File(basePath + "\\estados-municipios.json");
        File fileE = new File(basePath + "\\estados.json");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EstadosMunicipio municipioPrueba = objectMapper.readValue(fileM, EstadosMunicipio.class);

            printFile(fileE);
            printFile(fileM);

            List<Estado> estados = objectMapper.readValue(fileE, new TypeReference<>() {});
            List<Municipio> municipios = new ArrayList<>();

            municipioPrueba.Chiapas.forEach(m -> {
                var est = estados
                        .stream()
                        .reduce((e, a) -> (e.getNombre().equals(nombreEstado)) ? e : a);

                est.ifPresent(estado -> municipios.add(new Municipio(null, m, estado)));
            });

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/municipios/todo"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper
                            .writeValueAsString(municipios)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

        } catch (FileNotFoundException e) {
            System.out.println("El archivo estados-municipios.json no se pudo encontrar: " +
                    e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.out.println("No se pudo establecer una conexión con la API porque " +
                    e.getMessage());
        }
    }
}
