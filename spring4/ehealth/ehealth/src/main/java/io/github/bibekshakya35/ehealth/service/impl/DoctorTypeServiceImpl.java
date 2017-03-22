/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.model.DoctorType;
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
public class DoctorTypeServiceImpl implements EhealthService<DoctorType>{

    @Autowired
    IGenericDao<DoctorType> iGenericDao;

    public void setiGenericDao(IGenericDao<DoctorType> iGenericDao) {
        this.iGenericDao = iGenericDao;
        this.iGenericDao.setClazz(DoctorType.class);
    }
    @Override
    public void add(DoctorType t) {
        iGenericDao.create(t);
    }

    @Override
    public List<DoctorType> getList() {
        return iGenericDao.findAll();
    }

    @Override
    public void edit(DoctorType t) {
        iGenericDao.update(t);
    }

    @Override
    public DoctorType findOne(Object pk) {
        return iGenericDao.findOne(pk);
    }

}
