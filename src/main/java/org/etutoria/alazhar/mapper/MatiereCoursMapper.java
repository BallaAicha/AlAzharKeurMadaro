package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.MatiereCoursDto;
import org.etutoria.alazhar.entities.MatiereCours;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MatiereCoursMapper {

    public MatiereCoursDto fromMatiereCours(MatiereCours matiereCours) {
        if (matiereCours == null) {
            return null;
        }
        MatiereCoursDto matiereCoursDto = new MatiereCoursDto();
        BeanUtils.copyProperties(matiereCours, matiereCoursDto);
        return matiereCoursDto;
    }

    public MatiereCours fromMatiereCoursDto(MatiereCoursDto matiereCoursDto) {
        if (matiereCoursDto == null) {
            return null;
        }
        MatiereCours matiereCours = new MatiereCours();
        BeanUtils.copyProperties(matiereCoursDto, matiereCours);
        return matiereCours;
    }
}