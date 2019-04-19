package com.org.controller;

import com.org.client.ScheduleServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

  @Autowired
  ScheduleServiceHi sayHi;

  @RequestMapping(value = "/hi", method = RequestMethod.GET)
  public String sayHi(@RequestParam(value = "name") String name) {
    return sayHi.sayHiFromClient(name);
  }

}
