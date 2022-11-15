package com.hch.exam.ch_app_2022_10_13.article.service;

import com.hch.exam.ch_app_2022_10_13.article.repository.ArticleRepository;
import com.hch.exam.ch_app_2022_10_13.vo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //이렇게 하면 컴포넌트로 등록이된다.
public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService(ArticleRepository articleRepository){
    this.articleRepository = articleRepository;
  }


  public Article writeArticle(String title, String body) {
    return articleRepository.writeArticle(title, body);
  }

  public List<Article> getArticles() {
    return articleRepository.getArticles();
  }

  public Article getArticle(int id) {
    return articleRepository.getArticle(id);
  }

  public void deleteArticle(int id) {
   articleRepository.deleteArticle(id);
  }

  public void modifyArticle(int id, String title, String body) {
    articleRepository.modifyArticle(id, title, body);
  }
}
