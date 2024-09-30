package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.PaiementDto;
import org.etutoria.alazhar.entities.Paiement;
import org.etutoria.alazhar.entities.Student;
import org.etutoria.alazhar.entities.TypePaiment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PaiementMapper {

    private final AnneeMapper anneeMapper;
    private final MoisMapper moisMapper;
    private final StudentMapper studentMapper;

    public PaiementMapper(AnneeMapper anneeMapper, MoisMapper moisMapper, StudentMapper studentMapper) {
        this.anneeMapper = anneeMapper;
        this.moisMapper = moisMapper;
        this.studentMapper = studentMapper;
    }

    public PaiementDto fromPaiement(Paiement paiement) {
        if (paiement == null) {
            return null;
        }
        PaiementDto paiementDto = new PaiementDto();
        BeanUtils.copyProperties(paiement, paiementDto);
        paiementDto.setAnnee(anneeMapper.fromAnnee(paiement.getAnnee()));
        paiementDto.setMois(moisMapper.fromMois(paiement.getMois()));
        paiementDto.setStudent(studentMapper.fromStudent(paiement.getStudent()));
        paiementDto.setTypePaiement(String.valueOf(paiement.getTypePaiement()));
        return paiementDto;
    }

    public Paiement fromPaiementDto(PaiementDto paiementDto) {
        if (paiementDto == null) {
            return null;
        }
        Paiement paiement = new Paiement();
        BeanUtils.copyProperties(paiementDto, paiement);
        paiement.setAnnee(anneeMapper.fromAnneeDto(paiementDto.getAnnee()));
        paiement.setMois(moisMapper.fromMoisDto(paiementDto.getMois()));
        paiement.setStudent(studentMapper.fromStudentDto(paiementDto.getStudent()));
        paiement.setTypePaiement(TypePaiment.valueOf(paiementDto.getTypePaiement()));
        return paiement;
    }
}