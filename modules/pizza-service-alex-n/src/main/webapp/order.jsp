<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>order</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="content">
    <jsp:include page="header.jsp"></jsp:include>
    <c:choose>
        <c:when test="${count > 1}">
            <h2>There are ${count} pizzas in your order. To continue, enter your name and press "order".</h2>
        </c:when>
        <c:when test="${count > 0}">
            <h2>There is ${count} pizza in your order. To continue, enter your name and press "order".</h2>
        </c:when>
        <c:otherwise>
            <h2>There are no pizza in your order. You can add it on home page.</h2>
        </c:otherwise>
    </c:choose>
    <c:if test="${count > 0}">
    <ul>
        <div class="order-list">
            <c:forEach items="${pizzas}" var="pizza">
                <li>Pizza name: ${pizza.name} - type: ${pizza.pizzaType} - price: ${pizza.price}</li>
            </c:forEach>
        </div>
    </ul>
    <form action="${pageContext.request.contextPath}/order" method="post">
        <div class="user-data">
            <p>Your name:</p>
            <input class="usr-field" type="text" name="name">
            <p>Your phone:</p>
            <input class="usr-field" type="tel" name="tel">
            <div class="usr-data-btns">
                <input type="submit" class="slide-btn dlt-btn" name="usr-data-btn" value="delete all">
                <input type="submit" class="slide-btn create-btn" name="usr-data-btn" value="create order">
            </div>
        </div>
        </c:if>
    </form>
    <div class="push"></div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
