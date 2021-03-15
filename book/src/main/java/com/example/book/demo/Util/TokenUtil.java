package com.example.book.demo.Util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.book.demo.Model.User;

import java.util.Date;

public class TokenUtil {


    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    /**
     * 生成token 的方法
     * @param user
     * @return
     */
    public static String  getToken(User user){
        String token = "";
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        token = JWT.create().withAudience(user.getId())
                .withExpiresAt(date)
                .withClaim("id",user.getName())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
