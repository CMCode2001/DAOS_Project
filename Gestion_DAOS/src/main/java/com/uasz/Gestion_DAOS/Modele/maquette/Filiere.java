package com.uasz.Gestion_DAOS.Modele.maquette;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Filiere {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere;
    private String libelleFiliere;
    private String descriptionFiliere;
    @Temporal(TemporalType.DATE)
    private Date dateCreationFiliere;

    /**
     * Representation de la relation Filiere-Formation;
     */
    @JsonIgnore
    @OneToMany(mappedBy = "filiere")
    private List<Formation> formations;
}
