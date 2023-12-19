package com.uasz.Gestion_DAOS.repartition.modele;

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
