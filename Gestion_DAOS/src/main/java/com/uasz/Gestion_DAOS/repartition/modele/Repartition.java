package com.uasz.Gestion_DAOS.repartition.modele;

import com.uasz.Gestion_DAOS.emploi_du_temps.modele.Seance;
import com.uasz.Gestion_DAOS.maquette.modele.Enseignement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepartition;

    @ManyToOne
    @JoinColumn(name = "enseignement")
    private Enseignement enseignement;

    @ManyToOne
    @JoinColumn(name = "enseignant")
    private Enseignant enseignant;

    @OneToMany(mappedBy = "repartition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seance> seances;
}
