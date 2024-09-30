package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.FicheEleveDto;
import org.etutoria.alazhar.entities.FicheEleve;
import org.etutoria.alazhar.entities.Student;
import org.etutoria.alazhar.entities.TypeFiche;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FicheEleveMapper {

    private final AnneeMapper anneeMapper;
    private final StudentMapper studentMapper;

    public FicheEleveMapper(AnneeMapper anneeMapper, StudentMapper studentMapper) {
        this.anneeMapper = anneeMapper;
        this.studentMapper = studentMapper;
    }

    public FicheEleveDto fromFicheEleve(FicheEleve ficheEleve) {
        if (ficheEleve == null) {
            return null;
        }
        FicheEleveDto ficheEleveDto = new FicheEleveDto();
        BeanUtils.copyProperties(ficheEleve, ficheEleveDto);
        ficheEleveDto.setAnnee(anneeMapper.fromAnnee(ficheEleve.getAnnee()));
        ficheEleveDto.setStudent(studentMapper.fromStudent(ficheEleve.getStudent()));
        ficheEleveDto.setTypeFiche(ficheEleve.getTypeFiche().name());
        return ficheEleveDto;
    }

    public FicheEleve fromFicheEleveDto(FicheEleveDto ficheEleveDto) {
        if (ficheEleveDto == null) {
            return null;
        }
        FicheEleve ficheEleve = new FicheEleve();
        BeanUtils.copyProperties(ficheEleveDto, ficheEleve);
        ficheEleve.setAnnee(anneeMapper.fromAnneeDto(ficheEleveDto.getAnnee()));
        ficheEleve.setStudent(studentMapper.fromStudentDto(ficheEleveDto.getStudent()));
        ficheEleve.setTypeFiche(TypeFiche.valueOf(ficheEleveDto.getTypeFiche()));
        return ficheEleve;
    }
}