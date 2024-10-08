<%@ page import="com.hronline.config.Oauth2Security" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.hronline.dto.JobInfoDto" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    ApplicationContext applicationContext = RequestContextUtils.findWebApplicationContext(request);
    Oauth2Security oauth2Security = (Oauth2Security) applicationContext.getBean("oauth2Security");
    JobInfoDto job = (JobInfoDto) request.getAttribute("job");
    NumberFormat format = NumberFormat.getInstance();
%>
<!DOCTYPE html>
<html lang="en">
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
<main class="flex-grow mx-auto w-full max-w-screen-xl mt-26">
    <div class="grid grid-cols-1 md:grid-cols-3 mt-10">
        <div class="md:col-span-2 p-4"> <!-- Cột bên trái -->
            <div class="mt-4">
                <h1 class="text-2xl font-bold dark:text-white"><%=job.getName()%> <span class="text-red-600"><%=job.isUrgent()? "(Tuyển gấp)" : ""%></span></h1>
            </div>
            <div class="mt-4">
                <ul class="flex flex-wrap gap-2">
                    <% String[] tagList = new String[0];
                        if (job.getTags() != null) {
                            tagList = job.getTags().split(",");
                        }
                    %>
                    <% for (String tagItem : tagList) {%>
                    <li><span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded"><%= tagItem%></span></li>
                    <%}%>
                </ul>
            </div>
            <div class="md:col-span-2 mt-4">
                <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <!-- Phần 1 -->
                    <div class="flex flex-col bg-gray-100 p-4 rounded dark:bg-gray-800">
                        <div>
                            <h3 class="text-lg font-semibold dark:text-white">Tên công ty</h3>
                        </div>
                        <div class="flex-grow">
                            <p class="text-sm dark:text-white"><%=job.getCorporation().getName()%></p>
                        </div>
                    </div>

                    <!-- Phần 2 -->
                    <div class="flex flex-col bg-gray-100 p-4 rounded  dark:bg-gray-800">
                        <div>
                            <h3 class="text-lg font-semibold dark:text-white">Số lượng cần tuyển</h3>
                        </div>
                        <div class="flex-grow">
                            <p class="text-sm dark:text-white"><%=job.getVacancies()%></p>
                        </div>
                    </div>

                    <!-- Phần 3 -->
                    <div class="flex flex-col bg-gray-100 p-4 rounded dark:bg-gray-800">
                        <div>
                            <h3 class="text-lg font-semibold dark:text-white">Nơi làm việc</h3>
                        </div>
                        <div class="flex-grow">
                            <p class="text-sm dark:text-white"><%=job.getJobLocation().getName()%></p>
                        </div>
                    </div>

                    <!-- Phần 4 -->
                    <div class="flex flex-col bg-gray-100 p-4 rounded dark:bg-gray-800">
                        <div>
                            <h3 class="text-lg font-semibold dark:text-white">Mức lương</h3>
                        </div>
                        <div class="flex-grow">
                            <p class="text-sm dark:text-white">
                                <span>
                             <% if(job.getNegotiable()) {%>
                                <span>Thoả thuận</span>
                             <% } else { %>
                             <span><%= format.format(job.getSalaryFrom())%> <%= job.getSalaryFromCurrency() %> - <%= format.format(job.getSalaryTo())%> <%= job.getSalaryToCurrency()%> </span>
                             <% } %>
                         </span>
                            </p>
                        </div>
                    </div>
                    <!-- Phần 3 -->
                    <div class="flex flex-col bg-gray-100 p-4 rounded dark:bg-gray-800">
                        <div>
                            <h3 class="text-lg font-semibold dark:text-white">Hình thức làm việc</h3>
                        </div>
                        <div class="flex-grow">
                            <p class="text-sm dark:text-white"><%=job.getJobType()%></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="md:col-span-2 border-b border-dashed m-4 "></div>
            <div>
                <h3 class="text-lg font-semibold dark:text-white">Yêu cầu và mô tả công việc</h3>
            </div>
            <div class="md:col-span-1 mt-4">
                <div class="text-sm dark:text-white">
                    <%=job.getDescription()%>
                </div>
            </div>
            <div class="md:col-span-2 border-b border-dashed m-4"></div>
            <div class="mt-4">
                <h1 class="font-bold text-xl dark:text-white">Các vị trí tương tự</h1>
                <div class="mt-2">
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
                                <a href="#" class="text-xl font-bold dark:text-white hover:text-blue-500">Tuyển dụng
                                    Java developer (Techlead)</a>
                                <div class="mt-2">
                                    <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Java</span>
                                    <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">Oracle database</span>
                                    <span class="inline-block px-2 py-1 text-sm font-semibold text-gray-800 bg-gray-200 rounded">AWS</span>
                                </div>
                                <p class="mt-4 text-gray-700 dark:text-white"><span
                                        class="font-bold">Mức lương:&nbsp; </span>100$ - 2000$</p>
                                <p class="text-gray-700 mt-1 mb-4 dark:text-white"><span
                                        class="font-bold">Thưởng:&nbsp; </span>$200/Candidate</p>
                                <a href="#"
                                   class="absolute bottom-0 right-0 px-4 py-2 text-sm font-semibold text-blue-500 italic underline hover:text-blue-900 dark:text-white dark:hover:text-blue-500">Ứng
                                    tuyển ngay</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="md:col-span-1 md:order-last order-first md:flex md:flex-col rounded border p-2 m-2 dark:border-gray-400">
            <div class="mt-4">
                <div class="grid grid-cols-2 gap-4">
                    <a <%=job.getFileJd() != null ? "disabled" : ""%> href="<%=job.getFileJd() == null ? "#" : "/file/download/" + job.getFileJd().getId()%>" target="_blank" class="border border-blue-500 bg-white text-blue-500 font-semibold rounded-md py-2 px-4 flex items-center justify-center hover:border-blue-600 hover:text-blue-600">
                        Download JD
                    </a>
                    <button class="bg-blue-500 text-white font-semibold rounded-md py-2 px-4 flex items-center justify-center hover:bg-blue-600">
                        Giới thiệu ngay
                    </button>
                </div>
            </div>
            <div class="mt-4">
                <div class="flex justify-center">
                    <button id="open-modal" type="button" data-modal-target="crypto-modal" data-modal-toggle="crypto-modal"
                            class="border-dotted border-2 border-gray-500 bg-white text-black-500 font-semibold rounded-md py-2 px-4 inline-block text-center w-full max-w-xs hover:border-blue-500 hover:text-blue-500">Gửi
                        CV tới Head Hunter</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Main modal -->
    <div id="crypto-modal" tabindex="-1" aria-hidden="true" class="inset-0 flex items-center justify-center z-50 fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-[calc(100%-1rem)] max-h-full">
        <div class="relative w-full max-w-md max-h-full">
            <div id="modal-backdrop" class="fixed inset-0 bg-black opacity-50"></div>
            <!-- Modal content -->
            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                <button id="close-modal" type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-hide="crypto-modal">
                    <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                    <span class="sr-only">Close modal</span>
                </button>
                <!-- Modal header -->
                <div class="px-6 py-4 border-b rounded-t dark:border-gray-600">
                    <h3 class="text-base font-semibold text-gray-900 lg:text-xl dark:text-white">
                        Tải lên hồ sơ của bạn
                    </h3>
                </div>
                <!-- Modal body -->
                <div class="p-6">
                    <form action="${pageContext.request.contextPath}/submit-resume" method="post" enctype="multipart/form-data" onsubmit="submitFile($event)">
                        <div class="mb-6">
                            <label for="applicantName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Họ và tên</label>
                            <input type="text" id="applicantName" name="applicantName" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Điền tên của bạn" required>
                        </div>
                        <div class="mb-6">
                            <label for="applicantEmail" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
                            <input type="email" id="applicantEmail" name="applicantEmail" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@flowbite.com" required>
                        </div>
                        <div class="mb-6">
                            <label for="applicantFbLink" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Link facebook</label>
                            <input type="text" id="applicantFbLink" name="applicantFbLink" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="https://facebook.com" required>
                        </div>
                        <div class="mb-6">
                            <label for="applicantPhone" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Số điện thoại liên hệ</label>
                            <input type="tel" id="applicantPhone" name="applicantPhone" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="" required>
                        </div>
                        <div class="w-full h-64 flex items-center justify-center bg-gray-100 rounded-lg border-2 border-dashed border-gray-400 cursor-pointer">
                            <label for="fileResume" class="flex flex-col items-center">
                                <svg class="w-12 h-12 text-gray-400 mb-2" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 15v4a2 2 0 01-2 2H5a2 2 0 01-2-2v-4m2 2h14M8 7V3m8 4V3m-8 4h8m4-4h.01"></path>
                                </svg>
                                <span id="fileLabel" class="text-sm text-gray-600 text-center">Kéo và thả hoặc chọn CV (doc, docx, pdf tối đa 5MB)</span>
                                <input id="fileResume" name="fileResume" onchange="updateFileName(this)" type="file" class="hidden">
                            </label>
                        </div>
                        <div>
                            <input type="text" name="jobId" id="jobId" value="<%=job.getId()%>" class="hidden" hidden="hidden">
                        </div>
                        <div class="flex flex-col items-center justify-center mt-4">
                            <div class="w-full max-w-xs">
                                <button id="submitButton" onclick="submitFile($event)" class="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded-full w-full">Gửi hồ sơ</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="footer.jsp" />
