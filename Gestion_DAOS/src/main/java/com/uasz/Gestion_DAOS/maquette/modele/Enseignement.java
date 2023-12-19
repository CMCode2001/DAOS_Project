package com.uasz.Gestion_DAOS.maquette.modele;

import com.uasz.Gestion_DAOS.repartition.modele.Repartition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
