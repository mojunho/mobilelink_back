<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="container-fluid">
            <div class="row">
              <div class="col-md-12">
                <div class="card">
                  <div class="card-header card-header-icon card-header-rose">
                    <div class="card-icon">
                      <i class="material-icons">assignment</i>
                    </div>
                    <h4 class="card-title ">게시글 목록</h4>
                    <form class="navbar-form">
                      <div class="input-group no-border">
                        <div class="col">
                          <select class="selectpicker" data-style="select-with-transition" title="통신사" data-size="3" name="telecom" id="telecom">
                            <option value="1">SKT</option>
                            <option value="2">KT</option>
                            <option value="3">LGT</option>
                          </select>
                        </div>
                        <div class="col">
                          <select class="selectpicker" data-style="select-with-transition" title="검색인자" data-size="7" name="search" id="search">
                            <option value="title">제목</option>
                            <option value="content">내용</option>
                          </select>
                        </div>
                        <div class="col">
                          <input type="text" class="form-control" placeholder="검색어" name="keyword" id="keyword">
                        </div>
                        <button type="button" class="btn btn-white btn-round btn-just-icon" id="boardSearchBtn">
                          <i class="material-icons">search</i>
                          <div class="ripple-container"></div>
                        </button>
                      </div>
                    </form>
                  </div>
                  <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">
                          <thead class=" text-primary">
                            <th>번호</th>
                            <th>통신사</th>
                            <th>제목</th>
                            <th>조회수</th>
                            <th>등록자</th>
                            <th>등록일자</th>
                          </thead>
                          <tbody id="boardList">
                          </tbody>
                        </table>
                      <a href="/board/boardregister" class="btn btn-rose pull-right">게시글 등록</a>
                    </div>
                    <%-- paginate --%>
                    <div class="row">
                      <div class="col-sm-12 col-md-7">
                        <div class="dataTables_paginate paging_full_numbers" id="datatables_paginate">
                          <ul class="pagination" id="boardPaging">
                          </ul>
                        </div>
                      </div>
                    </div>
                    <%-- paginate --%>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer class="footer">
        <div class="container-fluid">
          <nav class="float-left">
            <ul>
              <li>
                <a href="#">
                  Creative Tim
                </a>
              </li>
              <li>
                <a href="#">
                  About Us
                </a>
              </li>
              <li>
                <a href="#">
                  Blog
                </a>
              </li>
              <li>
                <a href="#">
                  Licenses
                </a>
              </li>
            </ul>
          </nav>
          <div class="copyright float-right">
            &copy;
            <script>
              document.write(new Date().getFullYear())
            </script>, made with <i class="material-icons">favorite</i> by
            <a href="#" target="_blank">Creative Tim</a> for a better web.
          </div>
        </div>
      </footer>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="../../../../resources/assets/js/core/jquery.min.js"></script>
  <script src="../../../../resources/assets/js/core/popper.min.js"></script>
  <script src="../../../../resources/assets/js/core/bootstrap-material-design.min.js"></script>
  <script src="../../../../resources/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!-- Plugin for the momentJs  -->
  <script src="../../../../resources/assets/js/plugins/moment.min.js"></script>
  <!--  Plugin for Sweet Alert -->
  <script src="../../../../resources/assets/js/plugins/sweetalert2.js"></script>
  <!-- Forms Validations Plugin -->
  <script src="../../../../resources/assets/js/plugins/jquery.validate.min.js"></script>
  <!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
  <script src="../../../../resources/assets/js/plugins/jquery.bootstrap-wizard.js"></script>
  <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
  <script src="../../../../resources/assets/js/plugins/bootstrap-selectpicker.js"></script>
  <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
  <script src="../../../../resources/assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
  <script src="../../../../resources/assets/js/plugins/jquery.dataTables.min.js"></script>
  <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
  <script src="../../../../resources/assets/js/plugins/bootstrap-tagsinput.js"></script>
  <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
  <script src="../../../../resources/assets/js/plugins/jasny-bootstrap.min.js"></script>
  <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
  <script src="../../../../resources/assets/js/plugins/fullcalendar.min.js"></script>
  <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
  <script src="../../../../resources/assets/js/plugins/jquery-jvectormap.js"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="../../../../resources/assets/js/plugins/nouislider.min.js"></script>
  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
  <!-- Library for adding dinamically elements -->
  <script src="../../../../resources/assets/js/plugins/arrive.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chartist JS -->
  <script src="../../../../resources/assets/js/plugins/chartist.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="../../../../resources/assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../../../../resources/assets/js/material-dashboard.js?v=2.1.0" type="text/javascript"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="../../../../resources/assets/demo/demo.js"></script>
  <script>
    $(document).ready(function() {
      // ajax함수 호출
      basicList(1);
      // 리스트 검색
      $('#boardSearchBtn').click(function() {
        basicList(1);
      });
    });
    // 게시판 상세보기
    function boardView(id) {
      location.href = "/board/boardview?id=" + id;
    }
    // ajax 함수
    function basicList(pageNum){
      var sendData = JSON.stringify({
        telecom:$('#telecom').val(),
        search:$('#search').val(),
        keyword:$('#keyword').val(),
        pageNumber:pageNum
      });
      console.log(sendData);
      $.ajax({
        type: "POST",
        url: "/rest/boardlistrest",
        data: sendData,
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (result) {
          makeTableRow(result, sendData.pageNumber);
        },
        error: function (jqXHR, textStatus, errorThrown) {
          console.log('textStatus :' + textStatus);
          console.log('errorThrown :' + errorThrown);
          console.log('jqXHR.responseText :' + jqXHR.responseText);
        }
      });
    }
    // ajax 이용한 테이블 함수
    function makeTableRow(result, pageNum) { //
      // 테이블 만들기.
      console.log(result);
      var html = '';
      if (result.boardList != null) {
        var cnt = result.boardList;
        for (var i = 0; i < cnt.length; i++) {
          html += '<tr style="cursor: pointer" onclick="boardView(' + result.boardList[i].id + ')">';
          html += '<td>' + (i + 1) + '</td>';
          html += '<td>' + result.boardList[i].telecom + '</td>';
          html += '<td>' + result.boardList[i].title + '</td>';
          html += '<td>' + result.boardList[i].readCount + '</td>';
          html += '<td>' + result.boardList[i].regName + '</td>';
          html += '<td>' + result.boardList[i].regDate + '</td>';
          html += '</tr>';
        }
      } else if (result.boardList == null) {
        html += '<tr>' + result.notFoundMsg + '</tr>';
      }
      $('#boardList').empty().append(html);
      // 페이지 네이션 만들기.
      var maxPg = result.maxPage;
      var page = '';
      page += '<li class="paginate_button page-item first" id="datatables_first">';
      page += '<b style="cursor: pointer" aria-controls="datatables" data-dt-idx="0" tabindex="0" class="page-link" onclick="changeList(' + 1 + ')">' + 'First' + '</b>';
      page += '</li>';
      for(var i=0; i<maxPg; i++) {
        if( (i+1) == pageNum ){
          page += '<li class="paginate_button page-item active">';
          page += '<b aria-controls="datatables" data-dt-idx="2" tabindex="0" class="page-link">' + (i+1) + '</b>';
          page += '</li>';
        } else {
          page += '<li class="paginate_button page-item active">';
          page += '<b style="cursor: pointer" aria-controls="datatables" data-dt-idx="2" tabindex="0" class="page-link" onclick="changeList(' + (i+1) + ')">' + (i+1) + '</b>';
          page += '</li>';
        }
      }
      page += '<li class="paginate_button page-item last" id="datatables_last">';
      page += '<b style="cursor: pointer" aria-controls="datatables" data-dt-idx="7" tabindex="0" class="page-link" onclick="changeList(' + maxPg + ')">' + 'Last' + '</b>';
      page += '</li>';
      $('#boardPaging').empty().append(page);
    }
    // 바뀐 페이지번호로 리스트 조회
    function changeList(pageNum){
      basicList(pageNum);
    }
  </script>