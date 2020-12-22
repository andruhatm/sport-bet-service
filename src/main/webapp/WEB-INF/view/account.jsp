<jsp:useBean id="user" scope="application" class="ru.student.data.model.User"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Account</title>
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
<style>
  .acc{
    margin: auto;
    display: list-item;
  }
  .picture{
    display: list-item;
  }
</style>

<h1>My Account</h1>
<div>
  <form action="${pageContext.request.contextPath}/logout" method="post">
<div class="acc">
    <div>
      <h3>Name: <c:out value="${user.username}"/></h3>
    </div>
    <div class="picture">
      <h3>Your photo:</h3>

      <img src="data:image/jpeg;base64,${base64DataString}"  width="150" height="150" alt=""/>
    </div>
</div>
    <input type="submit" value="Sign Out"/>
  </form>
</div>
</body>
</html>
