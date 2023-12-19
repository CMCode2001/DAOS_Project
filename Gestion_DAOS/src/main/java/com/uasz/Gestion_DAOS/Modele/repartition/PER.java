package com.uasz.Gestion_DAOS.Modele.repartition;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor 
@AllArgsConstructor
@DiscriminatorValue("PER")
public class PER extends Enseignant {
    private String matricule;
}
