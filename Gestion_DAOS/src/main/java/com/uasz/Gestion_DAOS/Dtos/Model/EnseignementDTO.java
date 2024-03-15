package com.uasz.Gestion_DAOS.Dtos.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnseignementDTO {
    private Long id;
    private String libelle;
    private String description;
    private Long idModule;
    private String cours;
    private int  coefficient;
    private int nbreHeure;
    private Long idClasse;
    private String classe;
    private Long idGroupe;
    private String groupe;
    private String semestre;
}