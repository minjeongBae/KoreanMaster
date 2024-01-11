<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="koreanmaster.board.post.PostDTO"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <title>안녕 - 질문게시판</title>
    <style type="text/css">
    	a, a:hover{
    		color: #000000;
    		text-decoration:none;
    	}
    </style>
    <script>
        function alertMessage(message) {
            if (message.trim()!="") {
                alert(message);
            }
        }
        alertMessage(`${message}`);
    </script>
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

    <div style="margin: 50px 50px 10px 100px" >
        <h2>
            [질문게시판]
        </h2>
    </div>
    <div align="center" style="margin-top:50px" class= "container">
        <div= "row">
    	    <table class= "table table-stripped" style= "text-align: center; boarder: 1px; solid #dddddd">
    	        <thead>
    	    	<tr>
    	    		<th style= "background-color: #c9e4c2; text-align: center;">번호</th>
    	    		<th style= "background-color: #c9e4c2; text-align: center;">제목</th>
    	    		<th style= "background-color: #c9e4c2; text-align: center;">작성자</th>
    	    		<th style= "background-color: #c9e4c2; text-align: center;">작성일</th>
    	    		<th style= "background-color: #c9e4c2; text-align: center;"> </th>
    	    	</tr>
    	    	</thead>
                <tbody>
                    <!-- JSTL을 사용한 반복문 -->
                    <c:forEach var="post" items="${posts}" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${post.getTitle()}</td>
                            <td>${post.getWriter()}</td>
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
    </div>

    <div align="right" style="margin: 80px 100px 10px 80px">
        <c:if test="${signIn eq 'true'}">
            <button onclick="upload()" type="submit" class="btn btn-secondary"/> 게시물 작성 </button>
        </c:if>
    </div>
    <script>
        function upload() {
            window.location.href = "/KoreanMaster/upload_post";
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>