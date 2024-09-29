package org.etutoria.alazhar.services;

import org.etutoria.alazhar.dto.ClasseDto;

public interface ClasseService {
    ClasseDto findOrCreateClasse(String className);
}