package com.uasz.Gestion_DAOS.emploi_du_temps.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Deroulement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDeroulement;

    /**
     * Representation de la relation Seance-Deroulement
     */
    @OneToOne
    @JoinColumn(name = "seance")
    private Seance seance;
}
