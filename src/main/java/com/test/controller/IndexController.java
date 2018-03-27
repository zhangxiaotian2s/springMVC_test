package com.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView Home(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> map = new HashMap<>();
        map.put("indexMes","hello word");
        return new ModelAndView("index",map);
    }


}


