package org.etutoria.alazhar.services;

import org.etutoria.alazhar.entities.Mois;

public interface MoisService {
    Mois findOrCreateMois(String mois);
}