<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="게시물 내용" />
<%@ include file="../common/head.jspf"%>

<script>
  const params = {};
  params.id = parseInt(${param.id});
</script>

<script>
  function ArticleDetail__increaseHitCount() {

    const localStorageKey = 'article__' + ${param.id} + '__viewDone';
    if( localStorage.getItem(localStorageKey) ) {
      return;
    }
    localStorage.setItem(localStorageKey, true);

    $.get('/usr/article/doIncreaseHitCountRd',
      {
        id : params.id,
        ajaxMode: 'Y'
      }, function(data) {
        $('.article-detail__hit-count').empty().html(data.data1);
      }, 'json');
  }
  $(function() {
<!--    실전코드-->
    ArticleDetail__increaseHitCount();
<!--    임시코드-->
<!--    setTimeout(ArticleDetail__increaseHitCount(), 10000);-->
  })
</script>

<section class="mt-5 con-min-width">
  <div class="con px-3">
    <div class="table-box-type-1">
      <table>
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
          <td>${article.forPrintType2RegDate}</td>
        </tr>
        <tr>
          <th>수정날짜</th>
          <td>${article.forPrintType2UpdateDate}</td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>${article.extra__writerName}</td>
        </tr>
        <th>조회</th>
        <td>
          <span class="badge badge-primary article-detail__hit-count">${article.hitCount}</span>
        </td>
        </tr>
        <tr>
          <th>추천</th>
          <td>
            <div class="flex items-center">
              <span class="badge badge-primary article-detail__hit-count">${article.extra__goodReactionPoint}</span>
              &nbsp;
              <c:if test="${actorCanMakeReactionPoint}">
                <button class="btn btn-xs btn-primary">
                  좋아요 👍
                </button>
                &nbsp;
                <button class="btn btn-xs btn-secondary">
                  싫어요 👎
                </button> <!--       actorCanMakeReactionPoint가 참이면 좋아요 싫어요 표시됨 거짓, 즉 이미 누른상태면 표시가안됌    -->
              </c:if>
            </div>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>${article.title}</td>
        </tr>
        <tr>
          <th>내용</th>
          <td>${article.body}</td>
        </tr>
        </tbody>
      </table>
    </div>
    <div class="btns">
      <button class="btn btn-outline btn-accent" type="button" onclick="history.back()" >뒤로가기</button>
      <c:if test="${article.extra__actorCanModify}">
        <a class="btn btn-outline btn-accent" href="../article/modify?id=${article.id}">게시물 수정</a>
      </c:if>
      <c:if test="${article.extra__actorCanDelete}">
        <a class="btn btn-outline btn-accent" onclick="if( confirm('정말 삭제하시겠습니까?') == false ) return false" href="../article/doDelete?id=${article.id}">게시물 삭제</a>
      </c:if>
    </div>
  </div>
</section>

<!--<script>-->
<!--  location.href='http://localhost:8081/usr/article/doIncreaseHitCountRd?id=2';-->
<!--</script>-->

<!--<iframe src="http://localhost:8081/usr/article/doIncreaseHitCountRd?id=2" frameborder="0"></iframe>-->
<%@ include file="../common/foot.jspf"%>