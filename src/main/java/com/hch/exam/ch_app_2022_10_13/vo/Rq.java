package com.hch.exam.ch_app_2022_10_13.vo;

import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Rq {
  @Getter
  private boolean isLogined;
  @Getter
  private int loginedMemberId;

  private HttpServletRequest req;
  private HttpServletResponse resp;
  private HttpSession session;
  public Rq(HttpServletRequest req, HttpServletResponse resp) {
    this.req =req;
    this.resp = resp;
    this.session = req.getSession();

    boolean isLogined = false;
    int loginedMemberId = 0;

    if (session.getAttribute("loginedMemberId") != null) {
      isLogined = true;
      loginedMemberId = (int) session.getAttribute("loginedMemberId");
    }

    this.isLogined = isLogined;
    this.loginedMemberId = loginedMemberId; //위 로직에서 얻은 것들을 넣어준다.
  }

  public void printHistoryBackJs(String msg) {
    resp.setContentType("text/html; charset=UTF-8"); //한글

    println("<script>");

    println("alert('" + msg + "');");

    println("history.back();");

    println("</script>");

  }
  public void print(String str){
    try {
      resp.getWriter().append(str);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void println(String str) {
    print(str + "\n");
  }

  public void login(Member member) {
    session.setAttribute("loginedMemberId", member.getId());
  }

  public void logout() {
    session.removeAttribute("loginedMemberId");
  }
}