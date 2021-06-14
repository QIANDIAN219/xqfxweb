<%@ page import="java.util.List" %>
<%@ page import="cn.edu.guet.been.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Lanzh
  Date: 2021/6/14
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

    </style>
    <script>

    </script>
</head>
    <body>
        <%
            String userid = request.getParameter("userid");
            String username = request.getParameter("username");
            String address = request.getParameter("address");
        %>
        <form action="updata">
            <input type="hidden" name="userid" value="<%=userid%>">
            姓名：<input type="text" name="username" value="<%=username%>">
            地址：<input type="text" name="address" value="<%=address%>">
            <button type="submit" style="cursor: pointer">修改</button>
        </form>
    </body>
</html>