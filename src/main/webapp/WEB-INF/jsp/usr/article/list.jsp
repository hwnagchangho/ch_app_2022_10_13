<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="${board.name} 게시물 리스트" />
<%@ include file="../common/head.jspf"%>
<section class="con-min-width mt-5">
  <div class="con px-3">
    <div>
      게시물 개수: ${articlesCount}건
      <a class="btn btn-outline btn-accent" href="../article/write">게시물 작성하기</a>
    </div>
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
    <div class="page-menu mt-3 flex justify-center">
      <div class="btn-group">
        <c:set var="pageMenuArmLen" value="5"/>
        <c:set var="startPage" value="${page - pageMenuArmLen >= 1 ? page - pageMenuArmLen : 1}"/>
        <c:set var="endPage" value="${page + pageMenuArmLen <= pagesCount ? page + pageMenuArmLen : pagesCount}"/>

        <c:if test="${startPage > 1}">
          <a class="btn btn-sm" href="?page=1&boardId=${boardId}">1</a>
          <c:if test="${startPage > 2}">
            <a href="btn btn-disabled">...</a>
          </c:if>
        </c:if>

        <c:forEach begin="${startPage}" end="${endPage}" var="i">
          <a class="btn btn-sm ${page == i ? 'btn-active' : ''}" href="?page=${i}&boardId=${boardId}">${i}</a>
        </c:forEach>

        <c:if test="${endPage < pagesCount}">
          <c:if test="${endPage < pagesCount - 1}">
            <a href="btn btn-disabled">...</a>
          </c:if>
          <a class="btn btn-sm" href="?page=${pagesCount}&boardId=${boardId}">${pagesCount}</a>
        </c:if>
      </div>
    </div>
  </div>
</section>
<%@ include file="../common/foot.jspf"%>