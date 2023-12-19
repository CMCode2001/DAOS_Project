package com.uasz.Gestion_DAOS.Modele.emploi;

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
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalle;
    private int numeroSalle;
    private int CapaciteSalle;
    private String typeSalle;

    /**
     * Representation de la relation entre Batiment-Salle
     */
    @ManyToOne
    @JoinColumn(name = "batiment")
    private Batiment batiment;

    /**
     * Representation de la relation entre Salle-Seance
     */
    @OneToMany(mappedBy = "salle")
    private List<Seance> seances;

}
