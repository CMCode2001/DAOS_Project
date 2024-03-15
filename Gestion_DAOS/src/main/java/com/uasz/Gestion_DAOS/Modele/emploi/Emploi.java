package com.uasz.Gestion_DAOS.Modele.emploi;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @JsonIgnore
    @OneToMany(mappedBy = "emploi")
    private List<Seance> seances;
    
}
