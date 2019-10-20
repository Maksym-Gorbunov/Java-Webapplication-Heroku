

$('.editbtn').click(function() {
    var $this = $(this);
    var tds = $this.closest('tr').find('td').filter(function() {
        return $(this).find('.editBtn').length === 0;
    });

    var loginTd = tds.get(1);
    var passwordTd = tds.get(2);


    if ($this.html() === 'Edit') {
        $this.html('Save');
        loginTd.contentEditable = true;
        passwordTd.contentEditable = true;
        loginTd.style.backgroundColor = 'red';
        passwordTd.style.backgroundColor = 'red';
    } else {
        $this.html('Edit');
        loginTd.contentEditable = false;
        passwordTd.contentEditable = false;
        loginTd.style.backgroundColor = "transparent";
        passwordTd.style.backgroundColor = "transparent";
    }

});
