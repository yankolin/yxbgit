<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head lang="en">
    <meta charset="UTF-8"/>
    <link href="<%=basePath %>static/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="<%=basePath %>static/css/esm-login.css" rel="stylesheet"/>
    <title>成勘院资源监控平台</title>
</head>

<body onload="init();">
<div style="background-image: url(<%=basePath %>static/img/back-login.jpeg);width:1920px;height:1280px">
    <div id="loginBody">
        <form class="form-horizontal" role="form" method="post" action="doLogin" onSubmit="return validate();">

            <input type="hidden" name="login_token" value="${login_token}" />
            <div id="header" class="form-control" style="height: 80px;background-color: transparent;border: none">
                <span style="text-align: center"><h3>欢迎登录</h3></span>
            </div>
            <div class="form-group">
                <label class="col-sm-2 col-sm-offset-1 control-label" style="height: 20px"></label>
            </div>
            <div class="form-group">
                <label for="userid" class="col-sm-2 col-sm-offset-1 control-label">用户名：</label>
                <div class="col-sm-7 ">
                    <input type="text" class="form-control" id="admin_name" name="admin_name" onblur="checkInputName(this,'admin_error')"  placeholder="请输入用户名"/>
                </div>
            </div>
            <div class="form-group">
                <label for="pwd" class="col-sm-2 col-sm-offset-1 control-label">密码：</label>

                <div class="col-sm-7 ">
                    <input type="password" class="form-control" id="admin_pwd" name="admin_pwd" placeholder="请输入密码"/>
                </div>
            </div>
            <div class="form-group">
                <label for="admin2" class="col-sm-2 col-sm-offset-1 control-label">验证码：</label>

                <div class="col-sm-3 ">
                    <input type="text" class="form-control" id="admin_check"
                           placeholder="请输入验证码" onkeyup="DiscodeCheck()"/>
                </div>
                <div class="col-sm-4"><label for="admin3" id="admin_check_text" class="control-label"></label>
                    <a href="javascript:void(0)" onclick="changDiscode()" style="color:#1589c9;">换一张</a></div>
            </div>
            <div class="form-control" style="background-color:whitesmoke;height: 40px;text-align: center;border: none">
                <span id="admin_error" style="text-align: center;color:red;border: none">${ error_login }</span>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-2" style="text-align: right">
                    <button type="submit" class="btn btn-primary">登录</button>
                </div>
                <div class="col-sm-offset-1 col-sm-2" style="text-align: right">
                    <button type="reset" id="resetBtn" class="btn btn-primary" onclick="resetClear()">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>

		 <script type="text/javascript" src="<%=basePath %>static/js/jquery-1.12.2.min.js"></script>
		 <script type="text/javascript" src="<%=basePath %>static/js/common.js"></script>
    <script type="text/javascript" src="<%=basePath %>static/js/esm-login.js"></script>
     <script type="text/javascript" src="<%=basePath %>static/js/md5.js"></script>

</body>
</html>