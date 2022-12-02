package com.hch.exam.ch_app_2022_10_13.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ResultData<DT> {
  @Getter
  private String resultCode;
  @Getter
  private String msg;
  @Getter
  private String data1Name;
  @Getter
  private DT data1;
  @Getter
  private String data2Name;
  @Getter
  private Object data2;

  public static ResultData from(String resultCode, String msg) {
    return from(resultCode, msg, null, null);
  }

  public static <DT> ResultData<DT> from(String resultCode, String msg, String data1Name, DT data1) {
    ResultData<DT> rd = new ResultData<DT>();
    rd.resultCode = resultCode;
    rd.msg = msg;
    rd.data1Name = data1Name;
    rd.data1 = data1;

    return rd;
  }
//  데이터를 2개만받을 경우 3개받을경우가 있기 때문에 둘다 만들어주었따.
//  예를들어 실패했을 경우에는 data1를 보여줄 필요가 없기때문에 2개만 받는다.

  public boolean isSuccess() {
    return resultCode.startsWith("S-");
  }

  public boolean isFail() {
    return isSuccess() == false;
  }

  public static <DT> ResultData<DT> newData(ResultData oldRd, String data1Name, DT data1) {
    return from(oldRd.getResultCode(), oldRd.getMsg(), data1Name, data1);
  }

  public void setData2(String data2Name, Object data2) {
    this.data2Name = data2Name;
    this.data2 = data2;
  }
}
