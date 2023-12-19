package com.uasz.Gestion_DAOS.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUE;
    private String libelleUE;
    private  String codeUE;
    private String descriptionUE;

    /**
     * Representation de la relation entre UE-EC
     */
    @OneToMany(mappedBy = "ue")
    private List<EC> ecs;
}
