<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="koreanmaster.teachers.teacher.introduction.IntroductionDTO"%>

<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>
    <title>안녕: 멘토ver - 자기소개 수정</title>
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

    <div class="container" style="height: 85%">
        <div class="container">
            <form action="" method="post" style="background-color: #E0F7FA; margin:30px; padding: 20px">
                <h2></br>[최종학력 및 전공]</h2>
                </br>최종학력을 입력해주세요.</br>
                <input type="text" name="finalAcademicAbility" class="form-control mt-4 mb-2"
                    value="${introduction.getFinalAcademicAbility()}"/>
                </br>전공을 입력해주세요.</br>
                <input type="text" name="major" class="form-control mt-4 mb-2"
                                    value="${introduction.getMajor()}"/>
                </br>
                </br>졸업증명서 파일을 등록해주세요.</br>
                <input type="file" name="finalAcademicAbilityImg">
                <div style="margin-Top: 60px">
                    <button type="submit" class="btn btn-secondary mb-3">저장</button>
                </div>
            </form>

        </div>
        <div class="container">
            <form action="" method="post" style="background-color: #E0F7FA; margin:30px; padding: 20px;">
                <h2></br>[소개글]</h2>
                <input type="text" name="brief" class="form-control mt-4 mb-2"
                    value="${introduction.getBrief()}">
                <div class="form-group">
                    <textarea class="form-control" rows="10" name="txt"
                        placeholder="자세한 소개글을 입력해주세요.">${introduction.getTxt()}</textarea>
                </div>
                </br>
                <div style="margin-Top: 60px">
                    <button type="submit" class="btn btn-secondary mb-3">저장</button>
                </div>
            </form>
            <form action="" method="post" style="background-color: #E0F7FA; margin:30px; padding: 20px;">
                <h2></br>[이미지]</br></h2>
                <img class="rounded-lg-3" src="${introduction.getImg()}" width="25%">
                </br>
                <input type="file" name="img" id="fileInput" style="margin-Top: 10px"
                    value=${introduction.getImg()} onchange="previewImage()">
                <div style="margin-Top: 60px">
                    <button type="submit" class="btn btn-secondary mb-3">저장</button>
                </div>
            </form>
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

    <script>
    function previewImage() {
        // Get the file input element
        var fileInput = document.getElementById('fileInput');

        // Get the preview image element
        var previewImg = document.getElementById('previewImg');

        // Check if a file is selected
        if (fileInput.files && fileInput.files[0]) {
            // Create a FileReader object
            var reader = new FileReader();

            // Set the callback function when the file is loaded
            reader.onload = function (e) {
                // Set the source of the preview image to the loaded file data
                previewImg.src = e.target.result;
            };

            // Read the file as a data URL
            reader.readAsDataURL(fileInput.files[0]);
        } else {
            // If no file is selected, you can set a default image or clear the preview
            previewImg.src = ""; // Set a default image source or leave it empty to clear the preview
        }
    }
    </script>

    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="checkout.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
