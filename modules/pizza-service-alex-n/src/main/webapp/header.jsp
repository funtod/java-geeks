<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a  class="nav-btn" href="${pageContext.request.contextPath}/order">order</a>
                <c:if test="${counter > 0}">
                    <div class="order-counter">
                            ${counter}
                    </div>
                </c:if>
            </li>
        </ul>
    </nav>
    <br>
</header>
