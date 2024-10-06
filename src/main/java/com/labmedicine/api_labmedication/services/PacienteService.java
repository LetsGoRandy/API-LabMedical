package com.labmedicine.api_labmedication.services;

import com.labmedicine.api_labmedication.dtos.PacienteDTO;
import com.labmedicine.api_labmedication.models.Endereco;
import com.labmedicine.api_labmedication.models.Paciente;
import com.labmedicine.api_labmedication.repositories.EnderecoRepository;
import com.labmedicine.api_labmedication.repositories.PacienteRepository;
import com.labmedicine.api_labmedication.services.exceptions.DataBaseException;
import com.labmedicine.api_labmedication.services.exceptions.InvalidModificationException;
import com.labmedicine.api_labmedication.services.exceptions.ResourceAlreadyExistsException;
import com.labmedicine.api_labmedication.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    private final EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public PacienteDTO buscarById(Long id){
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Paciente não encontrado com o id " + id)
        );
        return new PacienteDTO(paciente);
    }

    @Transactional(readOnly = true)
    public Page<PacienteDTO> listarPacientes(Pageable pageable){
        Page<Paciente> result = pacienteRepository.findAll(pageable);
        return result.map(PacienteDTO::new);
//        TODO: prever query param opcional para filtrar o resultado da
//         consulta pelo nome do paciente.
    }

    @Transactional
    public PacienteDTO criarPaciente(PacienteDTO pacienteDTO){
        // Verificar se o ID do endereço é fornecido
        if (pacienteDTO.getEnderecoId() == null) {
            throw new IllegalArgumentException("ID do endereço é obrigatório");
        }
        Endereco endereco = enderecoRepository.findById(pacienteDTO.getEnderecoId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente com ID: " + pacienteDTO.getEnderecoId() + " não encontrado."));

        if (pacienteRepository.existsByCpf(pacienteDTO.getCpf())) {
            throw new ResourceAlreadyExistsException("O CPF informado já está cadastrado.");
        }

        Paciente paciente = getPaciente(pacienteDTO, endereco);

        paciente = pacienteRepository.save(paciente);
        return new PacienteDTO(paciente);
    }

    private static Paciente getPaciente(PacienteDTO pacienteDTO, Endereco endereco) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setNomeCompleto(pacienteDTO.getNomeCompleto());
        paciente.setGenero(pacienteDTO.getGenero());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setRg(pacienteDTO.getRg());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setNaturalidade(pacienteDTO.getNaturalidade());
        paciente.setEstadoCivil(pacienteDTO.getEstadoCivil());
        paciente.setContatoEmergencia(pacienteDTO.getContatoEmergencia());
        paciente.setCuidadosEspecificos(pacienteDTO.getCuidadosEspecificos());
        paciente.setAlergias(pacienteDTO.getAlergias());
        paciente.setConvenio(pacienteDTO.getConvenio());
        paciente.setNumeroConvenio(pacienteDTO.getNumeroConvenio());
        paciente.setValidadeConvenio(pacienteDTO.getValidadeConvenio());
        paciente.setEndereco(endereco);

        paciente = pacienteRepository.save(paciente);
        return new PacienteDTO(paciente);
    }

    @Transactional
    public PacienteDTO atualizarPaciente(Long id, PacienteDTO pacienteDTO){
        // Buscar o usuário existente pelo ID
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente com ID: " + id + " não encontrado."));

        // Verificar se o CPF foi alterado
        if (!paciente.getCpf().equals(pacienteDTO.getCpf())) {
            throw new InvalidModificationException("Não é permitido alterar o CPF.");
        }

        // Verificar se o RG foi alterado
        if (!paciente.getRg().equals(pacienteDTO.getRg())) {
            throw new InvalidModificationException("Não é permitido alterar o RG.");
        }

        paciente.setNomeCompleto(pacienteDTO.getNomeCompleto());
        paciente.setGenero(pacienteDTO.getGenero());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setNaturalidade(pacienteDTO.getNaturalidade());
        paciente.setEstadoCivil(pacienteDTO.getEstadoCivil());
        paciente.setContatoEmergencia(pacienteDTO.getContatoEmergencia());
        paciente.setCuidadosEspecificos(pacienteDTO.getCuidadosEspecificos());
        paciente.setAlergias(pacienteDTO.getAlergias());
        paciente.setConvenio(pacienteDTO.getConvenio());
        paciente.setNumeroConvenio(pacienteDTO.getNumeroConvenio());
        paciente.setValidadeConvenio(pacienteDTO.getValidadeConvenio());

        paciente = pacienteRepository.save(paciente);
        return new PacienteDTO(paciente);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarPaciente(Long id){
        if (!pacienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Paciente com ID: " + id + " não encontrado.");
        }
        try {
            pacienteRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Não é possível deletar paciente com medicação prescrita");
        }
    }
}
