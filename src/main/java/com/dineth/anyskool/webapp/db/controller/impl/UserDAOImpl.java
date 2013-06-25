package com.dineth.anyskool.webapp.db.controller.impl;

import com.dineth.anyskool.webapp.db.entity.User;

/**
 * Created with IntelliJ IDEA. User: dewmalpc Date: 6/21/13 Time: 1:28 AM To
 * change this template use File | Settings | File Templates.
 */
public class UserDAOImpl extends AbstractDAOImpl<User, String> {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public String save(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
