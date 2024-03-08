package com.uasz.Gestion_DAOS.Repository.maquette;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uasz.Gestion_DAOS.Modele.maquette.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    Optional<Module> findByLibelleModule(String libelle);
}
