<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.hronline.config.Oauth2Security" %>
<%@ page import="com.hronline.dto.IndustryDto" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.validation.ObjectError" %>
<%@ page import="org.springframework.util.CollectionUtils" %>
<%@ page import="com.hronline.util.HrConstant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    ApplicationContext applicationContext = RequestContextUtils.findWebApplicationContext(request);
    Oauth2Security oauth2Security = (Oauth2Security) applicationContext.getBean("oauth2Security");
    List<IndustryDto> industryDtos = (List<IndustryDto>) request.getAttribute("industries");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Thêm mới công ty</title>

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
                        <h1 class="m-0">Thêm mới công ty</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Thêm mới công ty</li>
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
                <form action="/admin/corp/create" method="POST">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="name">Tên công ty <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="name" name="name"
                                       placeholder="Công ty A...">
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label for="taxId">Mã số thuế <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="taxId" name="taxId" placeholder="">
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <!-- /.col -->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="industries">Ngành nghề <span class="text-danger">*</span></label>
                                <select class="select2 form-control select2-container--bootstrap4" id="industries" name="industries">
                                    <%for (IndustryDto industryDto : industryDtos) {%>
                                    <option value="<%=industryDto.getId()%>"><%=industryDto.getName()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label for="address">Địa chỉ <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="address" name="address" placeholder="">
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="phone">Số điện thoại <span class="text-danger">*</span></label>
                                <input type="tel" class="form-control" id="phone" name="phone" placeholder="">
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label for="website">Website</label>
                                <input type="text" class="form-control" id="website" name="website" placeholder="">
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="description">Mô tả công ty</label>
                                <textarea rows="4" class="form-control ckeditor" id="description" name="description"
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
<script src="/resources/js/ckeditor/ckeditor.js"></script>
<script src="/resources/js/ckeditor/adapters/jquery.js"></script>
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
