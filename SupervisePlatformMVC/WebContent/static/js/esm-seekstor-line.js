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
var startDate;
var endDate;
var tableName="Temp";
var time=new Date();
var timex=time.getTime();
var timex1=timex+86400000;
var date1=new Date(timex).Format("yyyy-MM-dd 00:00:00");
var date2=new Date(timex).Format("yyyy-MM-dd 06:00:00");
var date3=new Date(timex).Format("yyyy-MM-dd 12:00:00");
var date4=new Date(timex).Format("yyyy-MM-dd 18:00:00");
var date5=new Date(timex1).Format("yyyy-MM-dd 00:00:00");
init();

function init(){
	 $.ajax({
         type: "get",//数据发送的方式（post 或者 get）
         url: "/getIpJson",//要发送的后台地址
         //data: {page:page},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
         async:false,
         dataType: "json",//后台处理后返回的数据格式
         success: function (data) {//ajax请求成功后触发的方法
        	 console.log(data)
        	 initIp=data;
             }                                        //取出设备表的IP
     });

	 var date=new Date().Format("yyyy-MM-dd hh:mm:ss");
	 if(date>=date1 && date<=date2){
		 var startDate=date1;
	 }
	 else if(date>date2 && date<=date3){
		 var startDate=date2;
	 }	
	 else if(date>date3 && date<=date4){
		 var startDate=date3;
	 }
	 else{
		 var startDate=date4;
	 }
	 var endDate=date;
	 //alert(startDate+"***"+endDate);
	 document.getElementById("nowDevice").value=initIp[0];  //显示当前IP
	 document.getElementById("starttime").value=startDate;
	 document.getElementById("endtime").value=endDate;
	 document.getElementById("deviceIp").value=initIp[0];
	 document.getElementById("tableName").value=tableName;   //暂存4个参数
	 var deviceIp=initIp[0];
    //alert(deviceIp+"+++"+tableName)
	refleshStorStatusTable(deviceIp,startDate,endDate,tableName);//页面初始化传递的参数

}
function  lastOneHour(){
	deviceIp=document.getElementById("deviceIp").value;
	tableName=document.getElementById("tableName").value;
	var starttemp=document.getElementById("starttime").value;
	//alert(starttemp);
	if(starttemp==date1){
		startDate=starttemp;
		endDate=document.getElementById("endtime").value;
	}
	else if(starttemp==date2){
		startDate=date1;
		endDate=date2;
	}
	else if(starttemp==date3){
		startDate=date2;
		endDate=date3;
	}
	else {
		startDate=date3;
		endDate=date4;
	}
	document.getElementById("starttime").value=startDate;
	document.getElementById("endtime").value=endDate;
    refleshStorStatusTable(deviceIp,startDate,endDate,tableName);
	    //alert(endDate);
		 charts();	 
	  }
function  nextOneHour(){
    deviceIp=document.getElementById("deviceIp").value;
    tableName=document.getElementById("tableName").value; 
    var endtemp=document.getElementById("endtime").value;
    var now=new Date().Format("yyyy-MM-dd hh:mm:ss");
	if((endtemp<date2)||(endtemp>date2 && endtemp<date3)||(endtemp>date3 && endtemp<date4)||(endtemp>date4 && endtemp<date5)){
		startDate=document.getElementById("starttime").value;
		endDate=endtemp;
	}
	else{
		if(endtemp==date2){
			if(now<date3){
				endDate=now;
			}
			else{
				endDate=date3;
			}
		}
		else if(endtemp==date3){
			if(now<date4){
					endDate=now;
			}
			else{
					endDate=date4;
			}
		}
		else if(endtemp==date4){
			if(now<date5){
				endDate=now;
		    }
		    else{
				endDate=date5;
		    }
		}	
		else{
			endDate=date5;
		}
		startDate=endtemp;
	}
	document.getElementById("starttime").value=startDate;
	document.getElementById("endtime").value=endDate;
	refleshStorStatusTable(deviceIp,startDate,endDate,tableName);
	 charts();	
	 
  }
function clickQuery(){
	deviceIP=document.getElementById("deviceIP").value;
	var endtemp=document.getElementById("datetimepicker").value;  //获取yyyy/mm/dd格式
	if(deviceIP==""){
		//alert("设备IP不能为空!");
		//window.location.reload();
		deviceIP=document.getElementById("deviceIp").value;
	}
	
	if(endtemp==""){
		startDate=document.getElementById("starttime").value;
		endDate=document.getElementById("endtime").value;
		tableName="Temp";
	}
	else{
	var endtimex=new Date(endtemp).getTime();//转换成时间戳格式
	endDate=new Date(endtimex).Format("yyyy-MM-dd hh:mm:ss");//转换成yyyy-mm-dd格式
	tableName=new Date(endtimex).Format("yyyy-MM-dd");
	if(endDate<=date2){
		startDate=date1;
	}
	else if(endDate>date2 && endDate<=date3){
		startDate=date2;
	}
	else if(endDate>date3 && endDate<=date4){
		startDate=date3;
	}
	else{
		startDate=date4;
	}
}
	document.getElementById("starttime").value=startDate;
	document.getElementById("endtime").value=endDate;
	document.getElementById("deviceIp").value=deviceIP;
	document.getElementById("tableName").value=tableName; 
	document.getElementById("nowDevice").value=deviceIP;
	//alert(startDate+"+++"+endDate+"+++"+deviceIP+"+++"+tableName);
	refleshStorStatusTable(deviceIP,startDate,endDate,tableName);
	charts();
}
	
