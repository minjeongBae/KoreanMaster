<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="koreanmaster.user.teacher.introduction.dto.IntroductionDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>안녕 - 멘토 </title>
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

    <div class="container marketing" align="left" style="margin-top:40px">
        <h2>멘토 알아보기</h2>
    </div>

    <div class="container marketing" align="center" style="margin-top:50px">

        <div class="row">
            <c:forEach var="introduction" items="${introductionDTOList}">
                <div class="col-lg-4" style="padding:20px">
                    <img class="bd-placeholder-img rounded-circle" width="140" height="140" src="${introduction.getImg()}" />
                    <h2 class="fw-normal"><br />${introduction.getName()}</h2>
                    <p>${introduction.getBrief()}</p>
                    <p>
                        <form action="teacher_page" method="get">
                            <input type="hidden" name="introduction-id" value="${introduction.getIntroductionId()}" />
                            <button style="margin: 30px 10px 10px 50px" class="w-50 btn btn-lg btn-secondary" type="submit">자세히 보기 &raquo;</button>
                        </form>
                    </p>
                </div>

                <!-- Add a line break after every 3 items -->
                <c:if test="${(loop.index + 1) % 3 == 0}">
                    <div class="w-100"></div>
                </c:if>
            </c:forEach>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>