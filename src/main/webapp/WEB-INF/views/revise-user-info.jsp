<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>안녕 - 내 정보 수정 </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        .bordered-box {
            border-top: 3px solid #696969;
            border-bottom: 3px solid #696969;
            padding: 10px; /* 내용과 테두리 간격을 조절합니다. */
            margin: 10px; /* 요소 간격을 조절합니다. */
        }
        .colored-div {
            background-color: #FDF5E6; /* 여기에 원하는 색상 코드를 넣습니다. */
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

    <div>
        <div class="bordered-box colored-div" style="margin: 50px 50px 50px 50px">
            <p><h4>사용자 정보 수정</h4><p>
            <p>비밀번호 변경</p>
            <p>생일 변경</p>
            <p>이름 변경</p>
            <p>전화번호 변경</p>
        </div>

        <c:if test="${isStudent == true}">
            <div class="bordered-box colored-div" style="margin: 50px 50px 50px 50px">
                <p><h4>학생 정보 수정</h4><p>
                <p>영어 소통 능력 수준 변경</p>
            </div>
        </c:if>

        <c:if test="${isStudent == false}">
            <div class="bordered-box colored-div" style="margin: 50px 50px 50px 50px">
                <p><h4>멘토 정보 수정</h4><p>
                <p>영어 소통 능력 수준 변경</p>
                <p>한국 거주 기간 변경</p>
                <p>자기소개 추가 및 변경</p>
            </div>
        </c:if>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>