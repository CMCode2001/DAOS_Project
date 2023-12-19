package com.uasz.Gestion_DAOS.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
     * Representation de la relation Filiere-Formation;
     */
    @ManyToOne
    @JoinColumn(name = "filiere")
    private Filiere filiere;
}
