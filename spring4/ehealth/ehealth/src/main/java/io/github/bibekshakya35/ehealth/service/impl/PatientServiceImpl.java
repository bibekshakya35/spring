/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.model.Patient;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
public class PatientServiceImpl implements EhealthService<Patient> {

    @Autowired
    IGenericDao iGenericDao;

    @Autowired
    public void setiGenericDao(IGenericDao iGenericDao) {
        this.iGenericDao = iGenericDao;
        this.iGenericDao.setClazz(Patient.class);
    }

    @Override
    public void add(Patient t) {
        this.iGenericDao.create(t);
    }

    @Override
    public List<Patient> getList() {
        return this.iGenericDao.findAll();
    }

    @Override
    public void edit(Patient t) {
        this.iGenericDao.update(t);
    }

    @Override
    public Patient findOne(Object pk) {
        return (Patient)this.iGenericDao.findOne(pk);
    }

}