</body>
<script src="/resources/js/navbar-toggle.js"></script>
<script>
    // Lấy các phần tử DOM
    const openModalBtn = document.getElementById('open-modal');
    const closeModalBtn = document.getElementById('close-modal');
    const modal = document.getElementById('crypto-modal');
    const modalBackdrop = document.getElementById('modal-backdrop');
    const body = document.body;

    // Xử lý sự kiện khi nhấp vào nút mở modal
    openModalBtn.addEventListener('click', function() {
        modal.classList.remove('hidden');
        modalBackdrop.classList.remove('hidden');
        body.style.overflow = 'hidden';
    });

    // // Xử lý sự kiện khi nhấp vào nút đóng modal
    closeModalBtn.addEventListener('click', function() {
        modal.classList.add('hidden');
        modalBackdrop.classList.add('hidden');
        body.style.overflow = 'auto';
    });
    function updateFileName(input) {
        var fileName = input.files[0].name;
        var fileLabel = document.getElementById('fileLabel');
        fileLabel.textContent = fileName;
    }
    function submitFile(event) {
        var submitButton = document.getElementById('submitButton');
        submitButton.disabled = true;
        submitButton.classList.remove('hover:bg-blue-600', 'bg-blue-500');
        submitButton.classList.add('bg-blue-400')
    }

    <% if (request.getAttribute("submitResumeResult") != null) {%>
        alert('<%=(String) request.getAttribute("submitResumeResult")%>');
    <%}%>
</script>
</html>