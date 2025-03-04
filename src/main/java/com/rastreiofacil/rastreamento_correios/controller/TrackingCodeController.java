package com.rastreiofacil.rastreamento_correios.controller;

import com.rastreiofacil.rastreamento_correios.model.TrackingCode;
import com.rastreiofacil.rastreamento_correios.service.CorreiosService;
import com.rastreiofacil.rastreamento_correios.service.TrackingCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trackingCodes")
public class TrackingCodeController {

    @Autowired
    private TrackingCodeService trackingCodeService;

    @Autowired
    private CorreiosService correiosService;

    @PostMapping
    public TrackingCode createTrackingCode(@RequestBody TrackingCode trackingCode) {
        return trackingCodeService.saveTrackingCode(trackingCode);
    }

    @GetMapping
    public List<TrackingCode> getAllTrackingCodes() {
        return trackingCodeService.findAll();
    }

    @GetMapping("/{code}/info")
    public String getTrackingInfo(@PathVariable String code) {
        return correiosService.getTrackingInfo(code);
    }

}
