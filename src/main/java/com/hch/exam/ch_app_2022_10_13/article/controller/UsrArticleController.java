package com.hch.exam.ch_app_2022_10_13.article.controller;

import com.hch.exam.ch_app_2022_10_13.article.service.ArticleService;
import com.hch.exam.ch_app_2022_10_13.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsrArticleController {

  // 인스턴스 변수 시작
  @Autowired //컴포넌트로 등록이 된 것들에만 붙혀준다. Service Repository 등등
  private ArticleService articleService;
  int articleLastId;
  private List<Article> articles;
  // 인스턴스 변수 끝

  UsrArticleController(){
//    articleService = new ArticleService(); 이런식으로 객체생성을 안해도 된다. 컴포넌트로 등록이되었기때문
    articles = new ArrayList<>();
    articleLastId = 0;

    makeTestData();
  }

  // 서비스 메서드 시작
  private void makeTestData() {
    for(int i = 1; i <=10; i++){
      String title = "제목" + i;
      String body = "내용" + i;

      writeArticle(title, body);
    }
  }

  private Article getArticle (int id){
    for( Article article : articles){
      if(article.getId() == id){
//     롬복을 적용했기 때문에 getId를 써준다.
        return article;
      }
    }
    return null;
  }

  private Article writeArticle(String title, String body) {
    int id = articleLastId + 1;

    Article article = new Article(id, title, body);

    articles.add(article);
    articleLastId = id;

    return article;
  }

  private void deleteArticle (int id){
    Article article = getArticle(id);

    articles.remove(article);
  }

  private void modifyArticle(int id, String title, String body) {
    Article article = getArticle(id);

    article.setTitle(title);
    article.setBody(body);
  }

  // 서비스 메서드 끝

  // 액션 메서드 시작

  @RequestMapping("/usr/article/doAdd")
  @ResponseBody
  public Article doAdd (String title, String body){
    Article article = writeArticle(title, body);

    return article;
  }

  @RequestMapping("/usr/article/getArticles")
  @ResponseBody
  public List<Article> getArticles (){
    return articles;
  }

  @RequestMapping("/usr/article/getArticle")
  @ResponseBody
  public Object getArticleAction (int id){ //getArticle이라는 로직이 반복되면 안되기 때문에 메서드명을 바꿔준것이다.
    Article article = getArticle(id);

    if( article == null) {
      return id + "번 게시물이 존재하지 않습니다.";
    }

    return article;
  }

  @RequestMapping("/usr/article/doDelete")
  @ResponseBody
  public String doDelete (int id){
    Article article = getArticle(id);

    if( article == null) {
      return id + "번 게시물이 존재하지 않습니다.";
    }

    deleteArticle(id);

    return id + "번 게시물이 삭제되었습니다.";
  }

  @RequestMapping("/usr/article/doModify")
  @ResponseBody
  public String doModify (int id, String title, String body){
    Article article = getArticle(id);

    if( article == null) {
      return id + "번 게시물이 존재하지 않습니다.";
    }

    modifyArticle(id, title, body);

    return id + "번 게시물이 수정되었습니다.";
  }

  // 액션 메서드 끝
}

