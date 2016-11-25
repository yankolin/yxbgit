/**
 * Created by Administrator on 2016/4/5 0005.
 */
window.count = 0;
window.rows  = 0;
window.curPages = 1;
 $(function(){
	 reflashPage();
	
    });
	function reflashPage() {
		 //var count = 0;
		 var curPage = 1;
		 //var rows = 0;
					$.ajax({
					type:"get",
					url:"/getTVMCount",
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
					   numberOfPages:5,
					   totalPages:totalPage,
					    	 onPageClicked:function(event,originalEvent,type,curPage){
													window.curPages = curPage;						
					    		$("#tableTVMShow tbody").html("");
					    		refalshTVMTable(curPage,rows);
					    					        }
							 
								         };
					
					element.bootstrapPaginator(options);
					
					element.hasClass('pagination-sm');
		}			
	
 function refalshTVMTable(page,rows) {
	 var tbBody = "";
	 $.ajax({
         type: "get",//数据发送的方式（post 或者 get）
         url: "/getTVMTableJson?page="+page,//要发送的后台地址
         //data: {page:page},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
         dataType: "json",//后台处理后返回的数据格式
         success: function (data) {//ajax请求成功后触发的方法
        	 //console.log(data);
        	 
             
        	 var id = (page - 1) * rows;
        	 for(var i = 0; i < data.length; i++){
        		 	
        		 tbBody += "<tr id="+ data[i][0]  +"><td>" + ++id + "</td>" + 
        		           "<td>" + data[i][0] + "</td>" +
        		 							 "<td>" + data[i][1] + "</td>" +
        		 							 "<td>" + data[i][2] + "</td>"+
        		 							 "<td>" + data[i][3] + "</td>" +
        		 							 "<td>" + data[i][4] + "</td>" +
        		 							 "<td>" + data[i][5] + "</td>" +
        		 							 "<td style='text-align: center'>"+
        		 							 "<button  type='button' class='btn btn-primary' onClick='btnTVMAlterThreholdvalue(" + data[i][0] + ")' >"+
															"<i class='glyphicon glyphicon-edit'></i></button></tr>";
        	 			 }
        	                   //  tbBody += "</tbody>";
        	  		//alert(tbBody);
        	  		//$("#table-userman").append(tbBody); 
        	  		$("#tableTVMShow tbody").append(tbBody);//  alert(data[1]["userManEmail"]);
        	  	  //alert($("#table-userman").html());
         				},
         errorId: function (msg) {//ajax请求失败后触发的方法
             alert(msg);//弹出错误信息
                         }
     		});
	 
}
 
 
function btnTVMAddSubmit(){
    var deviceIp = document.getElementById("txtTVMAddDeviceIP");
    var cpu = document.getElementById("txtTVMAddThreholdValueCPU");
    var mem = document.getElementById("txtTVMAddThreholdValueMem");
    var stor = document.getElementById("txtTVMAddThreholdValueStor");
    var upflow = document.getElementById("txtTVMAddThreholdValueUpFlow");
    var downflow = document.getElementById("txtTVMAddThreholdValueDownFlow");
    var errorId = "lblTVMAddErrortip";
    if (checkAddDeviceIP(deviceIp,errorId)&&checkAddIsInt(cpu,errorId,'CPU阈值')&&checkAddIsInt(mem,errorId,'内存阈值')&&checkAddIsInt(stor,errorId,'硬盘阈值')&&checkAddIsInt(upflow,errorId,'上行流量阈值')&&checkAddIsInt(downflow,errorId,'下行流量阈值')){
       // alert(deviceIp.value);
        $.ajax({
            type: "post",//数据发送的方式（post 或者 get）
            url: "/doTVAddthrehold",//要发送的后台地址
            data: {id:deviceIp.value,cpu:cpu.value,mem:mem.value,stor:stor.value,upflow:upflow.value,downflow:downflow.value},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType: "json",//后台处理后返回的数据格式
            success: function (data) {//ajax请求成功后触发的方法
            	if(data == true) {
        			alert("添加阈值成功！");
        			reflashPage();
        			 $("#btnTVMAddClose").click();
        			 $("#tableTVMShow tbody").html("");
            refalshTVMTable(1,rows);
        		}else{
        			alert("添加阈值失败！");
        		}
            }
        });
        //说明信息是完整的，那么可以提交数据
    }
}

function btnTVMAlterThreholdvalue(em) {
	var deviceip = em;//document.getElementById(em).cells[1].innerHTML;
	var cpu = document.getElementById(em).cells[2].innerHTML;
	var mem = document.getElementById(em).cells[3].innerHTML;
	var stor = document.getElementById(em).cells[4].innerHTML;
	var upflow = document.getElementById(em).cells[5].innerHTML;
	var downflow = document.getElementById(em).cells[6].innerHTML;
	document.getElementById("lblTVMAlterDeviceIP").innerHTML = deviceip;
	document.getElementById("txtTVMAlterThreholdValueCPU").value = cpu;
	document.getElementById("txtTVMAlterThreholdValueMem").value = mem;
	document.getElementById("txtTVMAlterThreholdValueStor").value = stor;
	document.getElementById("txtTVMAlterThreholdValueUpFlow").value = upflow;
	document.getElementById("txtTVMAlterThreholdValueDownFlow").value = downflow;
	$('#btnTVMaltermodal').modal('show');
}

function btnTVMAlterSubmit(){
    var deviceIp = document.getElementById("lblTVMAlterDeviceIP");
    var cpu = document.getElementById("txtTVMAlterThreholdValueCPU");
    var mem = document.getElementById("txtTVMAlterThreholdValueMem");
    var stor = document.getElementById("txtTVMAlterThreholdValueStor");
    var upflow = document.getElementById("txtTVMAlterThreholdValueUpFlow");
    var downflow = document.getElementById("txtTVMAlterThreholdValueDownFlow");
    var errorId = "lblTVMAlterErrortip";
    if (checkAddIsInt(cpu,errorId,'CPU阈值')&&checkAddIsInt(mem,errorId,'内存阈值')&&checkAddIsInt(stor,errorId,'硬盘阈值')&&checkAddIsInt(upflow,errorId,'上行流量阈值')&&checkAddIsInt(downflow,errorId,'下行流量阈值')){
       // alert(deviceIp.innerHTML);
        $.ajax({
            type: "post",//数据发送的方式（post 或者 get）
            url: "/doTVAlterthrehold",//要发送的后台地址
            data: {id:deviceIp.innerHTML,cpu:cpu.value,mem:mem.value,stor:stor.value,upflow:upflow.value,downflow:downflow.value},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType: "json",//后台处理后返回的数据格式
            success: function (data) {//ajax请求成功后触发的方法
            	if(data == true) {
        			alert("修改阈值成功！");
        			 $("#btnTVMAlterCLose").click();
        			$("#tableTVMShow tbody").html("");
            refalshTVMTable(window.curPages,rows);
        		}else{
        			alert("修改阈值失败！");
        		}
            }
        });
        //说明信息是完整的，那么可以提交数据
    }
}

function checkAddIsInt(em,errorId,str){
    var num = em.value;
    if(!checkInputNull(num)) {
        showlblErrorTip(errorId,str + "不能为空！");
        return false;
    }else {
        if(isNaN(num)) {
            showlblErrorTip(errorId,str + "输入必须为数字！");
            return false;
        }else {
            showlblErrorTip(errorId,"");
            return true;
        }
    }
}

//核对IP是否正确
function checkAddDeviceIP(em,errorId){
    //用户名不能为空，并且有最大长度限制
    var num = em.value;
    if(!checkInputNull(num)) {
        showlblErrorTip(errorId,"设备IP不能为空！");
        return false;
    }else {
       // if(!IsIpValidate(num)) {
     //       showlblErrorTip(errorId,"IP格式不正确！");
     //       return false;
     //   }else {
        //	var check = checkAddipexist(num);
       // 	if(!check) {
        //		showlblErrorTip(errorId,"当前无该IP的设备，请先添加该IP的设备");
       // 		return false;
        //	}else {
            showlblErrorTip(errorId,"");
            return true;
       // 	}
   //     }
    }

}

function checkAddipexist(em) {
	var check = false;
	$.ajax({
		type:"post",
		url:"/getTVCheckip",
		async:false,
		data:{ip:em},
		dataType:function(data) {
			if(data == true) {
				check = true;
			}else {
				check = false;
			}
		}
	});
	return check;
}