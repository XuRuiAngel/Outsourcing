package com.example.book.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;

    private String name;

    private String author;

    private String type;

    private double price;

    private String content;

    private int uid;

    private String publisher;

    private String publishTime;

    private String version;

    private double depreciationRate;

    private String remark;

    private int state;

    private String ISBN;
}
