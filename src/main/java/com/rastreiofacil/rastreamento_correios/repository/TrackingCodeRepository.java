package com.rastreiofacil.rastreamento_correios.repository;

import com.rastreiofacil.rastreamento_correios.model.TrackingCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingCodeRepository extends JpaRepository<TrackingCode, Long> {
}
