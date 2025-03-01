package com.rastreiofacil.rastreamento_correios.service;


import com.rastreiofacil.rastreamento_correios.model.TrackingCode;
import com.rastreiofacil.rastreamento_correios.repository.TrackingCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingCodeService {

    @Autowired
    private TrackingCodeRepository trackingCodeRepository;

    public TrackingCode saveTrackingCode(TrackingCode trackingCode) {
        return trackingCodeRepository.save(trackingCode);
    }

    public List<TrackingCode> findAll() {
        return trackingCodeRepository.findAll();
    }
}
