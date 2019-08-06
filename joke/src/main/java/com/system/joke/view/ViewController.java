package com.system.joke.view;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/UserView")
    public String showUser () {

        return "User.html";
    }


}
