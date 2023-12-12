<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>안녕 - 게시물 작성 </title>
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
    <div style="margin: 50px 50px 50px 50px">
        <h2> [게시물 작성] </h2>
        <form action="success_upload_post" method="post" class="needs-validation">
            <input type="text" name="title" class="form-control mt-4 mb-2"
                placeholder="제목을 입력해주세요." required>
            <div class="form-group">
                <textarea class="form-control" rows="10" name="content"
                    placeholder="내용을 입력해주세요" required></textarea>
            </div>
            <div style="margin-Top: 20px">
                <button type="submit" class="btn btn-secondary mb-3">제출</button>
            </div>
        </form>
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