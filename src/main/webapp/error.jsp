<%--
  Created by IntelliJ IDEA.
  User: AlehKastsiukovich
  Date: 06.03.2020
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage = "true"%>

<html>
<head>
    <title>Show Error Page</title>
    <style>
        body {
            background: #c7b39b url(images/bg.jpg);
            color: #fff;
        }
    </style>
</head>

<body>
<h1 align="center">Sorry, we have some issues or request is wrong...</h1>
        <div class="error-message-container">
            <p><h2 align="center">Error status: ${pageContext.errorData.statusCode}</h2></p>
            <p><h2 align="center">Request URI: ${pageContext.errorData.requestURI}</h2></p>
        </div>
</body>
</html>