package com.example.user.Service;



import com.example.user.Model.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {


    User login(String studentId);

    User getUserById(int id);

    void registerUser(String name, String tel, String college, String sex, String major, String classNum, String studentId, String password);

    void registerSeller(String name, String tel, String password);
}
