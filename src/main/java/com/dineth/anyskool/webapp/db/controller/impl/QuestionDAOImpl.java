/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dineth.anyskool.webapp.db.controller.impl;

import com.dineth.anyskool.webapp.db.entity.Question;

/**
 *
 * @author dewmalpc
 */
public class QuestionDAOImpl extends AbstractDAOImpl<Question, String> {

    public QuestionDAOImpl() {
        super(Question.class);
    }

    @Override
    public String save(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
