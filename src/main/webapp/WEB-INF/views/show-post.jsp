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
              <li><a href="/KoreanMaster/introduction" class="nav-link px-2 text-white">소개</a></li>
              <li><a href="/KoreanMaster/show_board" class="nav-link px-2 text-white">질문게시판</a></li>
              <li><a href="/KoreanMaster/teachers" class="nav-link px-2 text-white">멘토</a></li>
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
      <div align="right" style="margin:30px 90px 30px 30px">
          <c:if test="${isManager == true}">
            <button onclick="upload_reply()" type="submit" style="margin: 10px 10px 30px 10px"  class="btn btn-outline-danger">답변작성</button>
          </c:if>
      </div>

      <footer class="container py-5">
        <div class="row">
            <div class="col-12 col-md">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
            </div>
            <div class="col-6 col-md"> <p>이메일: hi1234@gmail.com </p> </div>
            <div class="col-6 col-md"> <p>전화번호: 010-1111-0000 </p> </div>
            <div class="col-6 col-md"> <p>주소: 대한민국 </p> </div>
        </div>
      </footer>

    <script>
        function upload_reply() {
            window.location.href = "/KoreanMaster/upload_reply";
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>