package com.uasz.Gestion_DAOS.Modele.maquette;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    @Temporal(TemporalType.DATE)
    private Date dateCreationMaquette;


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
