/**
 * Created by rui on 2016/3/30.
 */
window.count = 0;
window.rows  = 0;
window.curPages = 1;
 $(function(){
	 relashPageUser();
    });
 function relashPageUser() {
	 //var count = 0;
	 var curPage = 1;
	 //var rows = 0;
			$.ajax({
			type:"get",
			url:"/getUMUsercount",
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
			numberOfPages: 5,
			totalPages:totalPage,
				 onPageClicked:function(event,originalEvent,type,curPage){
									window.curPages = curPage;						
					$("#tableUMShow tbody").html("");
					refalshUMTable(curPage,rows);
								        }
			 
				         };
			
			element.bootstrapPaginator(options);
			
			element.hasClass('pagination-sm');
 }
 function refalshUMTable(page,rows) {
	 var tbBody = "";
	 $.ajax({
         type: "get",//数据发送的方式（post 或者 get）
         url: "/showUMTabUserJson?page="+page,//要发送的后台地址
         //data: {page:page},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
         dataType: "json",//后台处理后返回的数据格式
         success: function (data) {//ajax请求成功后触发的方法
        	 //console.log(data);
        	 
             
        	 var id = (page - 1) * rows;
        	 for(var i = 0; i < data.length; i++){
        		 									//	alert(data[i].userManEmail);
        		 switch(data[i][2]) {
        		 case 0:data[i][2] = "普通用户";break;
        		 case 1:data[i][2] = "管理员";break;
        		                }
        		 switch(data[i][4]) {
        		 case 0:data[i][4] = "是";break;
        		 case 1:data[i][4] = "否";break;
        		 			}
        		 tbBody += "<tr id="+ data[i][0]  +"><td>" + ++id + "</td>" + 
        		 							 "<td>" + data[i][1] + "</td>" +
        		 							 "<td>" + data[i][2] + "</td>"+
        		 							 "<td>" + data[i][3] + "</td>" +
        		 							 "<td>" + data[i][4] + "</td>" + 
        		 							 "<td style='text-align: center'>"+
        		 							 "<button  type='button' class='btn btn-primary' onClick='btnUMAlterUser(" + data[i][0] + ")' >"+
															"<i class='glyphicon glyphicon-edit'></i></button>&nbsp;&nbsp;"+
															"<button type='button' class='btn btn-primary' onClick='btnUMDelUser(" + data[i][0] + ")' data-toggle='modal' data-target='#userman_delete_modal'>"+
															"<i class='glyphicon glyphicon-trash'></i></button></td>"+
        		 							 "<td style='display:none'>" + data[i][0] + "</td></tr>";
        	 			 }
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
 
 function showUMAddmodal() {
	 document.getElementById("adduser_id").value = "";
	  $.ajax({
		  type:"get",
		  url:"/showAddmodal",
		  async:false,
		  dataType:"json",
			 success:function(data){}
	  });
	 $('#btn_userman_addUser').modal('show');
 }
function btn_userman_addUser_submit(){
    var email = document.getElementById("emUMAddEmail");
    var name = document.getElementById("txtUMAddUsername");
    var pwd = document.getElementById("txtUMAddPwd");
    var repwd = document.getElementById("txtUMAddRepwd");
    var errorId = "lblUMAddErrortip";
    var type = document.getElementById("sltUMAddUsertype").value;
    var tag = document.getElementById("sltUMAddUsertag").value;
  //  var check = document.getElementById("adduser_id").value;
    if (checkAddUsername(name,errorId)&&checkAddPwd(pwd,errorId)&&checkAddRepwd(repwd,errorId)&&checkAddEmail(email,errorId)){
        $.ajax({
            type: "post",//数据发送的方式（post 或者 get）
            url: "/doUMAddUser",//要发送的后台地址
            data: {name:name.value,pwd:pwd.value,email:email.value,type:type,tag:tag},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType: "json",//后台处理后返回的数据格式
            success: function (data) {//ajax请求成功后触发的方法
            		 
                if(data == true){
                    alert('添加用户成功！');
                    relashPageUser();
                    $("#btnUMAddClose").click();
                	    $("#tableUMShow tbody").html("");
                    refalshUMTable(1,rows);
                	}else {
                			alert("添加用户失败");
                						}
            					},
            errorId: function (msg) {//ajax请求失败后触发的方法
                alert(msg);//弹出错误信息
            					}
        				});
        //说明信息是完整的，那么可以提交数据
    }
}



function btnUMAlterUser(em) {
	
	//var id = em.value;
	var name = document.getElementById(em).cells[1].innerHTML;
	var email = document.getElementById(em).cells[3].innerHTML;
	var alertId = document.getElementById(em).cells[6].innerHTML;
	document.getElementById("lblUMAlterId").innerHTML = em;
	document.getElementById("txtUMAlterUsername").value = name;
	document.getElementById("txtUMAlterEmail").value = email;
	setSelectChecked("sltUMAlterAlert",alertId);
	$('#btnUMAlterModal').modal('show');
}

function btn_userman_alter_submit(){
	    var email = document.getElementById("txtUMAlterEmail");
	    var name = document.getElementById("txtUMAlterUsername");
	    var errorId = "lblUMAlterErrortip";
	    var tag = document.getElementById("sltUMAlterAlert").value;
	    var id = document.getElementById("lblUMAlterId").innerHTML;
	   
	    if (checkAlterUsername(name,errorId)&&checkAddEmail(email,errorId)){
	        $.ajax({
	            type: "post",//数据发送的方式（post 或者 get）
	            url: "/doUMAlterUser",//要发送的后台地址
	            data: {name:name.value,email:email.value,tag:tag,id:id},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
	            dataType: "json",//后台处理后返回的数据格式
	            success: function (data) {//ajax请求成功后触发的方法
	            		 
	                if(data == true){
	                    alert('修改用户成功！');
	                    $("#btnUMAlterClose").click();
	                	   $("#tableUMShow tbody").html("");
	                    refalshUMTable(window.curPages,rows);
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
    

function btnUMDelUser(em) {
	document.getElementById("lblUMDelId").innerHTML = em;
}

function btn_userman_del_submit(){
	var id = document.getElementById("lblUMDelId").innerHTML;
	 $.ajax({
         type: "post",//数据发送的方式（post 或者 get）
         url: "/doUMDelUser",//要发送的后台地址
         data: {id:id},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
         dataType: "json",//后台处理后返回的数据格式
         success: function (data) {//ajax请求成功后触发的方法
         		 
             if(data == true){
                 alert('删除用户成功！');
                 relashPageUser();
                 $("#btnUMDelClose").click();
                	$("#tableUMShow tbody").html("");
                 refalshUMTable(window.curPages,rows);
             	}else {
             			alert("删除用户失败");
             						}
         					},
         errorId: function (msg) {//ajax请求失败后触发的方法
             alert(msg);//弹出错误信息
         					}
     				});
}

function checkAddUsername(em,errorId) {
    var num = em.value;
    if(!checkInputNull(num)) {
        showlblErrorTip(errorId,"用户名不能为空！");
        return false;
    }else {
        if(!checkInputIllegal(num)) {
            showlblErrorTip(errorId,"用户名输入字符有误！");
            return false;
        }else {
        	var check = checkAddUserexist(num);
        //	alert(check);
        	if(check) {
        		showlblErrorTip(errorId,"用户名已存在！");
        		return false;
        	}else {
        		showlblErrorTip(errorId,"");
        		return true;
        	}
        }
    }
}

function checkAddUserexist(em) {
	var check;
	$.ajax({
		type:"post",
	  url:"/doUMCheckuser",
	  async: false,
	  data:{name:em},
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



 