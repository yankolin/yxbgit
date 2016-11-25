/**
 * 
 */
window.count = 0;
window.rows  = 0;
window.curPages = 1;

$(function(){
		var curPage = 1;
		$.ajax({
		type:"get",
		url:"/getSSQQuerycount",
		async: false,
		dataType:"json",
		success:function(data){
		window.count = data[0];
		window.rows = data[1];
								}
						} );
		var totalPage = Math.ceil(window.count/window.rows);
		var element = $('#bp-3-element-sm-test');
		
		options = {
		size:"small",
		bootstrapMajorVersion:3,
		currentPage: 1,
		numberOfPages: 10,
		totalPages:totalPage,
		 onPageClicked:function(event,originalEvent,type,curPage){
								window.curPages = curPage;						
			$("#tableSSQShow tbody").html("");
			refalshSSQTable(curPage,rows);
						        }
		
			         };
		
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
});

function refalshSSQTable(page,rows) {
	 var tbBody = "";
	 $.ajax({
        type: "get",
        url: "/getSSQQuery?page="+page,
        dataType: "json",
        success: function (data) {
        	var id = (page - 1) * rows;
        	 for(var i = 0; i < data.length; i++){
           		 mem=data[i][3]/1024/1024 ;
           		 allmem=data[i][4]/1024/1024;
           		 stor=data[i][5]/1024/1024 /1024;
           		 allstor=data[i][6]/1024/1024 /1024;
           		 tbBody += "<tr id="+ data[i][0]  +">"  + 
           		 							"<td style='text-align:center'>" + ++id + "</td>" +
           		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
           		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
           		 							 "<td style='text-align:center'>" +mem.toFixed(2)+ "</td>" +
           		 							"<td style='text-align:center'>" + allmem.toFixed(2) + "</td>" +
           		 							"<td style='text-align:center'>" + stor.toFixed(2) + "</td>" +
           		 							"<td style='text-align:center'>" + allstor.toFixed(2) + "</td>" +
    	       		 						 "<td style='text-align:center'>" + (data[i][7]/1024).toFixed(2) + "</td>" +
    	   		 							 "<td style='text-align:center'>" +(data[i][8]/1024).toFixed(2) + "</td>" +
           		 							"<td style='text-align: center'>"+
    													"<button type='button' class='btn btn-primary' onClick='btnSSQDetailInfo(" + data[i][0] + ")' >"+
    													"<i class='glyphicon glyphicon-th'></i></button></td>"+
    										 "<td style='display:none'>" + data[i][9] + "</td>"+
    										 "<td style='display:none'>" + data[i][10] + "</td>"+
    										 "<td style='display:none'>" + data[i][11] + "</td>"+
           		 					"</tr>";
           	 			 }
           	$("#tableSSQShow tbody").append(tbBody)
            				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	 
}

function btnSSQQuery()
{	
		var myTable= document.getElementById("tableSSQShow"); 
		var Ip = document.getElementById("txtSSQDeviceIP");
	    var date_begin = document.getElementById("datetimepicker_begin").value;
	    var date_end = document.getElementById("datetimepicker_end").value;
	    var errorId = "lblSSQAddErrortip";
	    var deviceIp=Ip.value;
	    var begin=date_begin.split("/"); 
		var datestring_begin=begin[0] + begin[1] +begin[2];
		var end=date_end.split("/");
		var datestring_end=end[0]+end[1]+end[2];
	    var timeflag=ErrorType(date_begin,date_end);
	    if(!checkInputNull(deviceIp)){
	    	switch (timeflag)
	    	{
	    	case 0:
	    		showlblErrorTip(errorId,"至少输入IP或时间！");
	    	  break;
	    	case 1:
	    		showlblErrorTip(errorId,"请输入起始时间！");
	    	  break;
	    	case 2:
	    		showlblErrorTip(errorId,"请输入结束时间！");
	    	  break;
	    	case 3:
	    		showlblErrorTip(errorId,"起始时间不能大于结束时间！");
	    	  break;
	    	case 4:
	    		showlblErrorTip(errorId,"不能超过当前日期！");
	    	  break;
	    	case 5:
	    		//myTable.style.display="block";
	    		showlblErrorTip(errorId,"");
	    		QueryByDateRangePaged(datestring_begin,datestring_end);
	    		QueryByDateRange(datestring_begin,datestring_end,1,window.rows);	
	    	  break;
	    	  default:
	    		  break;
	    	}
	    }
	    else {
	    	if(checkInputDeviceIP(Ip,errorId)){
	    		switch (timeflag)
		    	{
		    	case 0:
		    		showlblErrorTip(errorId,"");
		    		QueryByDeviceIpPaged(deviceIp);
		    		QueryByDeviceIP(deviceIp,1,window.rows);
		    		//myTable.style.display="block";
		    	  break;
		    	case 1:
		    		showlblErrorTip(errorId,"请输入起始时间！");
		    	  break;
		    	case 2:
		    		showlblErrorTip(errorId,"请输入结束时间！");
		    	  break;
		    	case 3:
		    		showlblErrorTip(errorId,"起始时间不能大于结束时间！");
		    	  break;
		    	case 4:
		    		showlblErrorTip(errorId,"不能超过当前日期！");
		    	  break;
		    	case 5:
		    		//myTable.style.display="block";
		    		showlblErrorTip(errorId,"");
		    		QueryByMultiplePaged(deviceIp,datestring_begin,datestring_end);
		    		QueryByMultiple(deviceIp,datestring_begin,datestring_end,1,rows);
		    	  break;
		    	  default:
		    		  break;
		    	}
	    	}
	    	
	    }
	    
	}

function QueryByDeviceIpPaged(deviceip){
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSSQQueryByIPcount?deviceip="+deviceip,
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
		$("#tableSSQShow tbody").html("");
		QueryByDeviceIP(deviceip,curPage,rows);
					        }
	
		         };

	if(totalPage){
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	alert("没有查询到相关记录");
	}
	
}

function QueryByDeviceIP(deviceip,page,rows)
{
	var tbBody = "";
	var mem,allmem,stor,allstor;
	$("#tableSSQShow tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSSQQueryByIP?page="+page +"&deviceip="+deviceip,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 mem=data[i][3]/1024/1024 ;
       		 allmem=data[i][4]/1024/1024;
       		 stor=data[i][5]/1024/1024 /1024;
       		 allstor=data[i][6]/1024/1024 /1024;
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							 "<td style='text-align:center'>" +mem.toFixed(2)+ "</td>" +
       		 							"<td style='text-align:center'>" + allmem.toFixed(2) + "</td>" +
       		 							"<td style='text-align:center'>" + stor.toFixed(2) + "</td>" +
       		 							"<td style='text-align:center'>" + allstor.toFixed(2) + "</td>" +
	       		 						 "<td style='text-align:center'>" + (data[i][7]/1024).toFixed(2) + "</td>" +
	   		 							 "<td style='text-align:center'>" + (data[i][8]/1024).toFixed(2) + "</td>" +
       		 							"<td style='text-align: center'>"+
													"<button type='button' class='btn btn-primary' onClick='btnSSQDetailInfo(" + data[i][0] + ")' >"+
													"<i class='glyphicon glyphicon-th'></i></button></td>"+
										 "<td style='display:none'>" + data[i][9] + "</td>"+
										 "<td style='display:none'>" + data[i][10] + "</td>"+
										 "<td style='display:none'>" + data[i][11] + "</td>"+
       		 					"</tr>";
       	 			 }
       	$("#tableSSQShow tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function QueryByDateRangePaged(datestring_begin,datestring_end){
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSSQQueryByDateRangecount?date_begin="+datestring_begin +"&date_end="+datestring_end,
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
	currentPage: 1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSSQShow tbody").html("");
		QueryByDateRange(datestring_begin,datestring_end,curPage,rows);
					        }
	
		         };
	
	if(totalPage){
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	alert("没有查询到相关记录");
	}
}

