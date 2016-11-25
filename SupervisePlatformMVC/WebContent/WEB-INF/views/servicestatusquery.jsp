<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<!-- 引入日期控件 -->
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/jquery.datetimepicker.css"/>

<body>
<div id="wrapper">
		<jsp:include page="head.jsp"/> 
 			 <div id="page-wrapper">
				
            	<div class="container-fluid" >
											<!-- Page Heading -->
												<div class="row show-grid">
												    <div class="col-lg-12">
														<h3 class="page-header" style="margin:20px 0 20px">
													   	 服务器状态查询 <small></small>
														</h3>
														<ol class="breadcrumb" style="margin:0 0 0 0">
													    	<li class="active">
																<div >
																	<label for="txtSSQDeviceIP">设备IP: </label>
																    <input id="txtSSQDeviceIP"  type="text" class="span2 search-query"  placeholder="设备IP" onblur="checkInputDeviceIP(this,'lblSSQAddErrortip')">
																    &nbsp;&nbsp;&nbsp;<label > 时间范围: </label>
																   <input id="datetimepicker_begin" type="text" placeholder="from"  style="width:120px;">
																   <input id="datetimepicker_end" type="text" placeholder="to"   style="width:120px;">
																  <!--  <button type="submit" class="btn btn-info">Search</button> -->
																   &nbsp;&nbsp;&nbsp;<input type="button"  class="btn btn-info"  value="Search" style="width:70px;height:28px;line-height:14px;" onClick="btnSSQQuery();" />				  
												                  &nbsp;&nbsp;&nbsp;<label class="control-label" style="color: red;" id="lblSSQAddErrortip"></label>
															    </div>				
													    	</li>
																
														</ol>
												     </div>
												       <div style="float:right;">
                      							   			<ul id='bp-3-element-sm-test' style="margin: 10px 15px 0px 0px"></ul> 
                      								</div>
												</div>
												<!-- /.row -->
								
							 <input type="hidden" id="countPage" value="1"/>
       					    <input type="hidden" id="rowsPage" value="1"/>
							<div style="height:770px;overflow:auto;margin: 10px 0px 0px 0px">
							<table id ="tableSSQShow" class="table table-condensed  table-bordered table-hover"  ><!-- style="display :none;" table table-bordered table-hover-->
								<thead>
										<tr>
											<th style="width: 6%;text-align:center">序号</th>
											<th style="width: 11%;text-align:center">设备IP</th>
											<th style="width: 8%;text-align:center">CPU%</th>
											<th style="width: 9%;text-align:center">总内存GB</th>
											<th style="width: 11%;text-align:center">已用内存GB</th>
											<th style="width: 10%;text-align:center">总硬盘GB</th>
											<th style="width: 11%;text-align:center">已用硬盘GB</th>
											<th style="width:12%;text-align:center">上行流量KB/s</th>
											<th style="width:12%;text-align:center">下行流量KB/s</th>
											<th style="width:6%;text-align:center">操作</th>
											<th style="display :none;"></th>
											<th style="display :none;"></th>
										</tr>
									</thead>
									<tbody>
											<% int i = 0;%>
															<c:forEach items = "${servicestatus_data}" var = "data" varStatus = "status">
																<tr id="${data[0]}">
																<td style='text-align:center'><%=++i%></td>
																 <td style='text-align:center'>${data[1]}</td>
																<td style='text-align:center'>${data[2]}</td>
																<td style='text-align:center'>${Math.ceil(data[3]/1024/1024*100)/100}</td>
																<td style='text-align:center'>${Math.ceil(data[4]/1024/1024*100)/100}</td>
																<td style='text-align:center'>${Math.ceil(data[5]/1024/1024/1024*100)/100}</td>
																<td style='text-align:center'>${Math.ceil(data[6]/1024/1024/1024*100)/100}</td>
																 <td style='text-align:center'>${Math.ceil(data[7]/1024*100)/100}</td>
																<td style='text-align:center'>${Math.ceil(data[8]/1024*100)/100}</td>
																<td style='text-align:center'>
																	<button class="btn btn-primary" onClick='btnSSQDetailInfo(${data[0]})'  style="width:35px;height:23px;">
																	<i class='glyphicon glyphicon-th' > </i></button>
																</td>
																<td style='display:none'>${data[9]}</td>
																<td style='display:none'>${data[10]}</td>
																<td style='display:none'>${data[11]}</td>
																</tr>
															</c:forEach>
									</tbody>
							</table>
						</div>							
						</div>							
										<!-- DetailInfo modal-->
												<div class="modal fade"  id="DetailInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
												  <div class="modal-dialog" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
															<span aria-hidden="true">&times;</span></button>
												        <h4 class="modal-title" id="txtSSQTitleDetail">服务器状态详细信息</h4>
												      </div>
												      <div class="modal-body">
														  <form class="form-horizontal">
															  <div class="form-group">
																  <label for="txtSSQServiceStatusId" class="col-md-3 control-label">序号:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQServiceStatusId"></label>
																  </div>
															  </div>
														  	 <div class="form-group">
																  <label for="txtSSQDeviceIp" class="col-md-3 control-label">设备IP:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQDeviceIp"></label>
																  </div>
															  </div>
															     <div class="form-group">
																  <label for="txtSSQCPU" class="col-md-3 control-label">CPU状态:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQCPU"></label>
																  </div>
															  </div>
															   <div class="form-group">
																  <label for="txtSSQAllMem" class="col-md-3 control-label">总内存GB:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQAllMem"></label>
																  </div>
															  </div>
															  <div class="form-group">
																  <label for="txtSSQMem" class="col-md-3 control-label">已用内存GB:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQMem"></label>
																  </div>
															  </div>
															   <div class="form-group">
																  <label for="txtSSQAllStor" class="col-md-3 control-label">总磁盘GB:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQAllStor"></label>
																  </div>
															  </div>
															    <div class="form-group">
																  <label for="txtSSQStor" class="col-md-3 control-label">已用磁盘GB:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQStor"></label>
																  </div>
															  </div>
															   <div class="form-group">
																  <label for="txtSSQUpFlow" class="col-md-3 control-label">上行流量:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQUpFlow"></label>
																  </div>
															  </div>
															    <div class="form-group">
																  <label for="txtSSQDownFlow" class="col-md-3 control-label">下行流量:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQDownFlow"></label>
																  </div>
															  </div>
															   <div class="form-group">
																  <label for="txtSSQName" class="col-md-3 control-label">设备名称:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQName"></label>
																  </div>
															  </div>
															   <div class="form-group">
																  <label for="txtSSQDesc" class="col-md-3 control-label">设备描述:</label>
																  <div class="col-md-9">
																	   <label class="col-sm-9 control-label" id="txtSSQDesc"></label>
																  </div>
															  </div>
															  <div class="form-group">
																  <label for="txtSSQDate" class="col-md-3 control-label">日期:</label>
																  <div class="col-md-6">
																	   <label class="col-sm-2 control-label" id="txtSSQDate"></label>
																  </div>
															  </div>
														  </form>
												      </div>
												      <div class="modal-footer">
												        <button type="button" class="btn btn-default" id="btnSSQSClose" data-dismiss="modal">关闭</button>
												      </div>
												    </div>
												  </div>
												</div>
												<!-- ./DetailInfo modal-->			
				</div>
           	    <!-- /.container-fluid -->
				
         </div>
         <!-- /#page-wrapper -->

					<jsp:include page="foot.jsp"/> 
					
					<script type="text/javascript" src="<%=basePath %>static/js/common.js"></script>							
					<script type="text/javascript" src="<%=basePath %>static/js/ems-servicestatusquery.js"></script>
					<script src="<%=basePath %>static/js/jquery.datetimepicker.js"></script>
					<script>
					$('#datetimepicker_begin').datetimepicker();
					$('#datetimepicker_begin').datetimepicker({
						yearOffset:0,
						lang:'ch',
						timepicker:false,
						format:'Y/m/d',
						formatDate:'Y/m/d',
						maxDate:'+1970/01/01' // and tommorow is maximum date calendar
					});
					$('#datetimepicker_end').datetimepicker();
					$('#datetimepicker_end').datetimepicker({
						yearOffset:0,
						lang:'ch',
						timepicker:false,
						format:'Y/m/d',
						formatDate:'Y/m/d',
						maxDate:'+1970/01/01' // and tommorow is maximum date calendar
					});
					</script>
</body>
</html>

