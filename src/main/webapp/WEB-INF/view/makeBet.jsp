<jsp:useBean id="event" scope="application" class="ru.student.data.model.Event"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>New Bet</title>
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
<%----%>

<h1>Place your bet</h1>
<div>
  <form action="${pageContext.request.contextPath}/bet" method="post">
    <c:out value="${event.name}"/>

    <p><select name="winner" size="1" >
      <option selected value="home">${event.home}</option>
      <option value="away">${event.away}</option>
    </select>

    <input id="number" name="money" type="number" value="0">

    <p><select name="currency" size="1" >
      <option selected value="1">DOL</option>
      <option value="2">RUB</option>
      <option value="3">EUR</option>
    </select>
    <div>
      <button type="submit" class="button button1" value="${event.name}" name="event">Make a bet</button>
    </div>
  </form>
</div>
</body>
</html>
