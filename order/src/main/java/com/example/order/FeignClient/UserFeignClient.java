package com.example.order.FeignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name="user",fallback = Fallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@RequestParam("id") int id);
}


@Component
class Fallback implements UserFeignClient{
    @Override
    public String getUser(int id){
        return "默认id=0";
    }
}