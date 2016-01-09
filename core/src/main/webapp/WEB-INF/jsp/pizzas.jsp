<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/3/2015
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Pizzas</title>
</head>
<body>
<h2>Pizzas</h2>
<div>
    <ul>
        <c:forEach var="pizza" items="${pizzas}">
            <li>${pizza.type}</li>
        </c:forEach>
    </ul>
</div>
<sf:form method="POST" modelAttribute="newPizza">
    <fieldset>
        <table cellspacing="0">
            <tr>
                <th><label for="type">New Pizza Type: </label></th>
                <td><sf:input path="type" size="15" id="type"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </fieldset>
</sf:form>
</body>
</html>
