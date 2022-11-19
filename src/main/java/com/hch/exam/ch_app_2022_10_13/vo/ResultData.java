package com.hch.exam.ch_app_2022_10_13.vo;

public class ResultData {
  private String resultCode;

  private String msg;

  private String data1;

  private ResultData(){

  }

  private static ResultData from(String resultCode, String msg, String data1){
    ResultData rd = new ResultData();
    rd.resultCode = resultCode;
    rd.msg = msg;
    rd.data1 = data1;

    return rd;
  }

  public boolean isSuccess(){
    return resultCode.startsWith("S-");
  }

  public boolean isFail(){
    return isSuccess() == false;
  }
}
