package com.example.book.demo.Service;


import com.example.book.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();
    public void getUserlist(){
        User user1 = new User("1","liming","liming");
        User user2 = new User("2","limin","liming");
        User user3 = new User("3","limi","liming");
        User user4 = new User("4","lim","liming");
        User user5 = new User("5","li","liming");
        this.userList.add(user1);
        this.userList.add(user2);
        this.userList.add(user3);
        this.userList.add(user4);
        this.userList.add(user5);


    }
    public UserService(){
        getUserlist();
    }
    public User getUser(String id) {

        User user = null;
        for (User usertest:userList
        ) {
            if(usertest.getId().equals(id))
            {
                user = usertest;
            }

        }
        return user;
    }
    public User getUserByName(String username){

        for (User user:userList
        ) {
            if(user.getName().equals(username)){
                return user;
            }
        }
        return null;
    }


}
