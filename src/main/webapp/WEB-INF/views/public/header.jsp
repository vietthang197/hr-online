<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.hronline.config.Oauth2Security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    ApplicationContext applicationContext = RequestContextUtils.findWebApplicationContext(request);
    Oauth2Security oauth2Security = (Oauth2Security) applicationContext.getBean("oauth2Security");
%>

<header
        class="relative z-50 w-full flex-none text-sm font-semibold leading-6 text-slate-900">
    <nav class="bg-white border-gray-200 dark:bg-gray-900">
        <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
            <a href="/" class="flex items-center">
                <img src="/resources/logo.svg" class="h-8 mr-3" alt="Flowbite Logo"/>
                <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">IT Viec</span>
            </a>
            <button id="navbar-toggle" data-collapse-toggle="navbar-default" type="button"
                    class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
                    aria-controls="navbar-default" aria-expanded="false">
                <span class="sr-only">Open menu</span>
                <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20"
                     xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd"
                          d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                          clip-rule="evenodd"></path>
                </svg>
            </button>
            <div class="hidden w-full md:block md:w-auto" id="navbar-default">
                <ul class="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
                    <li class="relative inline-block text-left">
                        <a href="/"
                           class="inline-flex items-center justify-center w-full px-4 py-2 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700  dark:text-white md:dark:text-blue-500"
                           aria-current="page">Trang chủ</a>
                    </li>
                    <li class="relative inline-block text-left">
                        <a href="/about" target="_self"
                           class="inline-flex items-center justify-center w-full px-4 py-2 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700  dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">Giới
                            thiệu</a>
                    </li>
                    <li class="relative inline-block text-left">
                        <a href="/blog" target="_self"
                           class="inline-flex items-center justify-center w-full px-4 py-2 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700  dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">Blog</a>
                    </li>
                    <li class="relative inline-block text-left">
                        <a href="#"
                           class="inline-flex items-center justify-center w-full px-4 py-2 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700  dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">Cộng
                            tác</a>
                    </li>
                    <li class="relative inline-block text-left">
                        <a href="#"
                           class="inline-flex items-center justify-center w-full px-4 py-2 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700  dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">Liên
                            hệ</a>
                    </li>
                    <li class="relative inline-block text-left">
                        <a href="#"
                           class="inline-flex items-center justify-center w-full px-4 py-2 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700  dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">Donate</a>
                    </li>

                    <% if (oauth2Security.isAuthenticated()) { %>
                    <li class="relative inline-block text-left">
                        <a href="#" class="inline-flex items-center justify-center w-full px-4 py-2 text-sm font-medium text-white bg-gray-800 border border-gray-300 rounded-md hover:bg-gray-700 focus:outline-none" id="user-menu" aria-expanded="false" aria-haspopup="true">
                            Xin chào, <%=oauth2Security.getUsername()%>
                            <svg class="w-5 h-5 ml-2 -mr-1" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 8l4 4m0 0l-4 4m4-4H3"></path>
                            </svg>
                        </a>

                        <div class="absolute right-0 mt-2 space-y-2 origin-top-right bg-white border border-gray-300 rounded-md shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none hidden" id="user-dropdown" role="menu" aria-orientation="vertical" aria-labelledby="user-menu">
                            <% if (oauth2Security.hasResourcePermission(request, "Admin Resource", "urn:servlet-authz:protected:admin:access")) {%>
                                <a href="/admin" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100" role="menuitem">Quản lý</a>
                            <%}%>
                            <!-- Dropdown content -->
                            <a href="#" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100" role="menuitem">Hồ sơ</a>
                            <hr class="my-2 border-t border-gray-200">
                            <a href="/sso/logout" class="block px-4 py-2 text-sm text-red-600 hover:bg-gray-100" role="menuitem">Đăng xuất</a>
                        </div>
                    </li>
                    <% } else { %>
                    <li class="relative inline-block text-left">
                        <a href="/sso/login"
                           class="inline-flex items-center justify-center w-full px-4 py-2 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700  dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">Đăng nhập/ Đăng ký</a>
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>
</header>