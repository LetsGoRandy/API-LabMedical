package com.labmedicine.api_labmedication.services;

import com.labmedicine.api_labmedication.dtos.MedicamentoDTO;
import com.labmedicine.api_labmedication.models.Medicamento;
import com.labmedicine.api_labmedication.models.Paciente;
import com.labmedicine.api_labmedication.models.TipoMedicamento;
import com.labmedicine.api_labmedication.models.Usuario;
import com.labmedicine.api_labmedication.repositories.MedicamentoRepository;
import com.labmedicine.api_labmedication.repositories.PacienteRepository;
import com.labmedicine.api_labmedication.repositories.UsuarioRepository;
import com.labmedicine.api_labmedication.services.exceptions.DataBaseException;
import com.labmedicine.api_labmedication.services.exceptions.InvalidModificationException;
import com.labmedicine.api_labmedication.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public MedicamentoDTO criarMedicamento(MedicamentoDTO medicamentoDTO) {
        if (medicamentoDTO.getPacienteId() == null) {
            throw new IllegalArgumentException("ID do paciente é obrigatório");
        }
        Paciente paciente = pacienteRepository.findById(medicamentoDTO.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente com ID: " + medicamentoDTO.getPacienteId() + " não encontrado."));

        if (medicamentoDTO.getMedicoId() == null) {
            throw new IllegalArgumentException("ID do médico é obrigatório");
        }
        Usuario medico = usuarioRepository.findById(medicamentoDTO.getMedicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Médico com ID: " + medicamentoDTO.getMedicoId() + " não encontrado."));

        Medicamento medicamento = new Medicamento();
        medicamento.setId(medicamentoDTO.getId());
        medicamento.setNomeMedicamento(medicamentoDTO.getNomeMedicamento());
        medicamento.setMoment(medicamentoDTO.getMoment());
        medicamento.setTipoMedicamento(medicamentoDTO.getTipoMedicamento());
        medicamento.setQuantidade(medicamentoDTO.getQuantidade());
        medicamento.setPosologia(medicamentoDTO.getPosologia());
        medicamento.setObservacoes(medicamentoDTO.getObservacoes());
        medicamento.setPaciente(paciente);
        medicamento.setMedico(medico);

        medicamento = medicamentoRepository.save(medicamento);
        return new MedicamentoDTO(medicamento);
    }

    @Transactional
    public MedicamentoDTO atualizarMedicamento(Long id, MedicamentoDTO medicamentoDTO) {

        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento com ID: " + id + " não encontrado."));

        verificarAlteracaoDadosMedicamento(medicamento, medicamentoDTO);

        medicamento.setTipoMedicamento(medicamentoDTO.getTipoMedicamento());
        medicamento.setQuantidade(medicamentoDTO.getQuantidade());
        medicamento.setObservacoes(medicamentoDTO.getObservacoes());

        medicamento = medicamentoRepository.save(medicamento);
        return new MedicamentoDTO(medicamento);
    }

    @Transactional
    public MedicamentoDTO atualizarParcialMedicamento(Long id, Map<String, Object> updates) {

//        TODO: Corrigir erro de validação dos campos!

        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento com ID: " + id + " não encontrado."));

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            switch (key) {
                case "tipoMedicamento":
                    if (value instanceof Number) {
                        Long tipoValue = ((Number) value).longValue();
                        try {
                            medicamento.setTipoMedicamento(TipoMedicamento.fromId(tipoValue));
                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("Valor inválido para o tipo de medicamento. Use um ID válido.");
                        }
                    } else {
                        throw new IllegalArgumentException("Valor para 'tipoMedicamento' deve ser um número (ID).");
                    }
                    break;
                case "quantidade":
                    if (value instanceof Number) {
                        medicamento.setQuantidade(((Number) value).longValue());
                    } else {
                        throw new IllegalArgumentException("Valor inválido para quantidade.");
                    }
                    break;
                case "observacoes":
                    if (value instanceof String) {
                        medicamento.setObservacoes((String) value);
                    } else {
                        throw new IllegalArgumentException("Valor inválido para observações.");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Campo '" + key + "' não pode ser atualizado.");
            }
        }

        medicamento = medicamentoRepository.save(medicamento);
        return new MedicamentoDTO(medicamento);
    }

    @Transactional(readOnly = true)
    public MedicamentoDTO buscaById(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Medicamento não encontrado com o id " + id)
        );
        return new MedicamentoDTO(medicamento);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarMedicamento(Long id) {
        if (!medicamentoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Medicamento com ID: " + id + "não encontrado.");
        }
        medicamentoRepository.deleteById(id);
    }


    private void verificarAlteracaoDadosMedicamento(Medicamento medicamento, MedicamentoDTO medicamentoDTO) {
        // Verificar se o nome do medicamento foi alterado
        if (!medicamento.getNomeMedicamento().equals(medicamentoDTO.getNomeMedicamento())) {
            throw new InvalidModificationException("Não é permitido alterar o nome do medicamento.");
        }

        // Verificar se o momento foi alterado
        if (!medicamento.getMoment().equals(medicamentoDTO.getMoment())) {
            throw new InvalidModificationException("Não é permitido alterar o momento.");
        }

        // Verificar se a posologia foi alterada
        if (!medicamento.getPosologia().equals(medicamentoDTO.getPosologia())) {
            throw new InvalidModificationException("Não é permitido alterar a posologia.");
        }

        // Verificar se o pacienteId foi alterado
        if (!medicamento.getPaciente().getId().equals(medicamentoDTO.getPacienteId())) {
            throw new InvalidModificationException("Não é permitido alterar o ID do paciente.");
        }

        // Verificar se o medicoId foi alterado
        if (!medicamento.getMedico().getId().equals(medicamentoDTO.getMedicoId())) {
            throw new InvalidModificationException("Não é permitido alterar o ID do médico.");
        }
    }



}
