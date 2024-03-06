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
public class Semestre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSemestre;
    private String libelleSemestre, descriptionSemestre;
    @Temporal(TemporalType.DATE)
    private Date dateCreationSemestre;


    /**
     * Representation de la relation classe-Semestre;
     */
    @JsonIgnore
    @OneToMany(mappedBy = "semestre")
    private List<Classe> classes;

    /**
     * Representation de la relation Semestre-Module;
     */
    @JsonIgnore
    @OneToMany(mappedBy = "semestre")
    private List<Module> module;

}
