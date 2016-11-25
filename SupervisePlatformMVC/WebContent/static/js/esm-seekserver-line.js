Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	} //格式化date

var status1=new Array();
var initIp=new Array();
getinitIp();

function getinitIp(){
	 $.ajax({
         type: "get",//数据发送的方式（post 或者 get）
         url: "/getIpJson",//要发送的后台地址
         //data: {page:page},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
         async:false,
         dataType: "json",//后台处理后返回的数据格式
         success: function (data) {//ajax请求成功后触发的方法
        	 console.log(data)
        	 initIp=data;
             }
     });
	 var tableName="Temp";
	 var time=new Date();
	 var starttime=time.getTime();
	 endtime=starttime+3600000;//一个小时的毫秒数
	 var endDate=new Date(endtime).Format("yyyy-MM-dd hh:02:00");
	 var startDate=new Date(starttime).Format("yyyy-MM-dd hh:00:00");//获取当前日期
	 document.getElementById("nowDevice").value=initIp[0];  //显示当前IP
	 document.getElementById("starttime").value=starttime;
	 document.getElementById("endtime").value=endtime;
	 document.getElementById("deviceIp").value=initIp[0];
	 document.getElementById("tableName").value=tableName;   //暂存4个参数
	 var deviceIp=initIp[0];

	 refleshServerStatusTable(deviceIp,startDate,endDate,tableName);   //页面初始化传递的参数

}
function  lastOneHour(){
	deviceIp=document.getElementById("deviceIp").value;
	tableName=document.getElementById("tableName").value;   
	var endtime=document.getElementById("endtime").value - 0;
	var endDate=new Date(endtime).Format("yyyy-MM-dd hh:02:00");
	//alert(endDate+"++++++");
	var temp=new Date().Format("yyyy-MM-dd 01:02:00");
	//alert(temp+"*****");
		if(endDate==temp){
			//alert(endDate+"****");
			var starttime=document.getElementById("starttime").value - 0;
			var endtime=document.getElementById("endtime").value - 0;
		}
		else{
		    var endtime=document.getElementById("starttime").value - 0;
			var starttime=endtime-3600000;
		}
		var endDate=new Date(endtime).Format("yyyy-MM-dd hh:02:00");
		var startDate=new Date(starttime).Format("yyyy-MM-dd hh:00:00");
		document.getElementById("starttime").value=starttime;
		document.getElementById("endtime").value=endtime;
		
		refleshServerStatusTable(deviceIp,startDate,endDate,tableName);
	    //alert(endDate);
		 charts();	 
	  }
function  nextOneHour(){
deviceIp=document.getElementById("deviceIp").value;
tableName=document.getElementById("tableName").value; 
var starttime=document.getElementById("starttime").value - 0;
var startDate=new Date(starttime).Format("yyyy-MM-dd hh:00:00");
var temp=new Date().Format("yyyy-MM-dd hh:00:00");
if(startDate==temp){
	var starttime=document.getElementById("starttime").value - 0;
	var endtime=document.getElementById("endtime").value - 0;
}
else{
	var starttime=document.getElementById("endtime").value - 0;
	var endtime=starttime+3600000;
}
	var endDate=new Date(endtime).Format("yyyy-MM-dd hh:02:00");
	var startDate=new Date(starttime).Format("yyyy-MM-dd hh:00:00");
	document.getElementById("starttime").value=starttime;
	document.getElementById("endtime").value=endtime;
	//获取当前日期
	refleshServerStatusTable(deviceIp,startDate,endDate,tableName);
	 charts();	
	 
  }
function clickQuery(){
	deviceIP=document.getElementById("deviceIP").value;
	startDate1=document.getElementById("datetimepicker").value;  //获取yyyy/mm/dd格式
	if(deviceIP==""){
		alert("设备IP不能为空!");
		window.location.reload();
	}
	
	if(startDate1==""){
		starttime=new Date().getTime();//转换成时间戳格式
		startDate=new Date(starttime).Format("yyyy-MM-dd hh:00:00");//转换成yyyy-mm-dd格式
	}
	else{
	starttime=new Date(startDate1).getTime();//转换成时间戳格式
	startDate=new Date(starttime).Format("yyyy-MM-dd hh:00:00");//转换成yyyy-mm-dd格式
	}
	endtime=starttime+3600000;//一个小时的毫秒数
	endDate=new Date(endtime).Format("yyyy-MM-dd hh:02:00");
	tableName=new Date(starttime).Format("yyyy-MM-dd");
	document.getElementById("starttime").value=starttime;
	document.getElementById("endtime").value=endtime;
	document.getElementById("deviceIp").value=deviceIP;
	document.getElementById("tableName").value=tableName; 
	document.getElementById("nowDevice").value=deviceIP;
	refleshServerStatusTable(deviceIP,startDate,endDate,tableName);
	charts();
}
function  refleshServerStatusTable(var0,var1,var2,var3){
       	 $.ajax({
                type: "post",//数据发送的方式（post 或者 get）
                url: "/getServiceStatusJson",//要发送的后台地址
                data: {ip:var0,time1:var1,time2:var2,tName:var3},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
                async:false,
                dataType: "json",//后台处理后返回的数据格式
                success: function (data) {//ajax请求成功后触发的方法
               	 //console.log(data)
                status1=data;
               	//alert(status1);
              
                
               	// alert(status1.length);
               //charts();
             // alert(100*status1[0][2]/status1[0][1]);
                    }
            });       	  //ajax获取数据库数据
       
      
       }               	 
