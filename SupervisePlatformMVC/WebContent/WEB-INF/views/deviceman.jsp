<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<html lang="en">
<head>
<meta charset="UTF-8">

</head>

<body>
	<!-- Page Heading -->
	<div id="wrapper">
		<jsp:include page="head.jsp" />
		<div id="page-wrapper">
			<!-- 将内容都放在流式布局里面 -->
			<div class="container-fluid">
				<div class="row show-grid">
					<div class="col-lg-12">
						<h1 class="page-header">
							设备管理 <small></small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-table"></i> 设备列表</li>
							<button type="button" class="btn btn-primary"
								style="float: right; margin-top: -5px; margin-right: 20px;"
								data-toggle="modal" data-target="#btn_deviceman_addUser">
								<i class="glyphicon glyphicon-plus"></i>
							</button>
						</ol>
					</div>
					<!-- 添加分页效果 -->
					<div style="float: right">
						<ul id='bp-3-element-sm-test'></ul>
					</div>
				</div>
				<!-- /.row -->
				<input type="hidden" id="countPage" value="1" /> <input
					type="hidden" id="rowsPage" value="1" />
				<div style="height: 600px; overflow: auto">
					<table id="tableDMShow" class="table table-bordered table-hover">
						<thead>
							<tr>
								<th style="width: 8%; text-align: center">序号</th>
								<th style="width: 10%; text-align: center">设备名</th>
								<th style="width: 22; text-align: center">设备IP</th>
								<th style="width: 20; text-align: center">设备类型</th>
								<th style="width: 15%; text-align: center">设备位置</th>
								<th style="width: 15%; text-align: center">设备描述</th>
								<th style="width: 20%; text-align: center">操作</th>
								<th style="width: 0.001%"></th>
							</tr>
						</thead>
						<tbody>
							<%
								int i = 0;
							%>
							<c:forEach items="${device_data}" var="data" varStatus="status">
								<tr id="${data[0]}">
									<td><%=++i%></td>
									<td>${data[2]}</td>
									<td>${data[1]}</td>
									<td><c:choose>
											<c:when test="${data[3] <= 0}"> 服务器</c:when>
											<c:when test="${data[3] <= 1 }">存储设备</c:when>
											<c:when test="${data[3] <= 2 }">网络设备</c:when>
										</c:choose></td>
									<td>${data[4]}</td>
									<td>${data[5]}</td>
									<td style="text-align: center">
										<button type="button" class="btn btn-primary"
											onClick="btnDMAlterDevice(${data[0]})">
											<i class="glyphicon glyphicon-edit"></i>
										</button>
										<button type="button" class="btn btn-primary"
											onClick="btnDMDelDevice(${data[0]})" data-toggle="modal"
											data-target="#userman_delete_modal">
											<i class="glyphicon glyphicon-trash"></i>
										</button>
									</td>
									<td style="display: none">${data[4]}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- add modal-->
				<div class="modal fade" id="btn_deviceman_addUser" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="txt_deviceman_title_addDevice">添加设备</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal">
									<div class="form-group">
										<label for="txtDMAddDeviceIP" class="col-md-3 control-label">设备IP:</label>
										<div class="col-md-6">
											<input type="text" class="form-control" aria-label="Amount"
												id="txtDMAddDeviceIP"
												onblur="checkDeviceIP(this,'lblDMAddErrortip')"
												placeholder="设备IP" />
										</div>
									</div>
									<div class="form-group">
										<label for="txtDMAddDeviceName" class="col-md-3 control-label">设备名：</label>
										<div class="col-md-6">
											<input type="text" class="form-control"
												id="txtDMAddDeviceName" placeholder="设备名">
										</div>
									</div>
									<div class="form-group">
										<label for="chkDMDeviceType" class="col-md-3 control-label">设备类型:</label>
										<div class="col-md-6">
											<select class="form-control" id="chkDMDeviceType">
												<option value="0">服务器</option>
												<option value="1">存储设备</option>
												<option value="2">网络设备</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="txtDMAddDeviceposition"
											class="col-md-3 control-label">设备位置:</label>
										<div class="col-md-6">
											<input type="text" class="form-control"
												id="txtDMAddDeviceposition" placeholder="设备位置" />
										</div>
									</div>
									<div class="form-group">
										<label for="txtDMAddDeviceDesc" class="col-md-3 control-label">设备描述:</label>
										<div class="col-md-6">
											<input type="text" class="form-control"
												id="txtDMAddDeviceDesc" placeholder="设备描述" />
										</div>
									</div>
									<div class="form-group" style="text-align: center">
										<label class="control-label" style="color: red;"
											id="lblDMAddErrortip"></label>
									</div>

								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									id="btn_deviceman_add_close" data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary"
									onClick="btn_deviceman_addDevice_submit();">确定</button>
							</div>
						</div>
					</div>
				</div>
				<!-- ./add modal-->
				<!-- alter modal -->
				<div class="modal fade" id="btnDMAlterModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="lbl_userman_modifyTile">修改</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="col-sm-3 control-label" for="lblDMAlterId">设备ID：</label>
										<div class="col-sm-6">
											<label class="col-sm-2 control-label" id="lblDMAlterId"></label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label"
											for="txtDMAlterDevicename">设备名：</label>
										<div class="col-sm-9">
											<input type="text" class="form-control"
												id="txtDMAlterDevicename"
												onblur="checkAddUsername(this,'lblDMAlterErrortip')"
												placeholder="设备名">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label" for="txtDMAlterDeviceIp">设备IP：</label>
										<div class="col-sm-9">
											<input type="text" class="form-control"
												id="txtDMAlterDeviceIp"
												disabled="disabled"
												placeholder="example@xx.com">
										</div>
									</div>
									<div class="form-group">
										<label for="sltDMAlterDeviceType"
											class="col-sm-3 control-label">设备类型:</label>
										<div class="col-sm-9">
											<select class="form-control " id="sltDMAlterDeviceType">
												<option value="0">服务器</option>
                  <option value="1">存储设备</option>
                  <option value="2">网络设备</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label"
											for="txtDMAlterDeviceLoc">设备位置</label>
										<div class="col-sm-9">
											<input type="text" class="form-control"
												id="txtDMAlterDeviceLoc"
												onblur="checkInputLoc(this,'lblDMAlterErrortip')"
												placeholder="设备位置信息">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label"
											for="txtDMAlterDeviceDesc">设备描述：</label>
										<div class="col-sm-9">
											<input type="text" class="form-control"
												id="txtDMAlterDeviceDesc"
												onblur="checkInputDesc(this,'lblDMAlterErrortip')"
												placeholder="设备描述信息">
										</div>
									</div>
									<div class="form-group" style="text-align: center">
										<label class="control-label" style="color: red;"
											id="lblDMAlterErrortip"></label>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									id="btnDMAlterClose" data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary"
									onClick="btn_deviceman_alter_submit();">修改</button>
							</div>
						</div>
					</div>
				</div>
				<!-- ./alter modal -->
				<!-- delete modal-->
				<div class="modal fade" id="btn_deviceman_delete_modal"
					tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">删除设备</h4>
							</div>
							<div class="modal-body">
								<p>确定要删除该设备吗?</p>
								<label>设备ID：</label><label id="lblDMDelId">
							</div>
							<div class="modal-footer">
								<button type="button" id="btnDMDelClose" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" onClick="btn_deviceman_del_submit()"
									class="btn btn-warning" data-dismiss="modal">确定</button>
							</div>
						</div>
					</div>
				</div>
				<!-- ./delete modal-->
			</div>
		</div>

	</div>
	<!-- /.page-wrapper -->
	<jsp:include page="foot.jsp" />



 <script type="text/javascript" src="<%=basePath%>static/js/common.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>static/js/esm-deviceman.js"></script>

	</div>
</body>
</html>
