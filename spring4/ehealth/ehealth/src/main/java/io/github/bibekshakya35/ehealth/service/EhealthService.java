/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.bibekshakya35.ehealth.service;

import java.util.List;

/**
 *{Insert class description here}
 * @version $Revision: 1.1.1.1 $
 * @param <T>
 * @since Build {insert version here} (MM YYYY)
 * @author bibek
 */
public interface EhealthService<T> {
    void add(T t);
    List<T> getList();
    void edit(T t);
    T findOne(Object pk);
    default List<T> findAll(String code){
        List<T> list = null;
        return list;
    }
    default void deleteAll(List<T> entityList){
        return;
    }
}
