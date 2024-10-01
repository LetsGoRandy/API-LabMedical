package com.labmedicine.api_labmedication.dtos;

import com.labmedicine.api_labmedication.models.Pessoa;
import com.labmedicine.api_labmedication.models.Usuario;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioDTO {

    @NotBlank(message = "O nome completo é obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "O gênero é obrigatório")
    private String genero;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve estar no passado")
    private LocalDate dataNascimento;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato 000.000.000-00")
    private String cpf;

    @NotBlank(message = "O RG é obrigatório")
    private String rg;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @Email(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "A naturalidade é obrigatória")
    private String naturalidade;

    @NotBlank(message = "O crm é obrigatório")
    private String crm;

    @NotBlank(message = "O estado civil é obrigatório")
    private Pessoa.EstadoCivil estadoCivil;

    @NotBlank(message = "A especialização clínica é obrigatória")
    private Usuario.EspecializacaoClinica especializacaoClinica;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, message = "A senha deve conter no mínimo 8 dígitos")
    private String senha;

}
