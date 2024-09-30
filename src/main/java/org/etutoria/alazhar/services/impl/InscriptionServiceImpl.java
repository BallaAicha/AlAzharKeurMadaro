package org.etutoria.alazhar.services.impl;

import org.etutoria.alazhar.dao.AnneDao;
import org.etutoria.alazhar.dao.InscriptionDao;
import org.etutoria.alazhar.dao.ClasseDao;
import org.etutoria.alazhar.dao.NiveauDao;
import org.etutoria.alazhar.dto.InscriptionDto;
import org.etutoria.alazhar.dto.NiveauDto;
import org.etutoria.alazhar.entities.Inscription;
import org.etutoria.alazhar.entities.ANNEE;
import org.etutoria.alazhar.entities.Classe;
import org.etutoria.alazhar.entities.Niveau;
import org.etutoria.alazhar.mapper.InscriptionMapper;
import org.etutoria.alazhar.services.InscriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionDao inscriptionDao;
    private final AnneDao anneeDao;
    private final ClasseDao classeDao;
    private final NiveauDao niveauDao;
    private final InscriptionMapper inscriptionMapper;

    public InscriptionServiceImpl(InscriptionDao inscriptionDao, AnneDao anneeDao, ClasseDao classeDao, NiveauDao niveauDao, InscriptionMapper inscriptionMapper) {
        this.inscriptionDao = inscriptionDao;
        this.anneeDao = anneeDao;
        this.classeDao = classeDao;
        this.niveauDao = niveauDao;
        this.inscriptionMapper = inscriptionMapper;
    }

    @Override
    public InscriptionDto createInscription(InscriptionDto inscriptionDto) {
        // Retrieve the year
        Optional<ANNEE> annee = anneeDao.findByAnnee(inscriptionDto.getAnnee().getAnnee());
        if (annee.isEmpty()) {
            throw new IllegalArgumentException("Year not found: " + inscriptionDto.getAnnee().getAnnee());
        }

        // Retrieve the niveau
        NiveauDto niveauDto = inscriptionDto.getClasse().getNiveau();
        Optional<Niveau> niveau = niveauDao.findByNiveauName(niveauDto.getNiveauName());
        if (niveau.isEmpty()) {
            throw new IllegalArgumentException("Niveau not found: " + niveauDto.getNiveauName());
        }

        // Retrieve the class
        Optional<Classe> classe = classeDao.findByClassName(inscriptionDto.getClasse().getClassName());
        if (classe.isEmpty()) {
            throw new IllegalArgumentException("Class not found: " + inscriptionDto.getClasse().getClassName());
        }

        // Set the retrieved entities
        Inscription inscription = inscriptionMapper.fromInscriptionDto(inscriptionDto);
        inscription.setAnnee(annee.get());
        inscription.setClasse(classe.get());

        // Save the inscription
        inscription = inscriptionDao.save(inscription);
        return inscriptionMapper.fromInscription(inscription);
    }
}