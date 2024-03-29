package com.uasz.Gestion_DAOS.Modele.repartition;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", length=3)
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Enseignant {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEns;
    private String nomEns;
    private String prenomEns;
    private String gradeEns;
    @Temporal(TemporalType.DATE)
    private Date dateCreationEns;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    List<Repartition> repartitions;
}
