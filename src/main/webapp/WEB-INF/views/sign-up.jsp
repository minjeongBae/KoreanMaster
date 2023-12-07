<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>
    <link href="checkout.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body class="bg-body-tertiary">
    <header class="p-3 bg-dark text-white">
        <div class="container">
          <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/KoreanMaster" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <font size=5> 안녕 </font>
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
    <div class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle" style="margin-bottom: 30px">
      <button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center"
              id="bd-theme"
              type="button"
              aria-expanded="false"
              data-bs-toggle="dropdown"
              aria-label="Toggle theme (auto)">
        <svg class="bi my-1 theme-icon-active" width="1em" height="1em"><use href="#circle-half"></use></svg>
        <span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
      </button>
      <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light" aria-pressed="false">
            <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em"><use href="#sun-fill"></use></svg>
            Light
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark" aria-pressed="false">
            <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em"><use href="#moon-stars-fill"></use></svg>
            Dark
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center active" data-bs-theme-value="auto" aria-pressed="true">
            <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em"><use href="#circle-half"></use></svg>
            Auto
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
      </ul>
    </div>
    <div class="container">
      <main>
        <div class="py-5 text-center">
          <img class="d-block mx-auto mb-4" src="https://cdn.pixabay.com/photo/2013/07/12/14/07/student-147783_640.png" alt="" width="150" height="250">
          <h2>환영합니다.</h2>
        </div>

        <div class="row g-5">
          <div class="col-md-7 col-lg-8">
            <h4 class="mb-3">회원가입</h4>
            <form action="sign_up/step2" method="post" class="needs-validation" novalidate>
              <div class="row g-3">
                <div class="col-12">
                  <label for="email" class="form-label">이메일<span class="text-body-secondary"/></label>
                  <input type="email" class="form-control" id="email" placeholder="you@example.com">
                  <div class="invalid-feedback"> 이메일을 입력해주세요. </div>
                </div>
                <div class="col-sm-6">
                  <label for="password" class="form-label">비밀번호</label>
                  <input type="text" class="form-control" id="password" placeholder="" value="" required>
                  <div class="invalid-feedback">
                    비밀번호를 입력해주세요.
                  </div>
                </div>
                <div class="col-sm-6">
                  <label for="checkPw" class="form-label">비밀번호 확인</label>
                  <input type="text" class="form-control" id="checkPw" placeholder="" value="" required>
                  <div class="invalid-feedback">
                    비밀번호를 확인해주세요.
                  </div>
                </div>
                <hr class="my-4">
                <h4 class="mb-3">목적</h4>
                <div class="my-3">
                    <div class="form-check">
                      <input id="credit" name="position" type="radio" value="student" class="form-check-input" checked required>
                      <label class="form-check-label" for="credit">한국어를 배우고 싶어요!</label>
                    </div>
                    <div class="form-check">
                      <input id="debit" name="position" type="radio" value="teacher" class="form-check-input" required>
                      <label class="form-check-label" for="debit">한국어를 가르쳐주고 싶어요!</label>
                    </div>
                </div>
                <hr class="my-4">
                <div style="margin-bottom:50px">
                <button class="w-100 btn btn-primary btn-lg" type="submit">다음 단계</button>
              </div>
            </form>
          </div>
        </div>
      </main>
    </div>
    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="checkout.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
