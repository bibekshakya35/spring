/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.ProgressDao;
import np.com.drose.studentmanagementsystem.model.Progress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bibekshakya
 */
@Repository
public class ProgressDAOImpl implements ProgressDao{
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public int insertProgress(Progress progress) {
        Session session =sessionFactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.saveOrUpdate(progress);
        tx.commit();
        Serializable id = session.getIdentifier(progress);
        session.close();
        return (Integer)id;
    }
    
    @Transactional
    @Override
    public List<Progress> getProgressList() {
        Session session =sessionFactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        List<Progress> listProgress = session.createCriteria(Progress.class).list();
        tx.commit();
        session.close();
        return listProgress;
        
    }
    
    
    
    
}
