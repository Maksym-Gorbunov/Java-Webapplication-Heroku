<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="">
                <i class="fas fa-house-damage"></i>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" id="navigation">
                <li name="home"><a href="">Home<span class="sr-only">(current)</span></a></li>
                <li name="users"><a href="users">Users</a></li>
                <li name="cars"><a href="cars">Cars</a></li>
                <li name="about"><a href="about">About</a></li>
                <li class="dropdown disabled">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="pages/page1">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left disabled searchForm">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="disabled"><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"
                       style="color: #00AD5F">
                        Welcome ${user.login} <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="disabled"><a href="#">Action</a></li>
                        <li class="disabled"><a href="#">Another action</a></li>
                        <li class="disabled"><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="signout" style="color: red">Sign out</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<script>
    var pageName = '${pageName}';
    var current = false;
    $("#navigation li").each(function () {
        var navLink = $(this);
        if (pageName == navLink.attr("name")) {
            navLink.addClass('active');
            current = true;
            if((pageName == 'users') || (pageName == 'cars')){
                $('.searchForm').css('display', 'block');
            } else {
                $('.searchForm').css('display', 'none');
            }
        }
    });
    if (current == false) {
        $("#navigation li:nth-child(1)").addClass('active');
    }


</script>

<style>
    .disabled {
        pointer-events:none; /*This makes it not clickable*/
        opacity:0.6;         /*This grays it out to look disabled*/
    }
</style>