function QueryByDateRange(datestring_begin,datestring_end,page,rows)
{
	var tbBody = "";
	var mem,allmem,stor,allstor;
	$("#tableSSQShow tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSSQQueryByDateRange?page="+page +"&date_begin="+datestring_begin+"&date_end="+datestring_end,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 mem=data[i][3]/1024/1024 ;
       		 allmem=data[i][4]/1024/1024;
       		 stor=data[i][5]/1024/1024 /1024;
       		 allstor=data[i][6]/1024/1024 /1024;
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		 							/*"<td style='text-align:center'>" +  ++id  + "</td>" +*/
       		"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							 "<td style='text-align:center'>" +mem.toFixed(2)+ "</td>" +
       		 							"<td style='text-align:center'>" + allmem.toFixed(2) + "</td>" +
       		 							"<td style='text-align:center'>" + stor.toFixed(2) + "</td>" +
       		 							"<td style='text-align:center'>" + allstor.toFixed(2) + "</td>" +
	       		 						 "<td style='text-align:center'>" + (data[i][7]/1024).toFixed(2) + "</td>" +
	   		 							 "<td style='text-align:center'>" +(data[i][8]/1024).toFixed(2) + "</td>" +
       		 							"<td style='text-align: center'>"+
													"<button type='button' class='btn btn-primary' onClick='btnSSQDetailInfo(" + data[i][0] + ")' >"+
													"<i class='glyphicon glyphicon-th'></i></button></td>"+
										 "<td style='display:none'>" + data[i][9] + "</td>"+
										 "<td style='display:none'>" + data[i][10] + "</td>"+
										 "<td style='display:none'>" + data[i][11] + "</td>"+
       		 					"</tr>";
       	 			 }
       	$("#tableSSQShow tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
	}

function QueryByMultiplePaged(deviceip,datestring_begin,datestring_end){
	var curPage = 1;
	$.ajax({
	type:"get",
	url:"/getSSQQueryByMultiplecount?date_begin="+datestring_begin +"&date_end="+datestring_end+"&deviceip="+deviceip,
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
	currentPage: 1,
	numberOfPages: 10,
	totalPages:totalPage,
	 onPageClicked:function(event,originalEvent,type,curPage){
							window.curPages = curPage;						
		$("#tableSSQShow tbody").html("");
		QueryByMultiple(deviceip,datestring_begin,datestring_end,curPage,rows);
					        }
	
		         };
	
	if(totalPage){
		document.getElementById('bp-3-element-sm-test').style.display = "block";
		element.bootstrapPaginator(options);
		
		element.hasClass('pagination-sm');
	}else{
	document.getElementById('bp-3-element-sm-test').style.display = "none";
	alert("没有查询到相关记录");
	}
}

function QueryByMultiple(deviceip,datestring_begin,datestring_end,page,rows){
	var tbBody = "";
	var mem,allmem,stor,allstor,upflowavg,downflowavg;
	$("#tableSSQShow tbody").html("");
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/getSSQQueryByMultiple?page="+page +"&date_begin="+datestring_begin+"&date_end="+datestring_end+"&deviceip="+deviceip,//要发送的后台地址
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {
        var id = (page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 mem=data[i][3]/1024/1024 ;
       		 allmem=data[i][4]/1024/1024;
       		 stor=data[i][5]/1024/1024 /1024;
       		 allstor=data[i][6]/1024/1024 /1024;
       		upflowavg=data[i][7]/1024;
       		downflowavg=data[i][8]/1024;
       		 tbBody += "<tr id="+ data[i][0]  +">"  + 
       		"<td style='text-align:center'>" +  ++id  + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][1] + "</td>" +
       		 							 "<td style='text-align:center'>" +data[i][2] + "</td>" +
       		 							 "<td style='text-align:center'>" +mem.toFixed(2)+ "</td>" +
       		 							"<td style='text-align:center'>" + allmem.toFixed(2) + "</td>" +
       		 							"<td style='text-align:center'>" + stor.toFixed(2) + "</td>" +
       		 							"<td style='text-align:center'>" + allstor.toFixed(2) + "</td>" +
	       		 						 "<td style='text-align:center'>" + upflowavg.toFixed(2)+ "</td>" +
	   		 							 "<td style='text-align:center'>" +downflowavg.toFixed(2) + "</td>" +
       		 							"<td style='text-align: center'>"+
													"<button type='button' class='btn btn-primary' onClick='btnSSQDetailInfo(" + data[i][0] + ")' >"+
													"<i class='glyphicon glyphicon-th'></i></button></td>"+
										 "<td style='display:none'>" + data[i][9] + "</td>"+
										 "<td style='display:none'>" + data[i][10] + "</td>"+
										 "<td style='display:none'>" + data[i][11] + "</td>"+
       		 					"</tr>";
       	 			 }
       	$("#tableSSQShow tbody").append(tbBody)
        				},
        errorId: function (msg) {
            alert(msg);
                        }
    		});
}


