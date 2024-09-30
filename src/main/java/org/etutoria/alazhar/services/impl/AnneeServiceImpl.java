package org.etutoria.alazhar.services.impl;

import org.etutoria.alazhar.dao.AnneDao;
import org.etutoria.alazhar.dto.AnneeDto;
import org.etutoria.alazhar.entities.ANNEE;
import org.etutoria.alazhar.mapper.AnneeMapper;
import org.etutoria.alazhar.services.AnneeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnneeServiceImpl implements AnneeService {

    private final AnneDao anneeDao;
    private final AnneeMapper anneeMapper;

    public AnneeServiceImpl(AnneDao anneeDao, AnneeMapper anneeMapper) {
        this.anneeDao = anneeDao;
        this.anneeMapper = anneeMapper;
    }

    @Override
    public AnneeDto findOrCreateAnnee(String annee) {
        ANNEE anneeEntity = anneeDao.findByAnnee(annee)
                .orElseGet(() -> {//si l'année n'existe pas, on la crée
                    ANNEE newAnnee = new ANNEE();
                    newAnnee.setAnnee(annee);
                    return anneeDao.save(newAnnee);
                });
        return anneeMapper.fromAnnee(anneeEntity);
    }


}