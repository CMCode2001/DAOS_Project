package com.uasz.Gestion_DAOS.Modele.maquette;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Module {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;
    private String libelleModule;
    private String coursModule;
    private int dureeModule;
    private String objectifsModule, descriptionModule;
    @Temporal(TemporalType.DATE)
    private Date dateCreationModule;

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
    private UE ue;

    /**
     * Representation de la relation Module-EC;
     */
    @ManyToOne
    @JoinColumn(name="ec")
    private EC ec;
}