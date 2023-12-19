package com.uasz.Gestion_DAOS.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Module {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;

    /**
     * Representation de la relation Semestre-Module;
     */
    @ManyToOne
    @JoinColumn(name = "semestre")
    private Semestre semestre;

    /**
     * Representation de la relation Module-Enseignement;
     */
    @OneToMany(mappedBy = "module")
    private List<Enseignement> enseignements;

    /**
     * Representation de la relation Maquette-Module;
     */
    @ManyToOne
    @JoinColumn(name = "maquette")
    private Maquette maquette;

    /**
     * Representation de la relation UE-Module;
     */
    @ManyToOne
    @JoinColumn(name = "ue")
    private Module module;
}
