package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.NiveauDto;
import org.etutoria.alazhar.entities.Niveau;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class NiveauMapper {

    public NiveauDto fromNiveau(Niveau niveau) {
        if (niveau == null) {
            return null;
        }
        NiveauDto niveauDto = new NiveauDto();
        BeanUtils.copyProperties(niveau, niveauDto);
        return niveauDto;
    }

    public Niveau fromNiveauDto(NiveauDto niveauDto) {
        if (niveauDto == null) {
            return null;
        }
        Niveau niveau = new Niveau();
        BeanUtils.copyProperties(niveauDto, niveau);
        return niveau;
    }
}