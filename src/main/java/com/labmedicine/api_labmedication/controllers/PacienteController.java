package com.labmedicine.api_labmedication.controllers;

import com.labmedicine.api_labmedication.dtos.PacienteDTO;
import com.labmedicine.api_labmedication.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> novoPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) {
        pacienteDTO = pacienteService.criarPaciente(pacienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pacienteDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(pacienteDTO);
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> listarPacientes(Pageable pageable) {
        Page<PacienteDTO>  pacienteDTO= pacienteService.listarPacientes(pageable);
        return ResponseEntity.ok(pacienteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> pacienteById(@PathVariable Long id) {
        PacienteDTO pacienteDTO = pacienteService.buscarById(id);
        return ResponseEntity.ok(pacienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable Long id, @Valid @RequestBody PacienteDTO pacienteDTO) {
        pacienteDTO = pacienteService.atualizarPaciente(id, pacienteDTO);
        return ResponseEntity.ok(pacienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}