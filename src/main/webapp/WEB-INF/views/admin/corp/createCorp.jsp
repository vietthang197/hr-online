<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.hronline.config.Oauth2Security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    ApplicationContext applicationContext = RequestContextUtils.findWebApplicationContext(request);
    Oauth2Security oauth2Security = (Oauth2Security) applicationContext.getBean("oauth2Security");
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
                                <label for="industry">Ngành nghề <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="industry" name="industry" placeholder="">
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
                                <label for="email">Email <span class="text-danger">*</span></label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="">
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="website">Website</label>
                                <input type="text" class="form-control" id="website" name="website" placeholder="">
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">

                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="description">Mô tả công ty</label>
                                <textarea rows="4" class="form-control" id="description" name="description"
                                          placeholder=""></textarea>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-6 offset-md-3">
                                    <div class="dropzone" id="dropzone">
                                        <p id="uploadText">Kéo và thả hình ảnh hoặc <label for="fileInput" class="text-decoration-underline">nhấn vào đây</label> để tải lên.</p>
                                        <input type="file" id="fileInput" style="display: none;">
                                        <button id="deleteButton" class="delete-button" style="display: none;"><i class="fas fa-times"></i></button>
                                        <img id="preview" class="preview" src="" alt="Preview">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
                    <% if (oauth2Security.hasResourcePermission(request, "Corp Industry Resource", "urn:servlet-authz:protected:admin:industry:create")) { %>
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
<script>
    $(".alert-msg").fadeTo(2000, 500).slideUp(500, function(){
        $(".alert-msg").slideUp(500);
    });
</script>
<script>
    $(document).ready(function() {

        $("#dropzone").on("dragover", function(event) {
            event.preventDefault();
            $(this).addClass("dragover");
        });

        $("#dropzone").on("dragleave", function(event) {
            event.preventDefault();
            $(this).removeClass("dragover");
        });

        $("#dropzone").on("drop", function(event) {
            event.preventDefault();
            $(this).removeClass("dragover");

            var file = event.originalEvent.dataTransfer.files[0];
            displayImage(file);
        });

        $("#fileInput").on("change", function() {
            var file = this.files[0];
            displayImage(file);
        });

        $("#deleteButton").on("click", function(e) {
            e.stopPropagation();
            e.preventDefault();
            $("#preview").attr("src", "");
            $("#preview").hide();
            $("#deleteButton").hide();
            $("#fileInput").val("");
            showUploadText();
        });

        function displayImage(file) {
            var reader = new FileReader();
            reader.onload = function(event) {
                $("#preview").attr("src", event.target.result);
                $("#preview").show();
                $("#deleteButton").show();
                hideUploadText();
            };
            reader.readAsDataURL(file);
        }

        function hideUploadText() {
            $("#uploadText").hide();
        }

        function showUploadText() {
            $("#uploadText").show();
        }
    });
</script>
</body>
</html>
