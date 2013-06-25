/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dineth.anyskool.webapp.db.controller;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dewmalpc
 */
public interface AbstractDAO<T, E extends Serializable> {

    /**
     * Save give Entity
     *
     * @param entity
     * @return
     */
    public E save(T entity);

    /**
     * Update Given Entity
     *
     * @param entity
     */
    public void update(T entity);

    /**
     * Get Entity From given ID
     *
     * @param id
     * @return
     */
    public T get(E id);

    /**
     * GEt all entity from given type
     *
     * @param entityClass
     * @return
     */
    public List<T> getAll(Class<T> entityClass);

    /**
     *
     * Retrive Query
     *
     * @param entityClass
     * @param query
     * @return
     */
    public List<T> retriveQuery(Class<T> entityClass, String query);
}
