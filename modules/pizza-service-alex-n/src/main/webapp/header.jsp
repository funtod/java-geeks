<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<header>
    <h1>We have PIZZA! Order it right now!</h1>
    <nav>
        <ul>
            <li>
                <a class="nav-btn" href="${pageContext.request.contextPath}/index.html">home</a>
            </li>
            <li>
                <a class="nav-btn" href="${pageContext.request.contextPath}/index.html">about us</a>
            </li>
            <li>
                <a class="nav-btn" href="${pageContext.request.contextPath}/index.html">contacts</a>
            </li>
            <li>
                <a class="nav-btn" href="${pageContext.request.contextPath}/order">order</a>
                <c:if test="${fn:length(sessionScope.get('orderedPizza')) gt 0}">
                    <div class="order-counter">
                            ${fn:length(sessionScope.get('orderedPizza'))}
                    </div>
                </c:if>
            </li>
            <li>
                <a class="nav-btn" href="${pageContext.request.contextPath}/user">user</a>
                <c:if test="${not empty sessionScope.get('customer').name}">
                        <div class="user-name">
                            (${sessionScope.get('customer').name})
                        </div>
                </c:if>
            </li>
        </ul>
    </nav>
    <br>
</header>
