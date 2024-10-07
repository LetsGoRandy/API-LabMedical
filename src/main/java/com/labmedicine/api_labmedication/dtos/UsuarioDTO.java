package com.labmedicine.api_labmedication.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.labmedicine.api_labmedication.models.EspecializacaoClinica;
import com.labmedicine.api_labmedication.models.EstadoCivil;
import com.labmedicine.api_labmedication.models.Usuario;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

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
    private String cpf;

    @NotBlank(message = "O RG é obrigatório")
    @Size(max = 20, message = "O RG deve ter no máximo 20 caracteres")
    private String rg;

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "O telefone deve estar no formato (99) 99999-9999")
    private String telefone;

    @Email(message = "O email deve ser válido")
    private String email;

    @NotBlank(message = "A naturalidade é obrigatória")
    @Size(min = 8, max = 64, message = "A naturalidade deve ter entre 8 e 64 caracteres")
    private String naturalidade;

    @NotNull(message = "O estado civil é obrigatório")
    private EstadoCivil estadoCivil;

    @NotBlank(message = "O CRM é obrigatório")
    private String crm;

    @NotNull(message = "A especialização clínica é obrigatória")
    private EspecializacaoClinica especializacaoClinica;

    @Size(min = 8, message = "A Senha deve ter pelo menos 8 caracteres")
    private String senha;

    public UsuarioDTO(Usuario usuario) {

        id = usuario.getId();
        nomeCompleto = usuario.getNomeCompleto();
        genero = usuario.getGenero();
        dataNascimento = usuario.getDataNascimento();
        cpf = usuario.getCpf();
        rg = usuario.getRg();
        telefone = usuario.getTelefone();
        email = usuario.getEmail();
        naturalidade = usuario.getNaturalidade();
        estadoCivil = usuario.getEstadoCivil();
        crm = usuario.getCrm();
        especializacaoClinica = usuario.getEspecializacaoClinica();
        senha = usuario.getSenha();
    }

}
