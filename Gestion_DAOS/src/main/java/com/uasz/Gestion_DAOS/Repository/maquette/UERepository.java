package com.uasz.Gestion_DAOS.Repository.maquette;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Modele.maquette.UE;

public interface UERepository extends JpaRepository<UE, Long>{

    @Query("SELECT e FROM EC e WHERE e.ue = ?1")
    List<EC> findByUE (UE ue);

    @Query("SELECT m FROM Module m WHERE m.ue = ?1")
    List<Module> findByUEModules(UE ue);
}
