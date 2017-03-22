/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.UserDAO;
import np.com.drose.studentmanagementsystem.model.User;
import np.com.drose.studentmanagementsystem.security.Sha3Utils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bibekshakya
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public int insertUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            user.setPassword(Sha3Utils.hashPassword(user.getPassword()));
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.saveOrUpdate(user);
        tx.commit();
        Serializable id = session.getIdentifier(user);
        session.close();
        return (Integer) id;
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Criteria cr = session.createCriteria(User.class).add(Restrictions.eq("login", username));
        List<User> ls = cr.list();
        tx.commit();
        session.close();
        return ls.get(0);
    }

}
