<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="koreanmaster.teachers.applicationform.SimpleFormDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>안녕 - 매칭 신청 목록 </title>
        <style>

        .button { width: 100%; }

        .text-div {
            color: white;
            padding: 20px;
        }

        </style>

        <link href="sidebars.css" rel="stylesheet">
        <link rel="canonical" href="https://getbootstrap.kr/docs/5.3/examples/sidebars/">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
        <link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

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

    <div class="row container-fluid">
        <div class="col-md-3 d-flex flex-column flex-shrink-0 p-3 text-bg-dark" style="width: 280px;">
            매칭신청목록
            <hr>
            <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <button class="nav-link active button" aria-current="page">전체</a>
            </li>
            <li>
                <button class="nav-link text-white button">매칭 대기 중</button>
            </li>
            <li>
                <button class="nav-link text-white button">매칭 상담 중</button>
            </li>
            <li>
                <button class="nav-link text-white button">수업 진행 중</button>
            </li>
            <li>
                <button class="nav-link text-white button">수업 종료</button>
            </li>
            </ul>
            <hr>
        </div>

        <div align="center" style="margin-top:50px" class= "col-md-8 container">
            <div= "row">
        	    <table class= "table table-stripped" style= "text-align: center; boarder: 1px; solid #dddddd">
        	        <thead>
        	    	<tr>
        	    		<th style= "background-color: #B2EBF2; text-align: center;">번호</th>
        	    		<th style= "background-color: #B2EBF2; text-align: center;">신청인</th>
        	    		<th style= "background-color: #B2EBF2; text-align: center;">현상태</th>
        	    		<th style= "background-color: #B2EBF2; text-align: center;"></th>
        	    	</tr>
        	    	</thead>
                    <tbody>
                        <c:forEach var="application" items="${applications}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${application.getStudentEmail()}</td>
                                <td>${application.getStateDetail()}</td>
                                <td>
                                    <form action="show_detail_application" method="post">
                                        <input type="hidden" name="formCode" value="${application.getFormCode()}"
                                        <input type="hidden" name="teacher" value="${application.getTeacherEmail()}" />
                                        <input type="hidden" name="student" value="${application.getStudentEmail()}" />
                                        <button class="btn btn-secondary" type="submit">상세보기</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
        	    </table>
        	</div>
        </div>
    </div>
    <footer class="bg-dark">
        <div class="row text-div">
        <div class="col-12 col-md">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
        </div>
        <div class="col-6 col-md"> <p>이메일: hi1234@gmail.com </p> </div>
        <div class="col-6 col-md"> <p>전화번호: 010-1111-0000 </p> </div>
        <div class="col-6 col-md"> <p>주소: 대한민국 </p> </div>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>