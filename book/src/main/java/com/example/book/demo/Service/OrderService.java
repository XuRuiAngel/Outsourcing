package com.example.book.demo.Service;


import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    int addOrder(int uid, double price, String orderTime, int status, int model, int sellerId, int time, int bookId);

    Object getOrdersByUid(int uid);
}
