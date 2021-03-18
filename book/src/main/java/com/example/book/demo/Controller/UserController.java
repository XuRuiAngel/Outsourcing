package com.example.book.demo.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.example.book.demo.Annotation.PassToken;
import com.example.book.demo.Annotation.UserLoginToken;
import com.example.book.demo.Model.User;
import com.example.book.demo.Service.UserService;
import com.example.book.demo.Util.TokenUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 个人用户登录
     *
     * @param tel
     * @param password
     * @param request
     * @param response
     * @return
     */
    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(String tel, String password, HttpServletRequest request, HttpServletResponse response) {

        User userforbase = userService.login(tel);

        if (userforbase == null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "登录失败，用户不存在");
            jsonObject.put("status", "0");
            return jsonObject;
        }
        if (!userforbase.getPassword().equals(password)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "登录失败，密码错误");
            jsonObject.put("status", "2");
            return jsonObject;
        }

        String token = TokenUtil.getToken(userforbase);
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(30000);
        response.addCookie(cookie);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "登录成功");
        jsonObject.put("status", "1");
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
    @PassToken
    @ResponseBody
    public Object registUser(String name, String tel, String college, String sex, String major, String classNum, String studentId, String password) {
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
    @PassToken
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


    @UserLoginToken
    @RequestMapping("/getmessage")
    public String getmessage(HttpServletRequest request) {

        String token = request.getHeader("token");
        String id = JWT.decode(token).getAudience().get(0);
        Claim name = JWT.decode(token).getClaim("name");
        return id + "你已经通过验证" + name.asString();
    }


}
