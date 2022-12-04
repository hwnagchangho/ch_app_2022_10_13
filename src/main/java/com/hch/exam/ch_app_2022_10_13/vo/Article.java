package com.hch.exam.ch_app_2022_10_13.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
  private int id;
  private String regDate;
  private String updateDate;
  private int memberId;
  private String title;
  private String body;
  private String hitCount;

  private String extra__writerName;
  private boolean extra__actorCanModify;
  private boolean extra__actorCanDelete;

  public String getForPrintType1RegDate() {
    return regDate.substring(2, 16).replace(" ","<br>");
  }

  public String getForPrintType1UpdateDate() {
    return updateDate.substring(2, 16).replace(" ","<br>");
  }

  public String getForPrintType2RegDate() {
    return regDate.substring(2, 16);
  }

  public String getForPrintType2UpdateDate() {
    return updateDate.substring(2, 16);
  }
}
