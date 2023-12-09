<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="koreanmaster.board.dto.PostDTO"%>

<!doctype html>
<html lang="en">
  <head>
    <title>안녕 - 회원가입 2단계</title>
    <style>
        /* 라디오 버튼이 선택되었을 때의 스타일 */
        input[type="radio"]:checked {
            background-color: #4CAF50; /* 선택되었을 때의 배경 색상 */
            color: #c9e4c2; /* 선택되었을 때의 텍스트 색상 */
        }
    </style>
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
          <h2>멘토 회원가입</h2>
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
                  <label for="language" class="form-label">영어 소통 가능 여부</label>
                  <select class="form-select" id="language" required>
                    <option value="">선택</option>
                    <option>매우 잘 통함</option>
                    <option>간단한 의사소통 가능</option>
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
                <h4 class="mb-3">한국인 여부</h4>
                <div class="my-3">
                    <div class="form-check">
                      <input id="country" name="is_korean" type="radio" value="true" class="form-check-input" checked required>
                      <label class="form-check-label" for="credit">한국인입니다.</label>
                    </div>
                    <div class="form-check">
                      <input id="country" name="is_korean" type="radio" value="false" class="form-check-input" required>
                      <label class="form-check-label" for="debit">한국인이 아닙니다.</label>
                    </div>
                </div>
                <div id="yearInKorea" style="display:none; border:5px solid #c9e4c2" >
                    <div class="form-check">
                        <input id="years3" name="years" type="radio" value="three" class="form-check-input" checked required>
                        <label class="form-check-label" for="years3">3년 이하</label>
                    </div>
                    <div class="form-check">
                        <input id="years5" name="years" type="radio" value="five" class="form-check-input" required>
                        <label class="form-check-label" for="years5">5년 이하</label>
                    </div>
                    <div class="form-check">
                        <input id="years10" name="years" type="radio" value="ten" class="form-check-input" required>
                        <label class="form-check-label" for="years10">10년 이하</label>
                    </div>
                    <div class="form-check">
                        <input id="years10" name="years" type="radio" value="ten" class="form-check-input" required>
                        <label class="form-check-label" for="years10">그이상</label>
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
    <script>
        document.getElementsByName('is_korean').forEach(function(radio) {
            radio.addEventListener('change', function() {
                var yearInKorea = document.getElementById('yearInKorea');
                if (this.value === 'false') {
                    yearInKorea.style.display = 'block';
                } else {
                    yearInKorea.style.display = 'none';
                }
            });
        });
    </script>
    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="checkout.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>