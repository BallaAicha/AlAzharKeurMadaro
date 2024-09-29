package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.ClasseDto;
import org.etutoria.alazhar.entities.Classe;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ClasseMapper {

    private final NiveauMapper niveauMapper;

    public ClasseMapper(NiveauMapper niveauMapper) {
        this.niveauMapper = niveauMapper;
    }

    public ClasseDto fromClasse(Classe classe) {
        if (classe == null) {
            return null;
        }
        ClasseDto classeDto = new ClasseDto();
        BeanUtils.copyProperties(classe, classeDto);
        classeDto.setNiveau(niveauMapper.fromNiveau(classe.getNiveau()));
        return classeDto;
    }

    public Classe fromClasseDto(ClasseDto classeDto) {
        if (classeDto == null) {
            return null;
        }
        Classe classe = new Classe();
        BeanUtils.copyProperties(classeDto, classe);
        classe.setNiveau(niveauMapper.fromNiveauDto(classeDto.getNiveau()));
        return classe;
    }
}