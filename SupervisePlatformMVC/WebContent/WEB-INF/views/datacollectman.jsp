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
<body onload="GetCurValue()">
<div id="wrapper">
		<jsp:include page="head.jsp"/> 
 			 <div id="page-wrapper">
				
            	<div class="container-fluid" >
											<!-- Page Heading -->
												<div class="row show-grid">
												    <div class="col-lg-12">
														<h1 class="page-header">
													   	 数据采集配置 <small></small>
														</h1>
														<ol class="breadcrumb">
													    	<li class="active">
																采集周期						
													    	</li>
																
														</ol>
												     </div>
												   
												</div>
												<!-- /.row -->
								
							<div style="height:280px;overflow:auto">
							<table  style="height:200px ;width:800px;">
								
								<tbody>
									<tr>
										<td style="width:50%;text-align:right;padding-right:10px;">服 &nbsp;务  &nbsp;器: </td>
										<td style="width:25%;text-align:right">
											<input id="txtDCMServer"  class="form-control"  type="text" value="${service_data } " style="width:220px;" onblur="checkInputTime(this,'lblDCMAllterErrortip','服务器',5)" >
										</td>
										<td style="width:20%;text-align:left">分钟</td>
									</tr>
									<tr>
										<td style="text-align:right;padding-right:10px;">网络设备: </td>
										<td style="text-align:right">
											<input id="txtDCMNetDevice" class="form-control" type="text" value="${switch_data }" style="width:220px;" onblur="checkInputTime(this,'lblDCMAllterErrortip','网络设备',30)">
										</td>
										<td style="text-align:left"> 分钟</td>
									</tr>
									<tr>
										<td style="text-align:right;padding-right:10px;">存储设备: </td>
										<td style="text-align:right">
											<input id="txtDCMStorDevice" class="form-control" type="text" value="${stor_data }" style="width:220px;" onblur="checkInputTime(this,'lblDCMAllterErrortip','存储设备',30)">
										</td>
										<td style="text-align:left"> 分钟</td>
									</tr>
									<tr>
										<td></td>
										<td style="text-align:center">
											 <label class="control-label" style="color: red;" id="lblDCMAllterErrortip"></label>
										</td>
									</tr>
									<tr>
										<td></td>
										<td style="text-align:center">
										<button type="button" class="btn btn-primary"  onClick="btnDCMAlterSubmit();">提交</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>							
												
				</div>
           	    <!-- /.container-fluid -->
				
         </div>
         <!-- /#page-wrapper -->

					<jsp:include page="foot.jsp"/> 
					<script type="text/javascript" src="<%=basePath %>static/js/common.js"></script>							
					<script type="text/javascript" src="<%=basePath %>static/js/esm-datacollectman.js"></script>
										
</div>
</body>
</html>

