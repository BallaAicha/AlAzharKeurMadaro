package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.InscriptionDto;
import org.etutoria.alazhar.entities.Inscription;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class InscriptionMapper {

    private final AnneeMapper anneeMapper;
    private final ClasseMapper classeMapper;

    public InscriptionMapper(AnneeMapper anneeMapper, ClasseMapper classeMapper) {
        this.anneeMapper = anneeMapper;
        this.classeMapper = classeMapper;
    }

    public InscriptionDto fromInscription(Inscription inscription) {
        if (inscription == null) {
            return null;
        }
        InscriptionDto inscriptionDto = new InscriptionDto();
        BeanUtils.copyProperties(inscription, inscriptionDto);
        inscriptionDto.setAnnee(anneeMapper.fromAnnee(inscription.getAnnee()));
        inscriptionDto.setClasse(classeMapper.fromClasse(inscription.getClasse()));
        return inscriptionDto;
    }

    public Inscription fromInscriptionDto(InscriptionDto inscriptionDto) {
        if (inscriptionDto == null) {
            return null;
        }
        Inscription inscription = new Inscription();
        BeanUtils.copyProperties(inscriptionDto, inscription);
        inscription.setAnnee(anneeMapper.fromAnneeDto(inscriptionDto.getAnnee()));
        inscription.setClasse(classeMapper.fromClasseDto(inscriptionDto.getClasse()));
        return inscription;
    }
}