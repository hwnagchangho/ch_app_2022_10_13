package com.hch.exam.ch_app_2022_10_13.article.service;

import com.hch.exam.ch_app_2022_10_13.vo.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //이렇게 하면 컴포넌트로 등록이된다.
public class ArticleService {
  private int articleLastId;
  private List<Article> articles;


  public ArticleService(){
    articles = new ArrayList<>();
    articleLastId = 0;

    makeTestData();
  }
  public void makeTestData() {
    for(int i = 1; i <=10; i++){
      String title = "제목" + i;
      String body = "내용" + i;

      writeArticle(title, body);
    }
  }

  public Article getArticle (int id){
    for( Article article : articles){
      if(article.getId() == id){
//     롬복을 적용했기 때문에 getId를 써준다.
        return article;
      }
    }
    return null;
  }

  public Article writeArticle(String title, String body) {
    int id = articleLastId + 1;

    Article article = new Article(id, title, body);

    articles.add(article);
    articleLastId = id;

    return article;
  }

  public void deleteArticle (int id){
    Article article = getArticle(id);

    articles.remove(article);
  }
  public List<Article> getArticles (){
    return articles;
  }

  public void modifyArticle(int id, String title, String body) {
    Article article = getArticle(id);

    article.setTitle(title);
    article.setBody(body);
  }

}
