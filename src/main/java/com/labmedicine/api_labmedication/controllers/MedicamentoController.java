package com.labmedicine.api_labmedication.controllers;

import com.labmedicine.api_labmedication.dtos.MedicamentoDTO;
import com.labmedicine.api_labmedication.models.Medicamento;
import com.labmedicine.api_labmedication.services.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public ResponseEntity<MedicamentoDTO> novoMedicamento(@Valid @RequestBody MedicamentoDTO medicamentoDTO) {
        medicamentoDTO = medicamentoService.criarMedicamento(medicamentoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(medicamentoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(medicamentoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> atualizarMedicamento(@PathVariable Long id, @Valid @RequestBody MedicamentoDTO medicamentoDTO) {
        medicamentoDTO = medicamentoService.atualizarMedicamento(id, medicamentoDTO);
        return ResponseEntity.ok(medicamentoDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> atualizarParcialMedicamento(@PathVariable Long id, @Valid @RequestBody Map<String, Object> updates) {
        MedicamentoDTO medicamentoAtualizado = medicamentoService.atualizarParcialMedicamento(id, updates);
        return ResponseEntity.ok(medicamentoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> medicamentoById(@PathVariable Long id) {
        MedicamentoDTO medicamentoDTO = medicamentoService.buscaById(id);
        return ResponseEntity.ok(medicamentoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedicamento(@PathVariable Long id) {
        medicamentoService.deletarMedicamento(id);
        return ResponseEntity.noContent().build();
    }


}
