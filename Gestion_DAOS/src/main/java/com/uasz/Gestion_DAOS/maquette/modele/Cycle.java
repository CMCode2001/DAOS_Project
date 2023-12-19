package com.uasz.Gestion_DAOS.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cycle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCycle;
    private String libelleCycle;

    @OneToMany(mappedBy = "cycle")
    private List<Niveau> niveaux;


}


