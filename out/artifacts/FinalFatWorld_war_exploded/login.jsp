<%@ page import="java.net.CookieHandler" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sign in</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<%
    Cookie cookies[] = request.getCookies();
    if(cookies != null)
        for(Cookie cookie : cookies)
            if(cookie.getName().equals("email"))
                response.sendRedirect("index.jsp");
%>
<form action="<%=request.getContextPath()%>/Login" method="post">
    <div class="container">
        <label for="email"><b>Username</b></label>
        <input type="email" placeholder="Enter Email" name="email" required>
        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <button type="submit">Login</button>
        <%
            if(request.getAttribute("validateUser") != null && !(boolean)request.getAttribute("validateUser")){
        %>
        <div class="text-center p-t-54">
						<span class="txt1">
                            username or password incorrect
						</span>
        </div>
        <% }%>
        <div class="container signin">
            <p>Already have an account? <a href="register.jsp">Sign in</a>.</p>
        </div>
    </div>
</form>

</body>
</html>
