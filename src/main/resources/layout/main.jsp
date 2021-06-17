<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome</title>
  <link type="text/css" rel="stylesheet" href="css/header.css">
  <link type="text/css" rel="stylesheet" href="css/tableCss.css">
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
<table>
  <tr>
    <th>Event Name</th>
    <th>Prediction</th>
    <th>Bet</th>
    <th>Currency</th>
    <th>Result</th>
  </tr>
<c:forEach var="bet" items="${betList}">
  <tr>
    <td>${bet.event.name}</td>
    <td>${bet.winner}</td>
    <td>${bet.amount}</td>
    <td>${bet.currency.name}</td>
    <c:choose>
      <c:when test="${bet.winner==bet.real_winner}">
        <td>Win</td>
      </c:when>
      <c:otherwise>
        <td>Loss</td>
      </c:otherwise>
    </c:choose>
  </tr>
</c:forEach>
</table>
</body>
</html>
