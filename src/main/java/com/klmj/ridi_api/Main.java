package com.klmj.ridi_api;

import com.klmj.ridi_api.persistence.entity.Estado;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Estado estado = new Estado(null, "YUCATAN");
        RestTemplate restTemplate = new RestTemplate();

        // URL del controlador donde deseas enviar la solicitud POST
        String url = "http://localhost:8080/estados/leer"; // Ajusta la URL según tu configuración

        // Crear un objeto que represente el cuerpo de la solicitud (objeto JSON)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String entity = "{\"nombre\":\"CHIAPAS\"}";
        //Map<String, Long> variables = new HashMap<>();
        //variables.put("id_estado", 1L);

        //HttpEntity<Estado> request = new HttpEntity<>(estado, headers);
        HttpEntity<String> request = new HttpEntity<>(entity, headers);
        //HttpEntity<Map<String, String>> request = new HttpEntity<>(Map.of("nombre", "CHIAPAS"), headers);

        // Enviar la solicitud POST
        //ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        // Leer todas las entidades con GET
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        //ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, variables);

        // Imprimir la respuesta
        System.out.println("Respuesta del servidor: " + response.getBody());
    }
}

