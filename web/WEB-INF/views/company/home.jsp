<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/1
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>主页</title>
</head>
<body onload="refresh()">
公司主页
<button onclick="sha()">aa</button>

<script>
    function refresh()
    {
        alert("刷新！");
    }
    function sha() {
        location.reload();
    }

</script>
</body>
</html>
