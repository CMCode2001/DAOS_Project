package com.uasz.Gestion_DAOS.maquette.modele;


import com.uasz.Gestion_DAOS.Constante.NiveauConst;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau;
    private NiveauConst libelleNiveau;

    /**
     * Representation de la relation Niveau-Cycle;
     */

    @ManyToOne
    @JoinColumn(name = "cycle")
    private Cycle cycle;

    /**
     * Representation de la relation Niveau-Formation;
     */
    @OneToMany(mappedBy = "niveau")
    private List <Formation> formations;
}