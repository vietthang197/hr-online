<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.hronline.config.Oauth2Security" %>
<%@ page import="com.hronline.dto.IndustryDto" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.validation.ObjectError" %>
<%@ page import="org.springframework.util.CollectionUtils" %>
<%@ page import="com.hronline.util.HrConstant" %>
<%@ page import="com.hronline.dto.JobLocationDto" %>
<%@ page import="com.hronline.dto.CorporationDto" %>
<%@ page import="com.hronline.entity.JobLocation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    ApplicationContext applicationContext = RequestContextUtils.findWebApplicationContext(request);
    Oauth2Security oauth2Security = (Oauth2Security) applicationContext.getBean("oauth2Security");
    List<JobLocationDto> locations = (List<JobLocationDto>) request.getAttribute("locations");
    List<CorporationDto> corporations = (List<CorporationDto>) request.getAttribute("corporations");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Thêm mới công việc</title>

    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="/resources/adminlte/plugins/fontawesome-free/css/all.min.css">

    <!-- Theme style -->
    <link rel="stylesheet" href="/resources/adminlte/css/adminlte.min.css">
    <link rel="stylesheet" href="/resources/css/select2.min.css">
    <style>
        .dropzone {
            border: 2px dashed #ccc;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            position: relative;
        }
        img.preview {
            max-width: 100%;
            max-height: 200px;
            margin-top: 10px;
            display: none;
        }
        .delete-button {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: red;
            color: white;
            border: none;
            border-radius: 50%;
            width: 30px;
            height: 30px;
            cursor: pointer;
        }
    </style>
</head>
<!--
`body` tag options:

  Apply one or more of the following classes to to the body tag
  to get the desired effect

  * sidebar-collapse
  * sidebar-mini
-->
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../header.jsp"/>
    <!-- /.navbar -->

    <jsp:include page="../miniSideMenu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Thêm mới công việc</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Thêm mới công việc</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <% String successMessage = (String) request.getAttribute(HrConstant.ATTRIBUTE_SUCCCES_MESSAGE); %>
            <% if (successMessage != null) {%>
            <div class="row alert-msg">
                <div class="col-md-6">
                    <ul class="list-group mb-2">
                        <li class="list-group-item list-group-item-success">
                            <%=successMessage%>
                        </li>
                    </ul>
                </div>
            </div>
            <%}%>
            <% List<ObjectError> errorList = (List<ObjectError>) request.getAttribute(HrConstant.ATTRIBUTE_ERROR_LIST); %>
            <% if (!CollectionUtils.isEmpty(errorList)) {%>
            <div class="row alert-msg">
                <div class="col-md-6">
                    <ul class="list-group mb-2">
                        <%
                            for (ObjectError error : errorList) {
                        %>
                        <li class="list-group-item list-group-item-danger">
                            <%=error.getDefaultMessage()%>
                        </li>

                    </ul>
                    <%}%>
                </div>
            </div>
            <%}%>
            <div class="container-fluid">
                <form action="/admin/job/create" method="POST">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="name">Tên công việc <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="name" name="name"
                                       placeholder="Nhân viên kỹ thuật...">
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label for="tags">Nhãn dán (Cách nhau bởi dấu phẩy) <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="tags" name="tags" placeholder="">
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <!-- /.col -->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="salaryFrom">Mức lương thấp nhất <span class="text-danger">*</span></label>
                                <input type="number" class="form-control" id="salaryFrom" name="salaryFrom" placeholder="">
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label for="salaryTo">Mức lương cao nhất <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="salaryTo" name="salaryTo" placeholder="">
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="reward">Hoa hồng <span class="text-danger">*</span></label>
                                <input type="number" class="form-control" id="reward" name="reward" placeholder="">
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label for="corporation">Đăng cho công ty</label>
                                <select class="form-control" id="corporation" name="corporation">
                                    <%for (CorporationDto corp : corporations) {%>
                                    <option value="<%=corp.getId()%>"><%=corp.getName()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="location">Nơi làm việc: <span class="text-danger">*</span></label>
                                <select class="form-control" id="location" name="location">
                                    <%for (JobLocationDto jobLocation : locations) {%>
                                    <option value="<%=jobLocation.getId()%>"><%=jobLocation.getName()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label for="urgent">Cần gấp: <span class="text-danger">*</span></label>
                                <input type="checkbox" class="form-control-sm" id="urgent" name="urgent">
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="description">Mô tả công việc</label>
                                <textarea rows="4" class="form-control" id="description" name="description"
                                          placeholder=""></textarea>
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
                    <% if (oauth2Security.hasResourcePermission(request, "Admin Resource", "urn:servlet-authz:protected:admin:access")) { %>
                    <button type="submit" class="btn btn-primary btn-sm">Thêm</button>
                    <%}%>
                </form>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->

    <!-- Main Footer -->
    <jsp:include page="../footer.jsp"/>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="/resources/adminlte/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/resources/adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE -->
<script src="/resources/adminlte/js/adminlte.js"></script>
<script src="/resources/js/select2.min.js"></script>
<script>
    $(".alert-msg").fadeTo(2000, 500).slideUp(500, function(){
        $(".alert-msg").slideUp(500);
    });
</script>
<script>
    $(document).ready(function() {
        $('#industries').select2({
            multiple: true
        });
    });
</script>
</body>
</html>
