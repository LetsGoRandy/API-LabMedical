package com.labmedicine.api_labmedication.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "medico_medicamento",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private Set<Medicamento> medicamentos = new HashSet<>();

}
