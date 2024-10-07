package com.labmedicine.api_labmedication.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.labmedicine.api_labmedication.models.Medicamento;
import com.labmedicine.api_labmedication.models.Posologia;
import com.labmedicine.api_labmedication.models.TipoMedicamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoDTO {

    private Long id;

    @NotBlank(message = "Nome do medicamento é obrigatório")
    private String nomeMedicamento;

    @NotNull(message = "Data e Hora é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "UTC")
    private Instant moment;

    @NotNull(message = "Tipo do medicamento é obrigatório")
    private TipoMedicamento tipoMedicamento;

    @NotNull(message = "Quantidade é obrigatória")
    private Long quantidade;

    @NotNull(message = "Posologia é obrigatória")
    private Posologia posologia;

    @NotBlank(message = "Observações são obrigatórias")
    private String observacoes;

    @NotNull(message = "ID do paciente é obrigatório")
    private Long pacienteId;

    @NotNull(message = "ID do médico é obrigatório")
    private Long medicoId;


    public MedicamentoDTO(Medicamento medicamento) {
        id = medicamento.getId();
        nomeMedicamento = medicamento.getNomeMedicamento();
        moment = medicamento.getMoment();
        tipoMedicamento = medicamento.getTipoMedicamento();
        quantidade = medicamento.getQuantidade();
        posologia = medicamento.getPosologia();
        observacoes = medicamento.getObservacoes();
        pacienteId = medicamento.getPaciente().getId();
        medicoId = medicamento.getMedico().getId();
    }
}
