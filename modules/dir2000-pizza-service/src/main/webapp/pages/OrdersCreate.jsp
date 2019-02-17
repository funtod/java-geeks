<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>Orders</title>
</head>
<body>
<c:import url="/pages/Header.jsp"/>
<br/>
<br/>
<h2>Create an order, <c:out value="${sessionScope.customer.name}" default="Anonimous"/></h2>
<br/>
<br/><br/>
<form method="post">
    <c:forEach var="pizza" items="${requestScope.pizzas}" varStatus="status">
        <p><input type="checkbox" name="pizza_id" value="<c:out value='${ pizza.id }'/>"/><c:out value='${ pizza.name }'/></p>
    </c:forEach>
    <input type="submit" value="Create">
</form>
<br/><br/>
</form>
</body>
</html>
