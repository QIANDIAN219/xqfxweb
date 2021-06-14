<%@ page import="java.util.List" %>
<%@ page import="cn.edu.guet.been.User" %><%--
  Created by IntelliJ IDEA.
  User: Lanzh
  Date: 2021/6/6
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<User> userList = (List<User>)request.getAttribute("userlist");%>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
    <script>
        <%--window.onload = function() {--%>
        <%--    <%--%>
        <%--        for(int i = 0; i < userList.size(); i++){--%>
        <%--    %>--%>
        <%--    document.getElementById("a<%=i%>").onclick = function() {--%>
        <%--        document.getElementById("value").value = "<%=userList.get(i).getUserid()%>";--%>
        <%--        document.getElementById("form").submit();--%>
        <%--    }--%>
        <%--    <%--%>
        <%--        }--%>
        <%--    %>--%>
        <%--}--%>
    </script>
</head>
<body>
    <form action="delete" method="POST" id="form" target="nm_iframe">
        <input type="hidden" name="value" id="value" value="">
        <table>
            <thead>
                <tr>
                    <th>userid</th>
                    <th>username</th>
                    <th>address</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(int i = 0; i < userList.size(); i++){
                %>
                    <tr>
                        <td><%=userList.get(i).getUserid()%></td>
                        <td><%=userList.get(i).getUsername()%></td>
                        <td><%=userList.get(i).getAddress()%></td>
                        <td>
                            <a href="delete?id=<%=userList.get(i).getUserid()%>" name="a" id="a<%=i%>">删除</a>
                            <a href="updata.jsp?userid=<%=userList.get(i).getUserid()%>&username=<%=userList.get(i).getUsername()%>&address=<%=userList.get(i).getAddress()%>">修改</a>
                            <a href="add.jsp">添加</a>
                        </td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </form>
<%--    <iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>--%>
</body>
</html>
