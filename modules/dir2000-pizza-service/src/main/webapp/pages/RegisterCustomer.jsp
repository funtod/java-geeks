<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>All pizzas</title>
<link rel="stylesheet" href="css/w3.css" type="text/css"/>
</head>
<body>
<a href='<c:url value="/" />'>Back to main page..</a>
<br/>
<br/>
<div class="w3-container">
    <form method="post">
        <h2>New customer registration</h2>
        <label>Enter the name:
            <input type="text" name="customerName" value=<c:out value="${requestScope.customerName}"/> required><br/>
        </label>
        <c:if test="${ not empty errorMessage}">
            <div class="w3-panel w3-red">
                <c:out value="${errorMessage}"/>
            </div>
        </c:if>
        <input type="submit" value="Register"/>
    </form>
</div>
</body>
</html>
