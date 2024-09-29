package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.MoisDto;
import org.etutoria.alazhar.entities.Mois;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MoisMapper {

    public MoisDto fromMois(Mois mois) {
        if (mois == null) {
            return null;
        }
        MoisDto moisDto = new MoisDto();
        BeanUtils.copyProperties(mois, moisDto);
        return moisDto;
    }

    public Mois fromMoisDto(MoisDto moisDto) {
        if (moisDto == null) {
            return null;
        }
        Mois mois = new Mois();
        BeanUtils.copyProperties(moisDto, mois);
        return mois;
    }
}