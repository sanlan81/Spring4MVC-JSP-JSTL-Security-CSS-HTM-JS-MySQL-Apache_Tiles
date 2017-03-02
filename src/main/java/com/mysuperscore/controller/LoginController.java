package com.mysuperscore.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysuperscore.model.CheckPassword;
import com.mysuperscore.utils.PasswordChecker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class LoginController {

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
}
