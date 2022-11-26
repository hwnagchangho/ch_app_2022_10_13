package com.hch.exam.ch_app_2022_10_13.repository;

import com.hch.exam.ch_app_2022_10_13.vo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleRepository {

//  @Select("INSERT INTO article SET title=#{title}, body=#{body}")

  @Insert("""
          INSERT INTO article 
          SET regDate = NOW(), 
          updateDate = NOW(),
          memberId = #{memberId}, 
          title=#{title}, 
          body=#{body}
          """)
  public void writeArticle(@Param("memberId") int memberId, @Param("title") String title, @Param("body")String body);

  @Select("""
          SELECT A.*,
          M.nickname AS extra__writerName
          FROM article AS A
          LEFT JOIN member AS M
          ON A.memberId = M.id
          WHERE 1 
          AND A.id = #{id}
          """)
  public Article getForPrintArticle(@Param("id")int id);

  @Delete("""
          DELETE
          FROM article
          WHERE id = #{id}
          """)
  public void deleteArticle(@Param("id")int id);

  @Select("""
          SELECT A.*,
          M.nickname AS extra__writerName
          FROM article AS A
          LEFT JOIN member AS M
          ON A.memberId = M.id
          ORDER BY A.id DESC
          """)
  public List<Article> getForPrintArticles();

  @Update("""
          <script>
          UPDATE article
          <set>
            <if test='title != null'>
              title = #{title},
            </if>
            <if test='body != null'> 
              body = #{body},
            </if>  
            updateDate = NOW()
          </set>
          WHERE id = #{id}
          </script>
          """)
  public void modifyArticle(@Param("id")int id, @Param("title")String title, @Param("body")String body);

  @Select("SELECT LAST_INSERT_ID()")
  int getLastInsertId();

  @Select("""
          <script>          
          SELECT A.*,
          M.nickname AS extra__writerName
          FROM article AS A
          LEFT JOIN member AS M
          ON A.memberId = M.id 
          WHERE 1
          <if test="boardId != 0"> 
            AND A.boardId = #{boardId}
          </if>   
          ORDER BY A.id DESC
          </script>          
          """) //만약에 boardId가 0이 들어오면 전처럼 구분없이 전체가 다 나온다. 왜냐면 받을때 boardId=?로 받기때문이다.
  public List<Article> getArticles(@Param("boardId") int boardId);
}