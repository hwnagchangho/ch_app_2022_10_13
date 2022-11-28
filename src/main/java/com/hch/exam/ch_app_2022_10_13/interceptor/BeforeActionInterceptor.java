package com.hch.exam.ch_app_2022_10_13.interceptor;

import com.hch.exam.ch_app_2022_10_13.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BeforeActionInterceptor implements HandlerInterceptor {
  @Autowired
  private MemberService memberService;
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handle) throws Exception {
//    Rq rq = new Rq(req, resp, memberService);
//    req.setAttribute("rq", rq);
    // 이제는 Rq 객체가 자동으로 만들어지기 때문에 필요 없음

    return HandlerInterceptor.super.preHandle(req, resp, handle);
  }
}