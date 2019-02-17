<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pizza service</title>
</head>
<body>
<c:import url="/pages/Header.jsp"/>
<h2>Pizza service</h2>
<h3>Pizzas</h3>
<a href='<c:url value="/pizzas_show_all" />'>Show all pizzas</a><br/>
</body>
</html>