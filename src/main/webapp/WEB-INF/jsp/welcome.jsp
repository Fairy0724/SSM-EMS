<%@page import="edu.ems.entity.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.ems.entity.*" %>
<% String path = request.getContextPath(); %>
<!--229970615 李松蔓-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.css" rel="stylesheet">
    <link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">
    <script>
        var myVar = setInterval(function () {
            myTimer()
        }, 1000);

        function myTimer() {
            var d = new Date();
            var t = d.toLocaleTimeString();
            document.getElementById("time").innerHTML = t;
        }

        // 针对上班签到和下班签退分别设置不同的提示信息
        function showSignInMessage() {
            parent.layer.alert('签到成功！');
        }

        function showSignOutMessage() {
            parent.layer.alert('签退成功！');
        }
    </script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="jumbotron">
                <div style="margin-left: 250px">
                    <p>&nbsp;</p>
                    <%Employee employee = (Employee) session.getAttribute("loged"); %>
                    <h1><%=employee.getName() %>
                    </h1>
                    <p>&nbsp;</p>
                    <p>欢迎登录 美好的一天又开始了！</p>
                    <p id="time">&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>

    <a href="<%=path %>/attendance/addStart.do?employeeNumber=<%=employee.getEmployeeNumber() %>"
       class="btn btn-info btn-lg" onclick="showSignInMessage()">&nbsp;上班签到&nbsp;</a>&nbsp; &nbsp; &nbsp;
    <a href="<%=path %>/attendance/addEnd.do?employeeNumber=<%=employee.getEmployeeNumber() %>"
       class="btn btn-info btn-lg" onclick="showSignOutMessage()">&nbsp;下班签退&nbsp;</a>
                    </p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="<%=path%>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=path%>/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="<%=path%>/js/content.js?v=1.0.0"></script>

<!-- layer javascript -->
<script src="js/plugins/layer/layer.min.js"></script>

</body>
</html>




