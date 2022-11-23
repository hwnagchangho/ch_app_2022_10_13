package com.hch.exam.ch_app_2022_10_13.controller;

import com.hch.exam.ch_app_2022_10_13.service.ArticleService;
import com.hch.exam.ch_app_2022_10_13.util.Ut;
import com.hch.exam.ch_app_2022_10_13.vo.Article;
import com.hch.exam.ch_app_2022_10_13.vo.ResultData;
import com.hch.exam.ch_app_2022_10_13.vo.Rq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UsrArticleController {

  @Autowired //컴포넌트로 등록이 된 것들에만 붙혀준다. Service Repository 등등
  private ArticleService articleService;

  @RequestMapping("/usr/article/write")
  public String showWrite(HttpServletRequest req) {
    return "/usr/article/write";
  }

  @RequestMapping("/usr/article/doWrite")
  @ResponseBody
  public ResultData<Article> doWrite(HttpServletRequest req, String title, String body) {
    Rq rq = (Rq) req.getAttribute("rq");

    if (rq.isLogined() == false) {
      return ResultData.from("F-3", "로그인 후 이용해주세요.");
    }

    if (Ut.empty(title)) {
      return ResultData.from("F-1", "title을(를) 입력해주세요");
    }

    if (Ut.empty(body)) {
      return ResultData.from("F-2", "body(을)를 입력해주세요");
    }


    ResultData<Integer> writeArticleRd = articleService.writeArticle(rq.getLoginedMemberId(), title, body);

    int id = writeArticleRd.getData1();

    Article article = articleService.getForPrintArticle(rq.getLoginedMemberId(),id);

    return ResultData.newData(writeArticleRd, "article", article);
  }

  @RequestMapping("/usr/article/list")
  public String showList(HttpServletRequest req, Model model) {
    Rq rq = (Rq) req.getAttribute("rq");

    List<Article> articles = articleService.getForPrintArticles(rq.getLoginedMemberId());

    model.addAttribute("articles", articles);

    return "/usr/article/list";
  }

  @RequestMapping("/usr/article/detail")
  public String showDetail(HttpServletRequest req, Model model, int id) {
    Rq rq = (Rq) req.getAttribute("rq");

    Article article = articleService.getForPrintArticle(rq.getLoginedMemberId(), id);

    model.addAttribute("article", article);

    return "usr/article/detail";
  }

  @RequestMapping("/usr/article/doDelete")
  @ResponseBody
  public String  doDelete(HttpServletRequest req, int id) {
    Rq rq = (Rq) req.getAttribute("rq");

    if (rq.isLogined() == false) {
      return Ut.jsHistoryBack("로그인 후 이용해주세요.");
    }

    Article article = articleService.getForPrintArticle(rq.getLoginedMemberId(), id);

    if (article == null) {
      return Ut.jsHistoryBack(Ut.f("%d번 게시물이 존재하지 않습니다.", id));
    }

    if (article.getMemberId() != rq.getLoginedMemberId()) {
      return Ut.jsHistoryBack("권한이 없습니다.");
    }

    articleService.deleteArticle(id);


    return Ut.jsReplace(Ut.f("%d번 게시물을 삭제하였습니다.", id), "../article/list");
  }
  @RequestMapping("/usr/article/modify")
  public String showModify(HttpServletRequest req, int id, Model model) {

    Rq rq = (Rq) req.getAttribute("rq");

    Article article = articleService.getForPrintArticle(rq.getLoginedMemberId(), id);

    if (article == null) {
      rq.historyBackJsOnView(Ut.f("%d번 게시물이 존재하지 않습니다.", id));
    }

    ResultData actorCanModifyRd = articleService.actorCanModify(rq.getLoginedMemberId(), article);

    if (actorCanModifyRd.isFail()) {
      return rq.historyBackJsOnView(actorCanModifyRd.getMsg());
    }

    model.addAttribute("article", article);

    return "/usr/article/modify";
  }
  @RequestMapping("/usr/article/doModify")
  @ResponseBody
  public String doModify(HttpServletRequest req, int id, String title, String body) {

    Rq rq = (Rq) req.getAttribute("rq");

    if (rq.isLogined() == false) {
      return Ut.jsHistoryBack("로그인 후 이용해주세요.");
    }

    Article article = articleService.getForPrintArticle(rq.getLoginedMemberId(), id);

    if (article.getMemberId() != rq.getLoginedMemberId()) {
      return Ut.jsHistoryBack("권한이 없습니다.");
    }

    if (article == null) {
      return Ut.jsHistoryBack(Ut.f("%d번 게시물이 존재하지 않습니다.", id));
    }

    ResultData actorCanModifyRd = articleService.actorCanModify(rq.getLoginedMemberId(), article);

    if (actorCanModifyRd.isFail()) {
      return rq.historyBackJsOnView(actorCanModifyRd.getMsg());
//      그대로 Rd를 넘겨주는 이유는 Rd에는 실패한 원인에 대한 보고서가 담겨있다.
    }

    articleService.modifyArticle(id, title, body);

    return Ut.jsReplace(Ut.f("%d번 게시물이 수정되었습니다.", id), Ut.f("../article/detail?id=%d", id));
  }
}

