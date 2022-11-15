package com.hch.exam.ch_app_2022_10_13.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsrHomeController {
  int count;
  public UsrHomeController() {
    count = -1;
  }
  @RequestMapping("/usr/home/getCount")
  @ResponseBody
  public int getCount() {
    return count;
  }
  @RequestMapping("/usr/home/getString")
  @ResponseBody
  public String getString() {
    return "HI";
  }
  @RequestMapping("/usr/home/getInt")
  @ResponseBody
  public int getInt() {
    return 10;
  }
  @RequestMapping("/usr/home/getFloat")
  @ResponseBody
  public float getFloat() {
    return 10.5f;
  }
  @RequestMapping("/usr/home/getDouble")
  @ResponseBody
  public List<String> getList() {
    List<String> list = new ArrayList<>();
    list.add("철수");
    list.add("영희");
    return list;
  }
  @RequestMapping("/usr/home/getMap")
  @ResponseBody
  public Map<String, Object> getMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("철수나이", 22);
    map.put("영희나이", 21);
    return map;
  }

}