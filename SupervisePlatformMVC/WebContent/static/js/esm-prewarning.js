/**
 * Created by rui on 2016/3/30.
 */
window.count = 0;
window.rows  = 0;
window.curPages = 1;
 $(function(){
						 //var count = 0;
						 var curPage = 1;
						 //var rows = 0;
           $.ajax({
           type:"get",
           url:"/getPreWarningInfocount",
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
	             		$("#tableUMShow tbody").html("");
	             		document.getElementById("lhint").innerHTML="";
	             		refalshUMTable(curPage,rows);
	             					        }
					 
            			         };

            element.bootstrapPaginator(options);

           element.hasClass('pagination-sm');
    });
 
 function refalshUMTable(page,rows) {
	 var tbBody = "";
	 $.ajax({
         type: "get",//数据发送的方式（post 或者 get）
         url: "/showPreWarningInfoJson?page="+page,//要发送的后台地址
         //data: {page:page},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
         dataType: "json",//后台处理后返回的数据格式
         success: function (data) {//ajax请求成功后触发的方法
        	 //console.log(data);
        	 
            // var date;
        	 var id = (page - 1) * rows;
        	 for(var i = 0; i < data.length; i++){
        		 									//	alert(data[i].userManEmail);
        	//	date=new Date(parseInt(data[i][7]));
        		// datestring=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
        		//.replace(regexp, replaceValue)replace(/年|月/g,"-").replace(/日/g," ");
        		 tbBody += "<tr id="+ data[i][0]  +"><td style='text-align:center'>" + ++id + "</td>" + 
        		 							 "<td style='text-align:center'>" + data[i][8] + "</td>" +
        		 							 "<td style='text-align:center'>" + data[i][2] + "</td>"+
        		 							 "<td style='text-align:center'>" + data[i][3] + "</td>" +
        		 							 "<td style='text-align:center'>" + data[i][4] + "</td>" + 
        		 							"<td style='text-align:center'>" + data[i][5] + "</td>" +
        		 							"<td style='text-align:center'>" + data[i][6] + "</td>" +
        		 							"<td style='text-align:center'>"+ formatDate(data[i][7]) +"</td>" + "<td style='text-align: center'>"+
       		 							 "<button  type='button' class='btn btn-info'  onClick='btnShowInfo(" + data[i][0] + ")' >"+
											"<i class='glyphicon glyphicon-list-alt'></i></button></td>"+
							 "</tr>";
        	 			 }
        	                  
        	 //formatDate(data[i][7])  formatDate(data[i][7])
        	     //  tbBody += "</tbody>";
        	  		//alert(tbBody);
        	  		//$("#table-userman").append(tbBody); 
        	  		$("#tableUMShow tbody").append(tbBody);//  alert(data[1]["userManEmail"]);
        	  	  //alert($("#table-userman").html());
         				},
         errorId: function (msg) {//ajax请求失败后触发的方法
             alert(msg);//弹出错误信息
                         }
     		});
	 
}
 
 function   formatDate(date)   {    
	 var now=new Date(date);
     var   year=now.getFullYear();     
     var   month=now.getMonth()+1;     
     var   date=now.getDate();     
     var   hour=now.getHours();     
     var   minute=now.getMinutes();     
     var   second=now.getSeconds();  
     if(minute<10) minute="0"+minute;
    	 if(second<10)
        return   year+"-"+month+"-"+date+"   "+hour+":"+minute+":0"+second; 
     return   year+"-"+month+"-"+date+"   "+hour+":"+minute+":"+second; 
}  
 
 function btnShowInfo(em) {  //显示详细信息
	 var id=parseInt(em); 
	 var i=0;
	
	 document.getElementById("lhint").innerHTML="";
	 
	 $.ajax({
         type:"get",
         url:"/showPreWarningInfoJson_pid?pid="+id,
         async: false,
         dataType:"json",
         success:function(data){
      	         
    
        	if(data.length==0)
        		document.getElementById("lhint").innerHTML="暂时不能显示！";
		
        	else{
		document.getElementById("pinfoId").innerHTML = data[i][0]; //不是序列号 ，是表中的预警ID
		document.getElementById("dId").innerHTML = data[i][1];
		document.getElementById("cpu").innerHTML = data[i][2];
		document.getElementById("mem").innerHTML = data[i][3];
		document.getElementById("stor").innerHTML = data[i][4];
		document.getElementById("upfl").innerHTML = data[i][5];
		document.getElementById("downfl").innerHTML = data[i][6];
		document.getElementById("pdate").innerHTML = formatDate(data[i][7]);     /*formatDate(data[i][7]);*/
		document.getElementById("dIp").innerHTML = data[i][8];
		document.getElementById("dname").innerHTML = data[i][9];
		document.getElementById("dtype").innerHTML = data[i][10];
		document.getElementById("dlo").innerHTML = data[i][11];
		document.getElementById("desc").innerHTML= data[i][12];
		document.getElementById("ddate").innerHTML = formatDate(data[i][13]);
		
		$('#btn_showinfo').modal('show');
		}
        	}})
	}

	function btnShowSearchInfo(){  //查询
		var ip=document.getElementById("search_ip").value;
		var date=document.getElementById("search_date").value;
		var date_str=date.replace(/-/g, "");
		document.getElementById("lhint").innerHTML="";
		
		
		
		
		if(ip=="" && date==""){
			document.getElementById("lhint").innerHTML="请输入查询IP或日期！";}
		else{
			  if(date==""){
				  
				  btnShowSearchInfo_ip(ip);}
		      else{  
		    	   if(ip==""){
		    		  
		    		   btnShowSearchInfo_date(date_str);}
		          
		    	   else{ 
		    		  
		    		   btnShowSearchInfo_date_ip(ip,date_str)  ;}
		      }
		
	/*	var Page=1;var rows;
		
		$.ajax({
			type:"get",
			url:"/getPreWarningSearchInfocount?ip="+ip+"&date="+date_str,
			async: false,
			dataType:"json",
			success:function(data){
			
			rows = data[1];}});
		
		refalshSearchInfo(Page,rows,ip,date_str);
	
		
		ShowSearchInfolabel(ip,date_str); */
		
	
		
		
		
		}
	}

		


