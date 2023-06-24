<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<nav class="mt-2">
    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        <li class="nav-item <% if (request.getAttribute("javax.servlet.forward.servlet_path").toString().startsWith("/admin/job")) { %> menu-open<%}%>">
            <a href="#" class="nav-link">
                <i class="fas fa-briefcase"></i>
                <p>
                    Job
                    <i class="right fas fa-angle-left"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="/admin/job" class="nav-link <% if (request.getAttribute("javax.servlet.forward.servlet_path").equals("/admin/job")) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách job</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/job/create" class="nav-link <% if (request.getAttribute("javax.servlet.forward.servlet_path").equals("/admin/job/create")) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm mới Job</p>
                    </a>
                </li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link">
                <i class="fas fa-users"></i>
                <p>
                    Ứng viên
                    <i class="fas fa-angle-left right"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách cv</p>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
</nav>