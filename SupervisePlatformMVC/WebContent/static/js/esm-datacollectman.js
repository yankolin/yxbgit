/**
 * 

function GetCurValue(){  //数据库读取当前值
	$.ajax({
		type:"get",
		url:"",
		dataType:"json",
		success:function(data) {
			
		}
	});
	document.getElementById("txtDCMServer").value = 5;
	document.getElementById("txtDCMNetDevice").value = 30;
	document.getElementById("txtDCMStorDevice").value = 30;
}
 */
function btnDCMAlterSubmit()
{
	  var server = document.getElementById("txtDCMServer");
	   var netdevice = document.getElementById("txtDCMNetDevice");
	   var stordevice = document.getElementById("txtDCMStorDevice");
	   var errorId = "lblDCMAllterErrortip";
	    if (checkInputTime(server,errorId,'服务器',5)&&checkInputTime(netdevice,errorId,'网络设备',30)&&checkInputTime(stordevice,errorId,'存储设备',30)){
	       // alert("chenggong")
	        $.ajax({
	        	type:"post",
	        	url:"/updateCollectionConfig",
	        	data:{servicedata:server.value,netdevice:netdevice.value,stordevice:stordevice.value},
	        	dataType:"json",
	        	success:function(data) {
	        		if(data == true) {
	        			alert("修改成功！");
	        		}else {
	        			alert("修改失败！");
	        		}
	        		
	        	}
	        });
	        //说明信息是完整的，那么可以提交数据
	    }
	}

function checkInputTime(em,errorId,str,time){
    var num = em.value;
    if(!checkInputNull(num)) {
        showlblErrorTip(errorId,str + "采集周期不能为空！");
        return false;
    }else {
    	if (!(/(^[1-9]\d*$)/.test(num))) {
            showlblErrorTip(errorId,str + "采集周期必须为整数！");
            return false;
        }else {
        	  if(num<time){
        		  showlblErrorTip(errorId,str + "采集周期必须大于"+time);
                  return false;
              }
              else{
           	           showlblErrorTip(errorId,"");
           	           return true;
              }
        }
    }
}