package com.uasz.Gestion_DAOS.utilisateur;

import java.util.List;

import com.uasz.Gestion_DAOS.Modele.maquette.UE;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur; 
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String role;

    /**
     * Relation entre Utilisateur et UE
     */
    @OneToMany(mappedBy = "utilisateur")
    private List<UE> ues;
    
}
