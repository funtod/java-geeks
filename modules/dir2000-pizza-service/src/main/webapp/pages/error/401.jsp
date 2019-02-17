<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>401 Unauthorized </title>
</head>
<body>
<h2>Sorry, you should login to reach the page:</h2>
<c:out value="${requestScope['request_uri']}"/>
</body>
</html>