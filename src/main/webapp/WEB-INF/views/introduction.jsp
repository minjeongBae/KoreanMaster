<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>안녕 - 소개 </title>
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

    <main>
      <div class="container py-4">
        <header class="pb-3 mb-4 border-bottom">
            <p class="fs-4 d-flex align-items-center text-body-emphasis text-decoration-none">'안녕' 을 소개합니다</p>
        </header>

        <div class="p-5 mb-4 bg-body-tertiary rounded-3">
          <div class="container-fluid py-5">
            <h1 class="display-5 fw-bold">전화 한국어</h1>
            <p class="col-md-8 fs-4">
                전화를 통해 비대면으로 언제, 어디서나 듣기와 말하기를 하면서 한국어 능력을 향상시킬 수 있습니다.
                한국어만 사용하는 멘토, 영어로 설명을 돕는 멘토, 주말 전화, 평일 전화, 모든 컨디션을 선택할 수 있습니다.
                뿐만 아니라 매회 학습하고 싶은 한국 문화를 멘토에게 어필할 수 있습니다.
            </p>
            <button onclick="go_teacher()" class="btn btn-primary btn-lg" type="button">멘토 소개 페이지</button>
          </div>
        </div>

        <div class="row align-items-md-stretch">
          <div class="col-md-6">
            <div class="h-100 p-5 text-bg-dark rounded-3">
              <h2>멘토가 직접 소개글 작성</h2>
              <p>
                멘토 각자가 본인의 소개글을 직접 작성함으로 신뢰도를 높이고자 하였으며
                운영진들이 선별한 멘토들로 구성되어 있습니다.
              </p>
            </div>
          </div>
          <div class="col-md-6">
            <div class="h-100 p-5 bg-body-tertiary border rounded-3">
              <h2>활발한 질문게시판 운영</h2>
              <p>
                문제가 발생했을 때 빠른 해결이 가능하도록 질문게시판을 활발히 운영하고 있습니다.
                학생의 궁금증이 발생했거나 멘토와의 분쟁이 있을 때, 자유롭게 사용할 수 있습니다.
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
      </div>
    </main>

    <script>
        function go_teacher() {
            window.location.href = "/KoreanMaster/teachers";
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>