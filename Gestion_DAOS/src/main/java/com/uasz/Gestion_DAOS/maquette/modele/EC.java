package com.uasz.Gestion_DAOS.maquette.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEC;
    private String libelleEC;
    private  String codeEC;
    private String descriptionEC;

    /**
     * Representation de la relation entre EC-UE
     */
    @ManyToOne
    @JoinColumn(name = "ue")
    private UE ue;
}
