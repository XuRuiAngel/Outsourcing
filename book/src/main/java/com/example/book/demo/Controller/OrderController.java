package com.example.book.demo.Controller;


import com.auth0.jwt.JWT;
import com.example.book.demo.Annotation.PassToken;
import com.example.book.demo.Annotation.UserLoginToken;
import com.example.book.demo.Service.OrderService;
import com.example.book.demo.Util.TimeUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;


    /**
     * 新建订单
     *
     * @param request
     * @param price
     * @param model
     * @param time
     * @param sellerId
     * @param bookId
     * @return
     */

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    @ResponseBody
    Object addOrder(HttpServletRequest request, double price, int model, int time, int sellerId, int bookId) {
        String token = request.getHeader("token");
        int id = Integer.parseInt(JWT.decode(token).getAudience().get(0));

        String nowTime = new TimeUtil().getFormatDateForSix();

        int flag = orderService.addOrder(id, price, nowTime, 0, model, sellerId, time, bookId);

        if (flag == 0) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "抱歉!该书已被下单");
            jsonObject.put("status", "0");
            return jsonObject;
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "下单成功");
        jsonObject.put("status", "1");

        return jsonObject;
    }

    /**
     * 获取用户的订单列表(不是所有的，是目前登录用户发起的订单列表)
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    @ResponseBody
    Object getOrders(HttpServletRequest request) {
        String token = request.getHeader("token");
        int id = Integer.parseInt(JWT.decode(token).getAudience().get(0));
        return orderService.getOrdersByUid(id);
    }



}
