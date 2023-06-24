<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Oops!</title>
    <script src="<c:url value="/resources/js/tailwindcss.js" />"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
    <div class="max-w-3xl bg-white p-8 shadow-lg rounded-lg">
        <div class="flex items-center justify-center">
            <svg class="w-12 h-12 text-red-500 mr-3" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 20l4-16m4 4l4 4-4 4M6 16l-4-4 4-4" />
            </svg>
            <h1 class="text-3xl font-bold text-gray-800">Oops! Đã có lỗi xảy ra</h1>
        </div>
        <p class="text-gray-600 mt-4">Xin vui lòng thử lại sau.</p>
        <div class="mt-6">
            <a href="/" class="text-blue-500 underline">Quay lại trang chủ</a>
        </div>
    </div>
</body>
</html>