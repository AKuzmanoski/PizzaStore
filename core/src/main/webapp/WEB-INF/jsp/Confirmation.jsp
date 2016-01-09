<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/8/2015
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
  <h1>Confirmation</h1>
  <div>
    <table>
      <tr>
        <td>Pizza Type: </td>
        <td>${order.getPizza()}</td>
      </tr>
      <tr>
        <td>Name: </td>
        <td>${order.getClientName()}</td>
      </tr>
      <tr>
        <td>Address: </td>
        <td>${order.getClientAddress()}</td>
      </tr>
    </table>
  </div>
</body>
</html>
