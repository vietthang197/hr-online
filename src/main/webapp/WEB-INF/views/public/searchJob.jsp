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
    <title>Trang chủ</title>
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
    <link href="/resources/css/select2.min.css" rel="stylesheet" />
<!--    <link href="/resources/css/pagination.min.css" rel="stylesheet" />-->
    <style>
        .select2-selection {
            -webkit-box-shadow: none;
            box-shadow: none;
            background-color: #fff;
            border: 0;
            border-radius: 0;
            outline: 0;
            min-height: 3rem;
            text-align: center;
        }

        .select2-selection__rendered {
            margin: 0.625rem;
        }

        .select2-selection__arrow {
            margin: 0.625rem;
        }
    </style>
</head>
<body class="font-sans flex flex-col min-h-screen dark:bg-gray-900">
<jsp:include page="header.jsp" />
<main class="flex-grow mx-auto w-full max-w-screen-xl mt-27">
    <form class="p-2">
        <label for="default-search" class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Tìm
            kiếm</label>
        <div class="relative">
            <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                <svg aria-hidden="true" class="w-5 h-5 text-gray-500 dark:text-gray-400" fill="none"
                     stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>
                </svg>
            </div>
            <input type="search" id="default-search"
                   class="block w-full p-4 pl-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                   placeholder="Tìm kiếm công việc yêu thích!" required>
            <button type="submit"
                    class="text-white absolute right-2.5 bottom-2.5 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                Tìm kiếm
            </button>
        </div>
    </form>
    <div class="mt-4 text-center">
        <span class="text-md text-black-500 mb-2 dark:text-white">Đề xuất:</span>
        <div class="flex flex-wrap justify-center">
            <a href="#" class="block px-3 py-1 text-sm font-medium text-blue-700 underline hover:text-blue-800 mb-2 mr-2 dark:text-white">Từ khoá 1</a>
            <a href="#" class="block px-3 py-1 text-sm font-medium text-blue-700 underline hover:text-blue-800 mb-2 mr-2 dark:text-white">Từ khoá 2</a>
            <a href="#" class="block px-3 py-1 text-sm font-medium text-blue-700 underline hover:text-blue-800 mb-2 mr-2 dark:text-white">Từ khoá 3</a>

            <!-- Thêm các từ khóa khác vào đây -->
        </div>
    </div>
    <div class="grid grid-cols-2 md:grid-cols-4 gap-4 p-4">
        <div class="col-lg-3 col-md-3 col-sm-6 col-6 searcher-filter-item searcher-filter-select-multi">
            <select class="select2 custom-select2 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <option value="option1">Tất cả khu vực</option>
                <option value="option1">Option 1</option>
                <option value="option2">Option 2</option>
                <option value="option3">Option 3</option>
            </select>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 col-6 searcher-filter-item searcher-filter-select-multi">
            <select class="select2 custom-select2 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <option value="option1">Tất cả công việc</option>
                <option value="option1">Option 1</option>
                <option value="option2">Option 2</option>
                <option value="option3">Option 3</option>
            </select>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 col-6 searcher-filter-item searcher-filter-select-multi">
            <select class="select2 custom-select2 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <option value="option1">Mức lương</option>
                <option value="option1">Option 1</option>
                <option value="option2">Option 2</option>
                <option value="option3">Option 3</option>
            </select>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 col-6 searcher-filter-item searcher-filter-select-multi">
            <select class="select2 custom-select2 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <option value="option1">Sắp xếp mặc định</option>
                <option value="option1">Option 1</option>
                <option value="option2">Option 2</option>
                <option value="option3">Option 3</option>
            </select>
        </div>
    </div>
    <div class="mt-4 p-4">
        <h1 class="dark:text-white text-xl font-bold">Cơ hội giới thiệu</h1>
        <div class="mt-6 w-full grid gap-4 md:grid-cols-2">
            <div class="flex justify-center">
                <div class="w-full m-2 p-1 bg-white border border-gray-200 rounded-lg shadow hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700 mx-auto flex card">
                    <div class="flex">
                        <div class="w-1/5 p-4">
                            <!-- Logo -->
                            <img src="https://static.recruitery.co/uploads/images/08ab20c97c8b4d2783065d01072f0839_20210514101545.jpeg"
                                 alt="Logo" class="w-16 h-16 object-contain">
                        </div>
                        <div class="w-4/5 p-4 relative">
                            <!-- Urgent -->
                            <span class="absolute top-0 right-0 px-2 py-1 text-sm font-semibold text-red-500 bg-red-200 rounded">Urgent</span>
                            <!-- Các thông tin khác trong cột phải -->
                            <a href="/job-detail" target="_self"
                               class="text-xl font-bold dark:text-white hover:text-blue-500">Tuyển dụng Java developer
                                (Techlead)</a>
                            <div class="mt-2">
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Java</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Oracle database</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">AWS</span>
                            </div>
                            <p class="mt-4 text-gray-700 dark:text-white"><span class="font-bold">Mức lương:&nbsp; </span>100$
                                - 2000$</p>
                            <p class="text-gray-700 mt-1 mb-4 dark:text-white"><span class="font-bold">Thưởng:&nbsp; </span>$200/Candidate
                            </p>
                            <a href="#"
                               class="absolute bottom-0 right-0 px-4 py-2 text-sm font-semibold text-blue-500 italic underline hover:text-blue-900">Ứng
                                tuyển ngay</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="flex justify-center">
                <div class="w-full m-2 p-1 bg-white border border-gray-200 rounded-lg shadow hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700 mx-auto flex card">
                    <div class="flex">
                        <div class="w-1/5 p-4">
                            <!-- Logo -->
                            <img src="https://static.recruitery.co/uploads/images/08ab20c97c8b4d2783065d01072f0839_20210514101545.jpeg"
                                 alt="Logo" class="w-16 h-16 object-contain">
                        </div>
                        <div class="w-4/5 p-4 relative">
                            <!-- Urgent -->
                            <span class="absolute top-0 right-0 px-2 py-1 text-sm font-semibold text-red-500 bg-red-200 rounded">Urgent</span>
                            <!-- Các thông tin khác trong cột phải -->
                            <a href="/job-detail" target="_self"
                               class="text-xl font-bold dark:text-white hover:text-blue-500">Tuyển dụng Java developer
                                (Techlead)</a>
                            <div class="mt-2 flex flex-wrap gap-2">
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Java</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Oracle database</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">AWS</span>
                            </div>
                            <p class="mt-4 text-gray-700 dark:text-white"><span class="font-bold">Mức lương:&nbsp; </span>100$
                                - 2000$</p>
                            <p class="text-gray-700 mt-1 mb-4 dark:text-white"><span class="font-bold">Thưởng:&nbsp; </span>$200/Candidate
                            </p>
                            <a href="#"
                               class="absolute bottom-0 right-0 px-4 py-2 text-sm font-semibold text-blue-500 italic underline hover:text-blue-900">Ứng
                                tuyển ngay</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="flex justify-center">
                <div class="w-full m-2 p-1 bg-white border border-gray-200 rounded-lg shadow hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700 mx-auto flex card">
                    <div class="flex">
                        <div class="w-1/5 p-4">
                            <!-- Logo -->
                            <img src="https://static.recruitery.co/uploads/images/08ab20c97c8b4d2783065d01072f0839_20210514101545.jpeg"
                                 alt="Logo" class="w-16 h-16 object-contain">
                        </div>
                        <div class="w-4/5 p-4 relative">
                            <!-- Urgent -->
                            <span class="absolute top-0 right-0 px-2 py-1 text-sm font-semibold text-red-500 bg-red-200 rounded">Urgent</span>
                            <!-- Các thông tin khác trong cột phải -->
                            <a href="/job-detail" target="_self"
                               class="text-xl font-bold dark:text-white hover:text-blue-500">Tuyển dụng Java developer
                                (Techlead)</a>
                            <div class="mt-2 flex flex-wrap gap-2">
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Java</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Oracle database</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">AWS</span>
                            </div>
                            <p class="mt-4 text-gray-700 dark:text-white"><span class="font-bold">Mức lương:&nbsp; </span>100$
                                - 2000$</p>
                            <p class="text-gray-700 mt-1 mb-4 dark:text-white"><span class="font-bold">Thưởng:&nbsp; </span>$200/Candidate
                            </p>
                            <a href="#"
                               class="absolute bottom-0 right-0 px-4 py-2 text-sm font-semibold text-blue-500 italic underline hover:text-blue-900">Ứng
                                tuyển ngay</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="flex justify-center">
                <div class="w-full m-2 p-1 bg-white border border-gray-200 rounded-lg shadow hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700 mx-auto flex card">
                    <div class="flex">
                        <div class="w-1/5 p-4">
                            <!-- Logo -->
                            <img src="https://static.recruitery.co/uploads/images/08ab20c97c8b4d2783065d01072f0839_20210514101545.jpeg"
                                 alt="Logo" class="w-16 h-16 object-contain">
                        </div>
                        <div class="w-4/5 p-4 relative">
                            <!-- Urgent -->
                            <span class="absolute top-0 right-0 px-2 py-1 text-sm font-semibold text-red-500 bg-red-200 rounded">Urgent</span>
                            <!-- Các thông tin khác trong cột phải -->
                            <a href="/job-detail" target="_self"
                               class="text-xl font-bold dark:text-white hover:text-blue-500">Tuyển dụng Java developer
                                (Techlead)</a>
                            <div class="mt-2 flex flex-wrap gap-2">
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Java</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Oracle database</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">AWS</span>
                            </div>
                            <p class="mt-4 text-gray-700 dark:text-white"><span class="font-bold">Mức lương:&nbsp; </span>100$
                                - 2000$</p>
                            <p class="text-gray-700 mt-1 mb-4 dark:text-white"><span class="font-bold">Thưởng:&nbsp; </span>$200/Candidate
                            </p>
                            <a href="#"
                               class="absolute bottom-0 right-0 px-4 py-2 text-sm font-semibold text-blue-500 italic underline hover:text-blue-900">Ứng
                                tuyển ngay</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="flex justify-center">
                <div class="w-full m-2 p-1 bg-white border border-gray-200 rounded-lg shadow hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700 mx-auto flex card">
                    <div class="flex">
                        <div class="w-1/5 p-4">
                            <!-- Logo -->
                            <img src="https://static.recruitery.co/uploads/images/08ab20c97c8b4d2783065d01072f0839_20210514101545.jpeg"
                                 alt="Logo" class="w-16 h-16 object-contain">
                        </div>
                        <div class="w-4/5 p-4 relative">
                            <!-- Urgent -->
                            <span class="absolute top-0 right-0 px-2 py-1 text-sm font-semibold text-red-500 bg-red-200 rounded">Urgent</span>
                            <!-- Các thông tin khác trong cột phải -->
                            <a href="/job-detail" target="_self"
                               class="text-xl font-bold dark:text-white hover:text-blue-500">Tuyển dụng Java developer
                                (Techlead)</a>
                            <div class="mt-2 flex flex-wrap gap-2">
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Java</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Oracle database</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">AWS</span>
                            </div>
                            <p class="mt-4 text-gray-700 dark:text-white"><span class="font-bold">Mức lương:&nbsp; </span>100$
                                - 2000$</p>
                            <p class="text-gray-700 mt-1 mb-4 dark:text-white"><span class="font-bold">Thưởng:&nbsp; </span>$200/Candidate
                            </p>
                            <a href="#"
                               class="absolute bottom-0 right-0 px-4 py-2 text-sm font-semibold text-blue-500 italic underline hover:text-blue-900">Ứng
                                tuyển ngay</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="flex justify-center">
                <div class="w-full m-2 p-1 bg-white border border-gray-200 rounded-lg shadow hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700 mx-auto flex card">
                    <div class="flex">
                        <div class="w-1/5 p-4">
                            <!-- Logo -->
                            <img src="https://static.recruitery.co/uploads/images/08ab20c97c8b4d2783065d01072f0839_20210514101545.jpeg"
                                 alt="Logo" class="w-16 h-16 object-contain">
                        </div>
                        <div class="w-4/5 p-4 relative">
                            <!-- Urgent -->

                            <!-- Các thông tin khác trong cột phải -->
                            <a href="/job-detail" target="_self"
                               class="text-xl font-bold dark:text-white hover:text-blue-500">Tuyển dụng Java developer
                                (Techlead)</a>
                            <div class="mt-2 flex flex-wrap gap-2">
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Java</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Oracle database</span>
                                <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">AWS</span>
                            </div>
                            <p class="mt-4 text-gray-700 dark:text-white"><span class="font-bold">Mức lương:&nbsp; </span>100$
                                - 2000$</p>
                            <p class="text-gray-700 mt-1 mb-4 dark:text-white"><span class="font-bold">Thưởng:&nbsp; </span>$200/Candidate
                            </p>
                            <a href="#"
                               class="absolute bottom-0 right-0 px-4 py-2 text-sm font-semibold text-blue-500 italic underline hover:text-blue-900">Ứng
                                tuyển ngay</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="pagination" class="flex items-center justify-center mt-4 p-4"></div>
