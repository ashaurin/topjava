<%--
  Created by IntelliJ IDEA.
  User: 16906381
  Date: 21.02.2023
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Bot</title>
</head>
<body>
<section>
  <h3>Bot info</h3>
  <jsp:useBean id="bot" scope="request" type="ru.javawebinar.topjava.model.Bot"/>
  <tr>
    <td>ID: ${bot.id} | Name: ${bot.name} | Serial number: ${bot.serial}</td>
    <td><a href="bot?action=update">Update</a></td>
  </tr>
</section>
</body>
</html>
