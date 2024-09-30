package org.etutoria.alazhar.dao;

import org.etutoria.alazhar.entities.ANNEE;
import org.etutoria.alazhar.entities.Classe;
import org.etutoria.alazhar.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InscriptionDao extends JpaRepository<Inscription, Long> {
    boolean existsByAnneeAndClasse(ANNEE annee, Classe classe);

    Optional<Inscription> findByAnneeAndClasse(ANNEE annee, Classe classe);
}
