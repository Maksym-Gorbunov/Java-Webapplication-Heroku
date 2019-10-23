var make, color, licensenumber, newMake, newColor, newLicensenumber;
var row, makeTd, colorTd, licensenumberTd;


var rowsss = $("#carsTable").find('> tbody > tr');
// console.log(rowsss.length);
// console.log(rowsss[0]);
//console.log(rowsss[0].childNodes[0].innerHTML);



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

    console.log(row.childNodes)



    if ($this.html() === 'Edit') {
        $this.html('Save');
        makeTd.contentEditable = true;
        colorTd.contentEditable = true;

        // makeTd.style.backgroundColor = 'red';
        // colorTd.style.backgroundColor = 'red';
        // licensenumberTd.style.backgroundColor = 'red';

        make = tds.get(1).innerHTML;
        color = tds.get(2).innerHTML;
        licensenumber = tds.get(3).innerHTML;



        //toDo disable all except current row
        //toDo blur bage, or opacity ...?
        //toDo disable delete btn and add new btn

        for (var i = 0; i < rowsss.length; i++) {
            var r = rowsss[i];
            if(r != row){
                r.style.backgroundColor = 'green';
            }

        }

        // row = $this.closest('tr');
        // row.css('background', 'blue');


    } else {
        $this.html('Edit');
        makeTd.contentEditable = false;
        colorTd.contentEditable = false;

        // makeTd.style.backgroundColor = "transparent";
        // colorTd.style.backgroundColor = "transparent";
        // licensenumberTd.style.backgroundColor = "transparent";

        newMake = tds.get(1).innerHTML;
        newColor = tds.get(2).innerHTML;
        newLicensenumber = tds.get(3).innerHTML;


        //toDo send request to server + _method put
        editRequest();

        for (var i = 0; i < rowsss.length; i++) {
            var r = rowsss[i];
            r.style.backgroundColor = 'blue';
        }
    }
});

function editRequest() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //document.getElementById("demo").innerHTML = this.responseText;
        }
    };
    // xhttp.open("POST", "demo_post2.asp", true);
    xhttp.open("POST", "cars", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var my_body = `_method=PUT&licensenumber=${licensenumber}&newMake=${newMake}&newColor=${newColor}`;
    xhttp.send(my_body);
}


////////////////////////////////// DELETE //////////////////////////////////

$('.deleteBtn').click(function () {
    var $this = $(this);
    var tds = $this.closest('tr').find('td').filter(function () {
        return $(this).find('.editBtn').length === 0;
    });
    licensenumberTd = tds.get(3);
    licensenumber = tds.get(3).innerHTML;
    deleteRequest();
    row = $this.closest('tr');
    row.remove();

});

function deleteRequest() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //document.getElementById("demo").innerHTML = this.responseText;
        }
    };
    // xhttp.open("POST", "demo_post2.asp", true);
    xhttp.open("POST", "cars", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var my_body = `_method=DELETE&licensenumber=${licensenumber}`;
    xhttp.send(my_body);
}
