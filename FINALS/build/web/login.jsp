<%-- 
    Document   : login
    Created on : Jun 12, 2024, 1:35:00 PM
    Author     : Xander
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Homepage.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Login Form</title>
</head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-transparent fixed-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="img/LOGO.png" alt="LOGO" style="height: 65px;">
                </a>
               
                <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <li class="date-time" id="currentDateTime"></li>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <div class="content">
            <div class="wrapper">
                <form method="post" action="${pageContext.request.contextPath}/homepage">
                    <h2>Login</h2>
                    <div class="input-field">
                        <input type="text" name = "username"required>
                        <label>Enter your username</label>
                    </div>
                    <div class="input-field">
                        <input type="password" name="password" required>
                        <label>Enter your password</label>
                    </div>
                    <div class="forget">
                        <label for="remember">
                            <input type="checkbox" id="remember">
                            <span>Remember me</span>
                        </label>
                        <a href="#">Forgot password?</a>
                    </div>
                    <button type="submit">Log In</button>
                    <div class="register">
                        <p>Don't have an account? <a href="${pageContext.request.contextPath}/regform/create/form" class="text-white">Register</a></p>
                    </div>
                </form>
            </div>
        </div>
        
        <script>
            function updateTime() {
                var now = new Date();
                var options = {year: 'numeric', month: 'long', day: 'numeric'};
                var formattedDate = now.toLocaleDateString('en-US', options);
                var timeString = now.toLocaleTimeString();
                document.getElementById('currentDateTime').innerHTML = formattedDate + '&nbsp;&nbsp;' + timeString;
            }
            
            setInterval(updateTime, 1000);
            updateTime();
        </script>
    </body>
</html>
