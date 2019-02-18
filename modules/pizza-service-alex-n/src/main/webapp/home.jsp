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
    <jsp:include page="header.jsp"></jsp:include>

    <div class="grid-wrapper">
        <c:forEach items="${pizzas}" var="pizza">
            <form action="${pageContext.request.contextPath}/index.html" method="post">
                <div class="grid-item">
                    <div class="pizza-div">
                        <img class="pizza-img" src="${pageContext.request.contextPath}/img/mmm.png" alt="pizza">
                        <div class="pizza-info">
                            <p>pizza: ${pizza.name}</p>
                            <p>type: ${pizza.pizzaType}</p>
                            <p>price: ${pizza.price}</p>
                            <input type="hidden" name="pizzaId" value="${pizza.id}">
                            <input type="submit" class="slide-btn add-btn" name="add-btn" value="add to order">
                        </div>
                    </div>
                </div>
            </form>
        </c:forEach>
    </div>
    <div class="push"></div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
