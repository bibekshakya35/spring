/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.model.Role;
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
public class RoleServiceImpl implements EhealthService<Role> {

    @Autowired
    IGenericDao<Role> roleGenericDao;

    @Autowired
    public void setRoleGenericDao(IGenericDao<Role> roleGenericDao) {
        this.roleGenericDao = roleGenericDao;
        roleGenericDao.setClazz(Role.class);
    }

    @Override
    public void add(Role t) {
        this.roleGenericDao.create(t);
    }

    @Override
    public List<Role> getList() {
        return this.roleGenericDao.findAll();
    }

    @Override
    public void edit(Role t) {
        this.roleGenericDao.update(t);
    }

    @Override
    public Role findOne(Object pk) {
        return this.roleGenericDao.findOne(pk);
    }

}
