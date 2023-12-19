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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere;
    private String nomFiliere;

    /**
     * Representation de la relation Filiere-Formation;
     */
    @OneToMany(mappedBy = "filiere")
    private List<Formation> formations;
}
