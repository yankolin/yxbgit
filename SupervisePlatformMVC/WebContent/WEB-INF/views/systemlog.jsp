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
													   	 系统日志查询 <small></small>
														</h1>
														<ol class="breadcrumb">
													    	<li class="active">
																 <div  class="div_search" >
												     <p>
                                                       <form >
                                                        &ensp; 用户名: <input type="text" id="search_name" style="width:160px;"  placeholder="username" />	&ensp;&ensp;&ensp;
                                                         
                                                                                                                                                           日期: <input type="text"   id="search_date"   style="width:160px;" placeholder="2008-04-01" />  <!-- readonly="readonly" -->
                                                              &ensp;&ensp;                                                                
                                                                                                                                                           
                                                        <button  type="button" onClick="btnShowSearchlog()" >查找</button> &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
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
											
											<th style="width:14%;text-align:center">登录IP</th>
											<th style="width:12%;text-align:center">用户名</th>
											<th style="width:14%;text-align:center">用户类型</th>
											<th style="width:24%;text-align:center">日志描述</th>
											
											
											
											<th style="width:18%;text-align:center">日期</th>
											<th style="width:10%;text-align:center">详细信息</th>
										</tr>
									</thead>
									<tbody>
												   <%int i =0; %>
															<c:forEach items = "${systemloginfo_data}" var = "data" varStatus = "status">
																
																
																
                                                                
                                                               
																
																<tr id="${data[0]}">
																<td style="text-align:center"><%=++i %></td>
																
																<td style="text-align:center">${data[2]}</td>
																<td style="text-align:center">${data[5]}</td>
																
                                                                
                                                                
																<td style="text-align:center">
																<c:choose>
															    <c:when test="${data[6] <= 0}">
															       					普通用户
															    </c:when>
															    <c:when test="${data[6] <= 1}">
															       					 管理员
															    </c:when>
															   
															    <c:otherwise>
															       					 其他
															    </c:otherwise>
																</c:choose></td>
																
																<td align="center"> <div style="text-align:center;width:200px;overflow:hidden; white-space:nowrap; text-overflow:ellipsis;"> ${data[3]}</div></td>
																
																
																
																
																<td style="text-align:center"><fmt:formatDate value="${data[4]}" type="both"/></td>
																<td style="text-align: center">
																				<button  type="button" class="btn btn-info" onClick="btnShowInfo(${data[0]})" >
																					<i class="glyphicon glyphicon-list-alt"></i></button>
																				
																</td>
															
																
																
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
																		<label> 日志ID    ：</label><label id="lId"></label><br/>
																		<label> 用户ID    ：</label><label id="uId"></label><br/>
																		<label> 登录IP    ：</label><label id="dIp"></label><br/>
																		<label> 用户名   ：</label><label id="name"></label><br/>
																		<label> 用户类型         ：</label><label id="type"></label><br/>
																		<label> 邮箱         ：</label><label id="email"></label><br/>
																		
																		<label> 日期         ：</label><label id="date"></label><br/>
																		
																		
																		<label> 日志描述         ：</label><label id="desc"></label><br/>
																		
																	
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
					
					
					<script type="text/javascript" src="<%=basePath %>static/js/esm-systemlog.js"></script>
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

