<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.hronline.config.Oauth2Security" %>
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
    <meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />
    <title>Danh sách công việc</title>
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="/resources/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/resources/adminlte/css/adminlte.min.css">

    <!-- Data table-->
    <jsp:include page="../common/importDataTableCss.jsp"/>

    <!-- Data table-->
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
    <jsp:include page="../miniSideMenu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Danh sách CV ứng viên</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Danh sách CV ứng viên</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <form id="formSearch" class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="s_jobId">Mã công việc </label>
                                            <input type="text" class="form-control" id="s_jobId" name="jobId" placeholder="Job ID">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="s_applicantPhone">Số điện thoại ứng viên </label>
                                            <input type="tel" class="form-control" id="s_applicantPhone" name="applicantPhone" placeholder="Tel">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <button class="btn btn-primary btn-sm" id="btnSearchDataTable"><i class="fas fa-search"></i>Tìm kiếm</button>
                                        <button class="btn btn-warning btn-sm" id="btnClearFormSearch"><i class="fas fa-sync"></i> Làm mới</button>
                                    </div>
                                </form>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body card-wrap-data-table">
                                <div class="row mb-4">
                                    <div class="col-md-12">
                                        <% if (oauth2Security.hasResourcePermission(request, "Admin Resource", "urn:servlet-authz:protected:admin:access")) { %>
                                        <button class="btn btn-danger btn-sm" id="deleteMultiRowDataTable"><i class="fas fa-trash"></i> Xoá bản ghi</button>
                                        <% } %>
                                    </div>
                                </div>
                                <table id="dataTable" class="table table-striped table-bordered display nowrap" style="width:100%">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>ID</th>
                                        <% if (oauth2Security.hasResourcePermission(request, "Admin Resource", "urn:servlet-authz:protected:admin:access")) { %>
                                        <th>Sửa</th>
                                        <%}%>
                                        <th>Tên ứng viên</th>
                                        <th>Số điện thoại</th>
                                        <th>Email</th>
                                        <th>Mạng xã hội</th>
                                        <th>File Cv</th>
                                        <th>Mã công việc</th>
                                        <th>Ngày nộp</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
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

<!-- Data table -->
<jsp:include page="../common/importDataTableJs.jsp"/>
<!-- Data table -->

<script>
    $(document).ready(function () {

        const objectSearch = {
            name: null
        }

        const dataTable = $('#dataTable').DataTable({
            columnDefs: [
                {
                    orderable: false,
                    className: 'select-checkbox',
                    targets: 0
                },
                {
                    targets: 1,
                    visible: false,
                    searchable: false,
                }
            ],
            select: {
                style: 'multi',
                selector: 'td:first-child'
            },
            pagingType: "full_numbers",
            lengthMenu: [
                [10, 25, 50],
                [10, 25, 50]
            ],
            searching: false,
            ordering: false,
            info: true,
            responsive: true,
            processing: false,
            serverSide: true,
            "columns": [
                {"data": ""},
                {"data": "id", "render": $.fn.dataTable.render.text()},
                <% if (oauth2Security.hasResourcePermission(request, "Admin Resource", "urn:servlet-authz:protected:admin:access")) { %>
                {"data": "edit"},
                <%}%>
                {"data": "applicantName", "render": $.fn.dataTable.render.text()},
                {"data": "applicantPhone", "render": $.fn.dataTable.render.text()},
                {"data": "applicantEmail", "render": $.fn.dataTable.render.text()},
                {"data": "applicantFbLink", "render": $.fn.dataTable.render.text()},
                {"data": "fileResume", "render": function (data) {
                        if (data) {
                            return "<a target='_blank' href='/file/download/"+ data +"'>Tải về</a>"
                        } else {
                            return "<p>Không có</p>";
                        }
                    }},
                {"data": "jobId", "render": $.fn.dataTable.render.text()},
                {"data": "createdDate", "render": $.fn.dataTable.render.text()},

            ],
            ajax: {
                url: "/admin/resume/search",
                method: "POST",
                contentType: "application/json",
                data: function (data) {
                    return JSON.stringify({
                        draw: data.draw,
                        start: Math.round(data.start / data.length),
                        length: data.length,
                        ...objectSearch
                    })
                },
                dataFilter: function (response) {
                    let responseJson = JSON.parse(response).data;
                    let dataRes = {
                        "draw": responseJson.draw,
                        "recordsFiltered": responseJson.recordsTotal,
                        "recordsTotal": responseJson.recordsTotal,
                        "data": []
                    };

                    for (let i = 0; i < responseJson.data.length; i++) {
                        dataRes.data.push({
                            "": "",
                            "id": responseJson.data[i].id,
                            <% if (oauth2Security.hasResourcePermission(request, "Admin Resource", "urn:servlet-authz:protected:admin:access")) { %>
                            "edit": '<a href="/admin/job/edit/' + responseJson.data[i].id  +'" role="button" class="btn btn-sm btn-primary"><i class="fas fa-edit"></i></a>',
                            <%}%>
                            "applicantName": responseJson.data[i].applicantName,
                            "applicantPhone": responseJson.data[i].applicantPhone,
                            "applicantEmail": responseJson.data[i].applicantEmail,
                            "applicantFbLink": responseJson.data[i].applicantFbLink,
                            "fileResume": responseJson.data[i].fileResume == null ? "" : responseJson.data[i].fileResume.id,
                            "jobId": responseJson.data[i].jobInfo.id,
                            "createdDate": responseJson.data[i].createdDate
                        })
                    }

                    return JSON.stringify(dataRes);
                }
            }
        });

        $('#btnSearchDataTable').click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            objectSearch.jobId = $('#s_jobId').val() == '' ? null : $('#s_jobId').val();
            objectSearch.applicantPhone = $('#s_applicantPhone').val() == '' ? null : $('#s_applicantPhone').val();
            dataTable.search({...objectSearch}).draw()
        })

        $('#btnClearFormSearch').click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            $('#s_jobId').val('');
            $('#s_applicantPhone').val('');
            objectSearch.jobId = null;
            objectSearch.applicantPhone = null;
            dataTable.search({...objectSearch}).draw()
        });

        <% if (oauth2Security.hasResourcePermission(request, "Admin Resource", "urn:servlet-authz:protected:admin:access")) { %>
        $('#deleteMultiRowDataTable').click(function (e) {
            e.preventDefault();
            e.stopPropagation();

            const counter = dataTable.rows({ selected: true }).count();
            if (counter == 0) {
                alert('Bạn phải chọn các bản ghi trước khi xoá!');
                return;
            }

            const chooser = confirm('Bạn có muốn xoá các bản ghi được chọn?');
            if (chooser) {
                const ids = dataTable.rows({ selected: true }).data().map(item => item.id).toArray();
                if (ids) {
                    $.ajax({
                        url: '/admin/resume/delete',
                        method: 'DELETE',
                        contentType: 'application/json',
                        data: JSON.stringify({
                            ids: ids
                        }),
                        complete: function () {
                            location.reload()
                        }
                    })
                }
            }
        })
        <%}%>
    });
</script>
</body>
</html>
