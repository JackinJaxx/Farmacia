package com.klmj.ridi_api;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        //Estado estado = new Estado(null, "YUCATAN");
        RestTemplate restTemplate = new RestTemplate();

        // URL del controlador donde deseas enviar la solicitud POST
        String url = "http://localhost:8080/dispotivos/computadoras/{id}"; // Ajusta la URL según tu configuración

        // Crear un objeto que represente el cuerpo de la solicitud (objeto JSON)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String entity = "{\"dispositivoID\":{\"serial\":1}}";
        //variables.put("id_estado", 1L);

        /*try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule()); // Registrar el módulo JavaTime


            HistorialComputadora historialComputadora = objectMapper.readValue(entity, HistorialComputadora.class);

            // El objeto se ha creado correctamente
            System.out.println("Objeto HistorialDispositivo creado: " + historialComputadora);

        } catch (Exception r) {
            System.out.println(r.getMessage());
        }*/

        //HttpEntity<Estado> request = new HttpEntity<>(estado, headers);
        HttpEntity<String> request = new HttpEntity<>(entity, headers);
        //HttpEntity<Map<String, String>> request = new HttpEntity<>(Map.of("nombre", "CHIAPAS"), headers);

        // Enviar la solicitud POST
        //ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        // Leer todas las entidades con GET
        restTemplate.delete(url, entity);
        //ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, entity);

        //System.out.println("Respuesta del servidor: " + response.getBody());
    }
}

