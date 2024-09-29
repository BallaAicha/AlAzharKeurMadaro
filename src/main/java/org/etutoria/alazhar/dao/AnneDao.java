package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.ANNEE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnneDao extends JpaRepository<ANNEE, Long> {


    Optional<ANNEE> findByAnnee(String annee);
}
