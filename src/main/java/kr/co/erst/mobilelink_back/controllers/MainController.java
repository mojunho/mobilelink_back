package kr.co.erst.mobilelink_back.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"", "/"})
public class MainController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login() throws Exception {
        return "login/login";
    }

    @RequestMapping(value = "/errorpage", method = RequestMethod.GET)
    public String error() throws Exception {
        return "login/error";
    }

}
