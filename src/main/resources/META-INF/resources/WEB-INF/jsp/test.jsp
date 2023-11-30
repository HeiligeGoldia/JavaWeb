<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<h2>Registration Form</h2>
<form:form action="/create" method="post">
    <label for="username">Username:</label>
    <input type="text" name="username" id="username" required><br>

    <label for="password">Password:</label>
    <input type="password" name="password" id="password" required><br>

    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required><br>

    <label for="phone">Phone:</label>
    <input type="text" name="phone" id="phone" required><br>

    <label for="email">Email:</label>
    <input type="text" name="email" id="email" required><br>

    <label for="address">Address:</label>
    <input type="text" name="address" id="address" required><br>

    <input type="submit" value="Register">
</form:form>
</body>
</html>
