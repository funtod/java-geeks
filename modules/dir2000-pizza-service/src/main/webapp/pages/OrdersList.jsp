<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>Orders</title>
</head>
<body>
<br/>
<br/>
<c:if test="${sessionScope.customerID == null}">
    <c:redirect url="/index.jsp"/>
</c:if>
<h2>Orders</h2>
<br/>
Welcome <c:out value="${sessionScope.customerName}" default="Anonimous"/>!
<br/><br/>
<a href='<c:url value="/customer_logout" />'>Logout</a>
</body>
</html>
