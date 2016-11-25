function imgShowInfo(e) {

//    var imgID = e.id;
//    //将有意义的ID信息进行分割
//    var idArray = imgID.split("_");
//
//    var deviceType = idArray[1];
//
//    console.log("第一项："+idArray[0]);
//    console.log("第二项："+idArray[1]);
//    console.log("设备类型为:"+deviceType);
//
//    //如果该设备是服务器
//    if (deviceType == "SERVER") {
//        $.ajax({
//            type: "get",
//            url: "/getServerInfo",
//            data: {
//                deviceLoc: imgID,
//            },
//            dataType: "json",
//            success: function (data) {
//                //返回一个数组数据
//                //编号信息
//                document.getElementById("lblToID").innerHTML = data[0];
//                //设备名称
//                document.getElementById("lblToCPU").innerHTML = data[1];
//                //设备IP
//                document.getElementById("lblToAllMem").innerHTML = data[2];
//                //设备位置信息
//                document.getElementById("lblToMemo").innerHTML = data[3];
//                //设备描述信息
//                document.getElementById("lblToAllStor").innerHTML = data[4];
//                //CPU
//                document.getElementById("lblToStori").innerHTML = data[5];
//                //memory
//                document.getElementById("lblToUpFlow").innerHTML = data[6];
//                //磁盘容量
//                document.getElementById("lblToUpFlowAvg").innerHTML = data[7];
//                //流量信息
//                document.getElementById("lblToDownFlow").innerHTML = data[8];
//                //连接信息
//                document.getElementById("lblToDownFlowAvg").innerHTML = data[9];
//            },
//            errorId: function (msg) {// ajax请求失败后触发的方法
//                alert(msg);// 弹出错误信息
//            }
//        });
//        $("#show_Server_modal").modal("show");
//    }
//    //如果是交换机设备
//    else if (deviceType == "SWITCH") {
//        $.ajax({
//            type: "get",
//            url: "/getSwitchInfo",
//            data: {
//                deviceLoc: imgID,
//            },
//            dataType: "json",
//            success: function (data) {
//                //交换机ID
//                document.getElementById("lblSwitchToID").innerHTML = data[0];
//                //交换机位置信息
//                document.getElementById("lblSwitchToLoc").innerHTML = data[1];
//                //交换机端口信息
//                document.getElementById("lblSwitchToPort").innerHTML = data[2];
//                //交换机端口IP
//                document.getElementById("lblSwitchToPortIp").innerHTML = data[3];
//                //上/下行流量
//                document.getElementById("lblSwitchToFlow").innerHTML = data[4];
//                //连接信息
//                document.getElementById("lblSwitchToConn").innerHTML = data[5];
//            },
//            errorId: function (msg) {// ajax请求失败后触发的方法
//                alert(msg);// 弹出错误信息
//            }
//        });
//        $("#show_Switch_modal").modal("show");
//    }
//    //如果是存储设备
//    else if (deviceType == "STOR") {
//        $.ajax({
//            type: "get",
//            url: "/getStorInfo",
//            data: {
//                deviceLoc: imgID,
//            },
//            dataType: "json",
//            success: function (data) {
//                //存储设备名称
//                document.getElementById("lblStorToName").innerHTML = data[0];
//                //存储设备IP
//                document.getElementById("lblStorToIp").innerHTML = data[1];
//                //存储设备总容量
//                document.getElementById("lblStorTotalMem").innerHTML = data[2];
//                //存储设备剩余容量
//                document.getElementById("lblStorLaveMem").innerHTML = data[3];
//            },
//            errorId: function (msg) {// ajax请求失败后触发的方法
//                alert(msg);// 弹出错误信息
//            }
//        });
//        $("#show_Stor_modal").modal("show");
//    }
	
	 var imgID = e.id;

	    if (imgID != null && imgID.length != 0) {
	        $.ajax({
	            type: "get",
	            url: "/getServerInfo",
	            data: {
	                deviceLoc: imgID,
	            },
	            dataType: "json",
	            success: function (data) {
	                //这里，根据返回值，需要对不同的设备进行分类，包括服务器、存储设备和交换机三类
	                //返回一个数组数据
	                //编号信息
	                document.getElementById("lblToID").innerHTML = data[0];
	                //设备名称
	                document.getElementById("lblToCPU").innerHTML = data[1];
	                //设备IP
	                document.getElementById("lblToAllMem").innerHTML = data[2];
	                //设备位置信息
	                document.getElementById("lblToMemo").innerHTML = data[3];
	                //设备描述信息
	                document.getElementById("lblToAllStor").innerHTML = data[4];
	                //CPU
	                document.getElementById("lblToStori").innerHTML = data[5];
	                //memory
	                document.getElementById("lblToUpFlow").innerHTML = data[6];
	                //磁盘容量
	                document.getElementById("lblToUpFlowAvg").innerHTML = data[7];
	                //流量信息
	                document.getElementById("lblToDownFlow").innerHTML = data[8];
	                //连接信息
	                document.getElementById("lblToDownFlowAvg").innerHTML = data[9];
	            },
	            errorId: function (msg) {// ajax请求失败后触发的方法
	                alert(msg);// 弹出错误信息
	            }
	        });
	        $("#show_Server_modal").modal("show");
	    }
	
}

//跳转到存储设备状态查询，思考如何传参
function JumpToStorQuery(){

}

//跳转到交换机状态查询，未实现
function JumpToSwitchQuery(){

}

//跳转到服务器状态查询
function JumpToServerQuery(){

}