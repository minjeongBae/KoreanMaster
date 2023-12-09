<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="koreanmaster.board.dto.PostDTO"%>

<!doctype html>
<html lang="en">
  <head>
    <title>안녕 - 회원가입 2단계</title>
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
    <div class="container">
      <main>
        <div class="py-5 text-center">
          <img class="d-block mx-auto mb-4" src="https://cdn.pixabay.com/photo/2013/07/12/14/07/student-147783_640.png" alt="" width="150" height="250">
          <h2>학생 회원가입</h2>
        </div>
        <div class="row g-5">
          <div class="col-md-7 col-lg-8">
            <h4 class="mb-3">정보를 입력해주세요.</h4>
            <form action="success_membership" method="post" class="needs-validation" novalidate>
              <div class="row g-3">
                <div class="col-12">
                  <label for="name" class="form-label">이름<span class="text-body-secondary"/></label>
                  <input type="text" class="form-control" id="name" placeholder="홍길동" required>
                  <div class="invalid-feedback"> 이름을 입력해주세요. </div>
                </div>
                <div>
                    <div class="col-md-5">
                        <label for="phone" class="form-label">휴대폰번호</label>
                        <input name="phone" type="text" class="form-control" oninput="oninputPhone(this)" placeholder="010-1234-1234" maxlength="14" required>
                        <div class="invalid-feedback">
                            휴대폰 번호를 확인해주세요.
                        </div>
                    </div>
                </div>

                <div class="col-md-5">
                  <label for="language" class="form-label">영어 능력</label>
                  <select class="form-select" id="language" required>
                    <option value="">선택</option>
                    <option>매우 원활함</option>
                    <option>간단한 소통 가능</option>
                    <option>불가능</option>
                  </select>
                  <div class="invalid-feedback">
                    영어 소통 가능 여부를 선택해주세요.
                  </div>
                </div>

                <div>
                    <div class="col-md-5">
                      <label for="birth" class="form-label">생년월일</label>
                      <input type="date" name="birth" required/>
                      <div class="invalid-feedback">
                        생일을 선택해주세요.
                      </div>
                    </div>
                </div>
                <hr class="my-4">
                <div style="margin-bottom:50px">
                    <button class="w-100 btn btn-secondary btn-lg" type="submit">완료</button>
                </div>
            </form>
          </div>
        </div>
      </main>
    </div>

    <script>
        function oninputPhone(target) {
            target.value = target.value
                .replace(/[^0-9]/g, '')
                .replace(/(^02.{0}|^01.{1}|[0-9]{3,4})([0-9]{3,4})([0-9]{4})/g, "$1-$2-$3");
        }
    </script>
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
    </script>

    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="checkout.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>