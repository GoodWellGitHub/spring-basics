package com.org.provider;

import com.org.api.HiApi;
import com.org.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiProvider implements HiApi {
    @Override
    public String test(String test) {
        return "test : " + test;
    }

    @Override
    public User getUser(@RequestBody User user) {
        if (user == null) {
            return new User("jack", 10);
        }
        return user;
    }
}
