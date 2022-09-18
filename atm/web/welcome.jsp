<%--
  Created by IntelliJ IDEA.
  User: hkp
  Date: 2022/7/14
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
    <%
        String aname = request.getParameter("aname");
    %>
    <div>欢迎<%=aname%>进入atm系统</div>
    请输入操作选项<br>
    <a href="inquiry?aname=<%=aname%>">查询</a><br>
    <a href="deposit?aname=<%=aname%>">存款</a><br>
    <a href="">取款</a><br>
    <a href="">转账</a><br>
</body>
</html>
