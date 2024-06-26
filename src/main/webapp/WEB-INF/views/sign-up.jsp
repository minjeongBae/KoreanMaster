<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>
    <title>안녕 - 회원가입 1단계</title>
    <style>
        /* 라디오 버튼이 선택되었을 때의 스타일 */
        input[type="radio"]:checked {
            background-color: #4CAF50; /* 선택되었을 때의 배경 색상 */
            color: #c9e4c2; /* 선택되었을 때의 텍스트 색상 */
        }
    </style>
    <script>
        function handleDuplicateEmail(dup_email) {
            if (dup_email === "이용이 불가능한 이메일입니다.") {
                alert(dup_email);
                window.location.href = "/KoreanMaster/sign_up";
            }
        }
        handleDuplicateEmail(`${dup_email}`);
    </script>

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
              <li><a href="/KoreanMaster/introduction" class="nav-link px-2 text-white">소개</a></li>
              <li><a href="/KoreanMaster/show_board" class="nav-link px-2 text-white">질문게시판</a></li>
              <li><a href="/KoreanMaster/teachers" class="nav-link px-2 text-white">멘토</a></li>
              <li><a href="/KoreanMaster/my_page" class="nav-link px-2 text-white">마이페이지</a></li>
            </ul>
          </div>
        </div>
    </header>

    <div class="container">
      <main>
        <div class="py-5 text-center">
          <img class="d-block mx-auto mb-4" src="https://cdn.pixabay.com/photo/2013/07/12/14/07/student-147783_640.png" alt="" width="150" height="250">
          <h2>환영합니다.</h2>
        </div>

        <div class="row g-5">
          <div class="col-md-7 col-lg-8">
            <h4 class="mb-3">회원가입</h4>
            <form id="form" action="sign_up/step2" method="post" onsubmit="return validatePasswords()" class="needs-validation" novalidate>

              <div class="row g-3">
                <div class="col-12">
                  <label for="email" class="form-label">이메일<span class="text-body-secondary"/></label>
                  <input type="email" class="form-control" name="email" placeholder="you@example.com" required>
                  <div class="invalid-feedback"> 이메일을 입력해주세요. </div>
                </div>
                <div class="col-sm-6">
                  <label for="password" class="form-label">비밀번호</label>
                  <input type="password" id="password" class="form-control" name="password" value="" required>
                  <div class="invalid-feedback">
                    비밀번호를 입력해주세요.
                  </div>
                </div>
                <div class="col-sm-6">
                  <label for="checkPw" class="form-label">비밀번호 확인</label>
                  <input type="password" class="form-control" id="checkPw" name="checkPw" value="" required>
                  <div class="invalid-feedback">
                    비밀번호를 확인해주세요.
                  </div>
                </div>
                <hr class="my-4">
                <h4 class="mb-3">목적</h4>
                <div class="my-3">
                    <div class="form-check">
                      <input id="pStudent" name="position" type="radio" value="student" class="form-check-input" checked required>
                      <label class="form-check-label" for="credit">한국어를 배우고 싶어요!</label>
                    </div>
                    <div class="form-check">
                      <input id="pTeacher" name="position" type="radio" value="teacher" class="form-check-input" required>
                      <label class="form-check-label" for="debit">한국어를 가르쳐주고 싶어요!</label>
                    </div>
                </div>
                <hr class="my-4">
                <div style="margin-bottom:50px">
                <button class="w-100 btn btn-secondary btn-lg" type="submit">다음 단계</button>
              </div>
            </form>
          </div>
        </div>
      </main>
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
        (function () {
            'use strict';
            var forms = document.querySelectorAll('.needs-validation');
            Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
        })();
    </script>>
    <script>
        function validatePasswords() {
            // 두 패스워드 필드의 값을 가져옴
            var passwordValue = document.getElementById("password").value;
            var checkPwValue = document.getElementById("checkPw").value;

            // 패스워드가 일치하는지 확인
            if (passwordValue === checkPwValue) {
                // 일치하면 submit을 허용
                return true;
            } else {
                // 불일치하면 경고창을 띄우고 submit을 차단
                alert("입력한 패스워드가 일치하지 않습니다. 다시 확인해주세요.");
                return false;
            }
        }
    </script>
    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="checkout.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
