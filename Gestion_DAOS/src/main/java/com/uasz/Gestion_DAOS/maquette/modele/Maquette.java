package com.uasz.Gestion_DAOS.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maquette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaquette;
    private String libelleMaquette;
    private String codeMaquette;


    /**
     * Representation de la relation Maquette-Formation
     */
    @OneToOne
    @JoinColumn(name = "formation")
    private Formation formation;

    /**
     * Representation de la relation Maquette-module;
     */
    @OneToMany(mappedBy = "maquette")
    private List<Module> modules;

}
