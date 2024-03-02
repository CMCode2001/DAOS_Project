package com.uasz.Gestion_DAOS.Modele.repartition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private String matriculePer;
}
