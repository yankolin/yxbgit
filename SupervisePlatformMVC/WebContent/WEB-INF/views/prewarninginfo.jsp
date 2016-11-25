<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>



<link href="<%=basePath %>static/css/jquery.datetimepicker.css" rel="stylesheet">




<body>
<div id="wrapper">
		<jsp:include page="head.jsp"/> 
 				 <div id="page-wrapper">
				
            <div class="container-fluid" >
												<!-- Page Heading -->
												<div class="row show-grid">
												    <div class="col-lg-12">
														<h1 class="page-header">
													   	 预警信息 <small></small>
														</h1>
														<ol class="breadcrumb">
													    	<li class="active">
																 <div  class="div_search" >
												     <p>
                                                       <form >
                                                        &ensp; IP: <input type="text" id="search_ip" style="width:160px;"  placeholder="192.168.1.0" />	&ensp;&ensp;&ensp;
                                                         
                                                                                                                                                           日期: <input type="text"   id="search_date"   style="width:160px;" placeholder="2008-04-01" />  <!-- readonly="readonly" -->
                                                              &ensp;&ensp;                                                                
                                                                                                                                                           
                                                        <button  type="button" onClick="btnShowSearchInfo()" >查找</button> &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                                                        <label  id="lhint" style="color:red;"></label>
                                                       </form>
                                                         
                                                         
																					
                                                         </p>
                                                     </div>						
													    	</li>
															
														</ol>
														
												     </div>
												     
												    <style>
												     .div_search{font-family:Arial;font-size:18px;text-align:left}
												     
												     </style>
												     
												     
												     
												     <div style="float:right">
                         <ul id='bp-3-element-sm-test'></ul>
                      </div>
												</div>
												<!-- /.row -->
								
								
         <input type="hidden" id="countPage" value="1"/>
         <input type="hidden" id="rowsPage" value="1"/>
         <div style="height:600px;overflow:auto">
							<table id ="tableUMShow" class="table table-bordered table-hover">
								<thead>
										<tr>
											<th style="width:8%;text-align:center">序列号</th>
											<th style="width:20%;text-align:center">设备IP</th>
											<th style="width:8%;text-align:center">CPU</th>
											<th style="width:8%;text-align:center">内存</th>
											<th style="width:8%;text-align:center">磁盘</th>
											<th style="width:10%;text-align:center">上行流量</th>
											<th style="width:10%;text-align:center">下行流量</th>
											<th style="width:16%;text-align:center">日期</th>
											<th style="width:12%;text-align:center">详细信息</th>
										</tr>
									</thead>
									<tbody>
												   <%int i =0; %>
															<c:forEach items = "${PrewarningInfo_data}" var = "data" varStatus = "status">
																
																
																<tr id="${data[0]}">
																<td style="text-align:center"><%=++i %></td>
																<td style="text-align:center">${data[8]}</td>
																<td style="text-align:center">${data[2]}</td>
																
																
																<td style="text-align:center">${data[3]}</td>
																<td style="text-align:center">${data[4]}</td>
																<td style="text-align:center">${data[5]}</td>
																<td style="text-align:center">${data[6]}</td>
																<td style="text-align:center"><fmt:formatDate value="${data[7]}" type="both"/></td>
																<td style="text-align: center">
																				<button  type="button" class="btn btn-info" onClick="btnShowInfo(${data[0]})" >
																					<i class="glyphicon glyphicon-list-alt"></i></button>
																				
																</td>
																<!-- <td><script >formatDate(parseInt("${date[7]}"))</script></td>-->
																
																
																
																</tr>
															</c:forEach>
									</tbody>
							</table>
						</div>							
													<!-- showinfo modal-->
												<div class="modal fade" id="btn_showinfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
												  <div class="modal-dialog" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
															<span aria-hidden="true">&times;</span></button>
												        <h4 class="modal-title" id="title_showinfo">详细信息</h4>
												      </div>
												      
												      <div class="modal-body">
																		<label> 预警ID    ：</label><label id="pinfoId"></label><br/>
																		<label> 设备ID    ：</label><label id="dId"></label><br/>
																		<label> 设备IP    ：</label><label id="dIp"></label><br/>
																		<label> 预警CPU   ：</label><label id="cpu"></label><br/>
																		<label> 预警内存         ：</label><label id="mem"></label><br/>
																		<label> 预警磁盘         ：</label><label id="stor"></label><br/>
																		<label> 预警上行流量：</label><label id="upfl"></label><br/>
																		<label> 预警下行流量：</label><label id="downfl"></label><br/>
																		<label> 预警日期         ：</label><label id="pdate"></label><br/>
																		
																		<label> 设备名称         ：</label><label id="dname"></label><br/>
																		<label> 设备类型         ：</label><label id="dtype"></label><br/>
																		<label> 设备位置         ：</label><label id="dlo"></label><br/>
																		<label> 设备描述         ：</label><label id="desc"></label><br/>
																		<label> 设备日期         ：</label><label id="ddate"></label>
																	
												      </div>
												      
												      <div class="modal-footer">
												        
												        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
												      </div>
												    </div>
												  </div>
												</div>
												<!-- ./add modal-->
											
												<!-- delete modal-->
												
												<!-- ./submit modal-->
											
												<!-- alter modal-->
												
											<!-- ./alter modal-->
							 </div>
            <!-- /.container-fluid -->
				
        </div>
        <!-- /#page-wrapper -->

					<jsp:include page="foot.jsp"/> 
					
					
					<script type="text/javascript" src="<%=basePath %>static/js/esm-prewarning.js"></script>
					<script type="text/javascript" src="<%=basePath %>static/js/common.js"></script>
					<script type="text/javascript" src="<%=basePath %>static/js/jquery.datetimepicker.js"></script>
					   <script>
  
                       $( '#search_date' ).datetimepicker({
                    	   lang:"ch",           //语言选择中文
                           format:"Y-m-d",      //格式化日期
                           timepicker:false});
                       
     
    
  
                       </script>                  <!-- 位置很重要 -->
					
					
					
					
</div>
</body>
</html>