function btnShowSearchInfo_ip(ip){
	var Page=1;var rows;
	
	$.ajax({
		type:"get",
		url:"/getPreWarningSearchInfocount_ip?ip="+ip,
		async: false,
		dataType:"json",
		success:function(data){
		
		rows = data[1];}});
	
	refalshSearchInfo_ip(Page,rows,ip);

	
	ShowSearchInfolabel_ip(ip);
}

function refalshSearchInfo_ip(Page,rows,ip){
	$("#tableUMShow tbody").html("");
	 var tbBody = "";
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/showPreWarningSearchInfoJson_ip?page="+Page+"&ip="+ip,//要发送的后台地址
        //data: {page:page},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {//ajax请求成功后触发的方法
       	 //console.log(data);
       	 if(data.length==0)
       		document.getElementById("lhint").innerHTML="根据查询条件找不到相关信息！";//alert('根据查询条件找不到相关信息！');
           // var date;
       	 else{
       	 var id = (Page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 									//	alert(data[i].userManEmail);
       	//	date=new Date(parseInt(data[i][7]));
       		// datestring=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
       		//.replace(regexp, replaceValue)replace(/年|月/g,"-").replace(/日/g," ");
       		 tbBody += "<tr id="+ data[i][0]  +"><td style='text-align:center'>" + ++id + "</td>" + 
       		 							 "<td style='text-align:center'>" + data[i][8] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][2] + "</td>"+
       		 							 "<td style='text-align:center'>" + data[i][3] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][4] + "</td>" + 
       		 							"<td style='text-align:center'>" + data[i][5] + "</td>" +
       		 							"<td style='text-align:center'>" + data[i][6] + "</td>" +
       		 							"<td style='text-align:center'>" + formatDate(data[i][7]) +"</td>" + "<td style='text-align: center'>"+
      		 							 "<button  type='button' class='btn btn-info'  onClick='btnShowInfo(" + data[i][0] + ")' >"+
											"<i class='glyphicon glyphicon-list-alt'></i></button></td>"+
							 "</tr>";
       	 			 }
       	                  
       	 //formatDate(data[i][7])
       	     //  tbBody += "</tbody>";
       	  		//alert(tbBody);
       	  		//$("#table-userman").append(tbBody); 
       	  		$("#tableUMShow tbody").append(tbBody);//  alert(data[1]["userManEmail"]);
       	  	  //alert($("#table-userman").html());
        				}},
        errorId: function (msg) {//ajax请求失败后触发的方法
            alert(msg);//弹出错误信息
                        }
    		});
}

