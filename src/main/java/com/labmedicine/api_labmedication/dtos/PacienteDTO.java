package com.labmedicine.api_labmedication.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.labmedicine.api_labmedication.models.EstadoCivil;
import com.labmedicine.api_labmedication.models.Paciente;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {
    private Long id;

    @NotBlank(message = "O nome completo é obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "O gênero é obrigatório")
    private String genero;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve estar no passado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato 000.000.000-00")
    private String cpf;

    @NotBlank(message = "O RG é obrigatório")
    @Size(max = 20, message = "O RG deve ter no máximo 20 caracteres")
    private String rg;

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "O telefone deve estar no formato (99) 9 9999-9999")
    private String telefone;

    @Email(message = "O email deve ser válido")
    private String email;

    @NotBlank(message = "A naturalidade é obrigatória")
    @Size(min = 8, max = 64, message = "A naturalidade deve ter entre 8 e 64 caracteres")
    private String naturalidade;

    @NotNull(message = "O estado civil é obrigatório")
    private EstadoCivil estadoCivil;

    @NotBlank(message = "O contato de emergência é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "O contato de emergência deve estar no formato (99) 9 9999-9999")
    private String contatoEmergencia;

    private String alergias;
    private String cuidadosEspecificos;
    private String convenio;
    private String numeroConvenio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate validadeConvenio;
    private Long enderecoId;

    public PacienteDTO(Paciente paciente) {


        id = paciente.getId();
        nomeCompleto = paciente.getNomeCompleto();
        genero = paciente.getGenero();
        dataNascimento = paciente.getDataNascimento();
        cpf = paciente.getCpf();
        rg = paciente.getRg();
        telefone = paciente.getTelefone();
        email = paciente.getEmail();
        naturalidade = paciente.getNaturalidade();
        estadoCivil = paciente.getEstadoCivil();
        contatoEmergencia = paciente.getContatoEmergencia();
        alergias = paciente.getAlergias();
        cuidadosEspecificos = paciente.getCuidadosEspecificos();
        convenio = paciente.getConvenio();
        numeroConvenio = paciente.getNumeroConvenio();
        validadeConvenio = paciente.getValidadeConvenio();
        enderecoId = paciente.getEndereco().getId();
    }
}
