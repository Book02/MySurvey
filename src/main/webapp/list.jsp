<%--
  Created by IntelliJ IDEA.
  User: 润书
  Date: 2021/6/16
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <c:forEach items="${list}" var="admin">
     ${admin.name}<br/>
 </c:forEach>
</body>
</html>