function charts() {
    	 
    	 var time = new Array();  //X轴坐标
    	 var cpuRate =new Array();
    	 var ramRate =new Array();
    	 var diskRate =new Array();
    	 var upFlow =new Array();
    	 var downFlow =new Array();
  
    	 
    	 for(i=0;i<=status1.length-1;i++){
		   status1[i][7]=new Date(status1[i][7]).Format("hh:mm");
	   }   //时间格式转换
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
  		   time[i]=status1[status1.length-j][7];
  	   }  // 横坐标数组赋值
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 cpuRate[i]=status1[status1.length-j][0];
    	   } //CPU数组赋值
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 ramRate[i]=(100*status1[status1.length-j][2]/status1[status1.length-j][1]).toFixed(2);
    	   } //内存数组赋值
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 diskRate[i]=(100*status1[status1.length-j][4]/status1[status1.length-j][3]).toFixed(2);
    	   } //硬盘数组赋值
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 upFlow[i]=(status1[status1.length-j][5]/1024).toFixed(2);
    	   } //上行流量赋值
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 downFlow[i]=(status1[status1.length-j][6]/1024).toFixed(2);
    	   } //下行流量赋值
    	
    	 
    		  
    	 
           	    var lineChartData = {
           	        labels :time,
           	        datasets : [
           	            {
           	                label: "CPU使用率",
           	                fillColor : "rgba(30,144,255,0)",
           	                strokeColor : "rgba(30,144,255,1)",
           	                pointColor : "rgba(30,144,255,1)",
           	                pointStrokeColor : "#fff",
           	                pointHighlightFill : "#fff",
           	                pointHighlightStroke : "rgba(30,144,255,1)",
           	                data : cpuRate,
           	            },
           	            {
           	                label: "内存占用率",
           	                fillColor : "rgba(0,238,118,0)",
           	                strokeColor : "rgba(0,238,118,1)",
           	                pointColor : "rgba(0,238,118,1)",
           	                pointStrokeColor : "#fff",
           	                pointHighlightFill : "#fff",
           	                pointHighlightStroke : "rgba(0,238,118,1)",
           	                data : ramRate,
           	            },
           	            {
           	                label: "硬盘占用率 %",
           	                fillColor : "rgba(255,127,36,0)",
           	                strokeColor : "rgba(255,127,36,1)",
           	                pointColor : "rgba(255,127,36,1)",
           	                pointStrokeColor : "#fff",
           	                pointHighlightFill : "#fff",
           	                pointHighlightStroke : "rgba(255,127,36,1)",
           	                data : diskRate,
           	            }
           	            
           	            

           	        ]

           	    }
           	    
           	    var lineChartData1= {
           	    		labels : time,
           	            datasets : [
           	                {
           	                    label: "上行流量",
           	                    fillColor : "rgba(30,144,255,0)",
           	                    strokeColor : "rgba(30,144,255,1)",
           	                    pointColor : "rgba(30,144,255,1)",
           	                    pointStrokeColor : "#fff",
           	                    pointHighlightFill : "#fff",
           	                    pointHighlightStroke : "rgba(30,144,255,1)",
           	                    data : upFlow,
               	            },
           	                {
           	                    label: "下行流量  KB/S",
           	                    fillColor : "rgba(0,238,118,0)",
           	                    strokeColor : "rgba(0,238,118,1)",
           	                    pointColor : "rgba(0,238,118,1)",
           	                    pointStrokeColor : "#fff",
           	                    pointHighlightFill : "#fff",
           	                    pointHighlightStroke : "rgba(0,238,118,1)",
           	                    data : downFlow,
               	            }
           	                
           	                

           	            ]

           	        }

           	    $('#canvas').remove(); // this is my <canvas> element
              	$('#canvasParent').append('<canvas id="canvas" height="160" width="600""></canvas>');
    		   var ctx = document.getElementById("canvas").getContext("2d");
           	   
               var myLine=new Chart(ctx).Line(lineChartData, {
                    responsive: true
                });
               
                legend(document.getElementById("lineLegend"), lineChartData);
                
                
                $('#canvas1').remove(); // this is my <canvas> element
              	$('#canvas1Parent').append('<canvas id="canvas1" height="160" width="600""></canvas>');
                var ctx= document.getElementById("canvas1").getContext("2d");
                
                var myLine=new Chart(ctx).Line(lineChartData1, {
                    responsive: true
                });
                legend(document.getElementById("lineLegend1"), lineChartData1);
    	 }
window.onload=function(){
	$('#datetimepicker').datetimepicker({lang:'ch'});
        	charts();
        }
