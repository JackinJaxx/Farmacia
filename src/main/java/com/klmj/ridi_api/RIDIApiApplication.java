package com.klmj.ridi_api;

import com.klmj.ridi_api.persistence.entity.Estado;
import com.klmj.ridi_api.persistence.entity.Municipio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RIDIApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RIDIApiApplication.class, args);

        // Crear una instancia de RestTemplate
        /*RestTemplate restTemplate = new RestTemplate();

        // URL del controlador donde deseas enviar la solicitud POST
        String url = "http://localhost:8080/controller/persistence/municipio/guardar"; // Ajusta la URL según tu configuración

        // Crear un objeto que represente el cuerpo de la solicitud (objeto JSON)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Municipio municipioToSave = new Municipio(null, "Lomas", new Estado(1L, "CHIAPAS"));

        HttpEntity<Municipio> request = new HttpEntity<>(municipioToSave, headers);

        // Enviar la solicitud POST
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        // Imprimir la respuesta
        System.out.println("Respuesta del servidor: " + response.getBody());*/
    }

}
