<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="로그인" />
<%@ include file="../common/head.jspf"%>
<section class="mt-5">
  <div class="con px-3">
    <form class="table-box-type-1" method="post" action="../member/doLogin">
      <table>
        <colgroup>
          <col width="200"/>
        </colgroup>
        <tbody>
        <tr>
          <th>로그인 아이디</th>
          <td>
            <input name="loginId" class="input input-bordered w-96 max-w-xs" type="text" placeholder="아이디를 입력해주세요.">
          </td>
        </tr>
        <tr>
          <th>로그인 비밀번호</th>
          <td>
            <input name="loginPw" class="input input-bordered w-96 max-w-xs" type="password" placeholder="비밀번호를 입력해주세요.">
          </td>
        </tr>
        <tr>
          <th>로그인</th>
          <td>
            <button type="submit" class="btn btn-outline btn-success">로그인</button>
            <button type="button" class="btn btn-outline btn-info" onclick="history.back();">뒤로가기</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</section>
<%@ include file="../common/foot.jspf"%>