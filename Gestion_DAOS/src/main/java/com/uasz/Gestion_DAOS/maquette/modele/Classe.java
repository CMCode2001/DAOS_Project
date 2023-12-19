package com.uasz.Gestion_DAOS.maquette.modele;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasse;
    private String libelleClasse;
    private int effectifClasse;

    /**
     * Representation de la relation classe-Groupe;
     */
    @OneToMany(mappedBy = "classe")
    private List<Groupe> groupes;
    
    /**
     * Representation de la relation classe-Enseignement;
     */
    @OneToMany(mappedBy = "classe")
    private List<Enseignement> enseignements;

    /**
     * Representation de la relation classe-Semestre;
     */
    @ManyToOne
    @JoinColumn(name = "semestre")
    private Semestre semestre;

    /**
     * Representation de la relation Classe-Formation;
     */
    @OneToMany(mappedBy = "formation")
    private List<Formation> formations;
}
