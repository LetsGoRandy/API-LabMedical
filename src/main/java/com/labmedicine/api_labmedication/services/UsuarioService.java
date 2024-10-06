package com.labmedicine.api_labmedication.services;

import com.labmedicine.api_labmedication.dtos.UsuarioDTO;
import com.labmedicine.api_labmedication.models.Usuario;
import com.labmedicine.api_labmedication.repositories.UsuarioRepository;
import com.labmedicine.api_labmedication.services.exceptions.DataBaseException;
import com.labmedicine.api_labmedication.services.exceptions.InvalidModificationException;
import com.labmedicine.api_labmedication.services.exceptions.ResourceAlreadyExistsException;
import com.labmedicine.api_labmedication.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public UsuarioDTO buscarById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Usuário não encontrado com id: " + id)
        );
        return new UsuarioDTO(usuario);
    }

    @Transactional(readOnly = true)
    public Page<UsuarioDTO> listarUsuarios(Pageable pageable) {
        Page<Usuario> result = usuarioRepository.findAll(pageable);
        return result.map(UsuarioDTO::new);
    }

    @Transactional
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {

        if (usuarioRepository.existsByCpf(usuarioDTO.getCpf())) {
            throw new ResourceAlreadyExistsException("O CPF informado já está cadastrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
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

        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(Long id, @Valid UsuarioDTO usuarioDTO) {
        // Buscar o usuário existente pelo ID
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado."));

        // Verificar se o CPF foi alterado
        if (!usuarioExistente.getCpf().equals(usuarioDTO.getCpf())) {
            throw new InvalidModificationException("Não é permitido alterar o CPF.");
        }

        // Verificar se o RG foi alterado
        if (!usuarioExistente.getRg().equals(usuarioDTO.getRg())) {
            throw new InvalidModificationException("Não é permitido alterar o RG.");
        }

        usuarioExistente.setNomeCompleto(usuarioDTO.getNomeCompleto());
        usuarioExistente.setGenero(usuarioDTO.getGenero());
        usuarioExistente.setDataNascimento(usuarioDTO.getDataNascimento());
        usuarioExistente.setTelefone(usuarioDTO.getTelefone());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setNaturalidade(usuarioDTO.getNaturalidade());
        usuarioExistente.setCrm(usuarioDTO.getCrm());
        usuarioExistente.setEstadoCivil(usuarioDTO.getEstadoCivil());
        usuarioExistente.setEspecializacaoClinica(usuarioDTO.getEspecializacaoClinica());

        Usuario usuarioAtualizado = usuarioRepository.save(usuarioExistente);
        return new UsuarioDTO(usuarioAtualizado);
    }

    @Transactional
    public UsuarioDTO atualizarSenha(Long id, UsuarioDTO usuarioDTO) {
        // Buscar o usuário existente pelo ID
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID: " + id + " não encontrado."));

        usuarioExistente.setSenha(usuarioDTO.getSenha());

        Usuario usuarioAtualizado = usuarioRepository.save(usuarioExistente);
        return new UsuarioDTO(usuarioAtualizado);

//        TODO: corrigir response Status code 400(Bad Request) dados inválidos.
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário com ID: " + id + " não encontrado.");
        }
        try {
            usuarioRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Não é possível deletar usuário com medicação prescrita");
        }
    }



}
