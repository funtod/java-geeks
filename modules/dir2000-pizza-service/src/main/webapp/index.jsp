<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pizza service</title>
    <link rel="stylesheet" href="css/w3.css" type="text/css"/>
</head>
<body>
<div class="w3-container w3-teal">
    <h2>Pizza service</h2>
</div>
<div class="w3-container">
    <h3>Customers</h3>
    <div class="w3-bar w3-padding-large w3-padding-24">
        <a href='<c:url value="/register_customer" />'>Register</a><br/>
        <a href='<c:url value="/login" />'>Login</a>
    </div>
</div>
<div class="w3-container">
    <h3>Pizzas</h3>
    <div class="w3-bar w3-padding-large w3-padding-24">
        <a href='<c:url value="/show_all_pizzas" />'>Show all pizzas</a><br/>
        <a href='<c:url value="/create_order" />'>Create an order</a>
    </div>
</div>
</body>
</html>