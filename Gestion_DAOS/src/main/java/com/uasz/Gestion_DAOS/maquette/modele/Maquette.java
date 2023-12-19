package com.uasz.Gestion_DAOS.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
