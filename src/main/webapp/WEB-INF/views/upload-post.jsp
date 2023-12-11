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
              <li><a href="/KoreanMaster/show_board" class="nav-link px-2 text-white">질문게시판</a></li>
              <li><a href="#" class="nav-link px-2 text-white">정보</a></li>
              <li><a href="/KoreanMaster/my_page" class="nav-link px-2 text-white">마이페이지</a></li>
            </ul>
          </div>
        </div>
      </header>

      <div style="margin: 50px 50px 50px 50px">
        <h2>
            [게시물 작성]
        </h2>
          <form action="writerAction" method="post">
            <input type="text" name="bdTitle" class="form-control mt-4 mb-2"
                placeholder="제목을 입력해주세요." required>
            <div class="form-group">
                <textarea class="form-control" rows="10" name="bdContent"
                    placeholder="내용을 입력해주세요" required></textarea>
            </div>
            <div style="margin-Top: 20px">
                <button type="submit" class="btn btn-secondary mb-3">제출</button>
            </div>
          </form>
      </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>