package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TuteurDao extends JpaRepository<Tuteur, Long> {
    Optional<Tuteur> findByEmail(String email);
}
