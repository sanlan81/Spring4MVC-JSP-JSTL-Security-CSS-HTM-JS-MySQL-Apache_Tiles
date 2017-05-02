package com.mysuperscore.controller;

import com.mysuperscore.dao.SongDaoJDBC;
import com.mysuperscore.model.User;
import com.mysuperscore.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class RegistrationController {
    @Autowired
    SongDaoJDBC songDaoJdbc;

    @Autowired
    FileValidator fileValidator;

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String registration(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String saveRegistration(@Valid User user,
                                   BindingResult result, ModelMap model) {


        fileValidator.validateUser(user, result);


        if (result.hasErrors()) {
            return "registration";
        }
        songDaoJdbc.createTableUsers();
        songDaoJdbc.createUser(user);
        return "login";
    }

}
