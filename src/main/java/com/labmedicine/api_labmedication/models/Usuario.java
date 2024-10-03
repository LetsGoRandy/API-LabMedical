package com.labmedicine.api_labmedication.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String crm;

    @Column(nullable = false)
    private EspecializacaoClinica especializacaoClinica;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "medico")
    private List<Medicamento> medicamentos = new ArrayList<>();

}
