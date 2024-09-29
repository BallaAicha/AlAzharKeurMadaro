package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.AnneeDto;
import org.etutoria.alazhar.entities.ANNEE;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AnneeMapper {

    public AnneeDto fromAnnee(ANNEE annee) {
        if (annee == null) {
            return null;
        }
        AnneeDto anneeDto = new AnneeDto();
        BeanUtils.copyProperties(annee, anneeDto);
        return anneeDto;
    }

    public ANNEE fromAnneeDto(AnneeDto anneeDto) {
        if (anneeDto == null) {
            return null;
        }
        ANNEE annee = new ANNEE();
        BeanUtils.copyProperties(anneeDto, annee);
        return annee;
    }
}