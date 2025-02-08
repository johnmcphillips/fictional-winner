package com.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/proxy")
@Tag(name = "Proxy Controller", description = "Handles proxy requests to external APIs")
public class ProxyController {

    private final RestTemplate restTemplate;

    @Autowired
    public ProxyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // GET Example
    @Operation(summary = "Fetch your IP", description = "This method performs a GET request to an external API.")
    @GetMapping("/external")
    public String callExternalAPI() {
        String externalUrl = "https://icanhazip.com";
        String response = restTemplate.getForObject(externalUrl, String.class);
        return response;
    }
    // POST Example
    @Operation(summary = "Fetch data from external API via POST", description = "This method calls an external API with a POST request and returns the response.")
    @PostMapping("/external")
    public String postToExternalAPI(@RequestBody @Schema(description = "Request body for external API", example = "{\"key\":\"value\"}") ExternalRequest request) {
        String externalUrl = "https://api.example.com/data";
        return restTemplate.postForObject(externalUrl, request, String.class);
    }

    // Model class for request body
    public static class ExternalRequest {
        private String key;
        
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}