<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="게시물 리스트" />
<%@ include file="../common/head.jspf"%>
  </header>
  <table border="1">
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
          <th>${article.regDate.substring(2,16)}</th>
          <th>${article.updateDate.substring(2,16)}</th>
          <th>${article.memberId}</th>
          <th>
            <a href="../usr/article/detail?id=${article.id}">${article.title}</a>
          </th>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
<%@ include file="../common/foot.jspf"%>