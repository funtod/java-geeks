<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pizza service</title>
</head>
<body>
<h2>Pizza service</h2>
<h3>Pizzas</h3>
<a href='<c:url value="/show_all_pizzas" />'>Show all pizzas</a><br/>

<h3>Customers</h3>
<a href='<c:url value="/register_customer" />'>Register</a><br/>
<a href='<c:url value="/login" />'>Login</a>
</body>
</html>