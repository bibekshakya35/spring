/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.TeamDAO;
import np.com.drose.studentmanagementsystem.model.Employee;
import np.com.drose.studentmanagementsystem.model.Team;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
public class TeamDAOImpl implements TeamDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public int addTeam(Team team) {
        //open the session 
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(team);
        tx.commit();
        Serializable id = session.getIdentifier(tx);
        session.close();
        return (Integer) id;
    }

    @Transactional
    @Override
    public List<String> getTeamList() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<String> result = (List<String>) session.createQuery("SELECT DISTINCT teamName from Team").list();
        tx.commit();
        session.close();
        return result;
    }

    @Transactional
    @Override
    public List<Team> getTeam() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Team> result = (List<Team>) session.createCriteria(Team.class).list();
        tx.commit();
        session.close();
        return result;
    }

    @Transactional
    @Override
    public List<Team> getTeamMember(String teamName) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria cr = session.createCriteria(Team.class);
        List<Team> listTeam = cr.add(Restrictions.eq("teamName", teamName)).list();
        tx.commit();
        session.close();
        return listTeam;
    }

}
