package com.mysuperscore.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysuperscore.dao.SongDaoJDBC;
import com.mysuperscore.model.CheckPassword;
import com.mysuperscore.utils.PasswordChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    SongDaoJDBC songDaoJdbc;

    @RequestMapping(value = "/checkStrength", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String checkStrength(@RequestParam String password) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        CheckPassword checkPassword = new CheckPassword();

        if (password.length() != 0) {
            PasswordChecker passwordChecker = new PasswordChecker();
            checkPassword.strength = passwordChecker.getStrength(password);
        }
        return gson.toJson(checkPassword);
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String loginGood(ModelMap model) {

        return "redirect:/";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
