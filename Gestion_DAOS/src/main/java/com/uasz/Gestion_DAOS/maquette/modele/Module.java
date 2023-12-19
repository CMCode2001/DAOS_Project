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
public class Module {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;

    /**
     * Representation de la relation Module-EC;
     */
    @OneToMany(mappedBy = "EC")
    private List <EC> ec;
}
