<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Regform.css">
    </head>
    
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-transparent fixed-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
           
            <img src="${pageContext.request.contextPath}/img/LOGO.png" alt="LOGO" style="height: 65px;">
        </a>
            </div>
        </nav>
    </header>

    <div class="content">
        <div class="wrapper">
            <form method="post" action="${pageContext.request.contextPath}/regform/create" onsubmit="return formValidation()">
                <h2><b>Registration Form</b></h2>
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
                    <input type="text" id="email" name="email" required>
                    <label>Email Address</label>
                </div>
                <div class="input-field">
                    <input type="number" id="contactNumber" name="contactNumber" required>
                    <label>Contact Number</label>
                </div>
                <div class="input-field">
                    <input type="password" id="password" name="password" required>
                    <label>Password</label>
                </div>
                <div class="input-field">
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                    <label>Confirm password</label>
                </div>
                <button type="submit" id="submit-btn">Sign in</button>
            </form>
        </div>
    </div>

    <script>
        var characterOnly = /^[A-Za-z\s]+$/;
        var numeric = /^[0-9]+$/;
        var alphanumeric = /^[A-Za-z0-9]+$/;
        var passwordFormat = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_])[A-Za-z\d\W_]{8,}$/;
        var emailFormat = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        function formValidation() {
            var username = document.getElementById("username").value.trim();
            var firstName = document.getElementById("firstName").value.trim();
            var middleName = document.getElementById("middleName").value.trim();
            var lastName = document.getElementById("lastName").value.trim();
            var email = document.getElementById("email").value.trim();
            var contactNumber = document.getElementById("contactNumber").value.trim();
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;

            if (!username.match(alphanumeric)) {
                alert("Username must be alphanumeric (letters and numbers only).");
                return false;
            }

            if (username.length < 4 || username.length > 5) {
                alert("Username should be between 4 to 5 characters long.");
                return false;
            }

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

            if (!email.match(emailFormat)) {
                alert("Invalid email format.");
                return false;
            }

            if (!contactNumber.match(numeric) || contactNumber.length !== 11) {
                alert("Contact number must be numeric and have exactly 11 digits.");
                return false;
            }

            if (password.length < 8 || password.length > 16) {
                alert("Password must be between 8 to 16 characters long.");
                return false;
            }

            if (!password.match(passwordFormat)) {
                alert("Password must contain at least 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character.");
                return false;
            }

            if (password !== confirmPassword) {
                alert("Password and Confirm Password do not match.");
                return false;
            }

            return true;
        }
    </script>
</body>
</html>
