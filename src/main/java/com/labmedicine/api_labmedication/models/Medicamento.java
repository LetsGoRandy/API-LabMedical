package com.labmedicine.api_labmedication.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "medicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeMedicamento;

    @Column(nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    @Column(nullable = false)
    private TipoMedicamento tipoMedicamento;

    @Column(nullable = false)
    private Long quantidade;

    @Column(nullable = false)
    private Posologia posologia;

    @Column(nullable = false)
    private String observacoes;

    @ManyToMany(mappedBy = "medicamentos")
    private Set<Paciente> pacientes = new HashSet<>();

    @ManyToMany(mappedBy = "medicamentos")
    private Set<Usuario> medicos = new HashSet<>();

}
