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
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3 style="text-align: center;">赣州汽修公司</h3>
<div class="col-sm-12" style="text-align: center; padding-top: 20px;">
    <img src="<%=path %>/img/company.jpg" style="width: 90%; height: 78%"/>
</div>
<div class="col-sm-12">
    <div class="col-sm-9"></div>
    <div class="col-sm-3">
        <b>联系方式：</b><span style="color: red;">0808-2342342</span>
        <br/>
        <b>公司官网：</b><a href="#" title="赣州汽修公司">www.baidu.com</a>
    </div>
</div>

<%@ include file="../common/rightMenu.jsp" %>
<script src="<%=path %>/js/contextmenu.js"></script>
</body>
</html>