function ShowSearchInfolabel_ip(ip){
	 var curPage = 1;
	 //var rows = 0;
$.ajax({
type:"get",
url:"/getPreWarningSearchInfocount_ip?ip="+ip,
async: false,
dataType:"json",
success:function(data){
window.count = data[0];
window.rows = data[1];
						}
				} );
if(window.count==0)
	refalshSearchInfo_label();
//                  alert(window.count);
else{
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
	
						refalshSearchInfo_ip(curPage,rows,ip);
				        }

	         };

element.bootstrapPaginator(options);

element.hasClass('pagination-sm');}
}






function btnShowSearchInfo_date(date){
	var Page=1;var rows;
	
	$.ajax({
		type:"get",
		url:"/getPreWarningSearchInfocount_date?date="+date,
		async: false,
		dataType:"json",
		success:function(data){
		
		rows = data[1];}});
	
	refalshSearchInfo_date(Page,rows,date);

	
	ShowSearchInfolabel_date(date);
}

function refalshSearchInfo_date(Page,rows,date){
	$("#tableUMShow tbody").html("");
	 var tbBody = "";
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/showPreWarningSearchInfoJson_date?page="+Page+"&date="+date,//要发送的后台地址
        //data: {page:page},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {//ajax请求成功后触发的方法
       	 //console.log(data);
       	 if(data.length==0)
       		document.getElementById("lhint").innerHTML="根据查询条件找不到相关信息！";
           // var date;
       	 else{
       	 var id = (Page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 									//	alert(data[i].userManEmail);
       	//	date=new Date(parseInt(data[i][7]));
       		// datestring=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
       		//.replace(regexp, replaceValue)replace(/年|月/g,"-").replace(/日/g," ");
       		 tbBody += "<tr id="+ data[i][0]  +"><td style='text-align:center'>" + ++id + "</td>" + 
       		 							 "<td style='text-align:center'>" + data[i][8] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][2] + "</td>"+
       		 							 "<td style='text-align:center'>" + data[i][3] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][4] + "</td>" + 
       		 							"<td style='text-align:center'>" + data[i][5] + "</td>" +
       		 							"<td style='text-align:center'>" + data[i][6] + "</td>" +
       		 							"<td style='text-align:center'>" + formatDate(data[i][7]) +"</td>" + "<td style='text-align: center'>"+
      		 							 "<button  type='button' class='btn btn-info'  onClick='btnShowInfo(" + data[i][0] + ")' >"+
											"<i class='glyphicon glyphicon-list-alt'></i></button></td>"+
							 "</tr>";
       	 			 }
       	                  
       	 //formatDate(data[i][7])
       	     //  tbBody += "</tbody>";
       	  		//alert(tbBody);
       	  		//$("#table-userman").append(tbBody); 
       	  		$("#tableUMShow tbody").append(tbBody);//  alert(data[1]["userManEmail"]);
       	  	  //alert($("#table-userman").html());
        				}},
        errorId: function (msg) {//ajax请求失败后触发的方法
            alert(msg);//弹出错误信息
                        }
    		});
}

function ShowSearchInfolabel_date(date){
	 var curPage = 1;
	 //var rows = 0;
$.ajax({
type:"get",
url:"/getPreWarningSearchInfocount_date?date="+date,
async: false,
dataType:"json",
success:function(data){
window.count = data[0];
window.rows = data[1];
						}
				} );
if(window.count==0)
	refalshSearchInfo_label();
else{
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
	
						refalshSearchInfo_date(curPage,rows,date);
				        }

	         };

