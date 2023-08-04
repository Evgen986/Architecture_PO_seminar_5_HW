package ru.evgen.market.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/help")
public class HelpController {

    @GetMapping("/about")
    public String about(){
        return "help/about";
    }

    @GetMapping("/delivery")
    public String delivery(){
        return "help/delivery";
    }

    @GetMapping("/payment")
    public String payment(){
        return "help/payment";
    }

    @GetMapping("/return")
    public String refund() {
        return "help/return";
    }

}
