package com.hch.exam.ch_app_2022_10_13.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
   @RequestMapping("/usr/home/main")
  @ResponseBody
  public String main() {
    return "안녕";
  }
}