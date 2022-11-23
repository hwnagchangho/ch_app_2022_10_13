<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="게시물 등록" />
<%@ include file="../common/head.jspf"%>
<section class="mt-5">
  <div class="con px-3">
    <form class="table-box-type-1" method="POST" action="../article/doWrite">
      <input type="hidden" name="id" value="${article.id}">
      <table border="1">
        <colgroup>
          <col width="200"/>
        </colgroup>
        <tbody>
        <tr>
          <th>작성자</th>
          <td>
            ${rq.loginedMember.nickname}
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input name="title" class="input input-bordered w-96 max-w-xs" type="text" placeholder="제목을 입력해주세요."/>
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="body" class="textarea textarea-bordered w-full" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>등록</th>
          <td>
            <input type="submit" class="btn btn-outline btn-success" value="작성">
            <button type="button" class="btn btn-outline btn-info" onclick="history.back();">뒤로가기</button>
          </td>
        </tr>
        </tbody>
      </table>
    </form>
  </div>
</section>
<%@ include file="../common/foot.jspf"%>