package com.uasz.Gestion_DAOS.Modele.maquette;

import java.util.List;

import com.uasz.Gestion_DAOS.Modele.repartition.Repartition;

import jakarta.persistence.CascadeType;
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
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnseignement;
    
    /**
     * Representation de la relation classe-Enseignement;
     */
    @ManyToOne
    @JoinColumn(name = "classe")
    private Classe classe;

    /**
     * Representation de la relation Groupe-Enseignement;
     */
    @ManyToOne
    @JoinColumn(name = "groupe")
    private Groupe groupe;

    /**
     * Representation de la relation Module-Enseignement;
     */
    @ManyToOne
    @JoinColumn(name = "module")
    private Module module;

    @OneToMany(mappedBy = "enseignement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Repartition> repartitions;

}
