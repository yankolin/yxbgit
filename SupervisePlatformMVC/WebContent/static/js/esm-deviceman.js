/**
 * Created by Administrator on 2016/4/1 0001.
 */

//添加全局变量
window.count = 0;
window.rows = 0;

window.curPages = 1;

//输入信息最大最小长度，这里ip name location desc信息长度可以分开进行标记
var maxLength = 80;
var minLength = 1;

$(function(){
	reflashPageDevice();
});

function reflashPageDevice() {
	  //var count = 0
    var curPage = 1;
    console.log("初始化页面，进入ajax")
    $.ajax({
        type:"get",
        url:"/getDMDeviceCount",
        async:false,
        dataType:"json",
        success:function(data){
            //count为表中的数据总量
            window.count=data[0];
            //分页，每一页有多少个数据
            window.rows=data[1];
        }
    });

    //总共要分totalPage页
    var totalPage=Math.ceil(window.count/window.rows);
    console.log(totalPage);

    //分页添加
    var element=$("#bp-3-element-sm-test");

    options={
        size:"small",
        bootstrapMajorVersion:3,
        currentPage:1,
        numberOfPages:totalPage,
        totalPages : totalPage,
        onPageClicked : function(event, originalEvent, type, curPage) {
            window.curPages = curPage;
            $("#tableDMShow tbody").html("");
            refalshDMTable(curPage, rows);
        }
    };
    element.bootstrapPaginator(options);
    element.hasClass("pagination-sm");
}
function refalshDMTable(page,rows){
    var tbBody="";
    console.log("进入分页取数据");

    $.ajax({
        type:"get",
        url:"/showDMTabDeviceJson?page="+page,
        dataType:"json",
        success:function(data){
            var id=(page-1)*rows;

            for (var i = 0; i < data.length; i++) {
                switch(data[i][3]){
                    case 0:
                        data[i][3]="服务器";
                        break;
                    case 1:
                        data[i][3]="存储设备";
                        break;
                    case 2:
                        data[i][3]="网络设备";
                        break;
                }

                //进行数据填充
                tbBody += "<tr id="
                    + data[i][0]
                    + "><td>"
                    + ++id
                    + "</td>"
                    + "<td>"
                    + data[i][2]
                    + "</td>"
                    + "<td>"
                    + data[i][1]
                    + "</td>"
                    + "<td>"
                    + data[i][3]
                    + "</td>"
                    + "<td>"
                    + data[i][4]
                    + "</td>"
                    + "<td>"
                    + data[i][5]
                    + "</td>"
                    + "<td style='text-align: center'>"
                    + "<button  type='button' class='btn btn-primary' onClick='btnDMAlterDevice("
                    + data[i][0]
                    + ")' >"
                    + "<i class='glyphicon glyphicon-edit'></i></button>&nbsp;&nbsp;"
                    + "<button type='button' class='btn btn-primary' onClick='btnDMDelDevice("
                    + data[i][0]
                    + ")' data-toggle='modal' data-target='#userman_delete_modal'>"
                    + "<i class='glyphicon glyphicon-trash'></i></button></td>"
                    + "<td style='display:none'>" + data[i][0]
                    + "</td></tr>";
            }
            //添加数据到指定位置
            $("#tableDMShow tbody").append(tbBody);
        },
        errorId:function(msg){
            alert(msg);
        }
    });
}


//行按钮，对该行数据进行删除操作
function btnDMDelDevice(em){
    document.getElementById("lblDMDelId").innerHTML=em;
    $("#btn_deviceman_delete_modal").modal("show");
}

//设备删除，这里只是在数据库中删除
function btn_deviceman_del_submit(){
    var id=document.getElementById("lblDMDelId").innerHTML;
    console.log("删除的id为："+id)

    $.ajax({
        type:"post",
        url:"/doDMDelDevice",
        data:{
            deviceid:id
        },
        dataType:"json",
        success:function(data){
            if (true==data) {
                alert("删除设备成功");
                $("#btnDMDelClose").click();
                $("#tableDMShow tbody").html("");
                refalshDMTable(window.curPages, rows);
            }else{
                alert("删除设备失败");
            }
        },
        errorId:function(msg){
            alert(msg);
        }
    });
}

function btn_deviceman_addDevice_submit(){
    var btndeviceIp=document.getElementById("txtDMAddDeviceIP");
    var btndeviceType=document.getElementById("chkDMDeviceType");
    var btndeviceLoc=document.getElementById("chkDMDeviceType");
    var btndeviceDesc=document.getElementById("txtDMAddDeviceDesc");
    var btndeviceName=document.getElementById("txtDMAddDeviceName");

    var errorId="lblDMAddErrortip";
    //描述信息、位置信息可以为空，后台填补null类型数据，但是最大长度有限制

    if (checkInputLoc(btndeviceLoc,errorId,maxLength,minLength)&&checkDeviceIP(btndeviceIp,errorId)&&checkDeviceName(btndeviceName,errorId,maxLength,minLength)){
        console.log("进入判定函数！");
        $.ajax({
            type : "post",// 数据发送的方式（post 或者 get）
            url : "/addDMDevice",// 要发送的后台地址
            data : {
                deviceIp : btndeviceIp.value,
                deviceType : btndeviceType.value,
                deviceLoc : btndeviceLoc.value,
                deviceDesc : btndeviceDesc.value,
                deviceName : btndeviceName.value
            },// 要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType : "json",// 后台处理后返回的数据格式
            success : function(data) {// ajax请求成功后触发的方法

                if (data == true) {
                    alert('添加设备成功！');
                    $("#btn_deviceman_add_close").click();
                    $("#tableDMShow tbody").html("");
                    refalshDMTable(1, rows);
                } else {
                    alert("添加设备失败");
                }
            },
            errorId : function(msg) {// ajax请求失败后触发的方法
                alert(msg);// 弹出错误信息
            }
        });
    }
}

