<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="content">
    <jsp:include page="header.jsp"></jsp:include>

    <form action="${pageContext.request.contextPath}/registration" method="post">
        <div class="user-data">
            <p class="error">${errMsg}</p>
            <p>${msg}</p>
            <p>New user registration</p>
            <p>User name:</p>
            <input class="usr-field" type="text" name="userName"/>
            <p>Password:</p>
            <input class="usr-field" type="password" name="userPass">
            <p>Phone:</p>
            <input class="usr-field" type="tel" name="userPhone"/>
            <div class="usr-data-btns">
                <input class="slide-btn create-btn" type="submit" name="register" value="register">
            </div>
        </div>
    </form>

    <div class="push"></div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
