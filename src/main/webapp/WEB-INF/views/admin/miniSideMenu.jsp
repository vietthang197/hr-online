<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="com.hronline.config.Oauth2Security" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    ApplicationContext applicationContext = RequestContextUtils.findWebApplicationContext(request);
    Oauth2Security oauth2Security = (Oauth2Security) applicationContext.getBean("oauth2Security");
%>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/admin" class="brand-link">
        <img src="/resources/logo.svg" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">Tìm việc Online</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3">
            <div class="d-flex flex-column">
                <div class="p-2">
                    <a href="#" class="d-block">Xin chào <%=oauth2Security.getUsername()%>
                    </a>
                </div>
                <div class="p-2">
                    <a href="/sso/logout" class="d-block">Đăng xuất</a>
                </div>
            </div>
        </div>
        <!-- Sidebar Menu -->
        <jsp:include page="sideMenu.jsp"/>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>