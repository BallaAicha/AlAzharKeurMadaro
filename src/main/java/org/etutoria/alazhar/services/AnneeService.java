package org.etutoria.alazhar.services;

import org.etutoria.alazhar.dto.AnneeDto;
import org.etutoria.alazhar.entities.ANNEE;

public interface AnneeService {
    AnneeDto findOrCreateAnnee(String annee);

    AnneeDto fromAnnee(ANNEE anneeEntity);
}