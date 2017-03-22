/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.model.GroupPermission;
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
public class GroupPermissionServiceImpl implements EhealthService<GroupPermission> {

    @Autowired
    IGenericDao<GroupPermission> iGenericDao;

    @Autowired
    public void setiGenericDao(IGenericDao<GroupPermission> iGenericDao) {
        this.iGenericDao = iGenericDao;
        iGenericDao.setClazz(GroupPermission.class);
    }

    @Override
    public void add(GroupPermission t) {
        iGenericDao.create(t);
    }

    @Override
    public List<GroupPermission> getList() {
        return iGenericDao.findAll();
    }

    @Override
    public void edit(GroupPermission t) {
        iGenericDao.update(t);
    }

    @Override
    public GroupPermission findOne(Object pk) {
        return iGenericDao.findOne(pk);
    }
}
