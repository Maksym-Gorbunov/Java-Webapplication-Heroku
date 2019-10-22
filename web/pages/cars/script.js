

$('.editbtn').click(function() {
    var $this = $(this);
    var tds = $this.closest('tr').find('td').filter(function() {
        return $(this).find('.editBtn').length === 0;
    });

    var makeTd = tds.get(1);
    var colorTd = tds.get(2);
    var licensenumberTd = tds.get(3);

    var make = tds.get(1).innerHTML;
    var color = tds.get(2).innerHTML;
    var licensenumber = tds.get(3).innerHTML;


    if ($this.html() === 'Edit') {
        $this.html('Save');
        makeTd.contentEditable = true;
        colorTd.contentEditable = true;
        licensenumberTd.contentEditable = true;

        makeTd.style.backgroundColor = 'red';
        colorTd.style.backgroundColor = 'red';
        licensenumberTd.style.backgroundColor = 'red';

        console.log(make + " " + color + " " + licensenumber);
    } else {
        $this.html('Edit');
        makeTd.contentEditable = false;
        colorTd.contentEditable = false;
        licensenumberTd.contentEditable = false;

        makeTd.style.backgroundColor = "transparent";
        colorTd.style.backgroundColor = "transparent";
        licensenumberTd.style.backgroundColor = "transparent";
    }

});
