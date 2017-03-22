/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.bibekshakya35.ehealth.DAO.genericdao;

import java.io.Serializable;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * {Insert class description here}
 *
 * @version $Revision: 1.1.1.1 $
 * @param <T>
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao< T extends Serializable>
        extends AbstractHibernateDao<T> implements IGenericDao<T> {

}
