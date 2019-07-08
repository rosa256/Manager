<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>

<html>

<head>
    <title> Student Registration </title>
</head>

    <body>

        <h1>Registration</h1>
        <form method="post">
            Name: <input type="text" name="name"> <br> <!-- Nie ma action=, form wyslany bedzie na /students/register -->
            Surname: <input type="text" name="surname"> <br>
            Password: <input type="password" name="password"> <br>
            Age: <input type="text" name="age"> <br>

        <input type="submit" value="Register">
        </form>
    </body>
</html>