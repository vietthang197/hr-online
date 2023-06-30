$(document).ready(function () {

    const objectSearch = {
        name: null
    }

    const dataTable = $('#dataTable').DataTable({
        columnDefs: [
            {
                orderable: false,
                className: 'select-checkbox',
                targets: 0
            },
            {
                targets: 1,
                visible: false,
                searchable: false,
            }
        ],
        select: {
            style: 'multi',
            selector: 'td:first-child'
        },
        pagingType: "full_numbers",
        lengthMenu: [
            [10, 25, 50],
            [10, 25, 50]
        ],
        searching: false,
        ordering: false,
        info: true,
        responsive: true,
        processing: false,
        serverSide: true,
        "columns": [
            {"data": ""},
            {"data": "id", "render": $.fn.dataTable.render.text()},
            {"data": "name", "render": $.fn.dataTable.render.text()},
            {"data": "createdDate", "render": $.fn.dataTable.render.text()},
            {"data": "createdBy", "render": $.fn.dataTable.render.text()},
            {"data": "updatedDate", "render": $.fn.dataTable.render.text()},
            {"data": "updatedBy", "render": $.fn.dataTable.render.text()}
        ],
        ajax: {
            url: "/admin/industry/search",
            method: "POST",
            contentType: "application/json",
            data: function (data) {
                return JSON.stringify({
                    draw: data.draw,
                    start: Math.round(data.start / data.length),
                    length: data.length,
                    ...objectSearch
                })
            },
            dataFilter: function (response) {
                let responseJson = JSON.parse(response).data;
                let dataRes = {
                    "draw": responseJson.draw,
                    "recordsFiltered": responseJson.recordsTotal,
                    "recordsTotal": responseJson.recordsTotal,
                    "data": []
                };

                for (let i = 0; i < responseJson.data.length; i++) {
                    dataRes.data.push({
                        "": "",
                        "id": responseJson.data[i].id,
                        "name": responseJson.data[i].name,
                        "createdDate": responseJson.data[i].createdDate,
                        "createdBy": responseJson.data[i].createdBy,
                        "updatedDate": responseJson.data[i].updatedDate,
                        "updatedBy": responseJson.data[i].updatedBy
                    })
                }

                return JSON.stringify(dataRes);
            }
        }, infoCallback: function ( settings, start, end, max, total, pre ) {
            console.log('Chay vao day')
        }
    });

    $('#btnSearchDataTable').click(function (e) {
        e.preventDefault();
        e.stopPropagation();
        objectSearch.name = $('#s_name').val() == '' ? null : $('#s_name').val();
        dataTable.search({...objectSearch}).draw()
    })

    $('#btnClearFormSearch').click(function (e) {
        e.preventDefault();
        e.stopPropagation();
        $('#s_name').val('');
        objectSearch.name = null;
        dataTable.search({...objectSearch}).draw()
    });
});