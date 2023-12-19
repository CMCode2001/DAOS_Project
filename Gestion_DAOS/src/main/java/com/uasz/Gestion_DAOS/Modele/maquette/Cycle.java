package com.uasz.Gestion_DAOS.Modele.maquette;

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


