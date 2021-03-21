package com.example.user.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/getUser")
    @ResponseBody
    public String getUser(int id){
        return "用户："+id;
    }


}
