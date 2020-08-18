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
                    <h4 class="card-title ">사용자 목록</h4>
                    <c:if test="${not empty memberList}">
                      <form class="navbar-form" action="/member/memberlist" method="get">
                        <div class="input-group no-border">
                          <div class="col">
                            <select class="selectpicker" data-style="select-with-transition" title="통신사" data-size="3" name="telecom">
                              <option value="1" <c:if test="${telecomOne eq 1}">selected</c:if>>SKT</option>
                              <option value="2" <c:if test="${telecomOne eq 2}">selected</c:if>>KT</option>
                              <option value="3" <c:if test="${telecomOne eq 3}">selected</c:if>>LGT</option>
                            </select>
                          </div>
                          <div class="col">
                            <select class="selectpicker" data-style="select-with-transition" title="검색인자" data-size="7" name="search">
                              <option value="login" <c:if test="${searchOne eq 'login'}">selected</c:if>>아이디</option>
                              <option value="name" <c:if test="${searchOne eq 'name'}">selected</c:if>>이름</option>
                              <option value="phonenumber" <c:if test="${searchOne eq 'password'}">selected</c:if>>휴대폰번호</option>
                            </select>
                          </div>
                          <div class="col">
                            <input type="text" class="form-control" placeholder="검색어" name="keyword" value="<c:if test="${not empty keywordOne}">${keywordOne}</c:if>">
                          </div>
                          <button type="submit" class="btn btn-white btn-round btn-just-icon">
                            <i class="material-icons">search</i>
                            <div class="ripple-container"></div>
                          </button>
                        </div>
                      </form>
                    </c:if>
                    <c:if test="${empty memberList}">
                      <form class="navbar-form" action="/member/memberlist" method="get">
                        <div class="input-group no-border">
                          <div class="col">
                            <select class="selectpicker" data-style="select-with-transition" title="통신사" data-size="3" name="telecom">
                              <option value="1">SKT</option>
                              <option value="2">KT</option>
                              <option value="3">LGT</option>
                            </select>
                          </div>
                          <div class="col">
                            <select class="selectpicker" data-style="select-with-transition" title="검색인자" data-size="7" name="search">
                              <option value="login">아이디</option>
                              <option value="name">이름</option>
                              <option value="phonenumber">휴대폰번호</option>
                            </select>
                          </div>
                          <div class="col">
                            <input type="text" class="form-control" placeholder="검색어" name="keyword">
                          </div>
                          <button type="submit" class="btn btn-white btn-round btn-just-icon">
                            <i class="material-icons">search</i>
                            <div class="ripple-container"></div>
                          </button>
                        </div>
                      </form>
                    </c:if>
                  </div>
                  <div class="card-body">
                    <div class="table-responsive">
                      <c:if test="${empty memberList}">
                        <table class="table">
                          <thead class=" text-primary">
                            검색 결과가 없습니다!
                          </thead>
                        </table>
                      </c:if>
                      <c:if test="${!empty memberList}">
                        <table class="table">
                          <thead class=" text-primary">
                            <th>
                              번호
                            </th>
                            <th>
                              아이디
                            </th>
                            <th>
                              이름
                            </th>
                            <th>
                              통신사
                            </th>
                            <th>
                              휴대폰번호
                            </th>
                            <th>
                              가입일자
                            </th>
                          </thead>
                          <c:forEach var="member" items="${memberList}" varStatus="vs" begin="0" step="1">
                          <tbody style="cursor: pointer" onclick="location.href='/member/memberview?id=${member.id}'">
                            <tr>
                              <td>
                                ${vs.index + 1}
                              </td>
                              <td>
                                <c:out value="${member.login}"/>
                              </td>
                              <td>
                                <c:out value="${member.name}"/>
                              </td>
                              <td>
                                <c:if test="${member.telecom == 1}">
                                  SKT
                                </c:if>
                                <c:if test="${member.telecom == 2}">
                                  KT
                                </c:if>
                                <c:if test="${member.telecom == 3}">
                                  LGT
                                </c:if>
                              </td>
                              <td>
                                <c:out value="${member.phnum}"/>
                              </td>
                              <td>
                                <fmt:formatDate value="${member.createddate}" pattern="yyyy-MM-dd"/>
                              </td>
                            </tr>
                          </tbody>
                          </c:forEach>
                        </table>
                      </c:if>
                      <a href="/member/memberregister" class="btn btn-rose pull-right">회원 등록</a>
                    </div>
                    <%-- paginate --%>
                    <div class="row">
                      <div class="col-sm-12 col-md-7">
                        <div class="dataTables_paginate paging_full_numbers" id="datatables_paginate">
                          <ul class="pagination">
                            <li class="paginate_button page-item first" id="datatables_first">
                              <a href="/member/memberlist?pn=1" aria-controls="datatables" data-dt-idx="0" tabindex="0" class="page-link">First</a>
                            </li>
                            <c:if test="${pn > 1}">
                              <li class="paginate_button page-item previous" id="datatables_previous">
                                <a href="/member/memberlist?pn=${pn-1}" aria-controls="datatables" data-dt-idx="1" tabindex="0" class="page-link">Prev</a>
                              </li>
                            </c:if>
                            <c:forEach varStatus="vs" begin="1" end="${maxPg}" step="1">
                              <c:if test="${vs.current eq pn}">
                                <li class="paginate_button page-item active">
                                  <b aria-controls="datatables" data-dt-idx="2" tabindex="0" class="page-link">${vs.current}</b>
                                </li>
                              </c:if>
                              <c:if test="${vs.current ne pn}">
                                <li class="paginate_button page-item active">
                                  <a href="/member/memberlist?pn=${vs.current}" aria-controls="datatables" data-dt-idx="2" tabindex="0" class="page-link">${vs.current}</a>
                                </li>
                              </c:if>
                            </c:forEach>
                            <c:if test="${pn < maxPg}">
                              <li class="paginate_button page-item next" id="datatables_next">
                                <a href="/member/memberlist?pn=${pn+1}" aria-controls="datatables" data-dt-idx="6" tabindex="0" class="page-link">Next</a>
                              </li>
                            </c:if>
                            <li class="paginate_button page-item last" id="datatables_last">
                              <a href="/member/memberlist?pn=${maxPg}" aria-controls="datatables" data-dt-idx="7" tabindex="0" class="page-link">Last</a>
                            </li>
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

    });
  </script>