package com.example.user.Service.ServiceImpl;


import com.example.user.Mapper.UserMapper;
import com.example.user.Model.User;
import com.example.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String studentId) {

        return userMapper.login(studentId);
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
