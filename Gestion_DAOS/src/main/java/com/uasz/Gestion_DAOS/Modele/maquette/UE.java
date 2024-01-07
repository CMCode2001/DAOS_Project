package com.uasz.Gestion_DAOS.Modele.maquette;


import java.util.Date;
import java.util.List;

import com.uasz.Gestion_DAOS.utilisateur.Utilisateur;

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
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUE;
    private String libelleUE;
    private  String codeUE;
    private int creditUE;
    private int coefficientUE;
    private String descriptionUE;
    @Temporal(TemporalType.DATE)
    private Date dateCreationUE;

    /**
     * Representation de la relation entre UE-EC
     */
    @OneToMany(mappedBy = "ue")
    private List<EC> ecs;

    /**
     * Representation de la relation UE-module;
     */
    @OneToMany(mappedBy = "ue")
    private List<Module> modules;

    /**
     * Representation de Relation Utilisateur-UE
     */
    @ManyToOne
    @JoinColumn(name = "utilisateur")
    private Utilisateur utilisateur;

}
