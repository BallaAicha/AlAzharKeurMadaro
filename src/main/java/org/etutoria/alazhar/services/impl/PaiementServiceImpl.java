package org.etutoria.alazhar.services.impl;

import lombok.AllArgsConstructor;
import org.etutoria.alazhar.dao.PaymentDao;
import org.etutoria.alazhar.dao.StudentDao;
import org.etutoria.alazhar.dto.PaiementDto;
import org.etutoria.alazhar.entities.*;
import org.etutoria.alazhar.mapper.PaiementMapper;
import org.etutoria.alazhar.services.AnneeService;
import org.etutoria.alazhar.services.MoisService;
import org.etutoria.alazhar.services.PaiementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PaiementServiceImpl implements PaiementService {
    private final PaiementMapper paiementMapper;
    private final PaymentDao paiementRepository;
    private final AnneeService anneeService;
    private final MoisService moisService;
    private final StudentDao studentDao;

    @Override
    public PaiementDto createPaiement(PaiementDto paiementDto) {
        // Ensure Annee and Mois are persisted
        ANNEE annee = anneeService.findOrCreateAnnee(paiementDto.getAnnee().getAnnee()).toEntity();
        Mois mois = moisService.findOrCreateMois(paiementDto.getMois().getMois());

        // Ensure Student is properly set and persisted
        Student student = studentDao.findById(paiementDto.getStudent().getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        // Map DTO to entity
        Paiement paiement = paiementMapper.fromPaiementDto(paiementDto);
        paiement.setAnnee(annee);
        paiement.setMois(mois);
        paiement.setStudent(student);
        paiement.setTypePaiement(TypePaiment.valueOf(paiementDto.getTypePaiement()));

        // Save Paiement entity
        Paiement savedPaiement = paiementRepository.save(paiement);
        return paiementMapper.fromPaiement(savedPaiement);
    }
}