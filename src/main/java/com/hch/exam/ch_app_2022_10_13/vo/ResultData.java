package com.hch.exam.ch_app_2022_10_13.vo;

import lombok.Getter;

public class ResultData {
  @Getter
  private String resultCode;
  @Getter
  private String msg;
  @Getter
  private Object data1;

  private ResultData(){

  }

  public static ResultData from(String resultCode, String msg){
    return from(resultCode, msg, null);
  }

  public static ResultData from(String resultCode, String msg, Object data1){
    ResultData rd = new ResultData();
    rd.resultCode = resultCode;
    rd.msg = msg;
    rd.data1 = data1;

    return rd;
  }


//  데이터를 2개만받을 경우 3개받을경우가 있기 때문에 둘다 만들어주었따.
//  예를들어 실패했을 경우에는 data1를 보여줄 필요가 없기때문에 2개만 받는다.

  public boolean isSuccess(){
    return resultCode.startsWith("S-");
  }

  public boolean isFail(){
    return isSuccess() == false;
  }

  public static ResultData newData(ResultData joinRd, Object newData) {
    return ResultData.from(joinRd.getResultCode(), joinRd.getMsg(), newData);
  }
}
