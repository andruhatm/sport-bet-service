<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
  <title>Login</title>
  <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="container">
  <form action="${pageContext.request.contextPath}/login" method="post">
    <div class="row">
      <h2 style="text-align:center">Login to your SportBets Account</h2>
      <div class="col">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="submit" value="Login">
      </div>
    </div>
  </form>
</div>

<div class="bottom-container">
  <div class="row">
    <div class="col">
      <a href="${pageContext.request.contextPath}/register" style="color:white" class="btn">Sign up</a>
    </div>
  </div>
</div>

<style>
  body {
    font-family: Arial, Helvetica, sans-serif;
  }
  * {
    box-sizing: border-box;
  }
  /* style the container */
  .container {
    position: relative;
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px 0 30px 0;
  }
  /* style inputs and link buttons */
  input,
  .btn {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 4px;
    margin: 5px 0;
    opacity: 0.85;
    display: inline-block;
    font-size: 17px;
    line-height: 20px;
    text-decoration: none; /* remove underline from anchors */
  }
  input:hover,
  .btn:hover {
    opacity: 1;
  }
  /* style the submit button */
  input[type=submit] {
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
  }
  input[type=submit]:hover {
    background-color: #45a049;
  }
  .col{
    width: 35%;
    margin: auto;
    padding: 1px;
    margin-top: 6px;
  }
  /* Clear floats after the columns */
  .row:after {
    content: "";
    display: table;
    clear: both;
  }
  /* hide some text on medium and large screens */
  .hide-md-lg {
    display: none;
  }
  /* bottom container */
  .bottom-container {
    width: 35%;
    margin: auto;
    margin-top: 6px;
    padding: 0 50px;
    text-align: center;
    background-color: #666;
    border-radius: 0px 0px 4px 4px;
  }
  /* Responsive layout - when the screen is less than 650px wide, make the two columns stack on top of each other instead of next to each other */
  @media screen and (max-width: 650px) {
    .col {
      width: 100%;
      margin-top: 0;
    }
  }
</style>

</body>
</html>
