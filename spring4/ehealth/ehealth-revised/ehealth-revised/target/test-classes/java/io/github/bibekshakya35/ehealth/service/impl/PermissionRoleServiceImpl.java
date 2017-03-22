/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.model.PermissionRole;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class PermissionRoleServiceImpl implements EhealthService<PermissionRole> {

    @Autowired
    IGenericDao<PermissionRole> iGenericDao;

    @Autowired
    public void setiGenericDao(IGenericDao<PermissionRole> iGenericDao) {
        this.iGenericDao = iGenericDao;
        this.iGenericDao.setClazz(PermissionRole.class);
    }

    @Override
    public void add(PermissionRole t) {
        this.iGenericDao.create(t);
    }

    @Override
    public List<PermissionRole> getList() {
        return this.iGenericDao.findAll();
    }

    @Override
    public void edit(PermissionRole t) {
        this.iGenericDao.update(t);
    }

    @Override
    public PermissionRole findOne(Object pk) {
        return iGenericDao.findOne(pk);
    }

    @Override
    public List<PermissionRole> findAll(String code) {
       Map<String, Object> parameter = new HashMap<>();
       parameter.put("code",code);
       return this.iGenericDao.findAll(PermissionRole.PERMISSION_ROLE_FIND_BY_ROLECODE, parameter);
    }

    @Override
    public void deleteAll(List<PermissionRole> entityList) {
        iGenericDao.deleteAll(entityList);
                
    }
}
