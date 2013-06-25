/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dineth.anyskool.webapp;

import com.dineth.anyskool.webapp.db.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author dewmalpc
 */
@Controller
public class HomeController {

    private static final Logger LOG = Logger.getLogger(HomeController.class.getName());
    @Autowired
    private org.hibernate.SessionFactory sessionFactory;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeForm(Model model) {
        LOG.info("Welcome home! from Thymeleaf");

        Session session = sessionFactory.openSession(); // not part of a transaction, so we need to open a session manually
        Query query = session.createQuery("from User u where u.uid=:id").setString("id", "903064951V");
        User a = (User) query.uniqueResult();
        session.close();
        model.addAttribute("controllerMessage", a.getName());

        return "index";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String create(
            @Valid @ModelAttribute("messageInfo") User messageForm,
            BindingResult result) {

        if (result.hasErrors()) {
            return "index";
        }

        
        return "redirect:/list";

    }
}
