<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- End Navbar -->
<div class="content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header card-header-icon card-header-rose">
            <div class="card-icon">
              <i class="material-icons">perm_identity</i>
            </div>
            <h4 class="card-title">회원정보 등록 -
              <small class="category">작성</small>
            </h4>
          </div>
          <div class="card-body">
            <%--@elvariable id="memberVo" type="kr.co.erst.mobilelink_back.vo.MemberVo"--%>
            <form:form method="post" modelAttribute="memberVo" action="/member/memberregister">
              <div class="row">
                <div class="col-md-3">
                  <div class="form-group">
                    <c:if test="${empty retelecom}">
                    <select class="form-control" data-style="select-with-transition" title="통신사" data-size="3" name="telecom">
                      <option disabled selected>통신사</option>
                      <option value="1">SKT</option>
                      <option value="2">KT</option>
                      <option value="3">LGT</option>
                    </select>
                    </c:if>
                    <c:if test="${not empty retelecom}">
                      <select class="form-control" data-style="select-with-transition" title="통신사" data-size="3" name="telecom">
                        <option disabled>통신사</option>
                        <option value="1" <c:if test="${retelecom == 1}">selected</c:if>>SKT</option>
                        <option value="2" <c:if test="${retelecom == 2}">selected</c:if>>KT</option>
                        <option value="3" <c:if test="${retelecom == 3}">selected</c:if>>LGT</option>
                      </select>
                    </c:if>
                  </div>
                </div>
                <div class="col-md-3">
                  <div class="form-group">
                    <label class="bmd-label-floating">이름</label>
                    <form:input type="text" class="form-control" path="name" name="name"/>
                    <form:errors path="name" cssStyle="color: red"/>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-4">
                  <div class="form-group">
                    <label class="bmd-label-floating">아이디</label>
                    <form:input type="text" class="form-control" path="login" name="login"/>
                    <form:errors path="login" cssStyle="color: red"/>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="form-group">
                    <label class="bmd-label-floating">비밀번호</label>
                    <form:input type="password" class="form-control" path="password" name="password"/>
                    <form:errors path="password" cssStyle="color: red"/>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-5">
                  <div class="form-group">
                    <label class="bmd-label-floating">전화번호</label>
                    <form:input type="text" class="form-control" path="phonenumber" name="phonenumber"/>
                    <form:errors path="phonenumber" cssStyle="color: red"/>
                  </div>
                </div>
              </div>
              <button type="submit" class="btn btn-rose pull-right">등록하기</button>
              <a href="javascript:history.back()" class="btn btn-rose pull-right">뒤로가기</a>
              <a href="/member/memberlist" class="btn btn-rose pull-right">목록으로</a>
            </form:form>
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
<script src=".../../../../resources/assets/js/core/popper.min.js"></script>
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

  });
</script>