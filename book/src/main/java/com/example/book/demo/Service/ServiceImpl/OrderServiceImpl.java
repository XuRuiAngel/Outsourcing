package com.example.book.demo.Service.ServiceImpl;

import com.example.book.demo.Mapper.OrderMapper;
import com.example.book.demo.Model.Order;
import com.example.book.demo.Service.OrderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public int addOrder(int uid, double price, String orderTime, int status, int model, int sellerId, int time, int bookId) {
        List<Order> order = orderMapper.getOrderByBookId(bookId);
        if (order.size() != 0) {
            return 0;
        }
        orderMapper.addOrder(uid, price, orderTime, status, model, sellerId, time, bookId);
        return 1;
    }

    @Override
    public Object getOrdersByUid(int uid) {
        List<Order> orders = orderMapper.getOrdersByUid(uid);
        if (orders.size() == 0) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "无订单");
            jsonObject.put("status", "0");
            return jsonObject;
        }
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (Order order : orders) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", order.getId());
            jsonObject.put("uid", order.getUid());
            jsonObject.put("price", order.getPrice());
            jsonObject.put("orderTime", order.getOrderTime());
            jsonObject.put("status", order.getStatus());
            jsonObject.put("model", order.getModel());
            jsonObject.put("sellerId", order.getSellerId());
            jsonObject.put("time", order.getTime());
            jsonObject.put("bookId", order.getBookId());

            jsonArray.add(jsonObject);
        }
        result.put("status", 1);
        result.put("data", jsonArray);
        return result;
    }
}
