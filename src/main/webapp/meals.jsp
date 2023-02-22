<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Meals</title>
    <style type="text/css">
        TABLE {
            width: 600px; /* Ширина таблицы */
            border: 1px solid black; /* Рамка вокруг таблицы */
        }
        TD, TH {
            padding: 3px; /* Поля вокруг содержимого ячеек */
        }
        TH {
            text-align: left; /* Выравнивание по левому краю */
        }
    </style>
</head>

<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<h3><a href="meals?action=update">Add Meal</a></h3>

<table cellspacing="0" border="1">
    <tr>
        <th>Date</th><th>Description</th><th>Calories</th><th>&nbsp;</th><th>&nbsp;</th>
    </tr>

    <c:forEach items="${mealList}" var="meal">
        <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.UserMeal"/>
        <tr>
            <td>
                <fmt:parseDate value="${meal.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="myParseDate"/>
                <fmt:formatDate value="${myParseDate}" pattern="yyyy-MM-dd' 'HH:mm"/>
            </td>
            <td><c:out value="${meal.description}"/></td>
            <td><c:out value="${meal.calories}"/></td>
            <td>
                <a href="meals?action=create&id=${meal.id}">Update</a>
            </td>
            <td>
                <a href="meals?action=delete&id=${meal.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
