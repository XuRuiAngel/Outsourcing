package com.example.order.Controller;


import com.example.order.FeignClient.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TestController {

    @Autowired
    RestTemplate restTemplate;


    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/test")
    @ResponseBody
    public String  test(int id){
        return userFeignClient.getUser(id);
    }

}