</main>
<jsp:include page="footer.jsp" />
</body>
<script src="<c:url value="/resources/js/navbar-toggle.js" />"></script>
<script src="<c:url value="/resources/js/jquery-3.7.0.min.js" />"></script>
<script src="<c:url value="/resources/js/select2.min.js" />"></script>
<script src="<c:url value="/resources/js/pagination.min.js" />"></script>
<script>
    $(document).ready(function() {
        $('.select2').select2();
    });
</script>
<script>
    $(document).ready(function () {
        var data = [
            'Item 1', 'Item 2', 'Item 3', 'Item 4', 'Item 5',
            'Item 6', 'Item 7', 'Item 8', 'Item 9', 'Item 10',
            'Item 11', 'Item 12', 'Item 13', 'Item 14', 'Item 15',
            'Item 16', 'Item 17', 'Item 18', 'Item 19', 'Item 20','Item 1', 'Item 2', 'Item 3', 'Item 4', 'Item 5',
            'Item 6', 'Item 7', 'Item 8', 'Item 9', 'Item 10',
            'Item 11', 'Item 12', 'Item 13', 'Item 14', 'Item 15',
            'Item 16', 'Item 17', 'Item 18', 'Item 19', 'Item 20','Item 1', 'Item 2', 'Item 3', 'Item 4', 'Item 5',
            'Item 6', 'Item 7', 'Item 8', 'Item 9', 'Item 10',
            'Item 11', 'Item 12', 'Item 13', 'Item 14', 'Item 15',
            'Item 16', 'Item 17', 'Item 18', 'Item 19', 'Item 20','Item 1', 'Item 2', 'Item 3', 'Item 4', 'Item 5',
            'Item 6', 'Item 7', 'Item 8', 'Item 9', 'Item 10',
            'Item 11', 'Item 12', 'Item 13', 'Item 14', 'Item 15',
            'Item 16', 'Item 17', 'Item 18', 'Item 19', 'Item 20'
        ];

        var itemsPerPage = 5;
        var totalPages = Math.ceil(data.length / itemsPerPage);

        $('#pagination').pagination({
            dataSource: data,
            pageSize: itemsPerPage,
            totalPage: totalPages,
            showNext: false,
            showPrevious: false,
            // prevClassName: 'cursor-pointer block px-3 py-2 ml-0 leading-tight text-gray-500 bg-white border border-gray-300 rounded-l-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white',
            // nextClassName: 'cursor-pointer block px-3 py-2 leading-tight text-gray-500 bg-white border border-gray-300 rounded-r-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white',
            ulClassName: 'inline-flex items-center -space-x-px container',
            activeClassName: 'cursor-pointer active z-10 px-3 py-2 leading-tight text-blue-600 border border-blue-300 bg-blue-100 hover:text-blue-700 dark:border-gray-700 dark:bg-gray-700 dark:text-white',
            disableClassName: 'px-3 py-2 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white',
            pageClassName: 'cursor-pointer paginationjs-page J-paginationjs-page z-10 px-3 py-2 leading-tight border border-gray-300 hover:bg-blue-100 hover:text-blue-700 dark:border-gray-700 dark:bg-gray-700 dark:text-white',
            callback: function (pageNumber) {
                console.log(pageNumber)
            }
        });
    });
</script>
</html>