<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="koreanmaster.board.dto.PostDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <title>안녕 - 게시물</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>
      <header class="p-3 bg-dark text-white">
        <div class="container">
          <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/KoreanMaster" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <font size=5> 안녕 </font>
              <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
            </a>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><a href="/KoreanMaster/show_board" class="nav-link px-2 text-white">질문게시판</a></li>
              <li><a href="#" class="nav-link px-2 text-white">정보</a></li>
              <li><a href="/KoreanMaster/my_page" class="nav-link px-2 text-white">마이페이지</a></li>
            </ul>
          </div>
        </div>
      </header>

      <h1 style="margin:30px 30px 30px 30px" >질문게시판</h1>

      <div style="margin:50px 50px 50px 50px; border:5px solid #c9e4c2;">
        <div style="margin:50px 50px 50px 50px;">
            <h2> ${post.getTitle()} <br /> </h2>
            작성일자: ${post.getRegistrationDate()} <br />
            작성자: ${post.getWriter()} <br /><br />
            <h4> ${post.getContent()} <br /> </h4>
        </div>

      </div>

      <div style="margin:50px 50px 50px 50px">
        <c:if test="${post.getReplyId() > 0}">
            <div class="card">
              <div class="card-header">
                ${reply.getRegistrationDate()}
              </div>
              <div class="card-body">
                <h4 class="card-title">답글</h4>
                작성자: ${reply.getWriter()} <br /><br />
                <p class="card-text">${reply.getContent()}</p>
              </div>
            </div>
        </c:if>
      </div>

      <div align="right" style="margin-top:50px; margin-right:100px">
        <c:if test="${post.getPostId() > 1}">
            <form action="post" method="get">
                <input type="hidden" name="postId" value="${post.getPostId()-1}" />
                    <input type="submit" value="이전글" class="btn btn-secondary" />
            </form>
        </c:if>
        <br />
        <form action="post" method="get">
            <input type="hidden" name="postId" value="${post.getPostId()+1}" />
            <input type="submit" value="다음글" class="btn btn-secondary" />
        </form>
      </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>