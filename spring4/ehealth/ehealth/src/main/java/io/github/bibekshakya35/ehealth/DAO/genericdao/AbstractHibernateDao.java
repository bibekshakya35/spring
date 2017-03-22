/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.DAO.genericdao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @param <T>
 * @param <T>
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Transactional
public abstract class AbstractHibernateDao<T extends Serializable> {

    private Class<T> clazz;
    
    Session session;

    @Autowired
    SessionFactory sessionFactory;

    private static final Logger LOG = Logger.getLogger(AbstractHibernateDao.class.getName());

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(Object id) {
        if (id instanceof String) {
            return (T) getCurrentSession().get(clazz, (String) id);
        }
        if (id instanceof Long) {
            return (T) getCurrentSession().get(clazz, (Long) id);
        }
        if (id instanceof Integer) {
            return (T) getCurrentSession().get(clazz, (Integer) id);
        }
        return null;
    }

    public List< T> findAll() {
        session = getCurrentSession();
        LOG.info("--------------------------Inside find all----------------------");
        List<T> list = session.createQuery("from " + clazz.getName()).list();
        LOG.log(Level.INFO, "--------------------size of Object-------------{0}", list.size());
        return list;

    }
    
    public List findAll(String queryName,Map<String,Object> parameters){
        Set<Map.Entry<String,Object>> rawParameters = parameters.entrySet();
        org.hibernate.Query query = getCurrentSession().getNamedQuery(queryName);
        rawParameters.stream().forEach((r)->{
            query.setParameter(r.getKey(), r.getValue());
        });
        return query.list();
    }
    public void create(T entity) {
        session = getCurrentSession();
        LOG.log(Level.INFO, "inside create entity and you just bind your session to the current one{0}", session.toString());
        session.saveOrUpdate(entity);
        LOG.info("saved");
        session.flush();
        session.refresh(entity);
    }
    
    
    
    public void update(T entity) {
        getCurrentSession().merge(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }
    public void deleteAll(List<T> entityList){
        entityList.stream().forEach(e->delete(e));
    }

    public void deleteById(Object entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
    

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
