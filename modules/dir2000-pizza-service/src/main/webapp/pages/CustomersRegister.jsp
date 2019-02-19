<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>All pizzas</title>
</head>
<body>
<a href='<c:url value="/" />'>Back to main page..</a>
<br/>
<br/>
<form method="post">
    <h2>New customer registration</h2>
    <label>Enter the name:
        <input type="text" name="customerName" value=
        '<c:out value="${requestScope.customerName}"/>' required><br/>
    </label>
    <c:out value="${requestScope.errorMessage}"/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
