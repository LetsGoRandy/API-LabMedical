package com.labmedicine.api_labmedication.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeMedicamento;

    @Column(nullable = false)
    private LocalDate dataAdministracao;

    @Column(nullable = false)
    private TipoMedicamento tipoMedicamento;

    @Column(nullable = false)
    private Long quantidade;

    @Column(nullable = false)
    private Posologia posologia;

    @Column(nullable = false)
    private String observacoes;

//    TODO criar relacionamento com paciente - obrigatório
//    TODO criar relacionamento com medico - obrigatório
}
