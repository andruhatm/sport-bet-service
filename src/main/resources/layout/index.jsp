<jsp:useBean id="message" scope="request" type="java.lang.String"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html>
  <head>
    <link type="text/css" rel="stylesheet" href="css/header.css">
    <meta charset="UTF-8">
    <title>SportBets</title>
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

  <h1 align="center"><b>SportBets</b> - biggest service<br> for making bets on Cricket championships!</h1>
  </body>
</html>
