package com.rastreiofacil.rastreamento_correios.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CorreiosService {

    private final RestTemplate restTemplate;

    private final String user = "teste";
    private final String token = "1abcd00b2731640e886fb41a8a9671ad1434c599dbaa0a0de9a5aa619f29a83f";


    public CorreiosService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTrackingInfo(String trackingCode) {
        String url = "https://api.linketrack.com/track/json?user=" +user + "&token=" + token+ "&codigo="+trackingCode;
        int maxRetries = 3;
        int retryCount = 0;
        int delay = 5000;

        while (retryCount < maxRetries){
            try {
                return restTemplate.getForObject( url, String.class);
            } catch (HttpClientErrorException.TooManyRequests e) {
                retryCount++;
                if (retryCount >= maxRetries){
                    throw e;
                }
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw  new RuntimeException("Thread interrupted", ie);
                }
            }
        }

        throw new RuntimeException("Failed to get tracking info after " + maxRetries + " retries");
    }
}
