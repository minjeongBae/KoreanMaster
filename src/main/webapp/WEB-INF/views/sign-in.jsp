<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="en">
  <head>
    <title>Korean Master - 로그인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>
      <header class="p-3 bg-dark text-white">
        <div class="container">
          <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/KoreanMaster" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <font size=5> Korean Master </font>
              <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
            </a>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><a href="/KoreanMaster/show_board" class="nav-link px-2 text-white">질문게시판</a></li>
              <li><a href="#" class="nav-link px-2 text-white">정보</a></li>
              <li><a href="/KoreanMaster/my_page" class="nav-link px-2 text-white">마이페이지</a></li>
            </ul>
          </div>
        </div>
      </header>
      <div align="center" style="padding: 25px;">
        <form>
            <img class="mb-4" src="https://cdn.pixabay.com/photo/2015/11/06/11/43/businessman-1026415_640.jpg" alt="" width="230" height="250">
            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                <label for="floatingInput">이메일</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">비밀번호</label>
            </div>
            <button style="margin: 30px 10px 10px 50px" class="w-50 btn btn-lg btn-primary" type="submit">로그인</button>
        </form>
      </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>
