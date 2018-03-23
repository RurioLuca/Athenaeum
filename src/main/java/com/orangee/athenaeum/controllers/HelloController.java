package com.orangee.athenaeum.controllers;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }



    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String helloFromString() {
        return "index";
    }


    @RequestMapping(value = "/helloJson", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Map HelloFromJson() {
        Map<String, String> response = new HashMap<>();
        response.put("saluto", "Ciaoneeeee da Spring!");
        return response;
    }




    @RequestMapping(value = "/helloXml", produces = MediaType.APPLICATION_XML_VALUE )
    //@ResponseBody
    public Map HelloFromXml() {
        Map<String, String> response = new HashMap<>();
        response.put("saluto", "Ciaoneeeee da Spring!");
        return response;
    }
}
