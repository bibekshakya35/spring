/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.model.Cure;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Service
public class CureServiceImpl implements EhealthService<Cure>{
    @Autowired
    IGenericDao<Cure> iGenericDao;

    public void setiGenericDao(IGenericDao<Cure> iGenericDao) {
        this.iGenericDao = iGenericDao;
        this.iGenericDao.setClazz(Cure.class);
    }

    @Override
    public void add(Cure t) {
        this.iGenericDao.create(t);
    }

    @Override
    public List<Cure> getList() {
        return iGenericDao.findAll();
    }

    @Override
    public void edit(Cure t) {
        this.iGenericDao.update(t);
    }

    @Override
    public Cure findOne(Object pk) {
        return this.iGenericDao.findOne(pk);
    }
    
    
    
    
    
    
}
