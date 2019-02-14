<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="content">
    <header>
        <h1>We have PIZZA! Order it right now!</h1>
        <nav>
            <ul>
                <li>
                    <form action="${pageContext.request.contextPath}/index.html" method="get">
                        <button class="nav-btn" name="home">home</button>
                    </form>
                </li>
                <li>
                    <form action="${pageContext.request.contextPath}/" method="get">
                        <button class="nav-btn" name="about us">about us</button>
                    </form>
                </li>
                <li>
                    <form action="${pageContext.request.contextPath}/" method="get">
                        <button class="nav-btn" name="contacts">contacts</button>
                    </form>
                </li>
                <li>
                    <form action="${pageContext.request.contextPath}/order" method="get">
                        <button class="nav-btn" name="order">order</button>
                        <c:if test="${counter > 0}">
                            <div class="order-counter">
                                    ${counter}
                            </div>
                        </c:if>
                    </form>
                </li>
            </ul>
        </nav>
        <br>
    </header>
    <form action="${pageContext.request.contextPath}/index.html" method="post">
        <div class="grid-wrapper">
            <c:forEach items="${pizzas}" var="pizza">
                <div class="grid-item">
                    <div class="pizza-div">
                        <img class="pizza-img" src="${pageContext.request.contextPath}/img/mmm.png" alt="pizza">
                        <div class="pizza-info">
                            <p>pizza: ${pizza.name}</p>
                            <p>type: ${pizza.pizzaType}</p>
                            <p>price: ${pizza.price}</p>
                            <button class="slide-btn add-btn" name="add-btn" value="${pizza.id}">add to order</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </form>
    <div class="push"></div>
</div>
<footer>
    Created by Alexander Nalivayko
    <br>
    Contact information: <a href="mailto:example@example.com">example@example.com</a>.
    <br>
    2019
</footer>
</body>
</html>
