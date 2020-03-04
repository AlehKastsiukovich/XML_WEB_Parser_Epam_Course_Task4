<%--
  Created by IntelliJ IDEA.
  User: AlehKastsiukovich
  Date: 01.03.2020
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>XML parser</title>
  <title>Background</title>
  <style>
    body {
      background: #c7b39b url(images/bg.jpg);
      color: #fff;
    }
  </style>
</head>
<body>
    <div class ="maintext">
    <h1 align="center">XML file parser</h1>
    <form action="mainservlet" method="post" enctype="multipart/form-data">
        <p align="center"><input type="file" name="file" accept="application/xml"></p>
        <p align="center"><input type="submit"/></p>
    </form>

    <form action="${pageContext.request.contextPath}/mainservlet" method="post">
        <p align="center"><button type="submit" style="width: 95px;height: 50px" name="button" value="button1">DOM parser</button></p>
        <p align="center"><button type="submit" style="width: 95px;height: 50px" name="button" value="button2">SAX parser</button></p>
        <p align="center"><button type="submit" style="width: 95px;height: 50px" name="button" value="button3">STAX parser</button></p>
    </form>
    </div>
  </body>
</html>

