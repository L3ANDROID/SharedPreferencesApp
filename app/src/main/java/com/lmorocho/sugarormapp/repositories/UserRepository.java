package com.lmorocho.sugarormapp.repositories;

import com.lmorocho.sugarormapp.models.User;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static void create(String fullname, String email, String password) {

        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);

        SugarRecord.save(user);
    }

    public static User login(String email, String password){

        List<User> users = SugarRecord.find(User.class,
                "email=? and password=?", email, password);

        if(!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }

}