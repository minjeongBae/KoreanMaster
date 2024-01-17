<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>안녕 - 내 정보 수정 </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        .bordered-box {
            border-top: 3px solid #696969;
            border-bottom: 3px solid #696969;
            width:800px;
            padding: 10px; /* 내용과 테두리 간격을 조절합니다. */
            margin: 10px; /* 요소 간격을 조절합니다. */
            text-align: center;
        }
        .colored-div {
            background-color: #E0F7FA; /* 여기에 원하는 색상 코드를 넣습니다. */
            padding: 20px; /* 내용과 테두리 간격을 조절합니다. */
        }
    </style>
    <script>
        function alertMessage(message) {
            if (message.trim()!="") {
                alert(message);
            }
        }
        alertMessage(`${message}`);
    </script>
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

    <div>
        <div class="bordered-box colored-div" style="margin: 50px 50px 50px 50px">
            <p><h4>사용자 정보 수정</h4><p>
            <p>
                <button onclick="show_change_pw()" type="button" class="btn btn-secondary">비밀번호 변경</button>
                <button onclick="show_change_birth()" type="button" class="btn btn-secondary">생일 변경</button>
                <button onclick="show_change_name()" type="button" class="btn btn-secondary">이름 변경</button>
                <button onclick="show_change_phone()" type="button" class="btn btn-secondary">전화번호 변경</button>
            </p>
        </div>
        <div>
            <div id="change_pw_btn" style="margin: 50px 50px 50px 50px; display: none;">
                <h4>비밀번호 변경</h4>
                <form action="change_pw" method="post">
                    <p>현재 비밀번호<br /><input name="old_password" type="password"></p>
                    <p>새 비밀번호<br /><input name="new_password" type="password"></p>
                    <p>비밀번호 확인<br /><input name="chk_password" type="password"></p>
                    <input type="submit" value="변경"/>
                </form>
            </div>
            <div id="change_birth_btn" style="margin: 50px 50px 50px 50px; display: none;">
                <h4>생일 변경</h4>
                <form action="change_birth" method="post">
                    <p>생년월일 입력<br /><input type="date" name="birth"/></p>
                    <input type="submit" value="변경"/>
                </form>
            </div>
            <div id="change_name_btn" style="margin: 50px 50px 50px 50px; display: none;">
                <h4>이름 변경</h4>
                <form>
                    <p>이름 입력<br /><input type="text" name="name"/></p>
                    <input type="submit" value="변경"/>
                </form>
            </div>
            <div id="change_phone_btn" style="margin: 50px 50px 50px 50px; display: none;">
                <h4>전화번호 변경</h4>
                <form>
                    <p>새 전화번호 입력<br /><input type="text" name="phone"/></p>
                    <input type="submit" value="변경"/>
                </form>
            </div>
        </div>
        <div id="studentDiv" class="bordered-box colored-div" style="margin: 50px 50px 50px 50px; display: none;">
            <p><h4>학생 정보 수정</h4></p>
            <p>
                <button onclick="change_eng_level()" type="button" class="btn btn-secondary">영어 소통 능력 수준 변경</button>
            </p>
        </div>
        <div id="eng_level_btn" style="margin: 50px 50px 50px 50px; display: none;" class="col-md-3">
            <h4>영어 소통 능력 수준 변경</h4>
            <form>
                <p>입력<br />
                    <select class="form-select" name="english" id="eneglish">
                        <option value="">선택</option>
                        <option value=1>매우 원활함</option>
                        <option value=2>간단한 소통 가능</option>
                        <option value=3>불가능</option>
                    </select>
                </p>
                <input type="submit" value="변경"/>

            </form>
        </div>
        <div id="teacherDiv" class="bordered-box colored-div" style="margin: 50px 50px 50px 50px; display: none;">
            <p><h4>멘토 정보 수정</h4></p>
            <p>
                <button type="button" class="btn btn-secondary">영어 소통 능력 수준 변경</button>
                <button type="button" class="btn btn-secondary">한국 거주 기간 변경</button>
                <button type="button" class="btn btn-secondary">자기소개 추가 및 변경</button>
            </p>
        </div>
    </div>
    <div>
    </div>

    <script>
        function showCorrectDiv() {
            var isStudent = ${isStudent};
            if (isStudent) {
                document.getElementById('studentDiv').style.display = 'block';
            } else {
                document.getElementById('teacherDiv').style.display = 'block';
            }
        }
        function show_change_pw() {
            document.getElementById('change_pw_btn').style.display = 'block';
            document.getElementById('change_birth_btn').style.display = 'none';
            document.getElementById('change_name_btn').style.display = 'none';
            document.getElementById('change_phone_btn').style.display = 'none';
        }
        function show_change_birth() {
            document.getElementById('change_pw_btn').style.display = 'none';
            document.getElementById('change_birth_btn').style.display = 'block';
            document.getElementById('change_name_btn').style.display = 'none';
            document.getElementById('change_phone_btn').style.display = 'none';

        }
        function show_change_name() {
            document.getElementById('change_pw_btn').style.display = 'none';
            document.getElementById('change_birth_btn').style.display = 'none';
            document.getElementById('change_name_btn').style.display = 'block';
            document.getElementById('change_phone_btn').style.display = 'none';
        }
        function show_change_phone() {
            document.getElementById('change_pw_btn').style.display = 'none';
            document.getElementById('change_birth_btn').style.display = 'none';
            document.getElementById('change_name_btn').style.display = 'none';
            document.getElementById('change_phone_btn').style.display = 'block';
        }
        function change_eng_level() {
            document.getElementById('eng_level_btn').style.display = 'block';
        }
        showCorrectDiv();
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>