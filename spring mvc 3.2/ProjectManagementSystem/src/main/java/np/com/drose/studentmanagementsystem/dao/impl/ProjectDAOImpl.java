/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.ProjectDAO;
import np.com.drose.studentmanagementsystem.model.Project;
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
public class ProjectDAOImpl implements ProjectDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public int insertProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(project);
        tx.commit();
        Serializable id = session.getIdentifier(project);
        session.close();
        return (Integer) id;
    }

    @Override
    public List<Project> getProjectList() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Project> result = session.createCriteria(Project.class).add(Restrictions.ne("projectStatus", Project.ProjectStatus.FINISHED)).list();
        tx.commit();
        session.close();
        return result;

    }

   
    @Override
    public Project getProjectById(int id) {
       Session session = sessionFactory.openSession();
       Transaction tx = session.beginTransaction();
       Project project = (Project)session.get(Project.class, id);       
       tx.commit();
       session.close();
       return project; 
    }
    
    @Transactional
    @Override
    public int updateRow(Project project) {
        Session session =sessionFactory.openSession();
        Transaction tx =session.beginTransaction();
        if (project.getProjectId()!=null) {
            session.saveOrUpdate(project);
        }
        tx.commit();
        Serializable projectId =session.getIdentifier(project);
        session.close();
        return (Integer)projectId;
    }
    
   
    

}
