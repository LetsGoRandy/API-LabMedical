package com.labmedicine.api_labmedication.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario extends Pessoa{


    @Column(nullable = false)
    private String crm;

    @Column(nullable = false)
    private EspecializacaoClinica especializacaoClinica;

    @Column(nullable = false)
    private String senha;



    public enum EspecializacaoClinica{
        CLINICO_GERAL,
        ANESTESISTA,
        DERMATOLOGISTA,
        GINECOLOGISTA,
        NEUROLOGISTA,
        PEDIATRA,
        PSIQUIATRA,
        ORTOPEDISTA
    }
}
