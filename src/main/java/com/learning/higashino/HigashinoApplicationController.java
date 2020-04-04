package com.learning.higashino;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import sun.misc.Request;

@Controller
public class HigashinoApplicationController {

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav){
        mav.addObject("msg","Hello and FUCK WORLD");
        mav.setViewName("Higashino");
        return mav;
    }


}
