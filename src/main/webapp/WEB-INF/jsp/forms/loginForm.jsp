
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
    <div id="login-form" style="display: block">
        <form:form action="loginCheck" method="post" modelAttribute="loginForm">

            Surname: <form:input path="email"/><br><br>
            Password:<form:password path="password"/><br><br>
            <input type="submit" value="Login">

        </form:form>

</div>

<div style="clear: both"></div>
</body>

</html>