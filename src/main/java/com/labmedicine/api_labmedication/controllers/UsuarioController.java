package com.labmedicine.api_labmedication.controllers;

import com.labmedicine.api_labmedication.dtos.UsuarioDTO;
import com.labmedicine.api_labmedication.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> novoUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO){
        usuarioDTO = usuarioService.criarUsuario(usuarioDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuarioDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioDTO);
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> listarUsuarios(Pageable pageable) {
        Page<UsuarioDTO> usuariosDTO = usuarioService.listarUsuarios(pageable);
        return ResponseEntity.ok(usuariosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> usuarioById(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.buscarById(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id,@Valid @RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO = usuarioService.atualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<UsuarioDTO> atualizarSenha(@PathVariable Long id,@Valid @RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO = usuarioService.atualizarSenha(id, usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}