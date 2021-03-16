package com.example.book.demo.Mapper;


import com.example.book.demo.Model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    @Insert("insert into book.order(uid,price,orderTime,status,model,sellerId,time,bookId) " +
            "values(#{uid},#{price},#{orderTime},#{status},#{model},#{sellerId},#{time},#{bookId})")
    void addOrder(int uid, double price, String orderTime, int status, int model, int sellerId, int time, int bookId);

    @Select("select * from book.order where bookId=#{bookId} and status=0")
    List<Order> getOrderByBookId(int bookId);

    @Select("select * from book.order where uid=#{uid}")
    List<Order> getOrdersByUid(int uid);
}
