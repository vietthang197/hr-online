<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Website">
  <script src="<c:url value="/resources/js/tailwindcss.js" />"></script>
  <title>Blog</title>
  <style>
    html, body {
      height: 100%;
    }

    body {
      display: flex;
      flex-direction: column;
    }

    main {
      flex-grow: 1;
    }

    .card {
      display: flex;
      flex-direction: column;
    }

    .card > div {
      flex: 1;
    }
  </style>
</head>
<body class="font-sans flex flex-col min-h-screen dark:bg-gray-900">
<jsp:include page="header.jsp" />
<main class="container mx-auto px-4 py-8 grid grid-cols-1 md:grid-cols-3 gap-4">
  <div class="col-span-2 md:col-span-2">
    <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
      <div class="blog-card xl:max-w-[30rem] bg-white m-2 shadow rounded dark:bg-gray-800">
        <div class="image-wrapper rounded-tl rounded-tr overflow-hidden">
          <div class="image-container aspect-w-16 aspect-h-9">
            <img src="https://static.recruitery.co/uploads/images/d6f58c319a6d41c9ad6c03d1da4defdb_20230216090913.jpg" alt="Blog Image" class="w-full h-full object-cover">
          </div>
        </div>
        <div class="p-4 flex flex-col justify-between h-full">
          <div>
            <a href="#" class="text-xl font-bold text-gray-800 mb-2 hover:underline hover:text-blue-600 dark:text-white">Blog Post 1</a>
            <p class="text-gray-600 dark:text-white">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </div>
          <div class="mt-4">
            <!-- Additional content, if any -->
          </div>
        </div>
      </div>
      <div class="blog-card xl:max-w-[30rem] bg-white m-2 shadow rounded dark:bg-gray-800">
        <div class="image-wrapper rounded-tl rounded-tr overflow-hidden">
          <div class="image-container aspect-w-16 aspect-h-9">
            <img src="https://static.recruitery.co/uploads/images/d6f58c319a6d41c9ad6c03d1da4defdb_20230216090913.jpg" alt="Blog Image" class="w-full h-full object-cover">
          </div>
        </div>
        <div class="p-4 flex flex-col justify-between h-full">
          <div>
            <h2 class="text-xl font-bold text-gray-800 mb-2 dark:text-white">Blog Post 1</h2>
            <p class="text-gray-600 dark:text-white">Lorem ipsum dolor sit amet, consectetur adipiscing elit.Lorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet, consectetur adipiscing elitLorem ipsum dolor sit amet, consectetur adipiscing elit</p>
          </div>
          <div class="mt-4">
            <!-- Additional content, if any -->
          </div>
        </div>
      </div>
      <div class="blog-card xl:max-w-[30rem] bg-white m-2 shadow rounded dark:bg-gray-800">
        <div class="image-wrapper rounded-tl rounded-tr overflow-hidden">
          <div class="image-container aspect-w-16 aspect-h-9">
            <img src="https://static.recruitery.co/uploads/images/d6f58c319a6d41c9ad6c03d1da4defdb_20230216090913.jpg" alt="Blog Image" class="w-full h-full object-cover">
          </div>
        </div>
        <div class="p-4 flex flex-col justify-between h-full">
          <div>
            <h2 class="text-xl font-bold text-gray-800 mb-2 dark:text-white">Blog Post 1</h2>
            <p class="text-gray-600 dark:text-white">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </div>
          <div class="mt-4">
            <!-- Additional content, if any -->
          </div>
        </div>
      </div>
      <!-- Add more blog cards as needed -->
    </div>
  </div>
  <div class="md:col-span-1">
    <h1 class="text-2xl font-bold text-gray-800 mb-8 dark:text-white">Tin nổi bật</h1>
    <div class="blog-card bg-white p-4 shadow rounded flex items-start dark:bg-gray-800">
      <div class="image-wrapper rounded-tl rounded-tr overflow-hidden">
        <img src="https://static.recruitery.co/uploads/images/1275d5e5bf1b403b83762e54b255725d_20230210041605.png" alt="Featured Blog Image" class="w-32 h-auto">
      </div>
      <div class="flex flex-col ml-4">
        <h2 class="text-xl font-bold text-gray-800 mb-2 dark:text-white">Blog Post 1</h2>
        <p class="text-gray-600 dark:text-white">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      </div>
    </div>
    <div class="blog-card bg-white p-4 shadow rounded flex items-start dark:bg-gray-800">
      <div class="image-wrapper rounded-tl rounded-tr overflow-hidden">
        <img src="https://static.recruitery.co/uploads/images/1275d5e5bf1b403b83762e54b255725d_20230210041605.png" alt="Featured Blog Image" class="w-32 h-auto">
      </div>
      <div class="flex flex-col ml-4">
        <h2 class="text-xl font-bold text-gray-800 mb-2 dark:text-white">Blog Post 1</h2>
        <p class="text-gray-600 dark:text-white">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      </div>
    </div>
    <div class="blog-card bg-white p-4 shadow rounded flex items-start dark:bg-gray-800">
      <div class="image-wrapper rounded-tl rounded-tr overflow-hidden">
        <img src="https://static.recruitery.co/uploads/images/1275d5e5bf1b403b83762e54b255725d_20230210041605.png" alt="Featured Blog Image" class="w-32 h-auto">
      </div>
      <div class="flex flex-col ml-4">
        <h2 class="text-xl font-bold text-gray-800 mb-2 dark:text-white">Blog Post 1</h2>
        <p class="text-gray-600 dark:text-white">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      </div>
    </div>
    <!-- Add more blog cards in the second column as needed -->
  </div>
</main>
<jsp:include page="footer.jsp" />
</body>
<script src="<c:url value="/resources/js/navbar-toggle.js" />"></script>
</html>