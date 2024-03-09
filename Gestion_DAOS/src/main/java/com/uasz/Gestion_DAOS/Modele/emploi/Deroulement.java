package com.uasz.Gestion_DAOS.Modele.emploi;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class Deroulement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeroulement;
    private String objectifsDeroulement;
    private String descriptionDeroulement;
    @Temporal(TemporalType.DATE)
    private Date dateCreationDeroulement;

    /**
     * Representation de la relation Seance-Deroulement
     */
    @OneToOne
    private Seance seance ;
}
