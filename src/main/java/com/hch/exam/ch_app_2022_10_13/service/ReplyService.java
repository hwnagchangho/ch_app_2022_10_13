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
  private MemberService memberService;

  public ReplyService(ReplyRepository repository, MemberService memberService) {
    this.replyRepository = repository;
    this.memberService = memberService;
  }

  public ResultData<Integer> writeReply(int actorId, String relTypeCode, int relId, String body) {

    replyRepository.writeReply(actorId, relTypeCode, relId, body);

    int id = replyRepository.getLastInsertId();

    return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
  }

  public List<Reply> getForPrintReplies(Member actor, String relTypeCode, int relId) {
    List<Reply> replies = replyRepository.getForPrintReplies(relTypeCode, relId);

    for (Reply reply : replies) {
      if(actor == null){
        return replies; //오류 해결 exam1206에 적어놓음
      }
      updateForPrintData(actor, reply);
    }

    return replies;
  }

  private void updateForPrintData(Member actor, Reply reply) {
    if (reply == null) {
      return;
    }

    ResultData actorCanDeleteRd = actorCanDelete(actor, reply);
    reply.setExtra__actorCanDelete(actorCanDeleteRd.isSuccess());

    ResultData actorCanModifyRd = actorCanModify(actor, reply);
    reply.setExtra__actorCanModify(actorCanModifyRd.isSuccess());
  }

  private ResultData actorCanModify(Member actor, Reply reply) {
    if (reply == null) {
      return ResultData.from("F-1", "댓글이 존재하지 않습니다.");
    }

    if (reply.getMemberId() != actor.getId()) {
      return ResultData.from("F-2", "권한이 없습니다.");
    }

    return ResultData.from("S-1", "댓글 수정이 가능합니다.");
  }

  private ResultData actorCanDelete(Member actor, Reply reply) {
    if (reply == null) {
      return ResultData.from("F-1", "댓글이 존재하지 않습니다.");
    }

    if (reply.getMemberId() != actor.getId()) {
      return ResultData.from("F-2", "권한이 없습니다.");
    }

    return ResultData.from("S-1", "댓글 삭제가 가능합니다.");
  }

  public Reply getForPrintReply(Member actor, int id) {
    Reply reply = replyRepository.getForPrintReply(id);

    updateForPrintData(actor, reply);

    return reply;
  }

  public ResultData deleteReply(int id) {
    replyRepository.deleteReply(id);

    return ResultData.from("S-1", Ut.f("%d번 댓글을 삭제하였습니다.", id));
  }

  public ResultData modifyReply(int id, String body) {
    replyRepository.modifyReply(id, body);

    return ResultData.from("S-1", Ut.f("%d번 댓글을 수정하였습니다.", id));
  }
}
