package com.example.zuul.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "test", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String test() {
        return "test";
    }


    @RequestMapping(value = "index", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String index() {
        return "index";
    }
}
