<%@ page import="java.util.List" %>
<%@ page import="com.hronline.dto.JobInfoDto" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%
    NumberFormat format = NumberFormat.getInstance();
    List<JobInfoDto> jobs = (List<JobInfoDto>) request.getAttribute("jobs");
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Website">
    <script src="/resources/js/tailwindcss.js"></script>
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
    <div class="mt-6 w-full p-2 grid gap-4 md:grid-cols-2">
        <% for (JobInfoDto job : jobs) {%>
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
                        <% if (job.isUrgent()) { %>
                        <span class="absolute top-0 right-0 px-2 py-1 text-sm font-semibold text-red-500 bg-red-200 rounded">Tuyển gấp</span>
                        <%}%>
                        <!-- Các thông tin khác trong cột phải -->
                        <a href="/job-detail/<%=job.getId()%>" target="_self"
                           class="text-xl font-bold dark:text-white hover:text-blue-500"><%= job.getName() %></a>
                        <div class="mt-2">
                            <% String[] tagList = new String[0];
                                if (job.getTags() != null) {
                                    tagList = job.getTags().split(",");
                                }
                            %>
                            <% for (String tagItem : tagList) {%>
                            <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded"><%= tagItem%></span>
                            <%}%>
                        </div>
                        <p class="mt-4 text-gray-700 dark:text-white"><span class="font-bold">Mức lương:&nbsp; </span>
                         <span>
                             <% if(job.getNegotiable()) {%>
                                <span>Thoả thuận</span>
                             <% } else { %>
                             <span><%= format.format(job.getSalaryFrom())%> <%= job.getSalaryFromCurrency() %> - <%= format.format(job.getSalaryTo())%> <%= job.getSalaryToCurrency()%> </span>
                             <% } %>
                         </span>
                        </p>
                        <a href="#"
                           class="absolute bottom-0 right-0 px-4 text-sm font-semibold text-blue-500 italic underline hover:text-blue-900 dark:text-white dark:hover:text-blue-500">Ứng
                            tuyển ngay</a>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
    </div>
    <div class="flex justify-center mt-10">
        <a href="/search-job" target="_self"
           class="inline-flex items-center px-4 py-2 bg-blue-500 hover:bg-blue-600 text-white font-semibold rounded-md shadow-md mx-auto">
            Hiển thị thêm
        </a>
    </div>
</main>
<jsp:include page="footer.jsp" />
</body>
<script src="/resources/js/navbar-toggle.js"></script>
</html>