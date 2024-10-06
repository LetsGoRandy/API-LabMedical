package com.labmedicine.api_labmedication.dtos;

import com.labmedicine.api_labmedication.models.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Long id;

    @NotBlank(message = "Cep é Obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O Cep deve estar no formato 99999-999")
    private String cep;

    @NotBlank(message = "Cidade é Obrigatório")
    private String cidade;

    @NotBlank(message = "Estado é Obrigatório")
    private String estado;

    @NotBlank(message = "Logradouro é Obrigatório")
    private String logradouro;

    @NotNull(message = "Número é Obrigatório")
    private Integer numero;

    @NotBlank(message = "Bairro é Obrigatório")
    private String bairro;

    private String complemento;
    private String pontoReferencia;

    public EnderecoDTO(Endereco endereco) {
        id = endereco.getId();
        cep = endereco.getCep();
        cidade = endereco.getCidade();
        estado = endereco.getEstado();
        logradouro = endereco.getLogradouro();
        numero = endereco.getNumero();
        bairro = endereco.getBairro();
        complemento = endereco.getComplemento();
        pontoReferencia = endereco.getPontoReferencia();
    }
}
