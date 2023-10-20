package com.klmj.ridi_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.klmj.ridi_api.persistence.entity.HistorialDispositivo;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        //Estado estado = new Estado(null, "YUCATAN");
        RestTemplate restTemplate = new RestTemplate();

        // URL del controlador donde deseas enviar la solicitud POST
        String url = "http://localhost:8080/historial_dispositivos"; // Ajusta la URL según tu configuración

        // Crear un objeto que represente el cuerpo de la solicitud (objeto JSON)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String entity = "{\"primaryKey\":{\"dispositivo\":{\"id\":\"VIO:91na12121\"},\"cns\":1}," +
                "\"locacion\":{\"id\":1}," +
                "\"status\":\"CONECTADO\"," +
                "\"fechaHora\":\"2023-09-27T00:00:00\"," +
                "\"ipAddress\":\"192.168.1.1\"," +
                "\"source\":\"windows event log\"}";
        //variables.put("id_estado", 1L);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule()); // Registrar el módulo JavaTime


            HistorialDispositivo historialDispositivo = objectMapper.readValue(entity, HistorialDispositivo.class);

            // El objeto se ha creado correctamente
            System.out.println("Objeto HistorialDispositivo creado: " + historialDispositivo);

        } catch (Exception r) {
            System.out.println(r.getMessage());
        }

        //HttpEntity<Estado> request = new HttpEntity<>(estado, headers);
        HttpEntity<String> request = new HttpEntity<>(entity, headers);
        //HttpEntity<Map<String, String>> request = new HttpEntity<>(Map.of("nombre", "CHIAPAS"), headers);

        // Enviar la solicitud POST
        //ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        // Leer todas las entidades con GET
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        //ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, entity);

        System.out.println("Respuesta del servidor: " + response.getBody());
    }
}

