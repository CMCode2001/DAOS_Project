package com.uasz.Gestion_DAOS.Modele.repartition;

import java.util.ArrayList;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@DiscriminatorValue("VAC")
public class Vacataire extends Enseignant{
    private String specialite;

    public Vacataire() {
        super(); // Appel du constructeur de la classe parente
        this.repartitions = new ArrayList<>(); // Initialisation de la liste de répartitions
    }

}
