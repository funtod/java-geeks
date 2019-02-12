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
<div class="w3-responsive">
    <table class="w3-table-all">
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
</div>
</body>
</html>
