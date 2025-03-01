package com.rastreiofacil.rastreamento_correios.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CorreiosService {

    private final RestTemplate restTemplate;


    public CorreiosService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTrackingInfo(String trackingCode) {
        String url = "https://api-correios.herokuapp.com/track/" + trackingCode;
        return restTemplate.getForObject( url + trackingCode, String.class);
    }
}
