package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NiveauDao extends JpaRepository<Niveau, Long> {
    Optional<Niveau> findByNiveauName(String niveauName);
}
