<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>
    <title>안녕 - 매칭신청</title>
    <style>
        /* 라디오 버튼이 선택되었을 때의 스타일 */
        input[type="radio"]:checked {
            background-color: #4CAF50; /* 선택되었을 때의 배경 색상 */
            color: #c9e4c2; /* 선택되었을 때의 텍스트 색상 */
        }
        /* 선택된 체크박스의 스타일 */
        input[type="checkbox"]:checked {
            background-color: #4CAF50; /* 선택되었을 때의 배경 색상 */
            color: #c9e4c2; /* 선택되었을 때의 텍스트 색상 */
        }
    </style>
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
          <img class="d-block mx-auto mb-4" src="https://t3.ftcdn.net/jpg/05/51/28/74/240_F_551287455_wYfli2NDmOTy0cGjdcqVczBlBrdMbG24.jpg" width="300px">
          <h2>환영합니다</h2>
        </div>

        <div class="row g-5">
          <div class="col-md-7 col-lg-8">
            <div>
            <h4 class="mb-3">매칭신청</h4>
            <p>가능한 날짜/시간대 및 외의 필수사항들을 입력해주세요. <br/></p>
                <form id="form" action="/KoreanMaster" method="post" onsubmit="return validatePasswords()" class="needs-validation" novalidate>
                    <hr class="my-4">
                    <h4 class="mb-3"><br/>1. 원하는 횟수를 선택해주세요.</h4>
                    <div class="my-3"  style="margin:30px 30px 30px 30px; padding:30px; border:5px solid #c9e4c2;">
                        <div class="form-check">
                          <input id="frequency" name="frequency" type="radio" value="1" class="form-check-input" checked required>
                          <label class="form-check-label" for="credit">주 1회</label>
                        </div>
                        <div class="form-check">
                          <input id="frequency" name="frequency" type="radio" value="2" class="form-check-input" required>
                          <label class="form-check-label" for="credit">주 2회</label>
                        </div>
                        <div class="form-check">
                          <input id="frequency" name="frequency" type="radio" value="3" class="form-check-input" required>
                          <label class="form-check-label" for="credit">주 3회</label>
                        </div>
                        <div class="form-check">
                          <input id="frequency" name="frequency" type="radio" value="4" class="form-check-input" required>
                          <label class="form-check-label" for="credit">주 4회</label>
                        </div>
                        <div class="form-check">
                          <input id="frequency" name="frequency" type="radio" value="5" class="form-check-input" required>
                          <label class="form-check-label" for="credit">주 5회</label>
                        </div>
                    </div>
                    <h4 class="mb-3"><br/>2. 원하는 수업 시간을 선택해주세요.</h4>
                    <div class="my-3"  style="margin:30px 30px 30px 30px; padding:30px; border:5px solid #c9e4c2;">
                        <div class="form-check">
                          <input id="time" name="time" type="radio" value="15" class="form-check-input" checked required>
                          <label class="form-check-label" for="credit">15분</label>
                        </div>
                        <div class="form-check">
                          <input id="time" name="time" type="radio" value="30" class="form-check-input" required>
                          <label class="form-check-label" for="credit">30분</label>
                        </div>
                        <div class="form-check">
                          <input id="time" name="time" type="radio" value="60" class="form-check-input" required>
                          <label class="form-check-label" for="credit">60분</label>
                        </div>
                    </div>
                    <h4 class="mb-3"><br/>3. 원하는 수업 방식을 선택해주세요.</h4>
                    <div class="my-3"  style="margin:30px 30px 30px 30px; padding:30px; border:5px solid #c9e4c2;">
                        <div class="form-check">
                          <input id="root" name="root" type="radio" value="voice" class="form-check-input" checked required>
                          <label class="form-check-label" for="credit">실시간 음성 - 전화</label>
                        </div>
                        <div class="form-check">
                          <input id="root" name="root" type="radio" value="text" class="form-check-input" required>
                          <label class="form-check-label" for="credit">텍스트 - 채팅</label>
                        </div>
                        <div class="form-check">
                          <input id="root" name="root" type="radio" value="video" class="form-check-input" required>
                          <label class="form-check-label" for="credit">실시간 영상 - 화상통화</label>
                        </div>
                    </div>

                    <h4 class="mb-3"><br/>4. 현재 본인의 한국어 실력을 알려주세요.</h4>
                    <div class="my-3"  style="margin:30px 30px 30px 30px; padding:30px; border:5px solid #c9e4c2;">
                        <div class="form-check">
                          <input id="level" name="level" type="radio" value="1" class="form-check-input" checked required>
                          <label class="form-check-label" for="credit">처음 배워요</label>
                        </div>
                        <div class="form-check">
                          <input id="level" name="level" type="radio" value="2" class="form-check-input" required>
                          <label class="form-check-label" for="credit">인삿말을 구사할 수 있어요</label>
                        </div>
                        <div class="form-check">
                          <input id="level" name="level" type="radio" value="3" class="form-check-input" required>
                          <label class="form-check-label" for="credit">간단한 의사소통이 가능해요</label>
                        </div>
                        <div class="form-check">
                          <input id="level" name="level" type="radio" value="4" class="form-check-input" required>
                          <label class="form-check-label" for="credit">의사소통은 자유롭지만 더 다양한 표현들을 배우고 싶어요</label>
                        </div>
                    </div>
                    <hr class="my-4">
                    <h4 class="mb-3"><br/>신청인의 정보를 입력해주세요.</h4>
                    <div class="my-3"  style="margin:30px 30px 30px 30px; padding:30px; border:5px solid #c9e4c2;">
                        <p>
                            <label for="phone" class="form-label"><h3>상담 가능 시간대</h3></label>
                        </p>
                        <p>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" name="counselTime" value="1" checked> 모두 가능<br>
                            </div>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" name="counselTime" value="2"> 아침<br>
                            </div>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" name="counselTime" value="3"> 낮<br>
                            </div>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" name="counselTime" value="4"> 저녁<br>
                            </div>
                            <div class="invalid-feedback">
                                상담할 시간을 확인해주세요.
                            </div>
                        </p>
                        <div>
                            <p>궁금한 점이 있다면 적어주세요! (선택) </p>
                            <input type="text" name="addition" class="form-control mt-4 mb-2">
                        </div>
                    </div>
                    <hr class="my-4">
                    <div style="margin-bottom:50px">
                        <button class="w-100 btn btn-secondary btn-lg" type="submit">신청</button>
                    </div>
                </form>

            </div>
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
    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="checkout.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
