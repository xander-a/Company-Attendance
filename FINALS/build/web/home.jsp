<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Database Project Home</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Home.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-transparent fixed-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home.jsp">

                    <img src="${pageContext.request.contextPath}/img/LOGO.png" alt="LOGO" style="height: 65px;">
                </a>

                <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <span class="date-time" id="currentDateTime"></span>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="content">
            <div class="wrapper">
                <form method="post">
                    <h2>Employee Info</h2>
                    <div class="message">
                        <c:out value="${message}" />
                    </div>
                    <div class="input-field">
                        <input type="text" id="Fullname" name="firstName" value=" <c:out value="${firstName}" /> <c:out value="${middleName}" /> <c:out value="${lastName}" />"> 
                        <label for="Fullname"></label>
                    </div>
                    <div class="input-field">
                        <input type="text" id="Department" name="department" value="<c:out value='${department}'/>">
                        <label for="Department"></label>
                    </div>
                    <div class="input-field">
                        <input type="text" id="Day" name="day" value="<c:out value='${day}'/>">
                        <label for="Day"></label>
                    </div>
                    <div class="input-field">
                        <input type="text" id="Time" name="time" value="<c:out value='${time}'/>">
                        <label for="Time"></label>
                    </div>
                    <div class="button-container">
                        <button type="submit" formaction="${pageContext.request.contextPath}/timein/create/form">Time in</button>
                        <button type="submit" formaction="${pageContext.request.contextPath}/timeout/create/form">Time out</button>
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
