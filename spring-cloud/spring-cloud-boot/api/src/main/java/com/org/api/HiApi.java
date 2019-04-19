package com.org.api;

import com.org.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface HiApi {
    @RequestMapping(path = {"/api/test"}, method = RequestMethod.GET)
    String test(@RequestParam(value = "test") String test);

    @RequestMapping(value = "/api/getuser", method = RequestMethod.POST)
    User getUser(@RequestBody User user);
}
