package com.labmedicine.api_labmedication.controllers;

import com.labmedicine.api_labmedication.dtos.EnderecoDTO;
import com.labmedicine.api_labmedication.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> novoEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        enderecoDTO = enderecoService.criarEndereco(enderecoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(enderecoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(enderecoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<EnderecoDTO>> listarEnderecos(Pageable pageable) {
        Page<EnderecoDTO> enderecosDTO = enderecoService.listarEnderecos(pageable);
        return ResponseEntity.ok(enderecosDTO);
    }
}
