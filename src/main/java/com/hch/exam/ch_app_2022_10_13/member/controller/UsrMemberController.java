package com.hch.exam.ch_app_2022_10_13.member.controller;

import com.hch.exam.ch_app_2022_10_13.member.service.MemberService;
import com.hch.exam.ch_app_2022_10_13.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrMemberController {
//  @Autowired
  private MemberService memberService;

  public UsrMemberController(MemberService memberService){
    this.memberService = memberService;
  }

  @RequestMapping("/usr/member/doJoin")
  @ResponseBody
  public Member doJoin (String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email){
    int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);

    Member member  = memberService.getMemberById(id);
    return member;
  }
}
