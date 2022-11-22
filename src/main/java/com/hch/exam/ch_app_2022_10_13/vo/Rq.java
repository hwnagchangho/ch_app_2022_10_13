package com.hch.exam.ch_app_2022_10_13.vo;

import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Rq {
  @Getter
  private boolean isLogined;
  @Getter
  private int loginedMemberId;
  public Rq(HttpServletRequest req) {
    HttpSession httpSession = req.getSession();
    boolean isLogined = false;
    int loginedMemberId = 0;

    if (httpSession.getAttribute("loginedMemberId") != null) {
      isLogined = true;
      loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
    }

    this.isLogined = isLogined;
    this.loginedMemberId = loginedMemberId; //위 로직에서 얻은 것들을 넣어준다.
  }
}
