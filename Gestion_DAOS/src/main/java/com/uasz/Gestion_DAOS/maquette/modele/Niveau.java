package com.uasz.Gestion_DAOS.maquette.modele;


import com.uasz.Gestion_DAOS.Constante.NiveauConst;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau;
    private NiveauConst libelleNiveau;

    @ManyToOne
    @JoinColumn(name = "cycle")
    private Cycle cycle;
}