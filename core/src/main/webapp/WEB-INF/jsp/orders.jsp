<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/3/2015
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Pizza Orders</title>
</head>
<body>
<h2>Pizza Orders</h2>
<div>
  <ul>
    <c:forEach var="order" items="${listOrders}">
      <li><b>${order.getClientName()}</b> from <b>${order.getClientAddress()}</b> ordered <b>${order.pizza} pizza</b></li>
    </c:forEach>
  </ul>
</div>
</body>
</html>
