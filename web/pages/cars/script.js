var make, color, licensenumber, newMake, newColor, newLicensenumber;

$('.editBtn').click(function () {
    var $this = $(this);
    var tds = $this.closest('tr').find('td').filter(function () {
        return $(this).find('.editBtn').length === 0;
    });

    var makeTd = tds.get(1);
    var colorTd = tds.get(2);
    var licensenumberTd = tds.get(3);


    if ($this.html() === 'Edit') {
        $this.html('Save');
        makeTd.contentEditable = true;
        colorTd.contentEditable = true;
        licensenumberTd.contentEditable = true;

        makeTd.style.backgroundColor = 'red';
        colorTd.style.backgroundColor = 'red';
        licensenumberTd.style.backgroundColor = 'red';

        make = tds.get(1).innerHTML;
        color = tds.get(2).innerHTML;
        licensenumber = tds.get(3).innerHTML;

        //toDo disable all except current row
        //toDo blur bage, or opacity ...?
        //toDo disable delete btn and add new btn
    } else {
        $this.html('Edit');
        makeTd.contentEditable = false;
        colorTd.contentEditable = false;
        licensenumberTd.contentEditable = false;

        makeTd.style.backgroundColor = "transparent";
        colorTd.style.backgroundColor = "transparent";
        licensenumberTd.style.backgroundColor = "transparent";

        newMake = tds.get(1).innerHTML;
        newColor = tds.get(2).innerHTML;
        newLicensenumber = tds.get(3).innerHTML;

        // console.log(make + " " + color + " " + licensenumber);
        // console.log(newMake + " " + newColor + " " + newLicensenumber);
        // console.log("______________________________________________");

        //toDo send request to server + _method put
        sendRequest();
    }
});

function sendRequest() {
    console.log(make + " " + color + " " + licensenumber);
    console.log(newMake + " " + newColor + " " + newLicensenumber);
    console.log("______________________________________________");

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //document.getElementById("demo").innerHTML = this.responseText;
        }
    };
    // xhttp.open("POST", "demo_post2.asp", true);
    xhttp.open("POST", "cars", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    /*var body = `_method=DELETE
        &make=${make}
        &color=${color}
        &licensenumber=${licensenumber}
        &newMake=${newMake}
        &newColor=${newColor}
        &newLicensenumber=${newLicensenumber}`;*/
    /*var body = `_method=DELETE&make=${make}&color=${color}&licensenumber=${licensenumber}
    &newMake=${newMake}&newColor=${newColor}&newLicensenumber=${newLicensenumber}`;*/
    var body = `_method=DELETE&make=${make}&color=${color}&licensenumber=${licensenumber}`;
    xhttp.send(body);

    //window.location.reload(true);
}