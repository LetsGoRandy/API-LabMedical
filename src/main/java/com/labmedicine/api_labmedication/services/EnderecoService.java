package com.labmedicine.api_labmedication.services;

import com.labmedicine.api_labmedication.dtos.EnderecoDTO;
import com.labmedicine.api_labmedication.models.Endereco;
import com.labmedicine.api_labmedication.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Transactional
    public EnderecoDTO criarEndereco(EnderecoDTO enderecoDTO) {

        Endereco endereco = new Endereco();
        endereco.setId(enderecoDTO.getId());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setPontoReferencia(enderecoDTO.getPontoReferencia());

        enderecoRepository.save(endereco);
        return new EnderecoDTO(endereco);

    }

    @Transactional(readOnly = true)
    public Page<EnderecoDTO> listarEnderecos(Pageable pageable) {
        Page<Endereco> enderecos = enderecoRepository.findAll(pageable);
        return enderecos.map(EnderecoDTO::new);
    }
}
