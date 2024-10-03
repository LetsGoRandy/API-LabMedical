package com.labmedicine.api_labmedication.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "paciente")
    private List<Medicamento> medicamentos = new ArrayList<>();
}
