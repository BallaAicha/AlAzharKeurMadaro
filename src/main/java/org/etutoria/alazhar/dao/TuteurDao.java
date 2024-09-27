package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuteurDao extends JpaRepository<Tuteur, Long> {
}
