/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.RoleDAO;
import np.com.drose.studentmanagementsystem.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bibekshakya
 */

@Repository
public class RoleDAOImpl implements RoleDAO{
    @Autowired
    SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public int insertRow(Role role) {
        Session session =sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(role);
        Serializable id = session.getIdentifier(role);
        tx.commit();
        session.close();
        return (Integer)id;
        
    }
    
    @Transactional
    @Override
    public List<Role> getRoleList() {
        Session session =sessionFactory.openSession();
        Transaction tx =session.beginTransaction();
        List<Role> roleList = session.createCriteria(Role.class).list();
        tx.commit();
        session.close();
        return roleList;
                
    }

    @Override
    public Role getRole(int id) {
        Session session =sessionFactory.openSession();
        Transaction tx =session.beginTransaction();
        Role role =(Role)session.get(Role.class,id);
        tx.commit();
        session.close();
        return role;
    }
    
    
    
    
}
