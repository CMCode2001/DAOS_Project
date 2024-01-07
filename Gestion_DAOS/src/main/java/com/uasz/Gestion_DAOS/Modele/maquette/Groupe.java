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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroupe;
    private String libelleGroupe;
    private int numeroGroupe, effectifGroupe;
    private String descriptionGroupe;
    @Temporal(TemporalType.DATE)
    private Date dateCreationGroupe;


    /**
     * Representation de la relation classe-Groupe;
     */
    @ManyToOne
    @JoinColumn(name = "classe")
    private Classe classe;  

    /**
     * Representation de la relation Groupe-Enseignement;
     */
    @OneToMany(mappedBy = "groupe")
    private List<Enseignement> enseignements;
    
}
