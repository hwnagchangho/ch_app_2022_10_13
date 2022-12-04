package com.hch.exam.ch_app_2022_10_13.service;

import com.hch.exam.ch_app_2022_10_13.repository.ReactionPointRepository;
import org.springframework.stereotype.Service;

@Service
public class ReactionPointService {

  public ReactionPointService(ReactionPointRepository reactionPointRepository) {
    this.reactionPointRepository = reactionPointRepository;
  }

  private ReactionPointRepository reactionPointRepository;
  public boolean actorCanMakeReactionPoint(int actorId, String relTypeCode, int relId) {
    if(actorId == 0) {
      return false;
    }//로그인 아이디가 없으면 좋아요,싫어요를 못누르게하기위해. 아싸리 안보임

    return reactionPointRepository.getSumReactionPointByMemberId(relTypeCode, relId, actorId) == 0;
//    getSum에서 반환된 값이 0 이면 비어있다는것이니깐 좋아요를 누를수 있는상태 0 =0 true false가 오면 좋아요를 누를 수 없는 상태
  }
}
