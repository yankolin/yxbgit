/**
 * 
 */
$(function(){
	btnSMSQuery();
});

function btnSMSQuery(){
	$('#myTab a[href="#drive"]').tab('show');//默认选定drive
	var myTable= document.getElementById("tableSMSShowDrive"); 
	var Ip = document.getElementById("txtSMSDeviceIP");
	var date = document.getElementById("datetimepicker").value;
	var datearr=date.split("/");
	var datestring=datearr[0]+datearr[1]+datearr[2];  //日期格式转换
	var deviceip=Ip.value;
    var errorId = "lblSMSErrortip";
    if(!checkInputDeviceIP(Ip,errorId) || !checkDateBeforeNow(errorId,date))
    	{
    	  return false;
    	}
    else{
    	/*  $('#driveTag').attr("href","#drive" );
    	  $('#driveTag').attr("onclick","btnSMSQueryDrive();");
    	  $('#mdiskTag').attr("href","#mdisk"  );
    	  $('#mdiskTag').attr("onclick","btnSMSQueryMdisk();");*/
    	if(!checkInputNull(date) ||datestring==getNowFormatDate() ){  //查询当前表
    	//alert(1);
    		showlblErrorTip(errorId,""); 
        	QueryDriveTempPaged(deviceip);
    	}else{  //查询指定日期
    		QueryDrivePastPaged();
    	}
    	
    }
}

