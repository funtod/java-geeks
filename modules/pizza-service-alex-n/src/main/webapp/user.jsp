<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="content">
    <jsp:include page="header.jsp"></jsp:include>
    <c:if test="${not empty sessionScope.get('customer')}">
        <div class="user-data">
            <p class="aligner">You entered like: ${sessionScope.get('customer').name}</p>
            <form action="${pageContext.request.contextPath}/user" method="post">
                <div class="exit-div">
                    <input class="slide-btn dlt-btn aligner" type="submit" name="exit" value="exit">
                </div>
            </form>
        </div>
    </c:if>
    <c:if test="${empty sessionScope.get('customer')}">
        <form action="${pageContext.request.contextPath}/user" method="post">
            <div class="user-data">
                <p class="error">${errMsg}</p>
                <p>User name:</p>
                <input class="usr-field" type="text" name="userName"/>
                <p>Password:</p>
                <input class="usr-field" type="password" name="userPass">
                <div class="usr-data-btns">
                    <a class="slide-btn  dlt-btn ref-btn" href="${pageContext.request.contextPath}/registration">create
                        new user</a>
                    <input class="slide-btn create-btn" type="submit" name="signIn" value="sign in">
                </div>
            </div>
        </form>
    </c:if>
    <div class="push"></div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
