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
<h2>Create an order, <c:out value="${sessionScope.customerName}" default="Anonimous"/></h2>
<br/>
<br/><br/>
<form method="post">
    <c:forEach var="pizza" items="${requestScope.pizzas}" varStatus="status">
        <p><input type="checkbox" name="pizza_id" value="<c:out value='${ pizza.id }'/>"/><c:out value='${ pizza.name }'/></p>
    </c:forEach>
    <input type="submit" value="Create">
</form>
<br/><br/>

<form action='<c:url value="/customers_logout" />'><input type="submit" value="Logout">
</form>
</body>
</html>
