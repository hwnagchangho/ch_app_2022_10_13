package com.hch.exam.ch_app_2022_10_13.controller;

import com.hch.exam.ch_app_2022_10_13.service.ArticleService;
import com.hch.exam.ch_app_2022_10_13.util.Ut;
import com.hch.exam.ch_app_2022_10_13.vo.Article;
import com.hch.exam.ch_app_2022_10_13.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UsrArticleController {

  @Autowired //컴포넌트로 등록이 된 것들에만 붙혀준다. Service Repository 등등
  private ArticleService articleService;

  @RequestMapping("/usr/article/doAdd")
  @ResponseBody
  public Article doAdd (String title, String body){
    int id = articleService.writeArticle(title, body);
    Article article = articleService.getArticle(id);

    return article;
  }

  @RequestMapping("/usr/article/getArticles")
  @ResponseBody
  public List<Article> getArticles (){
    return articleService.getArticles();
  }

  @RequestMapping("/usr/article/getArticle")
  @ResponseBody
  public ResultData getArticle (int id){
    Article article = articleService.getArticle(id);

    if( article == null) {
      return ResultData.from("F-1", Ut.f("%d번 게시물이 존재하지 않습니다.", id));
    }

    return ResultData.from("S-1", Ut.f("%d번 게시물입니다.", id), article);
  }

  @RequestMapping("/usr/article/doDelete")
  @ResponseBody
  public String doDelete (int id){
    Article article = articleService.getArticle(id);

    if( article == null) {
      return id + "번 게시물이 존재하지 않습니다.";
    }

    articleService.deleteArticle(id);

    return id + "번 게시물이 삭제되었습니다.";
  }

  @RequestMapping("/usr/article/doModify")
  @ResponseBody
  public String doModify (int id, String title, String body){
    Article article = articleService.getArticle(id);

    if( article == null) {
      return id + "번 게시물이 존재하지 않습니다.";
    }

    articleService.modifyArticle(id, title, body);

    return id + "번 게시물이 수정되었습니다.";
  }

}

