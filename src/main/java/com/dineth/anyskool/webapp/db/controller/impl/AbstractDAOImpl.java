package com.dineth.anyskool.webapp.db.controller.impl;

import com.dineth.anyskool.webapp.db.controller.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dewmalpc
 * Date: 6/21/13
 * Time: 1:18 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDAOImpl<T, E extends Serializable> implements AbstractDAO<T, E> {


    private Class<T> entityClass;

    public AbstractDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void update(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public T get(E id) {
        return (T) getCurrentSession().get(entityClass, id);
    }

    @Override
    public List<T> getAll(Class<T> entityClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> retriveQuery(Class<T> entityClass, String query) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
