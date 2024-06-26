<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="koreanmaster.board.post.PostDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>안녕 - 마이페이지</title>

    <meta name="theme-color" content="#7952b3">
    <link href="signin.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body class="text-center">
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

    <div style="margin: 50px 50px 50px 50px" align="center">
        <img class="mb-4" src="https://cdn.pixabay.com/photo/2018/07/04/08/51/graphic-3515619_640.png" width="230" height="250">
        <br /><br />
        <h4> 로그인 정보: ${email} </h4> <br />

        <div>
            <c:if test="${isStudent==true}">
                <button onclick="show_classes()" type="button" class="btn btn-outline-primary">수강 목록</button>
            </c:if>
            <button onclick="show_my_posts()" type="button" class="btn btn-outline-info">나의 글</button>
            <button onclick="change_info()" type="button" class="btn btn-outline-secondary">정보 수정</button>
            <c:if test="${isStudent==false}">
                <button onclick="show_applications()" type="button" class="btn btn-outline-success">매칭 신청 목록</button>
            </c:if>
            <button onclick="logout()" type="button" class="btn btn-outline-danger">로그아웃</button>
        </div>

        <c:if test="${myPosts.size() == 0}">
            <div>
                <h5> <br /> 게시글이 없습니다. </h5>
            </div>
        </c:if>

        <c:if test="${myPosts.size() > 0}">
            <div style="margin: 50px 50px 50px 50px">
                <table class= "table table-stripped" style= "text-align: center; boarder: 1px; solid: #dddddd">
                    <thead>
                    <tr>
                        <th style= "background-color: #B2EBF2; text-align: center;">번호</th>
                        <th style= "background-color: #B2EBF2; text-align: center;">제목</th>
                        <th style= "background-color: #B2EBF2; text-align: center;">작성일</th>
                        <th style= "background-color: #B2EBF2; text-align: center;"> </th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="post" items="${myPosts}">
                            <tr>
                                <td>${post.getPostId()}</td>
                                <td>${post.getTitle()}</td>
                                <td>${post.getRegistrationDate()}</td>
                                <td>
                                    <form action="post" method="get">
                                        <input type="hidden" name="postId" value="${post.getPostId()}" />
                                        <input type="submit" value="상세보기" class="btn btn-secondary"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>

    </div>

    <script>
        function logout() {
            window.location.href = "/KoreanMaster/sign_in";
        }
        function show_my_posts() {
            window.location.href = "/KoreanMaster/my_posts";
        }
        function change_info() {
            window.location.href = "/KoreanMaster/revise_user_info";
        }
        function show_classes() {
            window.location.href = "/KoreanMaster/show_classes";
        }
        function show_applications() {
            window.location.href = "/KoreanMaster/show_applications";
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>