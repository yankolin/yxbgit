<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
<script src="static/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	  $("#getJsonValue").click(function(){
		  var username = document.getElementById("usernameJson").value ;
		  alert("sdfsd");
		  alert(username);
	  //htmlobj=$.ajax({url:"/getJson.do",async:false});
	  
		  $.ajax({
	            type: "post",//数据发送的方式（post 或者 get）
	            url: "/doJson",//要发送的后台地址
	            data: {username:username},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
	            dataType: "json",//后台处理后返回的数据格式
	            success: function (data) {//ajax请求成功后触发的方法
	            	alert('请求成功');
	               $("#myDiv").html(data);
	            },
	            error: function (msg) {//ajax请求失败后触发的方法
	            	alert(msg);//弹出错误信息
	            }
	        });
	});
	  
	  });

</script>
</head>
<body>

	<div style="margin:0 auto; padding-top: 100px;" align="center">
		<form action="doLogin.do" method="post">
			<p>
				<span>用户名：</span><input type="text" name="username">
			</p>
			<p>
				<span>密    码：</span><input type="password" name="password">
			</p>
			<p>
				<input type="submit" value="登录">
			</p>
			<p style="color: red;">
				${ error }
			</p>			
		</form>
			<form action="doDelete.do" method="post">
			<p>
				<span>用户名：</span><input type="text" name="username">
			</p>
			<p>
				<span>密    码：</span><input type="password" name="password">
			</p>
			<p>
				<input type="submit" value="删除">
			</p>
			<p style="color: red;">
				${ errorDe }
			</p>			
		</form>
			<form action="doAdd.do" method="post">
			<p>
				<span>用户名：</span><input type="text" name="username">
			</p>
			<p>
				<span>密    码：</span><input type="password" name="password">
			</p>
			<p>
				<input type="submit" value="增加">
			</p>
			<p style="color: red;">
				${ errorAdd }
			</p>			
		</form>
			<form action="doUpdate.do" method="post">
			<p>
				<span>用户名：</span><input type="text" name="username">
			</p>
			<p>
				<span>密    码：</span><input type="password" name="password">
			</p>
			<p>
				<input type="submit" value="修改">
			</p>
			<p style="color: red;">
				${ errorUpdate }
			</p>			
		</form>
		

			<p>
				<span>用户名：</span><input type="text" id="usernameJson">
			</p>
				<input type="button" id="getJsonValue"  value="Json">
		<div id="myDiv"><h2>通过 AJAX 改变文本</h2></div>

		
	</div>

</body>
</html>