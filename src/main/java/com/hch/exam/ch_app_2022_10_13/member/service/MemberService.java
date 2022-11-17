package com.hch.exam.ch_app_2022_10_13.member.service;

import com.hch.exam.ch_app_2022_10_13.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  private MemberRepository memberRepository;

  public void join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
//    memberRepository.join(loginId, loginPw, name, nickname cellphoneNo, email);
  }
}
