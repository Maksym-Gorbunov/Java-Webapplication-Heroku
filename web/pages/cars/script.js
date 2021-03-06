var make, color, licensenumber, newMake, newColor, newLicensenumber;
var row, makeTd, colorTd, licensenumberTd, buttons;

var rows = $("#carsTable").find('> tbody > tr');


////////////////////////////////// ADD //////////////////////////////////
$(document).ready(function() {
    $('.addField input').on('keyup', function() {
        let empty = false;

        $('.addField input').each(function() {
            empty = $(this).val().length == 0;
        });

        if (empty)
            $('.addActions button').attr('disabled', 'disabled');
        else
            $('.addActions button').attr('disabled', false);
    });
});




////////////////////////////////// EDIT //////////////////////////////////
$('.editBtn').click(function () {
    var $this = $(this);
    var tds = $this.closest('tr').find('td').filter(function () {
        return $(this).find('.editBtn').length === 0;
    });
    makeTd = tds.get(1);
    colorTd = tds.get(2);
    licensenumberTd = tds.get(3);
    row = $this.closest('tr');
    var rowIndex = $('#carsTable tr').index(row);
    if ($this.html() === 'Edit') {
        $this.html('Save');
        makeTd.contentEditable = true;
        colorTd.contentEditable = true;
        makeTd.style.backgroundColor = 'white';
        colorTd.style.backgroundColor = 'white';
        make = tds.get(1).innerHTML;
        color = tds.get(2).innerHTML;
        licensenumber = tds.get(3).innerHTML;
        $("#carsTable").find("button").attr('disabled', true);
        $this.attr('disabled', false);
        var op = 0.2;
        rows.css('opacity', op);
        row.css('opacity', 1);
        row.closest("button").css('opacity', op);
        $("*",".addForm").attr('disabled', true);
        $(".addForm").css('opacity', op);
    } else {
        $this.html('Edit');
        makeTd.contentEditable = false;
        colorTd.contentEditable = false;
       makeTd.style.backgroundColor = "transparent";
        colorTd.style.backgroundColor = "transparent";
        newMake = tds.get(1).innerHTML;
        newColor = tds.get(2).innerHTML;
        newLicensenumber = tds.get(3).innerHTML;
        editRequest();
        $("#carsTable").find("button").attr('disabled', false);
        rows.css('opacity', 1);
        $("*",".addForm").attr('disabled', false);
        $(".addForm").css('opacity', 1);
    }
});

function editRequest() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //document.getElementById("demo").innerHTML = this.responseText;
        }
    };
    xhttp.open("POST", "cars", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var my_body = `_method=PUT&licensenumber=${licensenumber}&newMake=${newMake}&newColor=${newColor}`;
    xhttp.send(my_body);
}



////////////////////////////////// DELETE //////////////////////////////////

$('.deleteBtn').click(function () {
    var $this = $(this);
    var tds = $this.closest('tr').find('td').filter(function () {
        return $(this).find('.deleteBtn').length === 0;
    });
    licensenumberTd = tds.get(3);
    licensenumber = tds.get(3).innerHTML;
    deleteRequest();

    row = $this.closest('tr');

    var total = $("#total").html();
    $("#total").html(total - 1);
    row.remove();
});

function deleteRequest() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //document.getElementById("demo").innerHTML = this.responseText;
        }
    };
    xhttp.open("POST", "cars", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var my_body = `_method=DELETE&licensenumber=${licensenumber}`;
    xhttp.send(my_body);
}
