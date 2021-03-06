<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	 <meta http-equiv="Access-Control-Allow-Origin" content="*">
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>成勘院资源监控系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath %>static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=basePath %>static/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS 
    <link href="css/plugins/morris.css" rel="stylesheet">-->

    <!-- Custom Fonts -->
    <link href="<%=basePath %>static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="chidi.html">成勘院资源监控系统</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
               <!--<li class="active">
                        <a href="javascript:void(0)" id="m_allstatus"><i class="fa fa-fw fa-home"></i>总体状态</a>
               </li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="javascript:void(0)" id="m_allstatus"><i class="fa fa-fw fa-home"></i>总体状态</a>
                    </li>
						 <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#status"><i class="fa fa-fw fa-bar-chart-o"></i> 设备运行状态 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="status" class="collapse">
                            <li>
                                <a href="javascript:void(0)" id="m_servicestatus"><i class="fa fa-fw fa-table"></i> 服务器状态</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-table"></i> 存储设备状态</a>
                            </li>
                        </ul>
                    </li>
						   <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#seekstatus"><i class="fa fa-fw fa-search"></i> 设备状态查询 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="seekstatus" class="collapse">
                            <li>
                                <a href="#"><i class="fa fa-fw fa-search"></i>服务器状态查询</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-search"></i>存储设备状态查询</a>
                            </li>
									<li>
                                <a href="#"><i class="fa fa-fw fa-warning"></i>预警信息查询</a>
                            </li>
                        </ul>
                    </li>
						   <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#equipman"><i class="fa fa-fw fa-wrench"></i> 设备管理<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="equipman" class="collapse">
                            <li>
                                <a href="#"><i class="fa fa-fw fa-edit"></i>设备阈值管理</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-plus"></i>设备添加</a>
                            </li>
                        </ul>
                    </li>
						  <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#sysman"><i class="fa fa-fw fa-wrench"></i> 系统管理<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="sysman" class="collapse">
                            <li>
                                <a href="#"><i class="fa fa-fw fa-pencil"></i>数据采集配置</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-search"></i>日志查询</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:void(0)" id="m_userman"><i class="fa fa-user"></i>用户管理</a>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">
				
            <div class="container-fluid">
					
										<div id="a_allstatus" class="a_content" style="height:650px;display: none"></div>
										<div id="a_servicestatus" class="a_content" style="height:650px;display: none"></div>
               <div id="a_userman" class="a_content" style="height:650px;display: none"></div>
            </div>
            <!-- /.container-fluid -->
				
        </div>
        <!-- /#page-wrapper -->
			<div id="page-floor">
					<div>@2016 版权所有：中国电建集团成都勘测设计研究院有限公司</div>
			</div>
    </div>
    <!-- /#wrapper -->
		
    <!-- jQuery -->
    <script src="<%=basePath %>static/js/jquery-1.11.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=basePath %>static/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script> -->
	 <script type="text/javascript">
		//$("#a_allstatus").show();
     // $('#a_allstatus').load('c.html');

		$(document).ready(function(){
			$("#m_allstatus").click(function(){
					hideAllDiv();
         		$("#a_allstatus").show();
         		$('#a_allstatus').load('c.html');
			});
			$("#m_servicestatus").click(function(){
					hideAllDiv();
     		$("#a_servicestatus").show();
     		$('#a_servicestatus').load('topo');
		});
			$("#m_userman").click(function(){
								hideAllDiv();
         		$("#a_userman").show();
         		$('#a_userman').load('userman');
			});
		});
		 function hideAllDiv() {
		   
	  	   if(document.getElementById){
	  			var ar = document.getElementsByTagName("div"); 
	  			var i;
	  			for(i=0;i<ar.length;i++){
	  				 if(ar[i].className == "a_content")
	  				 ar[i].style.display="none";	  				   
	  			}
	  		}
      		 }
	</script>

</body>

</html>
