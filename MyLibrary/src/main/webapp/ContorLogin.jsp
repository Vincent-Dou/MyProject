<%--
  Created by IntelliJ IDEA.
  User: 豆光耀
  Date: 2019/7/2
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <style>
        #baoti{
            font-family:楷体;
            font-size: 3.125rem;
            text-align: center;
        }
        #denlu{
            font-family: 楷体;
            font-size: 1.875rem;
            text-align: center;
        }
        #zhenti{
            position: absolute;
            top: 30%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        body{
            background: url(img/1.jpg);
        }
    </style>
</head>
<body>
<div id="zhenti">
    <div id="baoti">
        欢迎来到我的图书管理系统！管理员登录
    </div>
    <div id="denlu" >
        <form action="admin/login">
            <div>
                用户名<input name="adminid" />
            </div>
            <div>
                密&nbsp&nbsp码<input type="password" name="password"/>
            </div>
            <input type="submit" value="登录" />
        </form>
        <div>
        </div>
    </div>
</div>
</body>
</html>