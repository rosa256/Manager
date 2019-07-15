<%@include file="../init/init.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
    <link href="/css/menu.css" rel="stylesheet"/>
</head>
<body>
<h1>Index Page</h1>
<%@include file="../include/navigation-bar.jsp"%>

<div class="content">

    <div id="registration-form" style="display: block">
        <h1>Registration</h1>

        <form:form method="POST" modelAttribute="student">
            Name: <form:input path="name"/> </br>
            Surname: <form:input path="surname"/> </br>
            Email: <form:input path="email"/> </br>
            Password: <form:password path="password"/> </br>
            Age: <form:input path="age"/> </br>
            <input type="submit" value="Register" />
        </form:form>

    </div>

</div>

<div style="clear: both"></div>
</body>

</html>