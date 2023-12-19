package com.uasz.Gestion_DAOS.maquette.modele;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private int numeroSemestre;

    /**
     * Representation de la relation classe-Semestre;
     */
    @OneToMany(mappedBy = "semestre")
    private List<Classe> classes;

}
