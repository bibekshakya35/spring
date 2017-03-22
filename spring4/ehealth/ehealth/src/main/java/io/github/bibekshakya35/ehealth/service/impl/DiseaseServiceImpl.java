/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.model.Disease;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Service
public class DiseaseServiceImpl implements EhealthService<Disease> {

    @Autowired
    IGenericDao<Disease> iGenericDao;
    
    @Autowired
    public void setiGenericDao(IGenericDao<Disease> iGenericDao) {
        this.iGenericDao = iGenericDao;
        this.iGenericDao.setClazz(Disease.class);
    }
    
    @Override
    public void add(Disease t) {
        this.iGenericDao.create(t);
    }
    
    @Override
    public List<Disease> getList() {
        return this.iGenericDao.findAll();
    }
    
    @Override
    public void edit(Disease t) {
        this.iGenericDao.update(t);
    }
    
    @Override
    public Disease findOne(Object pk) {
        return this.iGenericDao.findOne(pk);
    }
    
}
