/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.bibekshakya35.ehealth.DAO.genericdao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1.1 $
 * @param <T>
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
public interface IGenericDao<T extends Serializable> {
 
   T findOne(Object id);
 
   List<T> findAll();
 
   void create(final T entity);
 
   void update(final T entity);
 
   void delete(final T entity);
 
   void deleteById(final Object entityId);
   
   public void deleteAll(List<T> entityList);
   
   List findAll(String queryName,Map<String,Object> parameters);
   
   public void setClazz( Class< T > clazzToSet );
}
