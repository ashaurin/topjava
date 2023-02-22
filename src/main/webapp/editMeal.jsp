<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Edit meal</title>
</head>

<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>${param.action == 'create' ? 'Edit meal' : 'Create meal'}</h2>

<jsp:useBean id="meal" class = "ru.javawebinar.topjava.model.UserMeal" scope="request" />

<form method="post" action="meals">
    <input type="hidden" name="id" value="${meal.id}">
    <dl>
        <dt>DateTime:</dt>
        <dd><input type="datetime-local" value="${meal.dateTime}" name="dateTime"></dd>
    </dl>
    <dl>
        <dt>Description:</dt>
        <dd><input type="text" value="${meal.description}" name="description"></dd>
    </dl>
    <dl>
        <dt>DateTime:</dt>
        <dd><input type="number" value="${meal.calories}" name="calories"></dd>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()">Cancel</button>
</form>

</body>
</html>
