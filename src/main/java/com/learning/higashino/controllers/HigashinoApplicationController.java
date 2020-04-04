package com.learning.higashino.controllers;

import com.learning.higashino.services.HigashinoApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HigashinoApplicationController {

    @Autowired
    HigashinoApplicationService higashinoApplicationService;

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("msg",higashinoApplicationService.getHelloMsg());
        return "Higashino";
    }


}
