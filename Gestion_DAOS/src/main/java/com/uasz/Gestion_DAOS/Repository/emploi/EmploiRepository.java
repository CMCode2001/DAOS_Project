package com.uasz.Gestion_DAOS.Repository.emploi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uasz.Gestion_DAOS.Modele.emploi.Emploi;

public interface EmploiRepository extends JpaRepository<Emploi, Long> {
}
