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
													   	 存储器状态查询 <small></small>
														</h3>
														<ol class="breadcrumb" style="margin:0 0 0 0">
													    	<li class="active">
																<div >
																	<label for="txtSMSDeviceIP">设备IP: </label>
																		<c:forEach items = "${DefaultIp}" var = "data" varStatus = "status">
																		<input id="txtSMSDeviceIP"   type="text" class="span2 search-query"  value="${data[0]}" onblur="checkInputDeviceIP(this,'lblSMSErrortip')">
																		</c:forEach>
																    
																   <label for="datetimepicker">日期: </label>
																    <input id="datetimepicker" type="text"  style="width:120px;">
																   &nbsp;&nbsp;&nbsp;<input type="button"  class="btn btn-info"  value="Search" style="width:70px;height:28px;line-height:14px;" onClick="btnSMSQuery();" />				  
												                  &nbsp;&nbsp;&nbsp;<label class="control-label" style="color: red;" id="lblSMSErrortip"></label>
												                  <label class="control-label" id="lblSMSAlertEmpty"></label>
															    </div>				
													    	</li>
																
														</ol>
												     </div>
												    <!--    <div style="float:right;">
                      							   			<ul id='bp-3-element-sm-test' style="margin: 10px 15px 0px 0px"></ul> 
                      								</div> -->
                      								
												</div>
												<!-- /.row -->
								
						 <ul id="myTab" class="nav nav-tabs">
							   <li class="active">
							      <a  class="navTags"  id="driveTag"  onClick="btnSMSQueryDrive();" href="#drive" data-toggle="tab">
							         驱动状态
							      </a>
							   </li>
							   <li><a  class="navTags"  id="mdiskTag"  onClick="btnSMSQueryMdisk();" href="#mdisk" data-toggle="tab"  >Mdisk状态</a></li>
							    <li><a class="navTags"  id="vdiskTag"  onClick="btnSMSQueryVdisk();" href="#vdisk" data-toggle="tab" >Vdisk状态</a></li>
							    <li><a class="navTags" id="hostTag"   onClick="btnSMSQueryHost();"  href="#host" data-toggle="tab">主机状态</a></li>
							   <li><a  class="navTags"  id="enclosureTag"  onClick="btnSMSQueryEnclosure();" href="#enclosure" data-toggle="tab">机柜状态</a></li>
							    <li><a class="navTags" id="systeminfoTag"   onClick="btnSMSQuerySystemInfo();" href="#systeminfo" data-toggle="tab">系统信息</a></li>
							    <li style="float:right;">
							       <div style="float:right;">
                      					<ul id='bp-3-element-sm-test' style="margin: 10px 15px 0px 0px"></ul> 
                      				</div>
							    </li>
							</ul>
							<div id="myTabContent" class="tab-content">
							   <div class="tab-pane fade in active" id="drive">
							     <div style="height:700px;overflow:auto;margin: 10px 0px 0px 0px">
									<table id ="tableSMSShowDrive" class="table table-condensed  table-bordered table-hover"  >
										<thead>
												<tr>
													<th style="width: 6%;text-align:center">序号</th>
													<th style="width: 10%;text-align:center">驱动器Id</th>
													<th style="width: 10%;text-align:center">驱动器容量</th>
													<th style="width: 10%;text-align:center">驱动器状态</th>
													<th style="width: 10%;text-align:center">MdiskId</th>
													<th style="width: 10%;text-align:center">机柜Id</th>
													<th style="width: 10%;text-align:center">插槽Id</th>
													<th style="width: 16%;text-align:center">日期</th>    <!-- 日期来自info还是status??? -->
													<th style="width:15%;text-align:center">设备位置</th>
												</tr>
											</thead>
											<tbody>
													
											</tbody>
									</table>
								</div>							
							   </div>
							   <div class="tab-pane fade" id="mdisk">
							         <div style="height:700px;overflow:auto;margin: 10px 0px 0px 0px">
									<table id ="tableSMSShowMdisk" class="table table-condensed  table-bordered table-hover"  >
										<thead>
												<tr>
													<th style="width: 6%;text-align:center">序号</th>
													<th style="width: 10%;text-align:center">MdiskId</th>
													<th style="width: 10%;text-align:center">Mdisk容量</th>
													<th style="width: 10%;text-align:center">Mdisk状态</th>
													<th style="width: 10%;text-align:center">PoolName</th>
													<th style="width: 16%;text-align:center">日期</th>
													<th style="width:15%;text-align:center">设备位置</th>
												</tr>
											</thead>
											<tbody>
													
											</tbody>
									</table>
								</div>							
							   </div>
							   <div class="tab-pane fade" id="vdisk">
							         <div style="height:700px;overflow:auto;margin: 10px 0px 0px 0px">
									<table id ="tableSMSShowVdisk" class="table table-condensed  table-bordered table-hover"  >
										<thead>
												<tr>
													<th style="width: 6%;text-align:center">序号</th>
													<th style="width: 10%;text-align:center">Vdisk名称</th>
													<th style="width: 10%;text-align:center">Vdisk容量</th>
													<th style="width: 10%;text-align:center">Vdisk状态</th>
													<th style="width: 16%;text-align:center">日期</th>
													<th style="width:15%;text-align:center">设备位置</th>
												</tr>
											</thead>
											<tbody>
													
											</tbody>
									</table>
								</div>							
							   </div>
							   <div class="tab-pane fade" id="host">
							         <div style="height:700px;overflow:auto;margin: 10px 0px 0px 0px">
									<table id ="tableSMSShowHost" class="table table-condensed  table-bordered table-hover"  >
										<thead>
												<tr>
													<th style="width: 6%;text-align:center">序号</th>
													<th style="width: 10%;text-align:center">主机名称</th>
													<th style="width: 10%;text-align:center">主机状态</th>
													<th style="width: 10%;text-align:center">端口数</th>
													<th style="width: 16%;text-align:center">日期</th>
													<th style="width:15%;text-align:center">设备位置</th>
												</tr>
											</thead>
											<tbody>
													
											</tbody>
									</table>
								</div>							
							   </div>
							   	   <div class="tab-pane fade" id="enclosure">
							         <div style="height:700px;overflow:auto;margin: 10px 0px 0px 0px">
									<table id ="tableSMSShowEnclosure" class="table table-condensed  table-bordered table-hover"  >
										<thead>
												<tr>
													<th style="width: 6%;text-align:center">序号</th>
													<th style="width: 9%;text-align:center">序列号</th>
													<th style="width: 10%;text-align:center">机柜状态</th>
													<th style="width: 10%;text-align:center">机柜类型</th>
													<th style="width: 10%;text-align:center">管理状态</th>
													<th style="width: 8%;text-align:center">IO组</th>
													<th style="width: 16%;text-align:center">日期</th>
													<th style="width:15%;text-align:center">设备位置</th>  <!-- 包括U的位置 -->
												</tr>
											</thead>
											<tbody>
													
											</tbody>
									</table>
								</div>							
							   </div>
							   	   <div class="tab-pane fade" id="systeminfo">
							         <div style="height:700px;overflow:auto;margin: 10px 0px 0px 0px">
									<table id ="tableSMSShowSysteminfo" class="table table-condensed  table-bordered table-hover"  >
										<thead>
												<tr>
													<th style="width: 6%;text-align:center">序号</th>
													<th style="width: 10%;text-align:center">设备名称</th>
													<th style="width: 10%;text-align:center">总容量</th>
													<th style="width: 10%;text-align:center">剩余空间</th>
													<th style="width: 10%;text-align:center">IP地址</th>
													<th style="width: 16%;text-align:center">日期</th>
													<th style="width:15%;text-align:center">设备位置</th>
												</tr>
											</thead>
											<tbody>
													
											</tbody>
									</table>
								</div>							
							   </div>
							</div>
								
							
							
						</div>							
				</div>
           	    <!-- /.container-fluid -->
				
         </div>
         <!-- /#page-wrapper -->

					<jsp:include page="foot.jsp"/> 					
					<script type="text/javascript" src="<%=basePath %>static/js/common.js"></script>							
					<script type="text/javascript" src="<%=basePath %>static/js/esm-seekmemstatus.js"></script>
					<script src="<%=basePath %>static/js/jquery.datetimepicker.js"></script>
					<script>
						$('#datetimepicker').datetimepicker();
						$('#datetimepicker').datetimepicker({
							validateOnBlur:true,
							allowBlank:true,
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

