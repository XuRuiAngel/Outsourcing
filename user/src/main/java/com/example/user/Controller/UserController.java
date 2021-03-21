package com.example.user.Controller;


import com.example.user.Model.User;
import com.example.user.Service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     *

     * @param password
     * @param request
     * @param response
     * @return
     */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(String studentId, String password, HttpServletRequest request, HttpServletResponse response) {

        User userforbase = userService.login(studentId);
        if (userforbase == null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "login fail, user not exist");
            jsonObject.put("code", "0");
            return jsonObject;
        }
        if (!userforbase.getPassword().equals(password)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "login fail，error password");
            jsonObject.put("code", "2");
            return jsonObject;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "login success");
        jsonObject.put("code", "1");

        JSONObject data=new JSONObject();
        data.put("id",userforbase.getId());
        data.put("type",userforbase.getType());


        jsonObject.put("data",data);
        return jsonObject;

    }

    /**
     * 注册个人用户
     *
     * @param name
     * @param tel
     * @param college
     * @param sex
     * @param major
     * @param classNum
     * @param studentId
     * @param password
     * @return
     */
    @RequestMapping(value = "/registUser", method = RequestMethod.POST)

    @ResponseBody
    public Object registUser(String name, String tel, String college, String sex, String major, String classNum, String studentId, String password) {
        User userforbase = userService.login(studentId);
        if (userforbase != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "该学号已被注册过");
            jsonObject.put("code", "0");
            return jsonObject;
        }
        userService.registerUser(name, tel, college, sex, major, classNum, studentId, password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "注册成功");
        jsonObject.put("code", "1");
        return jsonObject;
    }

    /**
     * 注册商家
     *
     * @param name
     * @param tel
     * @param college
     * @param sex
     * @param major
     * @param classNum
     * @param studentId
     * @param password
     * @return
     */
    @RequestMapping("/registSeller")
    @ResponseBody
    public Object registSeller(String name, String tel, String college, String sex, String major, String classNum, String studentId, String password) {
        User userforbase = userService.login(tel);
        if (userforbase != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "该电话号码已被注册过");
            jsonObject.put("status", "0");
            return jsonObject;
        }
        userService.registerUser(name, tel, college, sex, major, classNum, studentId, password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "注册成功");
        jsonObject.put("status", "1");
        return jsonObject;
    }




}
