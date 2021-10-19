
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- CSRF Token -->
    <meta name="csrf-token" content="09Pkb1kgTTiGMSEhXvyvKN1WTPA0u9en4ZKc9xk3">

    <title>Ecommerce | </title>

    <!-- Scripts -->
    <script type="text/javascript" src="http://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=VQWZDr3ZjJ2KDO_1F8CYj21EQI5DTQIHbZrMIhwtzzuErD2rX0avqzRfOGYQnJwtja0-2n0Vn3-gTrbv6L4IKQ" charset="UTF-8"></script><script src="http://vampireecommerce.herokuapp.com/js/app.js"></script>

    <!-- Fonts -->
    <link rel="dns-prefetch" href="//fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Merienda One" rel="stylesheet">
    
    <!-- Styles -->
    <link href="css/app.css" rel="stylesheet">
</head>
<body>
    <div id='app'>
<div id="cont">
    <ul style="height:4em">

    </ul>
</div>
        <div class="" style="margin-top: 2em">
                                    <div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Login</div>

                <div class="card-body">
                    <form action="Servlet" method="post">
                        <input type="hidden" name="_token" value="09Pkb1kgTTiGMSEhXvyvKN1WTPA0u9en4ZKc9xk3">
                        <div class="form-group row">
                            <label for="email" class="col-md-4 col-form-label text-md-right">Username</label>

                            <div class="col-md-6">
                                <input type="text" class="form-control my-input " name="identifiant" class="form-control" autofocus>

                                                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="email" class="col-md-4 col-form-label text-md-right">E-Mail Address</label>

                            <div class="col-md-6">
                                <input id="email" type="email" class="form-control my-input " name="email" value="" required autocomplete="email" autofocus>

                                                            </div>
                        </div>
                        

                        <div class="form-group row">
                            <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>

                            <div class="col-md-6">
                                <input id="password" type="password" class="form-control my-input " name="pw" required autocomplete="current-password">

                                                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-6 offset-md-4">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="remember" id="remember" >

                                    <label class="form-check-label" for="remember">
                                        Remember Me
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row mb-0">
                            <div class="col-md-8 offset-md-4">
                            <input type="hidden" name="action" value="login">
                                <button type="submit" class="btn btn-success custom-border">
                                    Login
                                </button>
                                <br><a href="signup.jsp">Sign up</a>
    							
                                                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
        </div>
   </div>
</body>
</html>
