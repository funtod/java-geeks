<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>order</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="content">
    <jsp:include page="header.jsp"></jsp:include>
    <c:choose>
        <c:when test="${fn:length(sessionScope.get('orderedPizza')) gt 1}">
            <h2>There are ${fn:length(sessionScope.get('orderedPizza'))} pizzas in your order.</h2>
        </c:when>
        <c:when test="${fn:length(sessionScope.get('orderedPizza')) gt 0}">
            <h2>There is ${fn:length(sessionScope.get('orderedPizza'))} pizza in your order.</h2>
        </c:when>
        <c:otherwise>
            <h2>There are no pizza in your order. You can add it on home page.</h2>
        </c:otherwise>
    </c:choose>
    <c:if test="${fn:length(sessionScope.get('orderedPizza')) gt 0}">
        <ul>
            <div class="order-list">
                <c:forEach items="${pizzas}" var="pizza">
                    <li>Pizza name: ${pizza.name} - type: ${pizza.pizzaType} - price: ${pizza.price}</li>
                </c:forEach>
            </div>
        </ul>

        <div class="user-data">
            <form action="${pageContext.request.contextPath}/order" method="post">
                <c:if test="${empty sessionScope.get('customer').name}">
                    <p>You need to register or sign in to make orders. Press button below to get to sign in/registration
                        page</p>
                    <div class="usr-data-btns">
                        <input type="submit" class="slide-btn dlt-btn" name="usr-data-btn" value="delete all">
                        <a class="slide-btn  dlt-btn ref-btn" href="${pageContext.request.contextPath}/user">
                            sign in/registration
                        </a>
                    </div>
                </c:if>
                <c:if test="${not empty sessionScope.get('customer').name}">
                    <div class="usr-data-btns">
                        <input type="submit" class="slide-btn dlt-btn" name="usr-data-btn" value="delete all">
                        <input type="submit" class="slide-btn create-btn" name="usr-data-btn" value="create order">
                    </div>
                </c:if>
            </form>
        </div>

    </c:if>
    <div class="push"></div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
