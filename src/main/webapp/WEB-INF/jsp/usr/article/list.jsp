<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="${board.name} 게시물 리스트" />
<%@ include file="../common/head.jspf"%>
<section class="con-min-width mt-5">
  <div class="con px-3">
    <divc>
      게시물 개수: ${articlesCount}건
    </divc>
    <div class="table-box-type-1">
      <table>
        <colgroup>
          <col width="80"/>
          <col width="150"/>
          <col width="150"/>
          <col width="150"/>
          <col />
        </colgroup>
        <thead>
        <tr>
          <th>제목</th>
          <th>작성날짜</th>
          <th>수정날짜</th>
          <th>작성자</th>
          <th>내용</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  var="article" items="${articles}">
          <tr>
            <th>${article.id}</th>
            <th>${article.regDateForPrint}</th>
            <th>${article.updateDateForPrint}</th>
            <th>${article.extra__writerName}</th>
            <th>
              <a class="btn-text-link" href="../article/detail?id=${article.id}">${article.title}</a>
            </th>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="btns">
        <a class="btn btn-outline btn-accent" href="../article/write">게시물 작성하기</a>
    </div>
  </div>
</section>
<%@ include file="../common/foot.jspf"%>