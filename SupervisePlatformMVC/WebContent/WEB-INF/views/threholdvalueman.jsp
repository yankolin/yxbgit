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
<body>
<div id="wrapper">
		<jsp:include page="head.jsp"/> 
 				 <div id="page-wrapper">
				
            <div class="container-fluid" >
												<!-- Page Heading -->
												<div class="row show-grid">
												    <div class="col-lg-12">
												        <h3 class="page-header">
												            阈值管理 <small></small>
												        </h3>
												        <ol class="breadcrumb">
												            <li class="active">
												                <i class="fa fa-table"></i> 阈值列表
												            </li>
												            <button type="button" class="btn btn-primary" style="float:right; margin-top:-5px;margin-right:20px;"  data-toggle="modal" data-target="#btnTVMAddThreholdValue">
												                <i class="glyphicon glyphicon-plus"></i></button>
												        </ol>
												      <div style="float:right">
                         <ul id='bp-3-element-sm-test'></ul>
                      </div>
												    </div>
												</div>
												<!-- /.row -->
												
								<div style="height:600px;overflow:auto">				
								<table id = "tableTVMShow" class="table table-bordered table-hover">
								    <thead>
								    <tr>
								        <th style="width:10%;text-align:center">序号</th>
								        <th style="width:20%;text-align:center">设备IP</th>
								        <th style="width:10%;text-align:center">CPU阈值</th>
								        <th style="width:10%;text-align:center">内存阈值</th>
								        <th style="width:10%;text-align:center">硬盘阈值</th>
								        <th style="width:15%;text-align:center">上行流量阈值</th>
								        <th style="width:15%;text-align:center">下行流量阈值</th>
								        <th style="width:10%;text-align:center">操作</th>
								    </tr>
								    </thead>
								    <thead>
								    <tbody>
								    <% int i = 0; %>
								    <c:forEach items = "${threhold_data}" var = "data" varStatus = "status">
								        <tr id="${data[0]}">
								        <td><%=++i %></td>
								        <td>${data[0]}</td>
								        <td>${data[1]}</td>
								        <td>${data[2]}</td>
						          <td>${data[3]}</td>
						          <td>${data[4]}</td>
						          <td>${data[5]}</td>
						           <td style="text-align: center">
                        <button  id="u_alter"  type="button" class="btn btn-primary"  onClick="btnTVMAlterThreholdvalue(${data[0]})"  >
                            <i class="glyphicon glyphicon-edit"></i></button>
                    </td>
								        </tr>
								    </c:forEach>
								    </tbody>
								</table>
								</div>
																			
								 <!-- add modal-->
								<div class="modal fade" id="btnTVMAddThreholdValue" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								    <div class="modal-dialog" role="document">
								        <div class="modal-content">
								            <div class="modal-header">
								                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
								                    <span aria-hidden="true">&times;</span></button>
								                <h4 class="modal-title" id="txt_threholdvalueman_tittle_addThreholdValue">添加阈值</h4>
								            </div>
								            <div class="modal-body">
								                <form class="form-horizontal">
								                    <div class="form-group">
								                        <label for="txtTVMAddDeviceIP" class="col-md-3 control-label">设备IP:</label>
								                        <div class="col-md-6">
								                            <input type="text" class="form-control" aria-label="Amount" id="txtTVMAddDeviceIP" onblur="checkAddDeviceIP(this,'lblTVMAddErrortip','设备IP')" placeholder="设备IP"/>
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label for="txtTVMAddThreholdValueCPU" class="col-md-3 control-label">CPU阈值:</label>
								                        <div class="col-md-6">
								                            <input type="text" class="form-control" aria-label="Amount" id="txtTVMAddThreholdValueCPU" onblur="checkAddIsInt(this,'lblTVMAddErrortip','CPU阈值')" placeholder="CPU阈值"/>
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label for="txtTVMAddThreholdValueMem" class="col-md-3 control-label">内存阈值:</label>
								                        <div class="col-md-6">
								                            <input type="text" class="form-control" id="txtTVMAddThreholdValueMem" onblur="checkAddIsInt(this,'lblTVMAddErrortip','内存阈值')" placeholder="内存阈值"/>
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label for="txtTVMAddThreholdValueStor" class="col-md-3 control-label">硬盘阈值:</label>
								                        <div class="col-md-6">
								                            <input type="text" class="form-control" id="txtTVMAddThreholdValueStor" onblur="checkAddIsInt(this,'lblTVMAddErrortip','硬盘阈值')" placeholder="硬盘阈值"/>
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label for="txtTVMAddThreholdValueUpFlow" class="col-md-3 control-label">上行流量阈值:</label>
								                        <div class="col-md-6">
								                            <input type="text" class="form-control" id="txtTVMAddThreholdValueUpFlow" onblur="checkAddIsInt(this,'lblTVMAddErrortip','上行流量阈值')" placeholder="上行流量阈值"/>
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label for="txtTVMAddThreholdValueDownFlow" class="col-md-3 control-label">下行流量阈值:</label>
								                        <div class="col-md-6">
								                            <input type="text" class="form-control" id="txtTVMAddThreholdValueDownFlow" onblur="checkAddIsInt(this,'lblTVMAddErrortip','下行流量阈值')" placeholder="下行流量阈值"/>
								                        </div>
								                    </div>
								                    <div class="form-group" style="text-align: center">
								                        <label class="control-label" style="color: red;" id="lblTVMAddErrortip"></label>
								                    </div>
								
								                </form>
								            </div>
								            <div class="modal-footer">
								                <button type="button" class="btn btn-default" id="btnTVMAddClose" data-dismiss="modal">关闭</button>
								                <button type="button" class="btn btn-primary"  onClick="btnTVMAddSubmit();">确定</button>
								            </div>
								        </div>
								    </div>
								</div>
								<!-- ./add modal-->
								
								<!-- alter modal-->
								<div class="modal fade" id="btnTVMaltermodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
								                        <label class="col-sm-3 control-label" for="lblTVMAlterDeviceIP">设备IP：</label>
								                        <div class="col-sm-6">
								                            <label class="col-sm-2 control-label" id="lblTVMAlterDeviceIP"></label>
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label class="col-sm-3 control-label" for="txtTVMAlterThreholdValueCPU">CPU阈值:</label>
								                        <div class="col-sm-9">
								                            <input type="text" class="form-control" id="txtTVMAlterThreholdValueCPU" onblur="checkAddIsInt(this,'lblTVMAlterErrortip','CPU阈值')" placeholder="CPU阈值">
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label class="col-sm-3 control-label" for="txtTVMAlterThreholdValueMem">内存阈值:</label>
								                        <div class="col-sm-9">
								                            <input type="text" class="form-control" id="txtTVMAlterThreholdValueMem" onblur="checkAddIsInt(this,'lblTVMAlterErrortip','内存阈值')" placeholder="内存阈值">
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label class="col-sm-3 control-label" for="txtTVMAlterThreholdValueStor">硬盘阈值:</label>
								                        <div class="col-sm-9">
								                            <input type="text" class="form-control" id="txtTVMAlterThreholdValueStor" onblur="checkAddIsInt(this,'lblTVMAlterErrortip','硬盘阈值')" placeholder="硬盘阈值">
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label class="col-sm-3 control-label" for="txtTVMAlterThreholdValueUpFlow">上行流量阈值:</label>
								                        <div class="col-sm-9">
								                            <input type="text" class="form-control" id="txtTVMAlterThreholdValueUpFlow" onblur="checkAddIsInt(this,'lblTVMAlterErrortip','上行流量阈值')" placeholder="上行流量阈值">
								                        </div>
								                    </div>
								                    <div class="form-group">
								                        <label class="col-sm-3 control-label" for="txtTVMAlterThreholdValueDownFlow">下行流量阈值:</label>
								                        <div class="col-sm-9">
								                            <input type="text" class="form-control" id="txtTVMAlterThreholdValueDownFlow" onblur="checkAddIsInt(this,'lblTVMAlterErrortip','下行流量阈值')" placeholder="下行流量阈值">
								                        </div>
								                    </div>
								                    <div class="form-group" style="text-align: center">
								                        <label class="control-label" style="color: red;" id="lblTVMAlterErrortip"></label>
								                    </div>
								
								                </form>
								            </div>
								            <div class="modal-footer">
								                <button type="button" class="btn btn-default" id="btnTVMAlterCLose" data-dismiss="modal">关闭</button>
								                <button type="button" class="btn btn-primary"  onClick="btnTVMAlterSubmit();">确定</button>
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
					
					<script type="text/javascript" src="<%=basePath %>static/js/esm-threholdvalue.js"></script>
					<script type="text/javascript" src="<%=basePath %>static/js/common.js"></script>
					
</div>
</body>
</html>

