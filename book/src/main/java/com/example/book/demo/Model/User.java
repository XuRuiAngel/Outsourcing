package com.example.book.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    private String name;

    private String password;

    private int type;

    private String tel;

    private String college;

    private String sex;

    private String major;

    private String classNum;

    private String studentId;

    private double account;

}
