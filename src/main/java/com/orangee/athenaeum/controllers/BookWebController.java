package com.orangee.athenaeum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Luca on 27/03/2018.
 */
@Controller
public class BookWebController {


    @RequestMapping(value = "/findbook",method = RequestMethod.GET)
    public ModelAndView findBook(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("find_book");
        return modelAndView;
    }

}