function btnSSQDetailInfo(em){
	var id=document.getElementById(em).cells[0].innerHTML;
	var deviceip=document.getElementById(em).cells[1].innerHTML;
	var cpu=document.getElementById(em).cells[2].innerHTML;
	var allmem=document.getElementById(em).cells[3].innerHTML;
	var mem=document.getElementById(em).cells[4].innerHTML;
	var allstor=document.getElementById(em).cells[5].innerHTML;
	var stor=document.getElementById(em).cells[6].innerHTML;
	var upflow=document.getElementById(em).cells[7].innerHTML;
	var downflow=document.getElementById(em).cells[8].innerHTML;
	var name=document.getElementById(em).cells[10].innerHTML;
	var desc=document.getElementById(em).cells[11].innerHTML;
	var time=document.getElementById(em).cells[12].innerHTML;
	 var datestring=format(time);
	document.getElementById("txtSSQServiceStatusId").innerHTML = id;
	document.getElementById("txtSSQDeviceIp").innerHTML = deviceip;
	document.getElementById("txtSSQCPU").innerHTML = cpu+"%";
	document.getElementById("txtSSQAllMem").innerHTML = allmem+"GB";
	document.getElementById("txtSSQMem").innerHTML = mem+"GB";
	document.getElementById("txtSSQAllStor").innerHTML = allstor+"GB";
	document.getElementById("txtSSQStor").innerHTML = stor+"GB";
	document.getElementById("txtSSQUpFlow").innerHTML = upflow+"KB/s";
	document.getElementById("txtSSQDownFlow").innerHTML = downflow+"KB/s";
	document.getElementById("txtSSQName").innerHTML = name;
	document.getElementById("txtSSQDesc").innerHTML = desc;
	document.getElementById("txtSSQDate").innerHTML = datestring;
	$('#DetailInfoModal').modal('show');
}

function ErrorType(em_begin,em_end){
	if(!checkInputNull(em_begin) && !checkInputNull(em_end)){
		return 0;//同为NULL
	}
	else{
		if(!checkInputNull(em_begin) && checkInputNull(em_end)){
			return 1;//只有end为空
		}
		else{
			if(checkInputNull(em_begin) && !checkInputNull(em_end)){
    			return 2;//只有begin为空
			}
			else{
				if(em_end < em_begin)
					return 3;
				else{
					var end=em_end.split("/");
					var datestring_end=end[0]+end[1]+end[2];
					if(datestring_end>getNowFormatDate())return 4;
					else return 5;
				}
				}
			}
	}
}

//核对IP是否正确
function checkInputDeviceIP(em,errorId){
    //用户名不能为空，并且有最大长度限制
    var num = em.value;
    if(!IsIpValidate(num) &&(num != "" && num.length != 0) ) {
        showlblErrorTip(errorId,"IP格式不正确！"); 
        return false;
    }else {
        showlblErrorTip(errorId,"");
        return true;
    }

}

//获取当前日期
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