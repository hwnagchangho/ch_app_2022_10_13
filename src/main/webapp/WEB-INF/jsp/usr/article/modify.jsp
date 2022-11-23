<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="게시물 수정" />
<%@ include file="../common/head.jspf"%>
<section class="mt-5">
  <div class="con px-3">
    <form class="table-box-type-1" method="POST" action="../article/doModify">
      <input type="hidden" name="id" value="${article.id}">
      <table border="1">
        <colgroup>
          <col width="200"/>
        </colgroup>
        <tbody>
        <tr>
          <th>번호</th>
          <td>${article.id}</td>
        </tr>
        <tr>
          <th>작성날짜</th>
          <td>${article.regDate}</td>
        </tr>
        <tr>
          <th>수정날짜</th>
          <td>${article.updateDate}</td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>${article.extra__writerName}</td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input name="title" class="w-96" type="text" placeholder="제목을 입력해주세요." value="${article.title}">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="body" class="w-full" rows="10">${article.body}</textarea>
          </td>
        </tr>
        <tr>
          <th>수정</th>
          <td>
            <input type="submit" value="수정">
            <button type="button" onclick="history.back();">뒤로가기</button>
          </td>
        </tr>
        </tbody>
      </table>
    </form>
  </div>
</section>
<%@ include file="../common/foot.jspf"%>