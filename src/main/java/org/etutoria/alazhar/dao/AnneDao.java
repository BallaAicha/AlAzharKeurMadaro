package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.ANNEE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnneDao extends JpaRepository<ANNEE, Long> {
}
