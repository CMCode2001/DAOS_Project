package com.uasz.Gestion_DAOS.Modele.emploi;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploi;
    private int dureeEmploi;
    @Temporal(TemporalType.DATE)
    private Date dateDebutEmploi;
    @Temporal(TemporalType.DATE)
    private Date dateFinEmploi;
    @Temporal(TemporalType.DATE)
    private Date dateCreationEmploi;
    
    /**
     * Representation de relation Emploi-seance
     */
    @OneToMany(mappedBy = "emploi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seance> seances;
    
}
