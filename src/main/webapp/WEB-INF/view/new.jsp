<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/css/style.css" var="jstlCss" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="css/header.css">
  <link rel="stylesheet" href="css/cards.css">
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

  <c:forEach var="event" items="${dbEventsList}">
    <div class="allcards" >
      <div class="card mb-3" style="max-width: 650px;">
        <div class="row no-gutters">
          <div class="col-md-4">
            <img src="${pageContext.request.contextPath}/images/cricket.png" class="card-img" alt="...">
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <form action="${pageContext.request.contextPath}/bet" method="get">
              <div>
                <div>
                  <h5 style="display: inline" class="card-title">${event.name}</h5>
                </div>
                <div id="np-results">
                <div>
                  <button type="submit" class="button button1" value="${event.name}" name="event">Bet</button>
                </div>
              </div>
              <p class="card-text">Competitors: <br> Home: ${event.home} <br> VS <br> Away: ${event.away}
              </p>
              <p class="card-text"><small class="text-muted">Date of competition ${formatter.format(event.date)}</small></p>
            </div>
           </form>
          </div>
        </div>
      </div>
    </div>
  </c:forEach>

</body>
</html>
