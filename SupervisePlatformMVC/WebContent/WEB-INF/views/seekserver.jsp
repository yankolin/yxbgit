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
<link href="<%=basePath %>static/css/ingrid.css" rel="stylesheet">
<link href="<%=basePath %>static/css/esm-seekserver.css" rel="stylesheet">
<link href="<%=basePath %>static/css/jquery.datetimepicker.css" rel="stylesheet">

<body>
<div id="wrapper">
		<jsp:include page="head.jsp"/> 
 				 <div id="page-wrapper">
				
            <div class="container-fluid" >
            <!-- Page Heading -->
												<div class="row show-grid">
												    <div class="col-lg-12">
														<h3 class="page-header">
													   	 服务器状态查询 <small></small>
														</h3>
														<ol class="breadcrumb">
													    	<li class="active">
																<i class="fa fa-table"></i> 服务器状态曲线图						
													    	</li>
															</ol>
															<div style="float:left">
								设备IP:<input type="text" name="deviceIP" id="deviceIP" style="width:108px;" /><br/>
															</div >
															<div style="float:left">
								时间：<input id="datetimepicker" type="text" /><br/>			
															</div>
															<div id="button1"  style="float:left">
										 <input type="button"  style="float: right" onclick="clickQuery()" value="查询"/>					
															</div>
															<div style="float:right">
								当前设备:<input type="text" id="nowDevice" style="width:108px;" readonly="true" /><br/>
															</div >
															
								<div  id="canvasGrandP "style="width:100%;">
                                         <div id="canvasParent">
                                                    
                                                    <canvas id="canvas" height="160" width="600"  ></canvas>
                                                    
                                                  
                                                    
                                         </div>
                                           <div id="lineLegend" style="margin-left: 25px"></div>
                                 </div>
                                 <div style="width:100%;">
                                          <div id="canvas1Parent">
                                             		  
                                                      <canvas id="canvas1" height="160" width="600"></canvas>
                                                    
                                                      
                                          </div>
                                          <div id="lineLegend1" style="margin-left: 25px"></div>
                                                      <input type="button"  style="float: right" onclick="nextOneHour()" value="后1小时"/>	
                                                      <input type="button"  style="float: right;margin-right:10px" onclick="lastOneHour()" value="前1小时"/>
                                                      <input id="starttime"  type="hidden" value ="" ></input>
                                                      <input id="endtime"  type="hidden" value ="" ></input>
                                                      <input id="deviceIp"  type="hidden" value ="" ></input>
                                                      <input id="tableName"  type="hidden" value ="" ></input>
                                  </div>

															
														
												     </div>
												</div>
												<!-- /.row -->
            </div>
   </div>
   </div>
   <script type="text/javascript" src="<%=basePath %>static/js/esm-main-Chart.js"></script>
   <script type="text/javascript" src="<%=basePath %>static/js/esm-main-legend.js"></script>
	<script type="text/javascript" src="<%=basePath %>static/js/esm-seekserver-line.js"></script>
   <script type="text/javascript" src="<%=basePath %>static/js/jquery.datetimepicker.js"></script>
   </body>
   </html>
            