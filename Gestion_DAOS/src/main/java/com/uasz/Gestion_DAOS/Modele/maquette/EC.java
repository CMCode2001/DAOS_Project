package com.uasz.Gestion_DAOS.Modele.maquette;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    private int cm, td, tp,tpe;
    private int coefficientEC;
    private String descritptionEC;
    @Temporal(TemporalType.DATE)
    private Date dateCreationEC;


    /**
     * Representation de la relation entre EC-UE
     */
    @ManyToOne
    @JoinColumn(name = "ue")
    private UE ue;


    /**
     * Representation de la relation EC-Module;
     */
    @OneToMany(mappedBy = "ec")
    private List<Module> modules;
}
