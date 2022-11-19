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
  public Object doJoin (String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email){
    int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);

    if( loginId == null || loginId.trim().length() == 0) {
      return "loginId(을)를 입력 해주세요.";
    }

    if( loginPw == null || loginPw.trim().length() == 0 ) {
      return "loginPw(을)를 입력 해주세요.";
    }

    if( name == null || name.trim().length() == 0 ) {
      return "name(을)를 입력 해주세요.";
    }

    if( nickname == null || nickname.trim().length() == 0) {
      return "nickname(을)를 입력 해주세요.";
    }

    if( cellphoneNo == null || cellphoneNo.trim().length() == 0) {
      return "cellphoneNo(을)를 입력 해주세요.";
    }

    if( email == null || email.trim().length() == 0) {
      return "email(을)를 입력 해주세요.";
    }

    Member member  = memberService.getMemberById(id);

    if(id == -1 ){
      return "이미 사용중인 아이디입니다.";
    }
    return member;
  }
}
