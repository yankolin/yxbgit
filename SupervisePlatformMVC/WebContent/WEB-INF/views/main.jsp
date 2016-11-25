<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<% response.setHeader("refresh","60"); %>     <!-- 60s刷新一次页面 -->
<html>
<link href="<%=basePath %>static/css/esm-main.css" rel="stylesheet">


<body >
<div id="wrapper">
		<jsp:include page="head.jsp"/> 
 				 <div id="page-wrapper">
				
            <div class="container-fluid">
						<!-- Page Heading -->
						<div class="row show-grid">
						    <div class="col-lg-12">
								<h3 class="page-header">
							   	 总体状态 <small></small>
								</h3>
								<ol class="breadcrumb">
							    	<li class="active">
										<i class="fa fa-table"></i> 总体状态图
										
										
							    	</li>
							    	<div id="button1"  style="float:right">
										 <input type="button"  style="float: right" onclick="history.go(0) " value="刷新"/>					
										</div>
								</ol>
								
						     </div>
						</div>
						<!-- /.row -->
						
       <table style="margin:auto;width:80%;height:90%">
<tr>
    <td>
        <div id="bigBox"  style="margin:auto;width:640px;height:920px;">
            <div id="top_left" style="background-image: url(static/img/ocean.jpg); float:left; width:620px;height:125px;margin-top:1px;margin-left: 10px;">
                <div id="chart1" class="pie-chart-tiny" data-percent="0 "style="height:113px;">
                    <span  class="percent"></span>
                    <span  class="pie-title" style="color: #ffffff;">CPU(AVG)</span>
                </div>
                <div id="chart2" class="pie-chart-tiny" data-percent="0"style="height:113px;">
                    <span class="percent"></span>
                    <span class="pie-title"style="color: #ffffff;">内存(AVG)</span>
                </div>
                <div id="chart3" class="pie-chart-tiny" data-percent="0"style="height:113px;">
                    <span class="percent"></span>
                    <span class="pie-title"style="color: #ffffff;">硬盘(AVG)</span>
                </div>
                <div id="chart4" class="pie-chart-tiny1" data-percent="0"style="height:113px;">
                    <span   class="percent1"></span>
                    <span class="pie-title"style="color: #ffffff;">上行流量(AVG)</span>
                </div>
                    <div id="chart5" class="pie-chart-tiny1" data-percent="0"style="height:113px;">
                    <span  class="percent3"></span>
                    <span class="pie-title"style="color: #ffffff;">下行流量(AVG)</span>
                </div>
            
          </div>
            <div id="bor1" style="float:left; width:650px;height:300px;margin-left:10px;margin-top:20px;margin-right: 10px;margin-bottom:20px;">
            <div id="bor1_left" style="float:left;width:300px;heght:330px" >
                设备分布情况
                <div style="width: 105%">
                    <canvas id="canvas" height="450" width="600" style="margin-left: 10px"></canvas>
                    <div id="barLegend" style="margin-left: 25px"></div>
                </div>
            </div >
             <div id="middle_left" style="float:left;width:152px;height:253px;margin-left: 30px;margin-top:30px">
                    三种设备比
                    <div style="width: 20%">
                        <canvas id="chart-area" width="132" height="142"></canvas>
                        <div id="pieLegend1"></div>
                    </div>
                </div>
                <div id="middle_right" style="float: left; width:152px;height:253px;margin-left: 10px;margin-top:30px">
                    预警设备正常设备比
                    <div style="width: 20%">
                        <canvas id="chart-area1" width="132" height="142"></canvas>
                        <div id="pieLegend2"></div>
                    </div>
                </div>
             </div>
        </div>
    </td>
</tr>
</table>
						
						
						
            </div>
            <!-- /.container-fluid -->
        
				
        </div>
        <!-- /#page-wrapper -->
        

<jsp:include page="foot.jsp"/> 
<script type="text/javascript" src="<%=basePath %>static/js/esm-main-sparkline.min.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/esm-main-easypiechart.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/esm-main-charts.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/esm-main-Chart.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/esm-main-legend.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/esm-main-table.js"></script>

</div>
</body>
</html>