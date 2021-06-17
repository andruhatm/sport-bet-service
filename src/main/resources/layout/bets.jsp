<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Open bets</title>
  <link rel="stylesheet" href="css/header.css">
</head>
<body>
<%--header--%>
<div class="header">
  <a href="${pageContext.request.contextPath}/" class="logo">SportBets</a>
  <div class="header-right">
    <a href="${pageContext.request.contextPath}/mybets">My Bets</a>
    <a href="${pageContext.request.contextPath}/events">Events</a>
    <a class="active" href="${pageContext.request.contextPath}/account">Account</a>
  </div>
</div>
</body>
</html>
