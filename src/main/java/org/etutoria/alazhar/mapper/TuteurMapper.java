package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.TuteurDto;
import org.etutoria.alazhar.entities.Tuteur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TuteurMapper {

    public TuteurDto fromTuteur(Tuteur tuteur) {
        if (tuteur == null) {
            return null;
        }
        TuteurDto tuteurDto = new TuteurDto();
        BeanUtils.copyProperties(tuteur, tuteurDto);
        return tuteurDto;
    }

    public Tuteur fromTuteurDto(TuteurDto tuteurDto) {
        if (tuteurDto == null) {
            return null;
        }
        Tuteur tuteur = new Tuteur();
        BeanUtils.copyProperties(tuteurDto, tuteur);
        return tuteur;
    }

    public void updateTuteurFromDto(TuteurDto tuteurDto, Tuteur tuteur) {//la pertinence de cette methode reside dans le fait que l'on ne peut pas modifier l'id d'un tuteur
        if (tuteurDto != null && tuteur != null) {
            BeanUtils.copyProperties(tuteurDto, tuteur, "tuteurId");
        }
    }
}