function  refleshStorStatusTable(var0,var1,var2,var3){
       	 $.ajax({
                type: "post",//数据发送的方式（post 或者 get）
                url: "/getStorStatusJson",//要发送的后台地址
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
    	 var driverRate =new Array();
    	 var mdiskRate =new Array();
    	 var vdiskRate =new Array();
    	 var hostRate =new Array();
    	 var storRate =new Array();
  
    	 
    	 for(i=0;i<=status1.length-1;i++){
		   status1[i][10]=new Date(status1[i][10]).Format("hh:mm");
	   }   //时间格式转换
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
  		   time[i]=status1[status1.length-j][10];
  	   }  // 横坐标数组赋值
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 if(status1[status1.length-j][0]==0){
    			 driverRate[i]=0;
    		 }
    		 else
    		 driverRate[i]=(100*(status1[status1.length-j][0]-status1[status1.length-j][1])/status1[status1.length-j][0]).toFixed(2);
    	   } //驱动数组赋值
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 if(status1[status1.length-j][2]==0){
    			 mdiskRate[i]=0;
    		 }
    		 else
    			 mdiskRate[i]=(100*(status1[status1.length-j][2]-status1[status1.length-j][3])/status1[status1.length-j][2]).toFixed(2);;
    	   } //Mdisk数组赋值
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 if(status1[status1.length-j][4]==0){
    			vdiskRate[i]=0;
    		 }
    		 else
    			 vdiskRate[i]=(100*(status1[status1.length-j][4]-status1[status1.length-j][5])/status1[status1.length-j][4]).toFixed(2);
    	   } //Vdisk数组赋值
    	 
    	
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 if(status1[status1.length-j][6]==0){
    			hostRate[i]=0;
    		 }
    		 else
    			 hostRate[i]=(100*(status1[status1.length-j][6]-status1[status1.length-j][7])/status1[status1.length-j][6]).toFixed(2);
    	   } //主机数组赋值
         
         for(i=0,j=1;i<=status1.length-1;i++,j++){
        	 status1[status1.length-j][8]=status1[status1.length-j][8].substr(0,status1[status1.length-j][8].length - 2) - 0;
        	 status1[status1.length-j][9]=status1[status1.length-j][9].substr(0,status1[status1.length-j][9].length - 2) - 0;
         }
         
    	 for(i=0,j=1;i<=status1.length-1;i++,j++){
    		 if(status1[status1.length-j][8]==0){
    			storRate[i]=0;
    		 }
    		 else
    			 storRate[i]=(100*(status1[status1.length-j][8]-status1[status1.length-j][9])/status1[status1.length-j][8]).toFixed(2);
    	   }//容量数组赋值
    	//alert(time+"+"+driverRate+"+"+mdiskRate+"+"+vdiskRate+"+"+hostRate+"+"+storRate);
    	
    	 
    		  
    	     
           	    var lineChartData = {
           	        labels :time,
           	        datasets : [
           	            {
           	                label: "驱动器在线率",
           	                fillColor : "rgba(30,144,255,0)",
           	                strokeColor : "rgba(30,144,255,1)",
           	                pointColor : "rgba(30,144,255,1)",
           	                pointStrokeColor : "#fff",
           	                pointHighlightFill : "#fff",
           	                pointHighlightStroke : "rgba(30,144,255,1)",
           	                data : driverRate,
           	            },
           	            {
           	                label: "Mdisk在线率",
           	                fillColor : "rgba(0,238,118,0)",
           	                strokeColor : "rgba(0,238,118,1)",
           	                pointColor : "rgba(0,238,118,1)",
           	                pointStrokeColor : "#fff",
           	                pointHighlightFill : "#fff",
           	                pointHighlightStroke : "rgba(0,238,118,1)",
           	                data : mdiskRate,
           	            },
           	            {
           	                label: "Vdisk在线率 %",
           	                fillColor : "rgba(255,127,36,0)",
           	                strokeColor : "rgba(255,127,36,1)",
           	                pointColor : "rgba(255,127,36,1)",
           	                pointStrokeColor : "#fff",
           	                pointHighlightFill : "#fff",
           	                pointHighlightStroke : "rgba(255,127,36,1)",
           	                data : vdiskRate,
           	            }
           	            
           	            

           	        ]

           	    }
           	    
           	    var lineChartData1= {
           	    		labels : time,
           	            datasets : [
           	                {
           	                    label: "连接主机在线率",
           	                    fillColor : "rgba(30,144,255,0)",
           	                    strokeColor : "rgba(30,144,255,1)",
           	                    pointColor : "rgba(30,144,255,1)",
           	                    pointStrokeColor : "#fff",
           	                    pointHighlightFill : "#fff",
           	                    pointHighlightStroke : "rgba(30,144,255,1)",
           	                    data : hostRate,
               	            },
           	                {
           	                    label: "已分配容量比  %",
           	                    fillColor : "rgba(0,238,118,0)",
           	                    strokeColor : "rgba(0,238,118,1)",
           	                    pointColor : "rgba(0,238,118,1)",
           	                    pointStrokeColor : "#fff",
           	                    pointHighlightFill : "#fff",
           	                    pointHighlightStroke : "rgba(0,238,118,1)",
           	                    data : storRate,
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
