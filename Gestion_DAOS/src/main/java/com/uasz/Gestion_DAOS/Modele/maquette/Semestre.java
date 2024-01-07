package com.uasz.Gestion_DAOS.Modele.maquette;

import java.util.Date;
import java.util.List;

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
    @OneToMany(mappedBy = "semestre")
    private List<Classe> classes;

    /**
     * Representation de la relation Semestre-Module;
     */
    @OneToMany(mappedBy = "semestre")
    private List<Module> module;

}
