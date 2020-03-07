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
        <form action="mainServlet" method="post" enctype="multipart/form-data">
        <p align="center"><input type="file" name="file" value="Choose File"/></p>
        <p align="center"><button type="submit" style="width: 95px;height: 50px" name="DOM_PARSER" value="DOM_PARSER">DOM parser</button></p>
        <p align="center"><button type="submit" style="width: 95px;height: 50px" name="SAX_PARSER" value="SAX_PARSER">SAX parser</button></p>
        <p align="center"><button type="submit" style="width: 95px;height: 50px" name="STAX_PARSER" value="STAX_PARSER">STAX parser</button></p>
    </form>
    </div>
  </body>
</html>

