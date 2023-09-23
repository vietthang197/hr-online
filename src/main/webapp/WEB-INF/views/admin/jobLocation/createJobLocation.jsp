<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.hronline.config.Oauth2Security" %>
<%@ page import="org.springframework.validation.ObjectError" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.util.CollectionUtils" %>
<%@ page import="com.hronline.util.HrConstant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    ApplicationContext applicationContext = RequestContextUtils.findWebApplicationContext(request);
    Oauth2Security oauth2Security = (Oauth2Security) applicationContext.getBean("oauth2Security");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Thêm mới ngành nghề</title>

    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="/resources/adminlte/plugins/fontawesome-free/css/all.min.css">

    <!-- Theme style -->
    <link rel="stylesheet" href="/resources/adminlte/css/adminlte.min.css">
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

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="/admin" class="brand-link">
            <img src="/resources/logo.svg" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">HR Online</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3">
                <div class="d-flex flex-column">
                    <div class="p-2">
                        <a href="#" class="d-block">Xin chào <%=oauth2Security.getUsername()%></a>
                    </div>
                    <div class="p-2">
                        <a href="/sso/logout" class="d-block">Đăng xuất</a>
                    </div>
                </div>
            </div>
            <!-- Sidebar Menu -->
            <jsp:include page="../sideMenu.jsp"/>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Thêm mới ngành nghề</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Thêm mới ngành nghề</li>
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
                <form action="/admin/corp-industry/create" method="POST">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="corpName">Tên ngành nghề <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="corpName"  name="name" placeholder="Công ty A..." required>
                            </div>
                        </div>
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
</body>
</html>
