package org.etutoria.alazhar.services.impl;

import org.etutoria.alazhar.dao.ClasseDao;
import org.etutoria.alazhar.dto.ClasseDto;
import org.etutoria.alazhar.entities.Classe;
import org.etutoria.alazhar.mapper.ClasseMapper;
import org.etutoria.alazhar.services.ClasseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClasseServiceImpl implements ClasseService {

    private final ClasseDao classeDao;
    private final ClasseMapper classeMapper;

    public ClasseServiceImpl(ClasseDao classeDao, ClasseMapper classeMapper) {
        this.classeDao = classeDao;
        this.classeMapper = classeMapper;
    }

    @Override
    public ClasseDto findOrCreateClasse(String className) {
        Classe classe = classeDao.findByClassName(className)
                .orElseGet(() -> {
                    Classe newClasse = new Classe();
                    newClasse.setClassName(className);
                    return classeDao.save(newClasse);
                });
        return classeMapper.fromClasse(classe);
    }
}