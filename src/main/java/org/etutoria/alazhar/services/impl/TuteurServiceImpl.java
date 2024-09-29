package org.etutoria.alazhar.services.impl;

import lombok.AllArgsConstructor;
import org.etutoria.alazhar.dao.TuteurDao;
import org.etutoria.alazhar.dto.TuteurDto;
import org.etutoria.alazhar.entities.Tuteur;
import org.etutoria.alazhar.mapper.TuteurMapper;
import org.etutoria.alazhar.services.TuteurService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TuteurServiceImpl implements TuteurService {
    private final TuteurMapper tuteurMapper;
    private final TuteurDao tuteurRepository;

    @Override
    public TuteurDto createTuteur(TuteurDto tuteurDto) {
        // Ensure all required fields are set
        if (tuteurDto.getNumber() == null || tuteurDto.getNumber().isEmpty()) {
            throw new IllegalArgumentException("Number cannot be null or empty");
        }

        // Retrieve or create the tuteur
        Optional<Tuteur> existingTuteur = tuteurRepository.findByEmail(tuteurDto.getEmail());
        Tuteur tuteur;
        if (existingTuteur.isPresent()) {
            tuteur = existingTuteur.get();
            tuteurMapper.updateTuteurFromDto(tuteurDto, tuteur);
        } else {
            tuteur = tuteurMapper.fromTuteurDto(tuteurDto);
        }

        Tuteur savedTuteur = tuteurRepository.save(tuteur);
        return tuteurMapper.fromTuteur(savedTuteur);
    }
}