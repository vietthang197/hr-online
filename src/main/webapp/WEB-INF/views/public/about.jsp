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
    <title>About</title>
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
<main class="flex-grow mx-auto w-full max-w-screen-xl mt-27">
    <section class="bg-white rounded-lg shadow-lg p-8 dark:bg-gray-900">
        <h1 class="text-4xl font-bold text-gray-800 mb-4 dark:text-white">Giới thiệu về công ty</h1>
        <p class="text-gray-600 dark:text-white">Chúng tôi là một công ty chuyên cung cấp các sản phẩm và dịch vụ xuất sắc. Với đội ngũ
            nhân viên tận tâm và chuyên nghiệp, chúng tôi cam kết mang đến sự hài lòng cho khách hàng.</p>
        <p class="text-gray-600 mt-4 dark:text-white">Cùng với tầm nhìn và sứ mệnh của chúng tôi, chúng tôi không ngừng phát triển và
            đổi mới để đáp ứng nhu cầu ngày càng cao của thị trường.</p>
        <a href="#" class="mt-6 inline-block bg-blue-500 text-white font-bold py-2 px-4 rounded hover:bg-blue-600">Tìm
            hiểu thêm</a>

        <div class="grid grid-cols-2 md:grid-cols-4 gap-4 mt-8">
            <div class="bg-gray-200 p-4 rounded flex flex-col items-center">
                <h2 class="text-2xl font-bold text-blue-500 mb-2">1000+</h2>
                <p class="text-gray-600">Doanh nghiệp hợp tác</p>
            </div>
            <div class="bg-gray-200 p-4 rounded flex flex-col items-center">
                <h2 class="text-2xl font-bold text-blue-500 mb-2">1000+</h2>
                <p class="text-gray-600">Doanh nghiệp hợp tác</p>
            </div>
            <div class="bg-gray-200 p-4 rounded flex flex-col items-center">
                <h2 class="text-2xl font-bold text-blue-500 mb-2">1000+</h2>
                <p class="text-gray-600">Doanh nghiệp hợp tác</p>
            </div>
            <div class="bg-gray-200 p-4 rounded flex flex-col items-center">
                <h2 class="text-2xl font-bold text-blue-500 mb-2">1000+</h2>
                <p class="text-gray-600">Doanh nghiệp hợp tác</p>
            </div>
            <!-- Add more columns as needed -->
        </div>
        <div class="p-4 rounded">
            <div class="mb-4">
                <h2 class="text-2xl font-bold dark:text-white">Quá trình phát triển</h2>
            </div>
            <ol class="relative border-l border-gray-200 dark:border-gray-700">
                <li class="mb-10 ml-6">
            <span class="absolute flex items-center justify-center w-6 h-6 bg-blue-100 rounded-full -left-3 ring-8 ring-white dark:ring-gray-900 dark:bg-blue-900">
                <svg aria-hidden="true" class="w-3 h-3 text-blue-800 dark:text-blue-300" fill="currentColor"
                     viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd"
                                                                                  d="M6 2a1 1 0 00-1 1v1H4a2 2 0 00-2 2v10a2 2 0 002 2h12a2 2 0 002-2V6a2 2 0 00-2-2h-1V3a1 1 0 10-2 0v1H7V3a1 1 0 00-1-1zm0 5a1 1 0 000 2h8a1 1 0 100-2H6z"
                                                                                  clip-rule="evenodd"></path></svg>
            </span>
                    <h3 class="flex items-center mb-1 text-lg font-semibold text-gray-900 dark:text-white">Flowbite
                        Application UI v2.0.0 <span
                                class="bg-blue-100 text-blue-800 text-sm font-medium mr-2 px-2.5 py-0.5 rounded dark:bg-blue-900 dark:text-blue-300 ml-3">Latest</span>
                    </h3>
                    <time class="block mb-2 text-sm font-normal leading-none text-gray-400 dark:text-gray-500">Released
                        on January 13th, 2022
                    </time>
                    <p class="mb-4 text-base font-normal text-gray-500 dark:text-gray-400">Get access to over 20+ pages
                        including a dashboard layout, charts, kanban board, calendar, and pre-order E-commerce &
                        Marketing pages.</p>
                    <a href="#"
                       class="inline-flex items-center px-4 py-2 text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-lg hover:bg-gray-100 hover:text-blue-700 focus:z-10 focus:ring-4 focus:outline-none focus:ring-gray-200 focus:text-blue-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white dark:hover:bg-gray-700 dark:focus:ring-gray-700">
                        <svg class="w-4 h-4 mr-2" fill="currentColor" viewBox="0 0 20 20"
                             xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M6 2a2 2 0 00-2 2v12a2 2 0 002 2h8a2 2 0 002-2V7.414A2 2 0 0015.414 6L12 2.586A2 2 0 0010.586 2H6zm5 6a1 1 0 10-2 0v3.586l-1.293-1.293a1 1 0 10-1.414 1.414l3 3a1 1 0 001.414 0l3-3a1 1 0 00-1.414-1.414L11 11.586V8z"
                                  clip-rule="evenodd"></path>
                        </svg>
                        Download ZIP</a>
                </li>
                <li class="mb-10 ml-6">
            <span class="absolute flex items-center justify-center w-6 h-6 bg-blue-100 rounded-full -left-3 ring-8 ring-white dark:ring-gray-900 dark:bg-blue-900">
                <svg aria-hidden="true" class="w-3 h-3 text-blue-800 dark:text-blue-300" fill="currentColor"
                     viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd"
                                                                                  d="M6 2a1 1 0 00-1 1v1H4a2 2 0 00-2 2v10a2 2 0 002 2h12a2 2 0 002-2V6a2 2 0 00-2-2h-1V3a1 1 0 10-2 0v1H7V3a1 1 0 00-1-1zm0 5a1 1 0 000 2h8a1 1 0 100-2H6z"
                                                                                  clip-rule="evenodd"></path></svg>
            </span>
                    <h3 class="mb-1 text-lg font-semibold text-gray-900 dark:text-white">Flowbite Figma v1.3.0</h3>
                    <time class="block mb-2 text-sm font-normal leading-none text-gray-400 dark:text-gray-500">Released
                        on December 7th, 2021
                    </time>
                    <p class="text-base font-normal text-gray-500 dark:text-gray-400">All of the pages and components
                        are first designed in Figma and we keep a parity between the two versions even as we update the
                        project.</p>
                </li>
                <li class="ml-6">
            <span class="absolute flex items-center justify-center w-6 h-6 bg-blue-100 rounded-full -left-3 ring-8 ring-white dark:ring-gray-900 dark:bg-blue-900">
                <svg aria-hidden="true" class="w-3 h-3 text-blue-800 dark:text-blue-300" fill="currentColor"
                     viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd"
                                                                                  d="M6 2a1 1 0 00-1 1v1H4a2 2 0 00-2 2v10a2 2 0 002 2h12a2 2 0 002-2V6a2 2 0 00-2-2h-1V3a1 1 0 10-2 0v1H7V3a1 1 0 00-1-1zm0 5a1 1 0 000 2h8a1 1 0 100-2H6z"
                                                                                  clip-rule="evenodd"></path></svg>
            </span>
                    <h3 class="mb-1 text-lg font-semibold text-gray-900 dark:text-white">Flowbite Library v1.2.2</h3>
                    <time class="block mb-2 text-sm font-normal leading-none text-gray-400 dark:text-gray-500">Released
                        on December 2nd, 2021
                    </time>
                    <p class="text-base font-normal text-gray-500 dark:text-gray-400">Get started with dozens of web
                        components and interactive elements built on top of Tailwind CSS.</p>
                </li>
            </ol>
        </div>
        <div class="p-4 rounded">
            <h2 class="text-2xl font-bold text-center mb-4 dark:text-white">Giá trị cốt lõi</h2>
            <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                <div>
                    <div class="bg-white p-4 rounded-lg shadow dark:bg-gray-900">
                        <h3 class="text-lg font-bold mb-2 dark:text-white">Tin tưởng và Tạo dựng niềm tin</h3>
                        <p class="text-gray-600 dark:text-white">Chúng tôi tin rằng, tin tưởng lẫn nhau sẽ giúp đi nhanh hơn và làm được nhiều thứ có ý nghĩa hơn. Mỗi cá nhân cần phải tin tưởng đồng nghiệp để trao quyền và hỗ trợ họ hoàn thành tốt công việc. Ngược lại, mỗi người phải xây dựng uy tín để có thể giữ được sự tin tưởng từ mọi người. Và luôn chọn khách hàng cũng như đối tác có uy tín.</p>
                    </div>
                </div>
                <div>
                    <div class="bg-white p-4 rounded-lg shadow dark:bg-gray-900">
                        <h3 class="text-lg font-bold mb-2 dark:text-white">Tập trung vào thứ có tác động lớn</h3>
                        <p class="text-gray-600 dark:text-white">Chúng tôi luôn muốn thời gian và công sức mình bỏ ra phải tạo ra giá trị và tác động lớn nhất cho tổ chức cũng như cho thị trường tuyển dụng. Vì vậy, thay vì lãng phí thời gian cho những vấn đề nhỏ và ít có ảnh hưởng, chúng tôi chọn giải quyết những vấn đề quan trọng nhất. Điều đó phải có tác động lớn tới mục tiêu sắp tới của tổ chức.</p>
                    </div>
                </div>
                <div>
                    <div class="bg-white p-4 rounded-lg shadow dark:bg-gray-900">
                        <h3 class="text-lg font-bold mb-2 dark:text-white">Quyết định táo bạo, thực thi quyết liệt</h3>
                        <p class="text-gray-600 dark:text-white">Recruitery khuyến khích tất cả mọi người nghĩ lớn, dám đưa ra các quyết định táo bạo và cho phép mắc sai lầm. Điều bắt buộc là phải thực thi quyết liệt. Chỉ có cách vượt qua giới hạn của mình, làm những thứ mà mỗi người chưa bao giờ làm thì mới có thể đưa chính mình và tổ chức lên một tầm cao mà chưa bao giờ đạt được.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="md:col-span-2 border-b border-dashed m-4 max-w-full"></div>
        <div class="p-4 rounded">
            <h2 class="text-2xl font-bold text-center mb-4 dark:text-white">Môi trường</h2>
            <div class="grid grid-cols-2 md:grid-cols-4 gap-4">
                <div class="grid gap-4">
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image.jpg" alt="">
                    </div>
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-1.jpg" alt="">
                    </div>
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-2.jpg" alt="">
                    </div>
                </div>
                <div class="grid gap-4">
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-3.jpg" alt="">
                    </div>
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-4.jpg" alt="">
                    </div>
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-5.jpg" alt="">
                    </div>
                </div>
                <div class="grid gap-4">
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-6.jpg" alt="">
                    </div>
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-7.jpg" alt="">
                    </div>
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-8.jpg" alt="">
                    </div>
                </div>
                <div class="grid gap-4">
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-9.jpg" alt="">
                    </div>
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-10.jpg" alt="">
                    </div>
                    <div>
                        <img class="h-auto max-w-full rounded-lg" src="https://flowbite.s3.amazonaws.com/docs/gallery/masonry/image-11.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<jsp:include page="footer.jsp" />
</body>
<script src="<c:url value="/resources/js/navbar-toggle.js" />"></script>
</html>