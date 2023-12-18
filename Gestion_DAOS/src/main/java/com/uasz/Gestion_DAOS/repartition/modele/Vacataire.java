package com.uasz.Gestion_DAOS.repartition.modele;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("VAC")
public class Vacataire extends Enseignant{
    private String specialite;
}
