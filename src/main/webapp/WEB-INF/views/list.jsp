<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>List Page</h1>
    <hr>
    <c:forEach var="dto" items="${list}">
        ${dto.id} / ${dto.writer} / <a href="detail?id=${dto.id}">${dto.title}</a> / ${dto.content} <br>
    </c:forEach>
    
</body>
</html>