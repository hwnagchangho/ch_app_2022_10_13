package com.hch.exam.ch_app_2022_10_13.article.repository;

import com.hch.exam.ch_app_2022_10_13.vo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleRepository {

  public Article writeArticle(String title, String body);

  @Select("SELECT * FROM article WHERE id = #{id}")
  public Article getArticle(int id);

  //DELETE FROM article WHERE id = ?
  public void deleteArticle(int id);

  // SELECT * FROM article ORDER BY id DESC
  public List<Article> getArticles();

  // UPDATE INTO article SET title = ?, body = ?, updateDate = NOW() WHERE id = ?
  public void modifyArticle(int id, String title, String body);

}