package com.uasz.Gestion_DAOS.Dtos.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDTO {
    private Long idClasse;
    private String classe;
    private int effectif;
    private int groupe;
    private String semestre;
    private String Formation;
    
}
