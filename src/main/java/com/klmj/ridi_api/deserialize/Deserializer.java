package com.klmj.ridi_api.deserialize;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.klmj.ridi_api.persistence.entity.location.Estado;
import com.klmj.ridi_api.persistence.entity.location.Municipio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Deserializer {
    public static void main(String[] args) {
        String apiBasePath = "http://localhost:8080";
        String basePath = Objects.requireNonNull(Deserializer.class.getClassLoader().getResource("data_master")).getPath();

        try {
            // Acceder al archivo en la unidad C
            File fileM = new File(basePath + "\\estados-municipios.json");
            File fileE = new File(basePath + "\\estados.json");

            //imprimimos el json
            /*Scanner scanner = new Scanner(fileM);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();*/

            ObjectMapper objectMapper = new ObjectMapper();
            EstadosMunicipio municipioPrueba = objectMapper.readValue(fileM, EstadosMunicipio.class);

            List<Estado> estados = objectMapper.readValue(fileE, new TypeReference<>() {});
            List<Municipio> municipios = new ArrayList<>();

            estados.forEach(System.out::println);

            municipioPrueba.Chiapas.forEach(m -> {
                var est = estados.stream().reduce((e, a) -> (e.getNombre().equals("CHIAPAS")) ? e : a).orElse(new Estado());

                municipios.add(new Municipio(null, m, est));
            });

            //System.out.println(objectMapper.writeValueAsString(municipios));

        } catch (Exception e) {
            System.out.println("El archivo estados-municipios.json no se pudo encontrar: " +
                    e.getMessage());
        }
    }
}
