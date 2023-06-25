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
        ajax: {
            url: "/admin/industry/search",
            method: "POST",
            contentType: "application/json",
            data: function (data) {
                return JSON.stringify({
                    page: data.draw,
                    size: data.length,
                    searchData: {}
                })
            },
            dataFilter: function (response) {
                let dataRes = {
                    "draw": 1,
                    "recordsFiltered": 0,
                    "recordsTotal": 0,
                    "data": []
                };
                return JSON.stringify(dataRes);
            }
        }
    });

    dataTable
        .on('select', function (e, dt, type, indexes) {
            const rowData = table.rows(indexes).data().toArray();
        })
        .on('deselect', function (e, dt, type, indexes) {
            const rowData = table.rows(indexes).data().toArray();
        });


    $('#btnSearchDataTable').click(function (e) {
        e.preventDefault();
        e.stopPropagation();
        objectSearch.name = $('#s_name').value;

        console.log(dataTable)
        console.log(dataTable.search());
        console.log(dataTable.draw())
    })
});