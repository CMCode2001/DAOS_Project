package com.uasz.Gestion_DAOS.Repository.repartition;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uasz.Gestion_DAOS.Modele.repartition.PER;
import org.springframework.stereotype.Repository;

@Repository
public interface PerRepository extends JpaRepository<PER, Long>{
}
