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
                    <a href="/admin/employee" class="nav-link <% if (request.getAttribute("javax.servlet.forward.servlet_path").equals("/admin/employee")) { %> active<%}%>">
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
                    <a href="/admin/corp" class="nav-link <% if (request.getAttribute("javax.servlet.forward.servlet_path").equals("/admin/corp")) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách công ty</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/corp/create" class="nav-link <% if (request.getAttribute("javax.servlet.forward.servlet_path").equals("/admin/corp/create")) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm mới công ty</p>
                    </a>
                </li>
            </ul>
        </li>
        <li class="nav-item menu-open">
            <a href="#" class="nav-link">
                <i class="fas fa-building"></i>
                <p>
                    Ngành nghề công ty
                    <i class="fas fa-angle-left right"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="/admin/corp-industry" class="nav-link <% if (request.getAttribute("javax.servlet.forward.servlet_path").equals("/admin/corp-industry")) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Danh sách ngành nghề</p>
                    </a>
                </li>
                <% if (oauth2Security.hasResourcePermission(request, "Corp Industry Resource", "urn:servlet-authz:protected:admin:industry:create")) {%>
                <li class="nav-item">
                    <a href="/admin/corp-industry/create" class="nav-link <% if (request.getAttribute("javax.servlet.forward.servlet_path").equals("/admin/corp-industry/create")) { %> active<%}%>">
                        <i class="far fa-circle nav-icon"></i>
                        <p>Thêm mới ngành nghề công ty</p>
                    </a>
                </li>
                <%}%>
            </ul>
        </li>
    </ul>
</nav>