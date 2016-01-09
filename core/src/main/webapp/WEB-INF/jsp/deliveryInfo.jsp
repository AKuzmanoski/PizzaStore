<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/8/2015
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delivery Info</title>
</head>
<body>
<form action="AddressInfo.do" method="post">
<h1>Delivery Info</h1>
  <div>
    <table style="list-style-type: none;">
      <tr>
        <td>Name: </td>
        <td><input type="text" name="clientName" /></td>
      </tr>
      <tr>
        <td>Address: </td>
        <td><input type="text" name="clientAddress" /></td>
      </tr>
    </table>
  </div>
  <input type="submit" value="Submit">
</form>
</body>
</html>
