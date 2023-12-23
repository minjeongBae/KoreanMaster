<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="koreanmaster.teachers.applicationform.ApplicationFormDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>안녕 - 매칭 신청 목록 </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        .colored-div {
            background-color: #FAEBD7; /* 여기에 원하는 색상 코드를 넣습니다. */
            padding: 20px; /* 내용과 테두리 간격을 조절합니다. */
        }
    </style>

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

    <div class="colored-div">
        <h1 style="margin:30px 30px 30px 30px" >[매칭신청 목록]</h1>
    </div>

    <div align="center" style="margin-top:50px" class= "container">
        <div= "row">
    	    <table class= "table table-stripped" style= "text-align: center; boarder: 1px; solid #dddddd">
    	        <thead>
    	    	<tr>
    	    		<th style= "background-color: #c9e4c2; text-align: center;">현상태</th>
    	    		<th style= "background-color: #c9e4c2; text-align: center;">신청인</th>
    	    		<th style= "background-color: #c9e4c2; text-align: center;">수업방식</th>
    	    		<th style= "background-color: #c9e4c2; text-align: center;"></th>
    	    	</tr>
    	    	</thead>
                <tbody>
                    <c:forEach var="application" items="${applications}">
                        <tr>
                            <td>${application.getState()}</td>
                            <td>${application.getStudentEmail()}</td>
                            <td>${application.getRoot()}</td>
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


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>