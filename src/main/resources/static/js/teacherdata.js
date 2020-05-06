$(document).ready(function() {
    var table = $('#teachersTable').DataTable({
        "sAjaxSource": "/teachersdata",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "name" },
            { "mData": "email" },
            { "mData": "num" },
            { "mData": "course" },
            { "mData": "level" },
            { "mData": "address" },
            { "mData": "classe" },
            { "mData": "school" }
        ]
    })
});