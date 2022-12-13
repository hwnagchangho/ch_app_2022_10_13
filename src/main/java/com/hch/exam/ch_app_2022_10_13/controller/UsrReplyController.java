package com.hch.exam.ch_app_2022_10_13.controller;

import com.hch.exam.ch_app_2022_10_13.service.ReplyService;
import com.hch.exam.ch_app_2022_10_13.util.Ut;
import com.hch.exam.ch_app_2022_10_13.vo.ResultData;
import com.hch.exam.ch_app_2022_10_13.vo.Rq;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrReplyController {
  private ReplyService replyService;

  private Rq rq;

  public UsrReplyController(ReplyService replyService, Rq rq) {
    this.replyService = replyService;
    this.rq = rq;
  }

  @RequestMapping("/usr/reply/doWrite")
  @ResponseBody
  public String doWrite(String relTypeCode, int relId, String body, String replaceUri) {

    if (Ut.empty(relTypeCode)) {
      return rq.jsHistoryBack("relTypeCode(를) 입력해주세요");
    }

    if (Ut.empty(relId)) {
      return rq.jsHistoryBack("relId(을)를 입력해주세요");
    }


    ResultData<Integer> writeArticleRd = replyService.writeReply(rq.getLoginedMemberId(), relTypeCode, relId, body);

    switch (relTypeCode){
      case "article":
        replaceUri = Ut.f("../article/detail?id=%d", relId);
    }

    return rq.jsReplace(writeArticleRd.getMsg(), replaceUri);
  }
}
