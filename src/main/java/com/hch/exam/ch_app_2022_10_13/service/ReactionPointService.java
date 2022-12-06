package com.hch.exam.ch_app_2022_10_13.service;

import com.hch.exam.ch_app_2022_10_13.repository.ReactionPointRepository;
import com.hch.exam.ch_app_2022_10_13.vo.ResultData;
import org.springframework.stereotype.Service;

@Service
public class ReactionPointService {

  private ReactionPointRepository reactionPointRepository;
  private ArticleService articleService;

  public ReactionPointService(ReactionPointRepository reactionPointRepository, ArticleService articleService) {
    this.reactionPointRepository = reactionPointRepository;
    this.articleService = articleService;
  }
  public ResultData actorCanMakeReactionPoint(int actorId, String relTypeCode, int relId) {
    if(actorId == 0) {
      return ResultData.from("F-1", "로그인 후 이용해주세요.");
    }//로그인 아이디가 없으면 좋아요,싫어요를 못누르게하기위해. 아싸리 안보임

    int sumReactionPointByMemberId = reactionPointRepository.getSumReactionPointByMemberId(relTypeCode, relId, actorId);

    if(sumReactionPointByMemberId != 0 ){
      return ResultData.from("F-2", "리액션이 불가능합니다.", "sumReactionPointByMemberId", sumReactionPointByMemberId);
    }
//    getSum에서 반환된 값이 0 이면 비어있다는것이니깐 좋아요를 누를수 있는상태 0 =0 true false가 오면 좋아요를 누를 수 없는 상태

    return ResultData.from("S-1", "리액션이 가능합니다.", "sumReactionPointByMemberId", sumReactionPointByMemberId);
  }

  public ResultData addGoodReactionPoint(int actorId, String relTypeCode, int relId) {
    reactionPointRepository.addGoodReactionPoint(actorId, relTypeCode, relId);

    switch (relTypeCode) {
      case "article":
        articleService.increaseGoodReactionPoint(relId);
        break;
    }

    return ResultData.from("S-1", "좋아요 처리 되었습니다.");
  }

  public com.hch.exam.ch_app_2022_10_13.vo.ResultData addBadReactionPoint(int actorId, String relTypeCode, int relId) {
    reactionPointRepository.addBadReactionPoint(actorId, relTypeCode, relId);

    switch (relTypeCode) {
      case "article":
        articleService.increaseBadReactionPoint(relId);
        break;
    }

    return ResultData.from("S-1", "싫어요 처리 되었습니다.");
  }
}