function QueryDriveTempPaged(deviceip){
	$("#tableSMSShowDrive tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQuerycount?deviceip="+deviceip,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowDrive tbody").html("");
		QueryDriveTemp(deviceip,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryDriveTemp(deviceip,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应驱动记录");
	}
	
}

function QueryDriveTemp(deviceip,page,rows)
{
	var tbBody = "";
	$("#tableSMSShowDrive tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQuery?page="+page +"&deviceip="+deviceip,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][3]+ "</td>" +
       		 							"<td style='text-align:center'>" + data[i][4] + "</td>" +
       		 							"<td style='text-align:center'>" + data[i][5]+ "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][6])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][7]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowDrive tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function QueryDrivePastPaged(){
	$("#tableSMSShowDrive tbody").html("");
	var deviceip=document.getElementById("txtSMSDeviceIP").value;
	var date = document.getElementById("datetimepicker").value;
	var datearr=date.split("/");
	var datestring=datearr[0]+datearr[1]+datearr[2]; 
	
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQueryDrivePastcount?deviceip="+deviceip +"&date="+datestring,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowDrive tbody").html("");
		QueryDrivePast(deviceip,datestring,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryDrivePast(deviceip,datestring,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应驱动记录");
	}
	
}

function QueryDrivePast(deviceip,datestring,page,rows)
{
	//alert(1);
	var tbBody = "";
	$("#tableSMSShowDrive tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQueryDrivePastList?page="+page +"&deviceip="+deviceip+"&date="+datestring,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][3]+ "</td>" +
       		 							"<td style='text-align:center'>" + data[i][4] + "</td>" +
       		 							"<td style='text-align:center'>" + data[i][5]+ "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][6])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][7]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowDrive tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function btnSMSQueryDrive(){
	btnSMSQuery();
}

function btnSMSQueryMdisk(){
	var Ip = document.getElementById("txtSMSDeviceIP");
	var date = document.getElementById("datetimepicker").value;
	var datearr=date.split("/");
	var datestring=datearr[0]+datearr[1]+datearr[2];  //日期格式转换
	var deviceip=Ip.value;
    var errorId = "lblSMSErrortip";
    if(!checkInputDeviceIP(Ip,errorId) || !checkDateBeforeNow(errorId,date))
    	{
    	  return false;
    	}
    else{
    	if(!checkInputNull(date) ||datestring==getNowFormatDate() ){  //查询当前表
    	//alert(1);
    		showlblErrorTip(errorId,""); 
        	QueryMdiskTempPaged(deviceip);
    	}else{  //查询指定日期
    		QueryMdiskPastPaged(deviceip,datestring);
    	}
    	
    }
}

function btnSMSQueryVdisk(){
	var Ip = document.getElementById("txtSMSDeviceIP");
	var date = document.getElementById("datetimepicker").value;
	var datearr=date.split("/");
	var datestring=datearr[0]+datearr[1]+datearr[2];  //日期格式转换
	var deviceip=Ip.value;
    var errorId = "lblSMSErrortip";
    if(!checkInputDeviceIP(Ip,errorId) || !checkDateBeforeNow(errorId,date))
    	{
    	  return false;
    	}
    else{
    	if(!checkInputNull(date) ||datestring==getNowFormatDate() ){  //查询当前表
    	//alert(1);
    		showlblErrorTip(errorId,""); 
        	QueryVdiskTempPaged(deviceip);
    	}else{  //查询指定日期
    		QueryVdiskPastPaged(deviceip,datestring);
    	}
    	
    }
}

function btnSMSQueryHost(){
	var Ip = document.getElementById("txtSMSDeviceIP");
	var date = document.getElementById("datetimepicker").value;
	var datearr=date.split("/");
	var datestring=datearr[0]+datearr[1]+datearr[2];  //日期格式转换
	var deviceip=Ip.value;
    var errorId = "lblSMSErrortip";
    if(!checkInputDeviceIP(Ip,errorId) || !checkDateBeforeNow(errorId,date))
    	{
    	  return false;
    	}
    else{
    	if(!checkInputNull(date) ||datestring==getNowFormatDate() ){  //查询当前表
    	//alert(1);
    		showlblErrorTip(errorId,""); 
        	QueryHostTempPaged(deviceip);
    	}else{  //查询指定日期
    		QueryHostPastPaged(deviceip,datestring);
    	}
    	
    }
}

function btnSMSQueryEnclosure(){
	var Ip = document.getElementById("txtSMSDeviceIP");
	var date = document.getElementById("datetimepicker").value;
	var datearr=date.split("/");
	var datestring=datearr[0]+datearr[1]+datearr[2];  //日期格式转换
	var deviceip=Ip.value;
    var errorId = "lblSMSErrortip";
    if(!checkInputDeviceIP(Ip,errorId) || !checkDateBeforeNow(errorId,date))
    	{
    	  return false;
    	}
    else{
    	if(!checkInputNull(date) ||datestring==getNowFormatDate() ){  //查询当前表
    	//alert(1);
    		showlblErrorTip(errorId,""); 
        	QueryEnclosureTempPaged(deviceip);
    	}else{  //查询指定日期
    		QueryEnclosurePastPaged(deviceip,datestring);
    	}
    	
    }
}

function btnSMSQuerySystemInfo(){
	var Ip = document.getElementById("txtSMSDeviceIP");
	var date = document.getElementById("datetimepicker").value;
	var datearr=date.split("/");
	var datestring=datearr[0]+datearr[1]+datearr[2];  //日期格式转换
	var deviceip=Ip.value;
    var errorId = "lblSMSErrortip";
    if(!checkInputDeviceIP(Ip,errorId) || !checkDateBeforeNow(errorId,date))
    	{
    	  return false;
    	}
    else{
    	showlblErrorTip(errorId,""); 
    	QuerySystemInfoPaged(deviceip);   	
    }
}

function QueryMdiskTempPaged(deviceip){
	$("#tableSMSShowMdisk tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQueryMdiskTempcount?deviceip="+deviceip,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowMdisk tbody").html("");
		QueryMdiskTemp(deviceip,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryMdiskTemp(deviceip,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应Mdisk记录");
	}
	
}

function QueryMdiskTemp(deviceip,page,rows)
{
	var tbBody = "";
	$("#tableSMSShowMdisk tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQueryMdiskTemp?page="+page +"&deviceip="+deviceip,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][3]+ "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][4])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][5]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowMdisk tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function QueryMdiskPastPaged(deviceip,date){	
	$("#tableSMSShowMdisk tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQueryMdiskPastcount?deviceip="+deviceip +"&date="+date,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowMdisk tbody").html("");
		QueryMdiskPast(deviceip,date,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryMdiskPast(deviceip,date,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应Mdisk记录");
	}
	
}

function QueryMdiskPast(deviceip,date,page,rows)
{
	//alert(1);
	var tbBody = "";
	$("#tableSMSShowMdisk tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQueryMdiskPastList?page="+page +"&deviceip="+deviceip+"&date="+date,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][3]+ "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][4])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][5]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowMdisk tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function QueryVdiskTempPaged(deviceip){
	$("#tableSMSShowVdisk tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQueryVdiskTempcount?deviceip="+deviceip,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowVdisk tbody").html("");
		QueryVdiskTemp(deviceip,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryVdiskTemp(deviceip,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应Vdisk记录");
	}	
}

function QueryVdiskTemp(deviceip,page,rows)
{
	var tbBody = "";
	$("#tableSMSShowVdisk tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQueryVdiskTemp?page="+page +"&deviceip="+deviceip,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][3])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][4]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowVdisk tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function QueryVdiskPastPaged(deviceip,date){	
	$("#tableSMSShowVdisk tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQueryVdiskPastcount?deviceip="+deviceip +"&date="+date,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowVdisk tbody").html("");
		QueryVdiskPast(deviceip,date,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryVdiskPast(deviceip,date,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应Vdisk记录");
	}
}

function QueryVdiskPast(deviceip,date,page,rows)
{
	var tbBody = "";
	$("#tableSMSShowVdisk tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQueryVdiskPastList?page="+page +"&deviceip="+deviceip+"&date="+date,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][3])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][4]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowVdisk tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function QueryHostTempPaged(deviceip){
	$("#tableSMSShowHost tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQueryHostTempcount?deviceip="+deviceip,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowHost tbody").html("");
		QueryHostTemp(deviceip,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryHostTemp(deviceip,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应主机记录");
	}	
}

function QueryHostTemp(deviceip,page,rows)
{
	var tbBody = "";
	$("#tableSMSShowHost tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQueryHostTemp?page="+page +"&deviceip="+deviceip,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][3])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][4]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowHost tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function QueryHostPastPaged(deviceip,date){	
	$("#tableSMSShowHost tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQueryHostPastcount?deviceip="+deviceip +"&date="+date,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowHost tbody").html("");
		QueryHostPast(deviceip,date,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryHostPast(deviceip,date,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应主机记录");
	}
}

function QueryHostPast(deviceip,date,page,rows)
{
	var tbBody = "";
	$("#tableSMSShowHost tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQueryHostPastList?page="+page +"&deviceip="+deviceip+"&date="+date,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][3])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][4]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowHost tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}


function QueryEnclosureTempPaged(deviceip){
	$("#tableSMSShowEnclosure tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQueryEnclosureTempcount?deviceip="+deviceip,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowEnclosure tbody").html("");
		QueryEnclosureTemp(deviceip,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryEnclosureTemp(deviceip,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应机柜记录");
	}	
}

function QueryEnclosureTemp(deviceip,page,rows)
{
	var tbBody = "";
	$("#tableSMSShowEnclosure tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQueryEnclosureTemp?page="+page +"&deviceip="+deviceip,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][3]+ "</td>" +
       		 						 "<td style='text-align:center'>" +data[i][4]+ "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][5])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][6]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowEnclosure tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function QueryEnclosurePastPaged(deviceip,date){	
	$("#tableSMSShowEnclosure tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQueryEnclosurePastcount?deviceip="+deviceip +"&date="+date,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowEnclosure tbody").html("");
		QueryEnclosurePast(deviceip,date,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QueryEnclosurePast(deviceip,date,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应机柜记录");
	}
}

function QueryEnclosurePast(deviceip,date,page,rows)
{
	var tbBody = "";
	$("#tableSMSShowEnclosure tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQueryEnclosurePastList?page="+page +"&deviceip="+deviceip+"&date="+date,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][3] + "</td>" +
   		 							 "<td style='text-align:center'>" +data[i][4] + "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][5])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][6]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowEnclosure tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}



function QuerySystemInfoPaged(deviceip){
	$("#tableSMSShowSystemInfo tbody").html("");
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSMSQuerySystemInfocount?deviceip="+deviceip,
	async: false,
	dataType:"json",
	success:function(data){
	window.count = data[0];
	window.rows = data[1];
							}
					} );
	//                  alert(window.count);
	var totalPage = Math.ceil(window.count/window.rows);
	//alert(totalPage);
	var element = $('#bp-3-element-sm-test');
	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage:1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSMSShowSystemInfo tbody").html("");
		QuerySystemInfo(deviceip,curPage,rows);
					        }
	
		         };

	if(totalPage){
		$("#lblSMSAlertEmpty").html("");
		QuerySystemInfo(deviceip,1,rows);
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	$("#lblSMSAlertEmpty").html("没有相应系统记录");
	}	
}

function QuerySystemInfo(deviceip,page,rows)
{
	var tbBody = "";
	$("#tableSMSShowSystemInfo tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSMSQuerySystemInfo?page="+page +"&deviceip="+deviceip,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 						 "<td style='text-align:center'>" + data[i][0] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][3]+ "</td>" +
       		 							"<td style='text-align:center'>" + format(data[i][4])+ "</td>" +
       		 						"<td style='text-align:center'>" + data[i][5]+ "</td>" +
       		 							
       		 					"</tr>";
       	 			 }
       	$("#tableSMSShowSystemInfo tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}



function checkInputDeviceIP(em,errorId){
    //用户名不能为空，并且有最大长度限制
    var num = em.value;
    if(!checkInputNull(num)){
    	showlblErrorTip(errorId,"IP不能为空！"); 
        return false;
    }else{
    	 if(!IsIpValidate(num) ) {
    	        showlblErrorTip(errorId,"IP格式不正确！"); 
    	        return false;
    	    }else {
    	        showlblErrorTip(errorId,"");
    	        return true;
    	    }

    }
   
}

function checkDateBeforeNow(errorId,date){
	var datearr=date.split("/");
	var datestring=datearr[0]+datearr[1]+datearr[2];
	if(datestring>getNowFormatDate() && checkInputNull(date) ){
		showlblErrorTip(errorId,"不能超过当前日期！"); 
		return false;}
	else return true;
	}

function getNowFormatDate(){
    var day = new Date();
    var Year = 0;
    var Month = 0;
    var Day = 0;
    var CurrentDate = "";
    Year= day.getFullYear();//支持IE和火狐浏览器.
    Month= day.getMonth()+1;
    Day = day.getDate();
    CurrentDate += Year;
    if (Month >= 10 ){
     CurrentDate += Month;
    }
    else{
     CurrentDate += "0" + Month;
    }
    if (Day >= 10 ){
     CurrentDate += Day ;
    }
    else{
     CurrentDate += "0" + Day ;
    }
  //  alert(CurrentDate);
    return CurrentDate;
 }	

function add0(m){return m<10?'0'+m:m }
function format(time)
{
var date = new Date(parseInt(time));
var y = date.getFullYear();
var m = date.getMonth()+1;
var d = date.getDate();
var h = date.getHours();
var mm = date.getMinutes();
var s = date.getSeconds();
return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}