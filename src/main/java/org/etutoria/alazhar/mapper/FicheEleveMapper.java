package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.FicheEleveDto;
import org.etutoria.alazhar.entities.FicheEleve;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FicheEleveMapper {

    private final AnneeMapper anneeMapper;

    public FicheEleveMapper(AnneeMapper anneeMapper) {
        this.anneeMapper = anneeMapper;
    }

    public FicheEleveDto fromFicheEleve(FicheEleve ficheEleve) {
        if (ficheEleve == null) {
            return null;
        }
        FicheEleveDto ficheEleveDto = new FicheEleveDto();
        BeanUtils.copyProperties(ficheEleve, ficheEleveDto);
        ficheEleveDto.setAnnee(anneeMapper.fromAnnee(ficheEleve.getAnnee()));
        return ficheEleveDto;
    }

    public FicheEleve fromFicheEleveDto(FicheEleveDto ficheEleveDto) {
        if (ficheEleveDto == null) {
            return null;
        }
        FicheEleve ficheEleve = new FicheEleve();
        BeanUtils.copyProperties(ficheEleveDto, ficheEleve);
        ficheEleve.setAnnee(anneeMapper.fromAnneeDto(ficheEleveDto.getAnnee()));
        return ficheEleve;
    }
}