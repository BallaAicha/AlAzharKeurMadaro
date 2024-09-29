package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Mois;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoisDao extends JpaRepository<Mois, Long> {
    Optional<Mois> findByMois(String mois);
}
