package com.hch.exam.ch_app_2022_10_13.member.repository;

import com.hch.exam.ch_app_2022_10_13.vo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberRepository {

  @Insert("""
          INSERT into member
          SET regDate = NOW(),
          updateDate = NOW(),
          loginId = #{loginId},
          loginPw = #{loginPw},
          name = #{name},
          nickname = #{nickname},
          cellphoneNo = #{cellphoneNo},
          email = #{email}
          """)
  public void join(@Param("loginId") String loginId, @Param("loginPw")String loginPw, @Param("name")String name,
                   @Param("nickname") String nickname, @Param("cellphoneNo")String cellphoneNo, @Param("email")String email);

  @Select("""
          SELECT LAST_INSERT_ID()
          """)
  int getLastInsertId();

  @Select("""
          SELECT *
          FROM member
          WHERE id = #{id}
          """)
  Member getMemberById(int id);

  @Select("""
          SELECT *
          FROM member
          WHERE loginId = #{loginId}
          """)
  Member getMemberByLoginId(String loginId);
}
