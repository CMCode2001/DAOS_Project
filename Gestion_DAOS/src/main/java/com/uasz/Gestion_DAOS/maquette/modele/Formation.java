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
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;
    private String libelleFormation;
    private String descriptionFormation;

    /**
     * Representation de la relation Maquette-Formation
     */
    @OneToOne(mappedBy = "formation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Maquette maquette;

    /**
     * Representation de la relation Formation-Niveau;
     */
    @ManyToOne
    @JoinColumn(name= "niveau")
    private Niveau niveau;

    /**
     * Representation de la relation Formation-Classe;
     */

    @OneToMany(mappedBy = "formation")
    private List<Classe> classes;

}
