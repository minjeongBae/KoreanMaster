<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="koreanmaster.teachers.teacher.dto.IntroductionDTO"%>

<!DOCTYPE html>
<html>
<head>
    <title>안녕 - 답글 작성 </title>
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



  <div class="container my-5">
    <div class="row p-4 pb-0 pe-lg-0 pt-lg-5 align-items-center rounded-3 border shadow-lg">
      <div class="col-lg-7 p-3 p-lg-5 pt-lg-3">
        <h1 class="display-4 fw-bold lh-1">${introduction.getName()} <br/> ${introduction.getBrief()}</h1>
        <p class="lead">${introduction.getTxt()}</p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-start mb-4 mb-lg-3">
          <button onclick="subscribe()" type="button" class="btn btn-success btn-lg px-4 me-md-2 fw-bold">매칭신청</button>
          <button onclick="counsel()" type="button" class="btn btn-outline-secondary btn-lg px-4">상담하기</button>
        </div>
      </div>
      <div class="col-lg-4 offset-lg-1 p-0 overflow-hidden shadow-lg" align="center">
          <img class="rounded-lg-3" src="${introduction.getImg()}" width="400">
      </div>
    </div>
  </div>

  <div class="container my-5">
    <div class="row p-4 pb-0 pe-lg-0 pt-lg-5 align-items-center rounded-3 border shadow-lg">
        <div class="bg-body-tertiary p-5 rounded">
            <div style="margin-bottom: 15px">
                <img class="rounded-lg-3" src="https://img.icons8.com/?size=50&id=37808&format=png" width="50px">
                <h1>확인해주세요</h1>
            </div>
                   <p class="lead">
            <div>
                <img src="https://img.icons8.com/?size=48&id=114321&format=png" width="23px">
                <span>최종 학력: </span>
            </div>
            <div>
                <img src="https://img.icons8.com/?size=48&id=114321&format=png" width="23px">
                <span>한국인입니다.</span>
            </div>
            <div>
                <img src="https://img.icons8.com/?size=48&id=114321&format=png" width="23px">
                <span>한국 거주 n년차 외국인입니다.</span>
            </div>
          </p>
        </div>
    </div>
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
        function subscribe() {
            window.location.href = "/KoreanMaster/subscribe";
        }
        function counsel() {
            window.location.href = "/KoreanMaster/counsel";
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>