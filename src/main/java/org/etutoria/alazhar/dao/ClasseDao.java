package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasseDao extends JpaRepository<Classe, Long> {
    Optional<Classe> findByClassName(String className);
}
