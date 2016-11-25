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

<body>
<div id="wrapper">
		<jsp:include page="head.jsp"/> 
 				 <div id="page-wrapper">
				
            <div class="container-fluid" >
												<!-- Page Heading -->
												<div class="row show-grid">
												    <div class="col-lg-12">
														<h3 class="page-header">
													   	 用户管理 <small></small>
														</h3>
														<ol class="breadcrumb">
													    	<li class="active">
																<i class="fa fa-table"></i> 用户列表						
													    	</li>
															<button type="button" class="btn btn-primary" style="float:right; margin-top:-5px;margin-right:20px;" data-toggle="modal" data-target="#btn_userman_addUser">
																 <i class="glyphicon glyphicon-plus"></i></button>	
														</ol>
														
												     </div>
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
											<th style="width:8%;text-align:center">序号</th>
											<th style="width:10%;text-align:center">用户名</th>
											<th style="width:15%;text-align:center">用户类型</th>
											<th style="width:30%;text-align:center">邮箱地址</th>
											<th style="width:16%;text-align:center">是否接受预警邮件</th>
											<th style="width:20%;text-align:center">操作</th>
											<th style="width:1%"></th>
										</tr>
									</thead>
									<tbody>
												<% int i = 0;%>
															<c:forEach items = "${user_data}" var = "data" varStatus = "status">
																<tr id="${data[0]}">
																<td><%=++i%></td>
																 <td>${data[1]}</td>
																<td>
																<c:choose>
															    <c:when test="${data[2] <= 0}">
															       					普通用户
															    </c:when>
															    <c:when test="${data[2] <= 1}">
															       					 管理员
															    </c:when>
															    <c:otherwise>
															       					 其他
															    </c:otherwise>
																</c:choose>
																</td>
																<td>${data[3]}</td>
																<td>
																<c:choose>
																	<c:when test="${data[4] <= 0}">
																	     是
																	</c:when>
																	<c:when test="${data[4] > 0 }">
																			否
																	</c:when>
																</c:choose></td>
																<td style="text-align: center">
																				<button  type="button" class="btn btn-primary" onClick="btnUMAlterUser(${data[0]})" >
																					<i class="glyphicon glyphicon-edit"></i></button>
																				<button type="button" class="btn btn-primary" onClick="btnUMDelUser(${data[0]})" data-toggle="modal" data-target="#userman_delete_modal">
																					<i class="glyphicon glyphicon-trash"></i></button>
																</td>
																<td  style="display:none">${data[4]}</td>
																</tr>
															</c:forEach>
									</tbody>
							</table>
						</div>							
													<!-- add modal-->
												<div class="modal fade" id="btn_userman_addUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
												  <div class="modal-dialog" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
															<span aria-hidden="true">&times;</span></button>
												        <h4 class="modal-title" id="txt_userman_title_addUser">添加用户</h4>
												      </div>
												      <div class="modal-body">
														  <form class="form-horizontal" method="post">
															  <div class="form-group">
																  <label for="txtUMAddUsername" class="col-md-3 control-label">用户名:</label>
																  <div class="col-md-6">
																	  <input type="text" class="form-control" aria-label="Amount" id="txtUMAddUsername" onblur="checkAddUsername(this,'lblUMAddErrortip')" placeholder="用户名"/>
																  </div>
															  </div>
															  <div class="form-group">
																  <label for="txtUMAddPwd" class="col-md-3 control-label">用户密码:</label>
																  <div class="col-md-6">
																	  <input type="password" class="form-control" id="txtUMAddPwd" onblur="checkAddPwd(this,'lblUMAddErrortip')" placeholder="密码"/>
																  </div>
															  </div>
															  <div class="form-group">
																  <label for="txtUMAddRepwd" class="col-md-3 control-label">确认密码:</label>
																  <div class="col-md-6">
																	  <input type="password" class="form-control" id="txtUMAddRepwd" onblur="checkAddRepwd(this,'lblUMAddErrortip')" placeholder="确认密码"/>
																  </div>
															  </div>
															  <div class="form-group">
																  <label for="emUMAddEmail" class="col-md-3 control-label">用户邮箱:</label>
																  <div class="col-md-6">
																	  <input type="email" class="form-control" id="emUMAddEmail" onblur="checkAddEmail(this,'lblUMAddErrortip')" placeholder="example@xx.com"/>
																  </div>
											
															  </div>
															  <div class="form-group">
																  <label for="sltUMAddUsertype" class="col-md-3 control-label">用户类型:</label>
																  <div class="col-md-6">
																	  <select class="form-control" id="sltUMAddUsertype">
																		  <option value="0">普通用户</option>
																		  <option value="1">管理员</option>
																	  </select>
																  </div>
															  </div>
															  <div class="form-group">
																  <label for="sltUMAddUsertag" class="col-md-3 control-label">是否接收预警邮件:</label>
																  <div class="col-md-6">
																	  <select class="form-control" id="sltUMAddUsertag">																		  
																		  <option value="1">否</option>
																		  <option value="0">是</option>
																	  </select>
																  </div>
															  </div>
															  <div class="form-group" style="text-align: center">
																  <label class="control-label" style="color: red;" id="lblUMAddErrortip"></label>
															  </div>
															   
														  </form>
												      </div>
												      <div class="modal-footer">
												       
												        <button type="button" class="btn btn-default" id="btnUMAddClose" data-dismiss="modal">关闭</button>
												        <button type="button" class="btn btn-primary"  onClick="btn_userman_addUser_submit();">确定</button>
												      </div>
												    </div>
												  </div>
												</div>
												<!-- ./add modal-->
											
												<!-- delete modal-->
												<div class="modal fade" id="userman_delete_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
												  <div class="modal-dialog" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
															<span aria-hidden="true">&times;</span></button>
												        <h4 class="modal-title" id="myModalLabel">删除用户</h4>
												      </div>
												      <div class="modal-body">
																		<p>确定要删除该用户吗?		</p><label>用户ID：</label><label id="lblUMDelId">
																	
												      </div>
												      <div class="modal-footer">
												        <button type="button" id="btnUMDelClose" class="btn btn-default" data-dismiss="modal">关闭</button>
												        <button type="button" onClick="btn_userman_del_submit()" class="btn btn-warning" data-dismiss="modal">确定</button>
												      </div>
												    </div>
												  </div>
												</div>
												<!-- ./submit modal-->
											
												<!-- alter modal-->
												<div class="modal fade" id="btnUMAlterModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
																<div class="form-group">
											   					 <label class="col-sm-3 control-label" for="lblUMAlterId">用户ID：</label>
																	<div class="col-sm-6">
											 						 	<label class="col-sm-2 control-label" id="lblUMAlterId"></label>
																	</div>
											  					</div>   
											  					<div class="form-group">
											    		      		<label class="col-sm-3 control-label" for="txtUMAlterUsername">用户名：</label>
																	<div class="col-sm-9">
											    						<input type="text" class="form-control" id="txtUMAlterUsername" disabled="disabled" placeholder="用户名">
																	</div>
											  					</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label" for="txtUMAlterEmail">邮箱地址：</label>
																	<div class="col-sm-9">
																		<input type="text" class="form-control" id="txtUMAlterEmail" onblur="checkAddEmail(this,'lblUMAlterErrortip')" placeholder="example@xx.com">
																	</div>
																</div>
																<div class="form-group">
																	<label for="sltUMAlterAlert" class="col-sm-3 control-label">是否接收预警邮件:</label>
																	<div class="col-sm-9">
																		<select class="form-control " id="sltUMAlterAlert">
																			<option value="1">否</option>
																			<option value="0">是</option>
																		</select>
																	</div>
																</div>
																<div class="form-group" style="text-align: center">
																	<label class="control-label" style="color: red;" id="lblUMAlterErrortip"></label>
																</div>
															</form>  	
												      </div>
												      <div class="modal-footer">
												        <button type="button" class="btn btn-default" id="btnUMAlterClose" data-dismiss="modal">关闭</button>
												        <button type="button" class="btn btn-primary"  onClick="btn_userman_alter_submit();">确定</button>
												      </div>
												    </div>
												  </div>
												</div>
											<!-- ./alter modal-->
							 </div>
            <!-- /.container-fluid -->
				
        </div>
        <!-- /#page-wrapper -->

					<jsp:include page="foot.jsp"/> 
					<script type="text/javascript" src="<%=basePath %>static/js/jquery.ingrid.account.js"></script>
					<script type="text/javascript" src="<%=basePath %>static/js/esm-username.js"></script>
					<script type="text/javascript" src="<%=basePath %>static/js/common.js"></script>
					
</div>
</body>
</html>

