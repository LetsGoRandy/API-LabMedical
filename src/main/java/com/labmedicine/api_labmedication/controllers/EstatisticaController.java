package com.labmedicine.api_labmedication.controllers;

import com.labmedicine.api_labmedication.dtos.EstatisticaDTO;
import com.labmedicine.api_labmedication.services.EstatisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatisticas")
@RequiredArgsConstructor
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> listarEstatisticas() {
        EstatisticaDTO estatisticas = estatisticaService.listarEstatisticas();
        return ResponseEntity.ok(estatisticas);
    }
}
