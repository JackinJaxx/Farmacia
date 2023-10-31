package com.klmj.ridi_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.klmj.ridi_api.persistence.entity.location.Estado;
import com.klmj.ridi_api.persistence.entity.location.Municipio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // Ruta del archivo en la unidad C
        String filePath = "D:\\GitHub\\RIDI_API\\src\\main\\resources\\data_master\\";

        try {
            // Acceder al archivo en la unidad C
            File fileM = new File(filePath + "estados-municipios.json");
            File fileE = new File(filePath + "estados.json");
            Scanner scanner = new Scanner(fileM);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();

            ObjectMapper objectMapper = new ObjectMapper();
            MunicipioPrueba municipioPrueba = objectMapper.readValue(fileM, MunicipioPrueba.class);
            List<Estado> estados = objectMapper.readValue(fileE, new TypeReference<List<Estado>>() {});

            List<Municipio> municipios = new ArrayList<>();

            municipioPrueba.Chiapas.forEach(m -> {
                var est = estados.stream().reduce((e, a) -> (e.getNombre().equals("CHIAPAS")) ? e : a).orElse(new Estado());

                municipios.add(new Municipio(null, m, est));
            });

            System.out.println(objectMapper.writeValueAsString(municipios));


        } catch (Exception e) {
            System.out.println("El archivo no se pudo encontrar: " + e.getMessage());
        }
    }
}

