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

    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
	 <meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <title>成勘院资源监控系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath %>static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=basePath %>static/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS 
    <link href="css/plugins/morris.css" rel="stylesheet">-->

    <!-- Custom Fonts -->
    <link href="<%=basePath %>static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <label id="login_name">${user_name }</label> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="javascript:void(0)" id="profile"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>                       
                        <li>
                            <a href="javascript:void(0)" id="alterpwd"><i class="fa fa-fw fa-gear"></i> Alter Password</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="<%=basePath %>doLoginout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="<%=basePath %>main"><i class="fa fa-fw fa-home"></i>总体状态</a>
                    </li>
						 <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#status"><i class="fa fa-fw fa-bar-chart-o"></i> 设备运行状态 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="status" class="collapse">
                            <li>
                                <a href="<%=basePath %>servicetopo"><i class="fa fa-fw fa-table"></i> 服务器状态</a>
                            </li>
                            <li>
                                <a href="<%=basePath %>stortopo"><i class="fa fa-fw fa-table"></i> 存储设备状态</a>
                            </li>
                        </ul>
                    </li>
						   <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#seekstatus"><i class="fa fa-fw fa-search"></i> 设备状态查询 <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="seekstatus" class="collapse">
                            <li>
                                <a href="<%=basePath %>seekserver"><i class="fa fa-fw fa-search"></i>服务器状态查询</a>
                            </li>
                            <li>
                                <a href="<%=basePath %>seekstor"><i class="fa fa-fw fa-search"></i>存储设备状态查询</a>
                            </li>
									<li>
                                <a href="<%=basePath %>prewarninginfo?page=1"><i class="fa fa-fw fa-warning"></i>预警信息查询</a>
                            </li>
                        </ul>
                    </li>
						   <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#equipman"><i class="fa fa-fw fa-wrench"></i> 设备管理<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="equipman" class="collapse">
                            <li>
                                <a href="<%=basePath %>initthrehold"><i class="fa fa-fw fa-edit"></i>设备阈值管理</a>
                            </li>
                            <li>
                                <a href="<%=basePath %>deviceman"><i class="fa fa-fw fa-plus"></i>设备添加</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#report"><i class="fa fa-fw fa-table"></i> 报表中心<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="report" class="collapse">
                            <li>
                                <a href="<%=basePath %>servicestatusquery?page=1"><i class="fa fa-fw fa-search"></i>服务器状态报表</a>
                            </li>
                            <li>
                                <a href="<%=basePath %>seekmemstatus"><i class="fa fa-fw fa-search"></i>存储设备状态报表</a>
                            </li>
                        </ul>
                    </li>
						  <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#sysman"><i class="fa fa-fw fa-wrench"></i> 系统管理<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="sysman" class="collapse">
                            <li>
                                <a href="<%=basePath %>dataconfig"><i class="fa fa-fw fa-pencil"></i>数据采集配置</a>
                            </li>
                            <li>
                                <a href="<%=basePath %>systemloginfo?page=1"><i class="fa fa-fw fa-search"></i>日志查询</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="<%=basePath %>inituserman"><i class="fa fa-user"></i>用户管理</a>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
        </div>
        
            <!-- alterprofile modal-->
                 <div class="modal fade" id="btnUMAlterprofileModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                   <div class="modal-dialog" role="document">
                     <div class="modal-content">
                       <div class="modal-header">
                         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                             <span aria-hidden="true">&times;</span>
                         </button>
                         <h4 class="modal-title" id="lbl_userman_modifyTile">修改</h4>
                       </div>
                       <div class="modal-body">
                             <form class="form-horizontal">
                                 <input type="hidden" id="txtUserprofileid"/>
                                 <div class="form-group">
                                     <label class="col-sm-3 control-label" for="txtUMAlterprofileUsername">用户名：</label>
                                     <div class="col-sm-9">
                                         <input type="text" class="form-control" id="txtUMAlterprofileUsername" disabled="disabled" placeholder="用户名">
                                     </div>
                                 </div>
                                 <div class="form-group">
                                     <label class="col-sm-3 control-label" for="txtUMAlterprofileEmail">邮箱地址：</label>
                                     <div class="col-sm-9">
                                         <input type="text" class="form-control" id="txtUMAlterprofileEmail"  onblur="checkAddEmail(this,'lblUMAlterprofileErrortip')" placeholder="example@xx.com">
                                     </div>
                                 </div>
                                 <div class="form-group">
                                     <label for="sltUMAlterprofileAlert" class="col-sm-3 control-label">是否接收预警邮件:</label>
                                     <div class="col-sm-9">
                                         <select class="form-control " id="sltUMAlterprofileAlert">
                                             <option value="1">否</option>
                                             <option value="0">是</option>
                                         </select>
                                     </div>
                                 </div>
                                 <div class="form-group" style="text-align: center">
                                     <label class="control-label" style="color: red;" id="lblUMAlterprofileErrortip"></label>
                                 </div>
                             </form>     
                       </div>
                       <div class="modal-footer">
                         <button type="button" class="btn btn-default" id="btnUMAlterprofileClose" data-dismiss="modal">关闭</button>
                         <button type="button" class="btn btn-primary"  onClick="btn_userman_alterprofile_submit();">修改</button>
                       </div>
                     </div>
                   </div>
                 </div>
             <!-- ./alterprofile modal-->
             
              <!-- alterpwd modal-->
                 <div class="modal fade" id="btnUMAlterpwdModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                   <div class="modal-dialog" role="document">
                     <div class="modal-content">
                       <div class="modal-header">
                         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                             <span aria-hidden="true">&times;</span>
                         </button>
                         <h4 class="modal-title" id="lbl_userman_modifyTile">修改密码</h4>
                       </div>
                       <div class="modal-body">
                             <form class="form-horizontal">
                                 <input type="hidden" id="txtUserprofileid"/>
                                 <div class="form-group">
                                     <label class="col-sm-3 control-label" for="txtUMAlterpwdUsername">用户名：</label>
                                     <div class="col-sm-9">
                                         <input type="text" class="form-control" id="txtUMAlterpwdUsername" disabled="disabled" placeholder="用户名">
                                     </div>
                                 </div>
                                 <div class="form-group">
                                     <label class="col-sm-3 control-label" for="txtUMAlteroldpwd">原密码：</label>
                                     <div class="col-sm-9">
                                         <input type="password" class="form-control" id="txtUMAlteroldpwd"  onblur="checkAddPwd(this,'lblUMAlterpwdErrortip')" placeholder="输入旧密码">
                                     </div>
                                 </div>
                                 <div class="form-group">
                                     <label for="txtUMAlternewpwd" class="col-sm-3 control-label">新密码:</label>
                                    <div class="col-sm-9">
                                         <input type="password" class="form-control" id="txtUMAlternewpwd"  onblur="checkAddPwd(this,'lblUMAlterpwdErrortip')" placeholder="密码长度大于6位">
                                     </div>
                                 </div>
                                  <div class="form-group">
                                     <label for="txtUMAlterrenewpwd" class="col-sm-3 control-label">确认新密码:</label>
                                    <div class="col-sm-9">
                                         <input type="password" class="form-control" id="txtUMAlterrenewpwd"  onblur="checkAddRepwd(document.getElementById('txtUMAlternewpwd'),this,'lblUMAlterpwdErrortip')" placeholder="密码长度大于6位">
                                     </div>
                                 </div>
                                 <div class="form-group" style="text-align: center">
                                     <label class="control-label" style="color: red;" id="lblUMAlterpwdErrortip"></label>
                                 </div>
                             </form>     
                       </div>
                       <div class="modal-footer">
                         <button type="button" class="btn btn-default" id="btnUMAlterpwdClose" data-dismiss="modal">关闭</button>
                         <button type="button" class="btn btn-primary"  onClick="btn_userman_alterpwd_submit();">修改</button>
                       </div>
                     </div>
                   </div>
                 </div>
             <!-- ./alterpwd modal-->
        </body>
          <!-- jQuery -->
        <script src="<%=basePath %>static/js/jquery-1.11.1.min.js"></script>
         <!-- Bootstrap Core JavaScript -->
        <script src="<%=basePath %>static/js/bootstrap.min.js"></script>     
        <script type="text/javascript" src="<%=basePath %>static/js/common.js"></script> 
        <script type="text/javascript" src="<%=basePath %>static/js/md5.js"></script>        
        <script type="text/javascript" src="<%=basePath %>static/js/head.js"></script>
        </html>