package com.hch.exam.ch_app_2022_10_13.service;

import com.hch.exam.ch_app_2022_10_13.repository.ArticleRepository;
import com.hch.exam.ch_app_2022_10_13.util.Ut;
import com.hch.exam.ch_app_2022_10_13.vo.Article;
import com.hch.exam.ch_app_2022_10_13.vo.ResultData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //이렇게 하면 컴포넌트로 등록이된다.
public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService(ArticleRepository articleRepository){
    this.articleRepository = articleRepository;
  }


  public ResultData writeArticle(int memberId, String title, String body) {
    articleRepository.writeArticle(memberId, title, body);

    int id = articleRepository.getLastInsertId();
    return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), id);
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
