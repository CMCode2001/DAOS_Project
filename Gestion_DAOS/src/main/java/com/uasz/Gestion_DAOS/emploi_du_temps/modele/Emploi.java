package com.uasz.Gestion_DAOS.emploi_du_temps.modele;

import java.sql.Date;
import java.util.List;

import com.uasz.Gestion_DAOS.Constante.Jour;

import jakarta.persistence.CascadeType;
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
public class Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmploi;
    private Jour jour;
    private int horaireDebut;
    private int horaireFin;
    private Date dateDebut;
    private Date dateFin;
    
    /**
     * Representation de relation Emploi-seance
     */
    @OneToMany(mappedBy = "emploi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seance> seances;
    
}
