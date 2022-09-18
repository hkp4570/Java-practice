<%--
  Created by IntelliJ IDEA.
  User: hkp
  Date: 2022/7/14
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deposit</title>
</head>
<body>
    <%
        String aname = request.getParameter("aname");
    %>
    <form action="doDeposit" method="post">
        <input type="number" name="abalance" placeholder="请输入存款金额"><br>
        <input type="hidden" name="aname" value="<%=aname%>" >
        <input type="submit">
    </form>
</body>
</html>
