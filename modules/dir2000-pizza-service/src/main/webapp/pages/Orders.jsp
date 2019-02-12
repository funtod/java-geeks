<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>Orders</title>
</head>
<body>
<br/>
<br/>
<form method="post">
    <c:if test="${sessionScope.customerID == null}">
        <c:redirect url="/index.jsp" />
    </c:if>
    <h2>Orders</h2>
    <form action='<c:url value="/customer_logout" />' method="post">
        <input type="submit" value="Logout">
    </form>
</form>
</body>
</html>