//行按钮，对该行数据进行修改
function btnDMAlterDevice(em){
    //这里进行数据填充，如果不添加数据，那么就可以保留原来的数据
    var deviceName=document.getElementById(em).cells[1].innerHTML;
    var deviceIp=document.getElementById(em).cells[2].innerHTML;
    var deviceType=document.getElementById(em).cells[3].innerHTML;
    var deviceLoc=document.getElementById(em).cells[4].innerHTML;
    var deviceDesc=document.getElementById(em).cells[5].innerHTML;
    console.log("em:"+em);

    document.getElementById("lblDMAlterId").value=em;
    document.getElementById("txtDMAlterDevicename").value=deviceName;
    document.getElementById("txtDMAlterDeviceIp").value=deviceIp;
    setSelectChecked("sltDMAlterDeviceType",deviceType);
    document.getElementById("txtDMAlterDeviceLoc").value=deviceLoc;
    document.getElementById("txtDMAlterDeviceDesc").value=deviceDesc;
    $("#btnDMAlterModal").modal("show");
}

//修改设备信息，然后进行提交
function btn_deviceman_alter_submit(){
    var deviceIP=document.getElementById("txtDMAlterDeviceIp");
    console.log("deviceIP:"+deviceIP.value);
    var deviceType=document.getElementById("sltDMAlterDeviceType");
    console.log("deviceType:"+deviceType.value);
    var deviceName=document.getElementById("txtDMAlterDevicename");
    console.log("deviceName:"+deviceName.value);
    var deviceLoc=document.getElementById("txtDMAlterDeviceLoc");
    console.log("deviceLOC:"+deviceLoc.value);
    var deviceDesc=document.getElementById("txtDMAlterDeviceDesc");
    console.log("deviceDesc:"+deviceDesc.value);
    var deviceId=document.getElementById("lblDMAlterId");

    var errorId="lblDMAlterErrortip";

    if (checkInputLoc(deviceLoc,errorId,maxLength,minLength)&&checkDeviceName(deviceName,errorId,maxLength,minLength)) {
        $.ajax({
            type:"post",
            url:"/doDMAlterDevice",
            data:{
                id:deviceId.value,
                ip:deviceIP.value,
                type:deviceType.value,
                name:deviceName.value,
                loc:deviceLoc.value,
                desc:deviceDesc.value
            },
            dataType:"json",
            success:function(data){
                if (data==true) {
                    alert("修改用户成功");
                    $("#btnDMAlterClose").click();
                    $("#tableDMShow tbody").html("");
                    refalshDMTable(window.curPages, rows);
                }else{
                    alert("修改用户失败");
                }
            },
            errorId:function(msg){
                alert(msg);
            }
        });
    }
}

//描述信息可以为空，需要后台进行数据填充，描述设备在机柜中的位置
//输入信息验证,验证位置信息,判断最大长度和最小长度
function checkInputLoc(em,errorId,maxLen,minLen){
    var num = em.value;
    if (!checkInputNull(num)) {
        showlblErrorTip(errorId,"输入信息为空");
        return false;
    }else if (!checkInputIllegal(num)) {
        showlblErrorTip(errorId,"位置信息输入字符有误！");
        return false;
    }else if(num.length<minLen){
        showlblErrorTip(errorId,"位置信息长度"+num.length+"小于"+minLen);
        return false;
    }else if(num.length>maxLen){
        showlblErrorTip(errorId,"位置信息长度"+num.length+"大于"+maxLen);
        return false;
    }else{
        showlblErrorTip(errorId,"");
        return true;
    }
}

//核对IP是否正确
function checkDeviceIP(em,errorId){
    var num = em.value;
    console.log(num);

    if(!checkInputNull(num)) {
        showlblErrorTip(errorId,"设备IP不能为空！");
        return false;
    }else {
        if(!IsIpValidate(num)) {
            showlblErrorTip(errorId,"IP格式不正确！");
            return false;
        }else {
        	var check = checkAddIpexist(num);
        	if(check) {
        		showlblErrorTip(errorId,"该IP已存在！");
                return false;
        	}else {
                showlblErrorTip(errorId,"");
                return true;
        	}
        }
    }
}

function checkAddIpexist(em) {
	var check;
	$.ajax({
		type:"post",
	  url:"/checkDMDevice",
	  async: false,
	  data:{deviceIp:em},
	  dataType:"json",
	  success:function(data) {
		 // alert(data);
		  if(data == true){
			 
		    check = true;
      }else {
         check = false;
             		}	  
	      }
	});
	return check;
}

//验证设备名
function  checkDeviceName(em,errorId,maxLen,minLen){
    var num=em.value;
    console.log("设备名："+num);
    if (!checkInputNull(num)){
        showlblErrorTip(errorId,"设备名不能为空");
        return false;
    }else if(!checkInputIllegal(num)){
        showlblErrorTip(errorId,"设备名字符非法");
        return false;
    }else if (num.length>maxLen){
        showlblErrorTip(errorId,"设备名长度"+num.length+"大于"+maxLen);
        return false;
    }else if(num.length<minLen){
        showlblErrorTip(errorId,"设备名长度"+num.length+"小于"+minLen);
        return false;
    }else {
        showlblErrorTip(errorId,"");
        return true;
    }
}

//验证位置信息,位置信息应该进行格式统一，描述在图中的位置
function checkDeviceLoc(em,errorId,maxLength,minLength){
    
}

