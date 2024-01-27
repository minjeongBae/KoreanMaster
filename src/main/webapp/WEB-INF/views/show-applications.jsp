<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="koreanmaster.teachers.applicationform.SimpleFormDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>안녕 - 매칭 신청 목록 </title>
    <link href="sidebars.css" rel="stylesheet">
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.3/examples/sidebars/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        .button {
            width: 100%;
        }

        .text-div {
            color: white;
            padding: 20px;
        }

        html, body {
            height: 100%;
        }

        .wrap {
            position: relative;
            min-height: 100%;
            padding-bottom: 114px;
            height: 100%;
        }

        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
        }
    </style>

</head>

<body style="height: 100%;">
    <div class="wrap">
        <header class="p-3 bg-dark text-white">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="/KoreanMaster" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <font size=5> 안녕 </font>
                        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap" /></svg>
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

        <div class="row container-fluid" style="height: 100%;">
            <div class="col-md-3 d-flex flex-column flex-shrink-0 p-3 text-bg-dark" style="height: 100%; width: 280px;">
                매칭신청목록
                <hr>
                <ul class="nav nav-pills flex-column mb-auto" style="margin: 20px; height: 100%;">
                    <li class="nav-item">
                        <button id="all" onclick="toggle(this)" class="nav-link active text-white button">전체</button>
                    </li>
                    <li>
                        <button id="waiting" onclick="toggle(this)" class="nav-link text-white button">매칭 대기 중</button>
                    </li>
                    <li>
                        <button id="counseling" onclick="toggle(this)" class="nav-link text-white button">매칭 상담 중</button>
                    </li>
                    <li>
                        <button id="doing" onclick="toggle(this)" class="nav-link text-white button">수업 진행 중</button>
                    </li>
                    <li>
                        <button id="done" onclick="toggle(this)" class="nav-link text-white button">수업 종료</button>
                    </li>
                </ul>
                <hr>
            </div>

            <div align="center" style="margin-top: 50px" class="col-md-8 container">
                <div class="row">
                    <table id="all_table" class="table table-stripped" style="text-align: center; border: 1px solid #dddddd">
                        <thead>
                            <tr>
                                <th style="background-color: #B2EBF2; text-align: center;">번호</th>
                                <th style="background-color: #B2EBF2; text-align: center;">신청인</th>
                                <th style="background-color: #B2EBF2; text-align: center;">현상태</th>
                                <th style="background-color: #B2EBF2; text-align: center;"></th>
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
                                            <input type="hidden" name="formCode" value="${application.getFormCode()}" />
                                            <input type="hidden" name="teacher" value="${application.getTeacherEmail()}" />
                                            <input type="hidden" name="student" value="${application.getStudentEmail()}" />
                                            <button class="btn btn-secondary" type="submit">상세보기</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <table id="waiting_table" class="table table-stripped" style="display: none; text-align: center; border: 1px solid #dddddd">
                        <thead>
                            <tr>
                                <th style="background-color: #B2EBF2; text-align: center;">번호</th>
                                <th style="background-color: #B2EBF2; text-align: center;">신청인</th>
                                <th style="background-color: #B2EBF2; text-align: center;">현상태</th>
                                <th style="background-color: #B2EBF2; text-align: center;"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="application" items="${applications}" varStatus="loop">
                                <c:if test="${application.getState() eq '0'}">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${application.getStudentEmail()}</td>
                                        <td>${application.getStateDetail()}</td>
                                        <td>
                                            <form action="show_detail_application" method="post">
                                                <input type="hidden" name="formCode" value="${application.getFormCode()}" />
                                                <input type="hidden" name="teacher" value="${application.getTeacherEmail()}" />
                                                <input type="hidden" name="student" value="${application.getStudentEmail()}" />
                                                <button class="btn btn-secondary" type="submit">상세보기</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <table id="counseling_table"  class="table table-stripped" style="display: none; text-align: center; border: 1px solid #dddddd">
                        <thead>
                            <tr>
                                <th style="background-color: #B2EBF2; text-align: center;">번호</th>
                                <th style="background-color: #B2EBF2; text-align: center;">신청인</th>
                                <th style="background-color: #B2EBF2; text-align: center;">현상태</th>
                                <th style="background-color: #B2EBF2; text-align: center;"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="application" items="${applications}" varStatus="loop">
                                <c:if test="${application.getState() eq '1'}">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${application.getStudentEmail()}</td>
                                        <td>${application.getStateDetail()}</td>
                                        <td>
                                            <form action="show_detail_application" method="post">
                                                <input type="hidden" name="formCode" value="${application.getFormCode()}" />
                                                <input type="hidden" name="teacher" value="${application.getTeacherEmail()}" />
                                                <input type="hidden" name="student" value="${application.getStudentEmail()}" />
                                                <button class="btn btn-secondary" type="submit">상세보기</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <table id="doing_table"  class="table table-stripped" style="display: none; text-align: center; border: 1px solid #dddddd">
                        <thead>
                            <tr>
                                <th style="background-color: #B2EBF2; text-align: center;">번호</th>
                                <th style="background-color: #B2EBF2; text-align: center;">신청인</th>
                                <th style="background-color: #B2EBF2; text-align: center;">현상태</th>
                                <th style="background-color: #B2EBF2; text-align: center;"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="application" items="${applications}" varStatus="loop">
                                <c:if test="${application.getState() eq '2'}">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${application.getStudentEmail()}</td>
                                        <td>${application.getStateDetail()}</td>
                                        <td>
                                            <form action="show_detail_application" method="post">
                                                <input type="hidden" name="formCode" value="${application.getFormCode()}" />
                                                <input type="hidden" name="teacher" value="${application.getTeacherEmail()}" />
                                                <input type="hidden" name="student" value="${application.getStudentEmail()}" />
                                                <button class="btn btn-secondary" type="submit">상세보기</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <table id="done_table"  class="table table-stripped" style="display: none; text-align: center; border: 1px solid #dddddd">
                        <thead>
                            <tr>
                                <th style="background-color: #B2EBF2; text-align: center;">번호</th>
                                <th style="background-color: #B2EBF2; text-align: center;">신청인</th>
                                <th style="background-color: #B2EBF2; text-align: center;">현상태</th>
                                <th style="background-color: #B2EBF2; text-align: center;"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="application" items="${applications}" varStatus="loop">
                                <c:if test="${application.getState() eq '3'}">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${application.getStudentEmail()}</td>
                                        <td>${application.getStateDetail()}</td>
                                        <td>
                                            <form action="show_detail_application" method="post">
                                                <input type="hidden" name="formCode" value="${application.getFormCode()}" />
                                                <input type="hidden" name="teacher" value="${application.getTeacherEmail()}" />
                                                <input type="hidden" name="student" value="${application.getStudentEmail()}" />
                                                <button class="btn btn-secondary" type="submit">상세보기</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <footer class="bg-dark footer">
            <div class="row text-div">
                <div class="col-12 col-md">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24"><title>Product</title><circle cx="12" cy="12" r="10" /><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" /></svg>
                </div>
                <div class="col-6 col-md">
                    <p>이메일: hi1234@gmail.com </p>
                </div>
                <div class="col-6 col-md">
                    <p>전화번호: 010-1111-0000 </p>
                </div>
                <div class="col-6 col-md">
                    <p>주소: 대한민국 </p>
                </div>
            </div>
        </footer>
    </div>

