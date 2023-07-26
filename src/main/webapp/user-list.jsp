<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Group29 User Registration and Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #007BFF">
            <div>
                <a href="#" class="navbar-brand">Group29 User App</a>
            </div>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${!loggedIn}">
                    <form action="register" method="post" id="registrationForm">
                        <caption>
                            <h2>User Registration</h2>
                        </caption>

                        <fieldset class="form-group">
                            <label>User Name</label>
                            <input type="text" class="form-control" name="username" required="required" minlength="4">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="password" required="required" minlength="8">
                        </fieldset>

                        <button type="submit" class="btn btn-primary">Register</button>
                        <p class="mt-2">Already have an account? <a href="#" onclick="showLogin()">Login</a></p>
                    </form>
                </c:if>

                <c:if test="${loggedIn}">
                    <h2>Welcome, ${loggedInUser.username}!</h2>
                    <button class="btn btn-danger" onclick="logout()">Logout</button>
                </c:if>
            </div>
        </div>
    </div>

    <script>
        function showLogin() {
            document.getElementById("registrationForm").setAttribute("action", "login");
            document.getElementsByTagName("h2")[0].innerText = "User Login";
            document.querySelector("button[type=submit]").innerText = "Login";
            document.querySelector(".mt-2 a").setAttribute("onclick", "showRegistration()");
            document.querySelector(".mt-2 a").innerText = "Register";
        }

        function showRegistration() {
            document.getElementById("registrationForm").setAttribute("action", "register");
            document.getElementsByTagName("h2")[0].innerText = "User Registration";
            document.querySelector("button[type=submit]").innerText = "Register";
            document.querySelector(".mt-2 a").setAttribute("onclick", "showLogin()");
            document.querySelector(".mt-2 a").innerText = "Login";
        }

        function logout() {
            if (confirm("Are you sure you want to logout?")) {
                window.location.href = "logout";
            }
        }
    </script>
</body>
</html>
