package com.uasz.Gestion_DAOS.Modele.repartition;

import java.util.List;

import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
import com.uasz.Gestion_DAOS.Modele.maquette.Enseignement;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "repartition", cascade = CascadeType.ALL)
    private List<Seance> seances;
}
