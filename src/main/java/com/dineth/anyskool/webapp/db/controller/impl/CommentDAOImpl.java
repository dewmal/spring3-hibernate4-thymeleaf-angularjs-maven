/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dineth.anyskool.webapp.db.controller.impl;

import com.dineth.anyskool.webapp.db.entity.Comment;
import com.dineth.anyskool.webapp.db.entity.CommentPK;

/**
 *
 * @author dewmalpc
 */
public class CommentDAOImpl extends AbstractDAOImpl<Comment, CommentPK> {

    public CommentDAOImpl() {
        super(Comment.class);
    }

    @Override
    public CommentPK save(Comment entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
