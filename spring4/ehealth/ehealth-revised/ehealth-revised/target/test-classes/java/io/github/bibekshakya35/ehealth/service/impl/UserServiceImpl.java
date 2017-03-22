/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.model.User;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Service
@Transactional
public class UserServiceImpl implements EhealthService<User> {

    @Autowired
    IGenericDao<User> genericDAO;

    @Transactional
    @Override
    public void add(User t) {
        genericDAO.create(t);
    }
    @Autowired
    public void setGenericDAO(IGenericDao<User> genericDAO) {
        this.genericDAO = genericDAO;
        genericDAO.setClazz(User.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getList() {
        return genericDAO.findAll();
    }
    @Transactional
    @Override
    public void edit(User t) {
        this.genericDAO.update(t);
    }
    @Transactional(readOnly = true)
    @Override
    public User findOne(Object pk) {
        return this.genericDAO.findOne(pk);
    }
    
    

}
