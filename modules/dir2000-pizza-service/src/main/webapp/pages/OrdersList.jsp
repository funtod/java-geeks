<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>Orders</title>
</head>
<body>
<c:import url="/pages/Header.jsp"/>
<h2>Orders</h2>
<br/>
<form action='<c:url value="/orders_create" />'><input type="submit" value="Create an order"></form>
<c:if test="${requestScope.orders != null}">
    <form action='<c:url value="/orders_list" />' method="post"><input type="submit" value="Refresh"></form>
    Your orders:
    <table>
        <tr>
            <th>Id</th>
            <th>Pizzas</th>
            <th>Status</th>
            <th>Total</th>
        </tr>
        <c:forEach var="order" items="${requestScope.orders}" varStatus="status">
            <tr>
                <td><c:out value="${ order.id }"/></td>
                <td>
                    <c:forEach var="pizza" items="${order.pizzas}" varStatus="inner_status">
                        <c:out value="${ pizza.name }"/>;
                    </c:forEach>
                </td>
                <td><c:out value="${ order.orderStatus }"/></td>
                <td><c:out value="${ order.total }"/></td>
            </tr>
        </c:forEach>
    </table>
    <br/><br/>
</c:if>
</body>
</html>
