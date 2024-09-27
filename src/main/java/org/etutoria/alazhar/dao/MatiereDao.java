package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.MatiereCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereDao extends JpaRepository<MatiereCours, Long> {
}
