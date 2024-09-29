package org.etutoria.alazhar.services.impl;

import lombok.AllArgsConstructor;
import org.etutoria.alazhar.dao.FicheDao;
import org.etutoria.alazhar.dao.StudentDao;
import org.etutoria.alazhar.dto.FicheEleveDto;
import org.etutoria.alazhar.entities.FicheEleve;
import org.etutoria.alazhar.entities.Student;
import org.etutoria.alazhar.mapper.FicheEleveMapper;
import org.etutoria.alazhar.services.FicheEleveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class FicheEleveServiceImpl implements FicheEleveService {
    private final FicheEleveMapper ficheEleveMapper;
    private final FicheDao ficheEleveRepository;
    private final StudentDao studentDao;

    @Override
    public FicheEleveDto createFicheEleve(FicheEleveDto ficheEleveDto) {
        FicheEleve ficheEleve = ficheEleveMapper.fromFicheEleveDto(ficheEleveDto);

        // Ensure student is properly set and persisted
        if (ficheEleveDto.getStudent() != null) {
            Student student = studentDao.findById(ficheEleveDto.getStudent().getStudentId())
                    .orElseThrow(() -> new IllegalArgumentException("Student not found"));
            ficheEleve.setStudent(student);
        } else {
            throw new IllegalArgumentException("Student cannot be null");
        }

        // Ensure annee is properly set and persisted
        if (ficheEleveDto.getAnnee() == null) {
            throw new IllegalArgumentException("Annee cannot be null");
        }

        FicheEleve savedFicheEleve = ficheEleveRepository.save(ficheEleve);
        return ficheEleveMapper.fromFicheEleve(savedFicheEleve);
    }
}