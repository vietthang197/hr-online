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
    <title>Not found!</title>
    <script src="<c:url value="/resources/js/tailwindcss.js" />"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
<div class="max-w-3xl bg-white p-8 shadow-lg rounded-lg">
    <div class="flex items-center justify-center">
        <svg class="w-12 h-12 text-red-500 mr-3" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 4a8 8 0 100 16 8 8 0 000-16zm0 10a2 2 0 11.001-4.001A2 2 0 0112 14z" />
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
        </svg>
        <h1 class="text-3xl font-bold text-gray-800">Không tìm thấy tài nguyên</h1>
    </div>
    <p class="text-gray-600 mt-4">Xin vui lòng thử lại sau.</p>
    <div class="mt-6">
        <a href="/" class="text-blue-500 underline">Quay lại trang chủ</a>
    </div>
</div>
</body>
</html>