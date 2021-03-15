package com.example.book.demo.Service;


import com.example.book.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Service
public interface UserService {


    User login(String tel);

    User getUserById(int id);

    void registerUser(String name,String tel,String college,String sex,String major,String classNum,String studentId,String password);

    void registerSeller(String name,String tel,String password);
}
