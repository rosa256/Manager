
<%@include file="init/init.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
    <link href="/css/menu.css" rel="stylesheet"/>
</head>
<body>
<h1>Index Page</h1>
<%@include file="include/navigation-bar.jsp"%>

    <div class="content">

        Logged in Student:
        <c:out value="${sessionScope.activeStudent.name}"/>
        <c:out value="${sessionScope.activeStudent.surname}"/>

    </div>

<div style="clear: both"></div>
</body>

</html>