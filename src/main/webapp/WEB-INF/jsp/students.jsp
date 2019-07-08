<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
    <html>
    <head>
        <meta charset="UTF-8" />
        <title>Welcome</title>
        <style>
            body {
                background-color: gray;
            }
        </style>
    </head>
        <body>
        <h1>Students Page</h1>
        <div>
            <c:forEach items="${studentsList}" var="student" >
                <c:out value="${student.name}" ></c:out>
                <c:out value="${student.surname}" ></c:out>
                <c:out value="${student.age}" ></c:out>
            </c:forEach>
        </div>

    </body>

</html>