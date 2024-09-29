package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.PaiementDto;
import org.etutoria.alazhar.entities.Paiement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PaiementMapper {

    private final AnneeMapper anneeMapper;
    private final MoisMapper moisMapper;

    public PaiementMapper(AnneeMapper anneeMapper, MoisMapper moisMapper) {
        this.anneeMapper = anneeMapper;
        this.moisMapper = moisMapper;
    }

    public PaiementDto fromPaiement(Paiement paiement) {
        if (paiement == null) {
            return null;
        }
        PaiementDto paiementDto = new PaiementDto();
        BeanUtils.copyProperties(paiement, paiementDto);
        paiementDto.setAnnee(anneeMapper.fromAnnee(paiement.getAnnee()));
        paiementDto.setMois(moisMapper.fromMois(paiement.getMois()));
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
        return paiement;
    }
}