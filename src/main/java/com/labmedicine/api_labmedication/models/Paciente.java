package com.labmedicine.api_labmedication.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Pacientes")
public class Paciente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contatoEmergencia;

    private String alergias;

    private String cuidadosEspecificos;

    private String convenio;

    private String numeroConvenio;

    private LocalDate validadeConvenio;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToMany
    @JoinTable(
            name = "paciente_medicamento",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private Set<Medicamento> medicamentos = new HashSet<>();

}
