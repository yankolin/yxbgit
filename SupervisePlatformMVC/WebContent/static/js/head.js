	var name = document.getElementById("login_name").innerHTML;
	
$("#profile").click(function(){
	
	$.ajax({
		type:"post",
		url:"/getProfileName",
		data:{name:name},
		dataType:"json",
		success:function(data) {
			document.getElementById("txtUserprofileid").value = data[0][0];
			document.getElementById("txtUMAlterprofileUsername").value = data[0][1];
			document.getElementById("txtUMAlterprofileEmail").value = data[0][2];
			setSelectChecked("sltUMAlterprofileAlert",data[0][3]);
		}
	});
	$('#btnUMAlterprofileModal').modal('show');
});

function btn_userman_alterprofile_submit(){
    var email = document.getElementById("txtUMAlterprofileEmail");
    var name = document.getElementById("txtUMAlterprofileUsername");
    var errorId = "lblUMAlterprofileErrortip";
    var tag = document.getElementById("sltUMAlterprofileAlert").value;
    var id = document.getElementById("txtUserprofileid").value;
   
    if (checkAlterUsername(name,errorId)&&checkAddEmail(email,errorId)){
        $.ajax({
            type: "post",//数据发送的方式（post 或者 get）
            url: "/doUMAlterprofileUser",//要发送的后台地址
            data: {name:name.value,email:email.value,tag:tag,id:id},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType: "json",//后台处理后返回的数据格式
            success: function (data) {//ajax请求成功后触发的方法
            		 
                if(data == true){
                    alert('修改用户成功！');
                    $("#btnUMAlterprofileClose").click();
                
                	}else {
                			alert("修改用户失败");
                						}
            					},
            errorId: function (msg) {//ajax请求失败后触发的方法
                alert(msg);//弹出错误信息
            					}
        				});
        //说明信息是完整的，那么可以提交数据
    }
	
}


$("#alterpwd").click(function(){


	document.getElementById("txtUMAlterpwdUsername").value = name;
	$('#btnUMAlterpwdModal').modal('show');
});

function btn_userman_alterpwd_submit(){
    var oldpwd = document.getElementById("txtUMAlteroldpwd");
    var newpwd = document.getElementById("txtUMAlternewpwd");
    var renewpwd = document.getElementById("txtUMAlterrenewpwd");
    var name = document.getElementById("txtUMAlterpwdUsername");
    var errorId = "lblUMAlterpwdErrortip";
     
    var oldpwdmd5 = $.md5(oldpwd.value);
    var newpwdmd5 = $.md5(newpwd.value);
    if (checkAddPwd(oldpwd,errorId)&&checkAddPwd(newpwd,errorId)&&checkAddRepwd(newpwd,renewpwd,errorId)){
        $.ajax({
            type: "post",//数据发送的方式（post 或者 get）
            url: "/doUMAlterpwd",//要发送的后台地址
            data: {name:name.value,oldpwd:oldpwdmd5,newpwd:newpwdmd5},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType: "json",//后台处理后返回的数据格式
            success: function (data) {//ajax请求成功后触发的方法
            		 if(data == 0) {
            			 showlblErrorTip(errorId,"旧密码输入有误，请重新输入！");
            		  return false;
            		                      }
                if(data == 1){
                    alert('修改用户成功！');
                    $("#btnUMAlterpwdClose").click();
                	  
                	                   }
                if(data == 2){
                			alert("修改用户失败");
                			 $("#btnUMAlterpwdClose").click();
                						}
            					},
            errorId: function (msg) {//ajax请求失败后触发的方法
                alert(msg);//弹出错误信息
            					}
        				});
        //说明信息是完整的，那么可以提交数据
    }
	
}


function checkAddPwd(em,errorId) {
    var num = em.value;
    if(!checkInputNull(num)) {
        showlblErrorTip(errorId,"密码不能为空！");
        return false;
    }else {
        if(!checkInputMinlen(num,6)) {
            showlblErrorTip(errorId,"密码长度不能小于6位数！");
            return false;
        }else {
            if(!checkInputMaxlen(num,20)) {
                showlblErrorTip(errorId,"密码长度不能大于20位！");
                return false;
            }else {
                showlblErrorTip(errorId,"");
                return true;
            }
        }
    }
}

function checkAddRepwd(em,errorId) {
    var pwd = document.getElementById("txtUMAddPwd").value;
    if(pwd != em.value) {
        showlblErrorTip(errorId,"两次密码输入不一致！");
        return false;
    }else {
        showlblErrorTip(errorId,"");
        return true;
    }
}
//检查邮箱问题
function checkAddEmail(em,errorId){
    showlblErrorTip(errorId,"");
    var name = em.value;
    var cnull = checkInputNull(name);
    if(!cnull) {
        showlblErrorTip(errorId,"邮箱地址不能为空！");
        return false;
    }else {
        var flag = checkInputEmail(name);
        if(!flag) {
            showlblErrorTip(errorId,"邮箱地址格式有误！");
            return false;
        }else {
            showlblErrorTip(errorId,"");
            return true;
        }
    }

}

function checkAlterUsername(em,errorId) {
    var num = em.value;
    if(!checkInputNull(num)) {
        showlblErrorTip(errorId,"用户名不能为空！");
        return false;
    }else {
        if(!checkInputIllegal(num)) {
            showlblErrorTip(errorId,"用户名输入字符有误！");
            return false;
        }else {
        		showlblErrorTip(errorId,"");
        		return true;
        }
    }
}



