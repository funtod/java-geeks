<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>All pizzas</title>
</head>
<body>
<a href='<c:url value="/" />'>Back to main page..</a>
<br/>
<br/>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Type</th>
        <th>Time to cook</th>
        <th>Price</th>
    </tr>
    <c:forEach var="pizza" items="${pizzas}" varStatus="status">
        <tr>
            <td><c:out value="${ pizza.id }"/></td>
            <td><c:out value="${ pizza.name }"/></td>
            <td><c:out value="${ pizza.pizzaType }"/></td>
            <td><c:out value="${ pizza.millisecondsToCook }"/></td>
            <td><c:out value="${ pizza.price }"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
