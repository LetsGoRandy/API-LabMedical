package com.labmedicine.api_labmedication.services;

import com.labmedicine.api_labmedication.dtos.UsuarioDTO;
import com.labmedicine.api_labmedication.models.Usuario;
import com.labmedicine.api_labmedication.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNomeCompleto(usuarioDTO.getNomeCompleto());
        usuario.setGenero(usuarioDTO.getGenero());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setRg(usuarioDTO.getRg());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNaturalidade(usuarioDTO.getNaturalidade());
        usuario.setCrm(usuarioDTO.getCrm());
        usuario.setEstadoCivil(usuarioDTO.getEstadoCivil());
        usuario.setEspecializacaoClinica(usuarioDTO.getEspecializacaoClinica());
        usuario.setSenha(usuarioDTO.getSenha());

        usuarioRepository.save(usuario);
        return usuarioDTO;
    }


}
