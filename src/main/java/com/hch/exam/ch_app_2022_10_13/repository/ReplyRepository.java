package com.hch.exam.ch_app_2022_10_13.repository;

import com.hch.exam.ch_app_2022_10_13.vo.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyRepository {
  @Select("""
          SELECT R.*,
          M.nickname AS extra__writerName
          FROM reply AS R
          LEFT JOIN `member` AS M
          ON R.memberId = M.id
          WHERE R.relTypeCode = #{relTypeCode}
          AND R.relId = #{relId}
          ORDER BY R.id DESC
          """)
  List<Reply> getForPrintReplies(@Param("relTypeCode") String relTypeCode, @Param("relId") int relId);

  @Select("""
          SELECT R.*,
          M.nickname AS extra__writerName
          FROM reply AS R
          LEFT JOIN `member` AS M
          ON R.memberId = M.id
          WHERE R.id = #{id}
          """)
  Reply getForPrintReply(@Param("id") int id);

  @Insert("""
          INSERT INTO reply 
          SET regDate = NOW(), 
          updateDate = NOW(),
          memberId = #{memberId}, 
          relTypeCode = #{relTypeCode}, 
          relId=#{relId}, 
          body=#{body}
          """)
  void writeReply(@Param("memberId") int memberId,
                    @Param("relTypeCode") String relTypeCode,
                    @Param("relId") int relId, @Param("body") String body);

  @Select("""
          SELECT LAST_INSERT_ID()
          """)
  int getLastInsertId();


  @Delete("""
          DELETE 
          FROM reply
          WHERE id = #{id}
          """)
  void deleteReply(@Param("id") int id);

  @Update("""
          UPDATE reply
          SET updateDate = NOW(),
          `body` = #{body}
          WHERE id = #{id}
          """)
  void modifyReply(@Param("id") int id, @Param("body") String body);
}
