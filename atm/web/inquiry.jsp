<%--
  Created by IntelliJ IDEA.
  User: hkp
  Date: 2022/7/14
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>inquiry</title>
</head>
<body>
    <%
        Float abalance = (Float)request.getAttribute("abalance");
    %>
    当前余额为<%=abalance%>
    <div style="cursor: pointer" onclick="back()">返回</div>
    <script>
        function back(){
            window.history.back();
        }
    </script>
</body>
</html>
