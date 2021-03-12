package com.example.book.demo.Controller;


import com.example.book.demo.Annotation.PassToken;
import com.example.book.demo.Annotation.UserLoginToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {


    @PassToken
    @RequestMapping(value = "test",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public String test(){
        return "test";
    }

}
