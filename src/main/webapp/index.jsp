<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="en">
  <head>
    <title>안녕</title>
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.3/examples/product/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <style>
    .jb-wrap {
    	width: 100%;
    	position: relative;
    }
    .jb-wrap img {
    	width: 100%;
    	vertical-align: middle;
    }
    .jb-text {
        margin: 20px 20px 20px 20px;
        padding: 5px 10px;
        color: black;
        position: absolute;
        top: 30%;
        left: 25%;
        transform: translate(-50%, -50%);
        font-size: 60px; /* 텍스트 크기를 추가 */
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
      <div class="position-relative jb-wrap">
        <img class="jb-image" src="https://cdn.pixabay.com/photo/2016/12/03/11/44/background-1879623_640.jpg" width="100%" height="350px"/>
        <div class="col-sm-3 col-md-5 col-lg-20 mx-auto my-5 jb-text">
          <h1 class="display-3 fw-bold">전화로 한국어 <br /> 배우기</h1>
          <h3 class="fw-normal text-muted mb-8">검증된 선생님들로 구성되어 있으며, <br /> 직접 선생님을 선택할 수 있습니다.</h3>
        </div>
      </div>

        <div class="w-100 my-md-3 ps-md-3" align="center">
          <div class="bg-body-tertiary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
            <div class="my-3 p-3">
              <h2 class="display-5">멘토 매칭</h2>
              <p class="lead">멘토 소개 페이지를 확인하면서 직접 비교할 수 있습니다.</p>
            </div>
            <img src="https://cdn.pixabay.com/photo/2020/06/06/22/00/online-5268393_640.png" />
          </div>
          <div class="bg-body-tertiary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
            <div class="my-3 p-3">
              <h2 class="display-5">질문 게시판 운영</h2>
              <p class="lead">빠른 게시판 응답으로 질문이나 문제가 발생할 때 신속한 답변을 얻을 수 있습니다.</p>
            </div>
            <img src="https://cdn.pixabay.com/photo/2017/09/20/11/27/bulletin-board-2768204_640.jpg"/>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>