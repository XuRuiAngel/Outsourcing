package com.example.book.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;

    private int uid;

    private int sellerId;

    private String orderTime;

    private int status;

    private int model;

    private int time;

    private double price;

    private int bookId;
}
