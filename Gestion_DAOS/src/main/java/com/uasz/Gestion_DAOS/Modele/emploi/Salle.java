package com.uasz.Gestion_DAOS.Modele.emploi;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalle;
    private String libelleSalle;
    private String codeSalle;
    private int capaciteSalle;
    private String descriptionSalle;
    @Temporal(TemporalType.DATE)
    private Date dateCreationSalle;

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
