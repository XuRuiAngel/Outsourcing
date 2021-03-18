package com.example.book.demo.Service.ServiceImpl;

import com.example.book.demo.Mapper.UserMapper;
import com.example.book.demo.Model.User;
import com.example.book.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String tel) {

        return userMapper.login(tel);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void registerUser(String name, String tel, String college, String sex, String major, String classNum, String studentId, String password) {
        userMapper.registUser(name, tel, college, sex, major, classNum, studentId, password);
    }

    @Override
    public void registerSeller(String name, String tel, String password) {

    }
}