<script>

    function active(button){
        // 현재 버튼의 클래스에 "active"가 있는지 확인
        var isActive = button.classList.contains('active');

        // 모든 버튼에서 "active" 클래스 제거
        var buttons = document.querySelectorAll('.nav-link.button');
        buttons.forEach(function(btn) {
            btn.classList.remove('active');
        });

        // 현재 버튼이 "active" 클래스를 가지고 있지 않으면 추가
        if (!isActive) {
            button.classList.add('active');
        }
    }

    function toggle(button) {
        active(button);
        var buttonId = button.id;
        switch (buttonId) {
            case 'all':
                tableVisibility('all_table');
                break;
            case 'waiting':
                tableVisibility('waiting_table');
                break;
            case 'counseling':
                tableVisibility('counseling_table');
                break;
            case 'doing':
                tableVisibility('doing_table');
                break;
            case 'done':
                tableVisibility('done_table');
                break;
        }
    }

    function tableVisibility(tableId) {
         // 모든 테이블 숨기기
         var allTables = document.querySelectorAll('table');
         allTables.forEach(function(table) {
             table.style.display = 'none';
         });

         // 특정 테이블 보이기
         var targetTable = document.getElementById(tableId);
         if (targetTable) {
             targetTable.style.display = 'table';
         }
    }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>