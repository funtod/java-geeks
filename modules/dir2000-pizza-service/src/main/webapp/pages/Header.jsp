<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <c:if test="${sessionScope.customer == null}">
        <a href='<c:url value="/customers_register" />'>Register</a>
        <a href='<c:url value="/customers_login" />'>Login</a>
    </c:if>
    <c:if test="${sessionScope.customer != null}">
        Customer: "<c:out value="${sessionScope.customer.name}"/>"
        <form action='<c:url value="/customers_logout" />'><input type="submit" value="Logout"></form>
    </c:if>
    <hr/>
</header>