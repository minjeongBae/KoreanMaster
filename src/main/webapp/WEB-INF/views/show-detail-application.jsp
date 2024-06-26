<%@ page contentType="text/html; charset=utf-8" %>

<!doctype html>
<html lang="en">
  <head>
    <title>안녕 - 신청서들 확인하기</title>

    <style>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
  <body>
    <div class="wrap">
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



          <footer class="container py-5 footer">
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
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>