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
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PassToken
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(User user , BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){
        if(bindingResult.hasErrors()){
            throw new RuntimeException(bindingResult.getFieldError().toString());
        }
        User userforbase =  userService.getUserByName(user.getName());

        if(userforbase==null){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("message","登录失败，用户不存在");
            return jsonObject;
        }
        if(!userforbase.getPassword().equals(user.getPassword())){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("message","登录失败，密码错误");
            return jsonObject;
        }

        String token = TokenUtil.getToken(userforbase);
        Cookie cookie=new Cookie("token",token);
        cookie.setMaxAge(30000);
        response.addCookie(cookie);
        return token;
    }
    @UserLoginToken
    @RequestMapping("/getmessage")
    public String getmessage(HttpServletRequest request){

        String token  =  request.getHeader("token");
        String id=JWT.decode(token).getAudience().get(0);
        Claim name =JWT.decode(token).getClaim("name");
        return id+"你已经通过验证"+name.asString();
    }


}
