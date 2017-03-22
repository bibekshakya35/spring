/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.model.Doctor;
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
public class DoctorServiceImpl implements EhealthService<Doctor>{
   @Autowired
   IGenericDao<Doctor> iGenericDao;

    public void setiGenericDao(IGenericDao<Doctor> iGenericDao) {
        this.iGenericDao = iGenericDao;
        this.iGenericDao.setClazz(Doctor.class);
    }

    @Override
    public void add(Doctor t) {
        this.iGenericDao.create(t);
    }

    @Override
    public List<Doctor> getList() {
        return this.iGenericDao.findAll();
    }

    @Override
    public void edit(Doctor t) {
        iGenericDao.update(t);
    }

    @Override
    public Doctor findOne(Object pk) {
        return iGenericDao.findOne(pk);
    }
    
    
   
   
}
