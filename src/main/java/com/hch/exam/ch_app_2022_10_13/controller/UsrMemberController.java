package com.hch.exam.ch_app_2022_10_13.controller;

import com.hch.exam.ch_app_2022_10_13.service.MemberService;
import com.hch.exam.ch_app_2022_10_13.util.Ut;
import com.hch.exam.ch_app_2022_10_13.vo.Member;
import com.hch.exam.ch_app_2022_10_13.vo.ResultData;
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
  public ResultData doJoin (String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email){

    if( Ut.empty(loginId)) {
      return ResultData.from("F-1", "loginId(을)를 입력 해주세요.");
    }

    if( Ut.empty(loginPw) ) {
      return ResultData.from("F-2", "loginPw(을)를 입력 해주세요.");
    }

    if( Ut.empty(name) ) {
      return ResultData.from("F-3", "name(을)를 입력 해주세요.");
    }

    if( Ut.empty(nickname) ) {
      return ResultData.from("F-4", "nickname(을)를 입력 해주세요.");
    }

    if( Ut.empty(cellphoneNo) ) {
      return ResultData.from("F-5", "cellphoneNo(을)를 입력 해주세요.");
    }

    if( Ut.empty(email) ) {
      return ResultData.from("F-6", "email(을)를 입력 해주세요.");
    }

    // 들어있는 데이터
    // S-1
    // 회원 가입이 완료되었습니다.
    // 7
    ResultData<Integer> joinRd= memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);

    if ( joinRd.isFail() ) {
      return joinRd;
    }

    Member member  = memberService.getMemberById(joinRd.getData1());

    return ResultData.newData(joinRd, member);
  }
}
