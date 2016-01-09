<%--
  Created by IntelliJ IDEA.
  User: ristes
  Date: 11/9/15
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<form action="PizzaOrder.do" method="post">
    <h1>Order Pizza</h1>

    <div>
        <c:forEach var="pizza" items="${pizzas}">
            <input type="radio" name="pizzaId" value="${pizza.id}"/> ${pizza.type} <br/>
        </c:forEach>
    </div>


    <input type="checkbox" id="remember" name="remember" value="true"/> Remember my choice <br/>

    <input type="submit" value="Submit"/>
</form>

</body>
</html>
