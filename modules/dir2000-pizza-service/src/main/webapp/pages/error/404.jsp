<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>404 Not found</title>
</head>
<body>
<h2>Sorry, there is not such a page:</h2>
<c:out value="${requestScope['javax.servlet.error.request_uri']}"/>
</body>
</html>
