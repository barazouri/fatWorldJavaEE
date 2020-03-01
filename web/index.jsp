<%--
  Created by IntelliJ IDEA.
  User: barazouri
  Date: 26/02/2020
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page import="Entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home Page</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
</head>
<body>
<%
  Cookie cookies[] = request.getCookies();
  boolean cookieExist = false;
  if(cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("email"))
        cookieExist = true;
    }
    if(!cookieExist) {
      response.sendRedirect("login.jsp");
    }
    else {
      response.sendRedirect("https://fatworld.netlify.com/");
    }
  }
  else {
    response.sendRedirect("login.jsp");
  }

%>
