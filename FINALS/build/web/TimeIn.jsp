<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Time In</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Regform.css">
    </head>

    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-transparent fixed-top">
                <div class="container-fluid">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/home.jsp">
                        <img src="${pageContext.request.contextPath}/img/LOGO.png" alt="LOGO" style="height: 65px;">
                    </a>
                </div>
            </nav>
        </header>

        <div class="content">
            <div class="wrapper">
                <form method="post" action="${pageContext.request.contextPath}/timein/home">
                    <h2><b>Time In Form</b></h2>
                    <div class="message">
                        <c:out value="${message1}" />
                    </div>
                    <div class="input-field">
                        <input type="text" id="username" name="username" required>
                        <label>Username</label>
                    </div>
                    <div class="input-field">
                        <input type="text" id="firstName" name="firstName" required>
                        <label>First Name</label>
                    </div>
                    <div class="input-field">
                        <input type="text" id="middleName" name="middleName">
                        <label>Middle Name</label>
                    </div>
                    <div class="input-field">
                        <input type="text" id="lastName" name="lastName" required>
                        <label>Last Name</label>
                    </div>
                    <div class="input-field">
                        <input type="text" id="Department" name="department" required>
                        <label>Department</label>
                    </div>
                    <div class="input-field">
                        <input type="text" id="DAY" name="day">
                        <label>Day</label>
                    </div>
                    <div class="input-field">
                        <input type="text" id="TIME" name="time">
                        <label>Time</label>
                    </div>
                    <button type="submit">Submit</button>
                </form>

            </div>
        </div>

        <script>
            var characterOnly = /^[A-Za-z\s]+$/;

            function formValidation() {
                var firstName = document.getElementById("firstName").value.trim();
                var middleName = document.getElementById("middleName").value.trim();
                var lastName = document.getElementById("lastName").value.trim();
                var Department = document.getElementById("Department").value.trim();

                if (!firstName.match(characterOnly)) {
                    alert("First name must contain only characters and be at least 1 letter.");
                    return false;
                }

                if (firstName.length < 1) {
                    alert("First name must be at least 1 character long.");
                    return false;
                }

                if (middleName.trim().length > 0 && !middleName.match(characterOnly)) {
                    alert("Middle name must contain only characters.");
                    return false;
                }

                if (!lastName.match(characterOnly)) {
                    alert("Last name must contain only characters and be at least 2 letters.");
                    return false;
                }

                if (Department.trim().length === 0) {
                    alert("Department is required.");
                    return false;
                }

                return true;
            }

            function updateTime() {
                var now = new Date();
                var options = {year: 'numeric', month: 'long', day: 'numeric'};
                var formattedDate = now.toLocaleDateString('en-US', options);

                // Get hours, minutes, and AM/PM
                var hours = now.getHours();
                var minutes = now.getMinutes();
                var ampm = hours >= 12 ? 'PM' : 'AM';
                hours = hours % 12;
                hours = hours ? hours : 12; // the hour '0' should be '12'
                var timeString = hours + ':' + (minutes < 10 ? '0' + minutes : minutes) + ' ' + ampm;

                // Update the display inputs
                document.getElementById('DAY').value = formattedDate;
                document.getElementById('TIME').value = timeString;
            }

            setInterval(updateTime, 1000);
            updateTime();
        </script>

    </body>
</html>
