<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<meta name="viewport" content="device-width,initial-scale=1">
	<title> 成勘院</title>
	<link rel="stylesheet" href="/static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/static/css/monitor_show.css">
</head>
<body>
	<div class="myheading">
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">
						<!-- <img src="static/image/logo.png" style="width: 75px"> -->
						<p>成都院</p>
					</a>
				</div>
				<div class="nav navbar-collapse">
					<ul class="nav navbar-nav">
						<!-- <li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expand="false">信息浏览<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li class=""><a href="#">微博信息</a></li>
								<li><a href="#">论坛信息</a></li>
							</ul>
						</li> -->
						<li class=""><a href="/monitor/">首页</a></li>
						<li class=""><a href="/monitor/show">信息浏览</a></li>
						<li class=""><a href="/monitor/input">信息录入</a></li>
						<li class="active"><a href="/monitor/submited">已提交信息</a></li>
						
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expand="false"><span class="glyphicon glyphicon-user"></span>yalinpei<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li class="dropdown-menu-title"><span>Account Settings</span></li>
								<li><a href="#"><i class="glyphicon glyphicon-user"></i>Profile</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-off"></i>Logout</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="mybody container">
		<div class="row">
			<div class="leftmenu col-md-3">
				<br>
				<br>
				<div class="list-group">
					<a href="/monitor/" class="list-group-item">首页</a>
					<a href="/monitor/show" class="list-group-item">信息浏览</a>
					<a href="/monitor/input" class="list-group-item">信息录入</a>
					<a href="/monitor/submited" class="list-group-item active">已提交信息</a>
				</div>
			</div>
			<div class="content col-md-9">
				<ol class="breadcrumb">
					<li><a href="#" class="active">已提交信息</a></li>
				</ol>
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>标题</th>
								<th>日期</th>
								<th>标记</th>
							</tr>
							<thead>
								<tbody>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
									<tr>
										<td>我是标题我是标题我是标题我是标题</td>
										<td>2016-01-17</td>
										<td style="text-align: center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submit_modal">撤销</button></td>
									</tr>
								</tbody>
							</thead>
						</thead>
					</table>
			</div>
		</div>
	</div>
	<div class="modal fade" id="submit_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">备注</h4>
	      </div>
	      <div class="modal-body">
			<p>确定要撤销该条目吗?</p>	      	
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	</div>
	<footer class="nav navbar-inverse">
		<p>2016@安科创信</p>
	</footer>

<script src="/static/js/jquery-2.1.3.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script>
	$(".navbar-nav a").click(function(e){
		$(this).tab("show");
	})
</script>
</body>
</html>

