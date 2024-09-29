package org.etutoria.alazhar.services.impl;

import org.etutoria.alazhar.dao.MoisDao;
import org.etutoria.alazhar.entities.Mois;
import org.etutoria.alazhar.services.MoisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MoisServiceImpl implements MoisService {

    private final MoisDao moisDao;

    public MoisServiceImpl(MoisDao moisDao) {
        this.moisDao = moisDao;
    }

    @Override
    public Mois findOrCreateMois(String mois) {
        return moisDao.findByMois(mois)
                .orElseGet(() -> {
                    Mois newMois = new Mois();
                    newMois.setMois(mois);
                    return moisDao.save(newMois);
                });
    }



}