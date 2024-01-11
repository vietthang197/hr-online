<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="com.hronline.config.Oauth2Security" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    ApplicationContext applicationContext = RequestContextUtils.findWebApplicationContext(request);
    Oauth2Security oauth2Security = (Oauth2Security) applicationContext.getBean("oauth2Security");
%>
<nav class="mt-2">
    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        <li class="nav-item menu-open">
            <a href="#" class="nav-link">
                <i class="fas fa-tasks"></i>
                <p>
                    Job
                    <i class="right fas fa-angle-left"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="/admin/job" class="nav-link <% if ("/admin/job".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách job</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/job/create" class="nav-link <% if ("/admin/job/create".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm mới Job</p>
                    </a>
                </li>
            </ul>
        </li>
        <li class="nav-item menu-open">
            <a href="#" class="nav-link">
                <i class="fas fa-users"></i>
                <p>
                    Ứng viên
                    <i class="fas fa-angle-left right"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="/admin/employee" class="nav-link <% if ("/admin/employee".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách cv</p>
                    </a>
                </li>
            </ul>
        </li>
        <li class="nav-item menu-open">
            <a href="#" class="nav-link">
                <i class="fas fa-building"></i>
                <p>
                    Công ty
                    <i class="fas fa-angle-left right"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="/admin/corp" class="nav-link <% if ("/admin/corp".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách công ty</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/corp/create" class="nav-link <% if ("/admin/corp/create".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm mới công ty</p>
                    </a>
                </li>
            </ul>
        </li>
        <li class="nav-item menu-open">
            <a href="#" class="nav-link">
                <i class="fas fa-industry"></i>
                <p>
                    Ngành nghề công ty
                    <i class="fas fa-angle-left right"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="/admin/corp-industry" class="nav-link <% if ("/admin/corp-industry".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách ngành nghề</p>
                    </a>
                </li>
                <% if (oauth2Security.hasResourcePermission(request, "Corp Industry Resource", "urn:servlet-authz:protected:admin:industry:create")) {%>
                <li class="nav-item">
                    <a href="/admin/corp-industry/create" class="nav-link <% if ("/admin/corp-industry/create".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm mới ngành nghề công ty</p>
                    </a>
                </li>
                <%}%>
            </ul>
        </li>
        <li class="nav-item menu-open">
            <a href="#" class="nav-link">
                <i class="fas fa-map-marker-alt"></i>
                <p>
                    Địa chỉ làm việc
                    <i class="fas fa-angle-left right"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="/admin/job-location" class="nav-link <% if ("/admin/job-location".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách địa chỉ</p>
                    </a>
                </li>
                <% if (oauth2Security.hasResourcePermission(request, "Corp Location Resource", "urn:servlet-authz:protected:admin:job-location:create")) {%>
                <li class="nav-item">
                    <a href="/admin/job-location/create" class="nav-link <% if ("/admin/job-location/create".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm mới địa chỉ</p>
                    </a>
                </li>
                <%}%>
            </ul>
        </li>
<%--        <li class="nav-item menu-open">--%>
<%--            <a href="#" class="nav-link">--%>
<%--                <i class="fas fa-briefcase"></i>--%>
<%--                <p>--%>
<%--                    Chức vụ công việc--%>
<%--                    <i class="fas fa-angle-left right"></i>--%>
<%--                </p>--%>
<%--            </a>--%>
<%--            <ul class="nav nav-treeview">--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="/admin/job-title" class="nav-link <% if ("/admin/job-title".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">--%>
<%--                        <i class="far fa-circle nav-icon"></i>--%>
<%--                        <p>Danh sách chức vụ</p>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <% if (oauth2Security.hasResourcePermission(request, "Corp JobTitle Resource", "urn:servlet-authz:protected:admin:job-title:create")) {%>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="/admin/job-title/create" class="nav-link <% if ("/admin/job-title/create".equals(request.getAttribute("javax.servlet.forward.servlet_path"))) { %> active<%}%>">--%>
<%--                        <i class="far fa-circle nav-icon"></i>--%>
<%--                        <p>Thêm mới chức vụ</p>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <%}%>--%>
<%--            </ul>--%>
<%--        </li>--%>
    </ul>
</nav>