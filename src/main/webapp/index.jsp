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
    <h1 align="center">XML file parser</h1>
    <form action="upload" method="post" enctype="multipart/form-data">
      <p align="center"><input type="file" value="Choose file" name="file" multiple accept="application/xml"></p>
    </form>
    <form>
      <p align="center"><input type="button" style="width: 95px;height: 50px" value="DOM parser"></p>
      <p align="center"><input type="button" style="width: 95px;height: 50px" value="SAX parser"></p>
      <p align="center"><input type="button" style="width: 95px;height: 50px" value="STAX parser"></p>
    </form>
  </body>
</html>
