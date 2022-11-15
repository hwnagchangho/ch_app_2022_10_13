package com.hch.exam.ch_app_2022_10_13.article.repository;

import com.hch.exam.ch_app_2022_10_13.vo.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleRepository {

//  @Select("INSERT INTO article SET title=#{title}, body=#{body}")
  public Article writeArticle(String title, String body);

  @Select("SELECT * FROM article WHERE id = #{id}")
  public Article getArticle(int id);

  @Delete("DELETE FROM article WHERE id = #{id}")
  public void deleteArticle(int id);

  @Select("SELECT * FROM article ORDER BY id DESC")
  public List<Article> getArticles();

  @Update("UPDATE article SET title = #{title}, body = #{body}, updateDate = NOW() WHERE id = #{id}")
  public void modifyArticle(int id, String title, String body);

}