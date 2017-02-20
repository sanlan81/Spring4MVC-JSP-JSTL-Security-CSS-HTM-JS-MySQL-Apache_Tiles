package com.mysuperscore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class LoginController {
    private static final int WEAK_STRENGTH = 1;
    private static final int FEAR_STRENGTH = 5;
    private static final int STRONG_STRENGTH = 7;

    private static final String WEAK_COLOR = "#FF0000";
    private static final String FEAR_COLOR = "#FF9900";
    private static final String STRONG_COLOR = "#006400";

    @RequestMapping(value = "/checkStrength",method = RequestMethod.GET,produces = {"text/html"})
    @ResponseBody
    public String checkStrength(@RequestParam String password){
        String result = "<span style=\"color:%s; font-weight:hold;\">%s</span>";
         if(password.length() >= WEAK_STRENGTH & password.length() < FEAR_STRENGTH){

             return String.format(result,WEAK_COLOR,"WEAK");
         }else if(password.length() >= FEAR_STRENGTH & password.length() < STRONG_STRENGTH){

             return String.format(result,FEAR_COLOR,"MEDIUM");
         }else if(password.length() >= STRONG_STRENGTH){

             return String.format(result,STRONG_COLOR,"STRONG");
         }
         return "";
    }
}
