package com.hch.exam.ch_app_2022_10_13.service;


import com.hch.exam.ch_app_2022_10_13.repository.ReplyRepository;
import com.hch.exam.ch_app_2022_10_13.util.Ut;
import com.hch.exam.ch_app_2022_10_13.vo.Member;
import com.hch.exam.ch_app_2022_10_13.vo.Reply;
import com.hch.exam.ch_app_2022_10_13.vo.ResultData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
  private ReplyRepository replyRepository;

  public ReplyService(ReplyRepository repository) {
    this.replyRepository = repository;
  }
  public ResultData<Integer> writeReply(int actorId, String relTypeCode, int relId, String body) {

    replyRepository.writeReply(actorId, relTypeCode, relId, body);

    int id = replyRepository.getLastInsertId();

    return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
  }

  public List<Reply> getForPrintReplies(Member actor, String relTypeCode, int relId) {
    return replyRepository.getForPrintReplies(relTypeCode, relId);
  }
}
