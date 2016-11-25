		<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

			<div id="page-floor">
					<div>@2016 版权所有：中国电建集团成都勘测设计研究院有限公司</div>
			</div>
    </div>
    <!-- /#wrapper -->
		
  <script type="text/javascript" src="<%=basePath %>static/js/bootstrap-paginator.js"></script>
    <!-- Morris Charts JavaScript
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script> -->
	 <script type="text/javascript">
		//$("#a_allstatus").show();
     // $('#a_allstatus').load('c.html');

		$(document).ready(function(){
			$("#m_allstatus").click(function(){
					hideAllDiv();
         		$("#a_allstatus").show();
         		$('#a_allstatus').load('c.html');
			});
			$("#m_servicestatus").click(function(){
					hideAllDiv();
     		$("#a_servicestatus").show();
     		$('#a_servicestatus').load('topo');
		});
			$("#m_userman").click(function(){
								hideAllDiv();
         		$("#a_userman").show();
         		$('#a_userman').load('userman');
			});
		});
		 function hideAllDiv() {
		   
	  	   if(document.getElementById){
	  			var ar = document.getElementsByTagName("div"); 
	  			var i;
	  			for(i=0;i<ar.length;i++){
	  				 if(ar[i].className == "a_content")
	  				 ar[i].style.display="none";	  				   
	  			}
	  		}
      		 }
	</script>