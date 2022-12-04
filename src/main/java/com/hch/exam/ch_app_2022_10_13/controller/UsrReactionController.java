package com.hch.exam.ch_app_2022_10_13.controller;

import com.hch.exam.ch_app_2022_10_13.service.ReactionPointService;
import com.hch.exam.ch_app_2022_10_13.vo.Rq;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrReactionController {
  private ReactionPointService reactionPointService;
  private Rq rq;

  public UsrReactionController(ReactionPointService reactionPointService, Rq rq) {
    this.reactionPointService = reactionPointService;
    this.rq = rq;
  }

  @RequestMapping("/usr/reactionPoint/doGoodReaction")
  @ResponseBody
  String doGoodReaction(String relTypeCode, int relId, String replaceUri){
    boolean actorCanMakeReactionPoint = reactionPointService.actorCanMakeReactionPoint(rq.getLoginedMemberId(), relTypeCode, relId);

    if (actorCanMakeReactionPoint == false) {
      return rq.jsHistoryBack("이미 처리되었습니다.");
    }

    reactionPointService.addGoodReactionPoint(rq.getLoginedMemberId(), relTypeCode, relId);

    return rq.jsReplace("좋아요를 하셨습니다.", replaceUri);
  }

  @RequestMapping("/usr/reactionPoint/doBadReaction")
  @ResponseBody
  String doBadReaction(String relTypeCode, int relId, String replaceUri) {
    boolean actorCanMakeReactionPoint = reactionPointService.actorCanMakeReactionPoint(rq.getLoginedMemberId(), relTypeCode, relId);

    if (actorCanMakeReactionPoint == false) {
      return rq.jsHistoryBack("이미 처리되었습니다.");
    }

    return rq.jsReplace("싫어요를 하셨습니다.", replaceUri);
  }
}
