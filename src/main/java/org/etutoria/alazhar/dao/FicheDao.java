package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.FicheEleve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheDao extends JpaRepository<FicheEleve, Long> {
}
