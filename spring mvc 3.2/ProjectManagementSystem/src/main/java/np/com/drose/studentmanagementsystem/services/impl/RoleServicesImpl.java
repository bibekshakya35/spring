/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.RoleDAO;
import np.com.drose.studentmanagementsystem.model.Role;
import np.com.drose.studentmanagementsystem.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bibekshakya
 */
@Service
@Transactional
public class RoleServicesImpl implements RoleServices{
    
    @Autowired
    RoleDAO roleDao;

    @Override
    public int insertRow(Role role) {
        return roleDao.insertRow(role);
                
    }

    @Override
    public List<Role> getRolesList() {
        return roleDao.getRoleList();
                
    }

    @Override
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }
    
    
    
    
    
    
}