element.bootstrapPaginator(options);

element.hasClass('pagination-sm');}
}


function btnShowSearchInfo_date_ip(ip,date){
	
	var Page=1;var rows;

$.ajax({
	type:"get",
	url:"/getPreWarningSearchInfocount?ip="+ip+"&date="+date,
	async: false,
	dataType:"json",
	success:function(data){
	
	rows = data[1];}});

refalshSearchInfo(Page,rows,ip,date);


ShowSearchInfolabel(ip,date);
}

function ShowSearchInfolabel(ip,date){
	 //var count = 0;
	 var curPage = 1;
	 //var rows = 0;
$.ajax({
type:"get",
url:"/getPreWarningSearchInfocount?ip="+ip+"&date="+date,
async: false,
dataType:"json",
success:function(data){
window.count = data[0];
window.rows = data[1];
						}
				} );
if(window.count==0)
	refalshSearchInfo_label();
else{
//                 alert(window.count);
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
	
	refalshSearchInfo(curPage,rows,ip,date);
				        }

	         };

element.bootstrapPaginator(options);

element.hasClass('pagination-sm');}
}
		
function refalshSearchInfo(Page,rows,ip,date){
	$("#tableUMShow tbody").html("");
	 var tbBody = "";
	 $.ajax({
        type: "get",//数据发送的方式（post 或者 get）
        url: "/showPreWarningSearchInfoJson?page="+Page+"&ip="+ip+"&date="+date,//要发送的后台地址
        //data: {page:page},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType: "json",//后台处理后返回的数据格式
        success: function (data) {//ajax请求成功后触发的方法
       	 //console.log(data);
       	 if(data.length==0)
       		document.getElementById("lhint").innerHTML="根据查询条件找不到相关信息！";
           // var date;
       	 else{
       	 var id = (Page - 1) * rows;
       	 for(var i = 0; i < data.length; i++){
       		 									//	alert(data[i].userManEmail);
       	//	date=new Date(parseInt(data[i][7]));
       		// datestring=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
       		//.replace(regexp, replaceValue)replace(/年|月/g,"-").replace(/日/g," ");
       		 tbBody += "<tr id="+ data[i][0]  +"><td style='text-align:center'>" + ++id + "</td>" + 
       		 							 "<td style='text-align:center'>" + data[i][8] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][2] + "</td>"+
       		 							 "<td style='text-align:center'>" + data[i][3] + "</td>" +
       		 							 "<td style='text-align:center'>" + data[i][4] + "</td>" + 
       		 							"<td style='text-align:center'>" + data[i][5] + "</td>" +
       		 							"<td style='text-align:center'>" + data[i][6] + "</td>" +
       		 							"<td style='text-align:center'>" + formatDate(data[i][7]) +"</td>" + "<td style='text-align: center'>"+
      		 							 "<button  type='button' class='btn btn-info'  onClick='btnShowInfo(" + data[i][0] + ")' >"+
											"<i class='glyphicon glyphicon-list-alt'></i></button></td>"+
							 "</tr>";
       	 			 }
       	                  
       	 //formatDate(data[i][7])
       	     //  tbBody += "</tbody>";
       	  		//alert(tbBody);
       	  		//$("#table-userman").append(tbBody); 
       	  		$("#tableUMShow tbody").append(tbBody);//  alert(data[1]["userManEmail"]);
       	  	  //alert($("#table-userman").html());
        				}},
        errorId: function (msg) {//ajax请求失败后触发的方法
            alert(msg);//弹出错误信息
                        }
    		});
}


function refalshSearchInfo_label(){  //隐藏页标签
	var element = $('#bp-3-element-sm-test');

	options = {
	size:"small",
	bootstrapMajorVersion:3,
	currentPage: 1,
	numberOfPages: 0,
	totalPages:1,
	

		         };

	element.bootstrapPaginator(options);

	element.hasClass('pagination-sm');
}