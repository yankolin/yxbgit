
(function () {
  $.MsgBox = {
    Confirm: function (title, msg,callback) {
      GenerateHtml("confirm", title, msg);
      btnOk(callback);
      btnNo();
    }
  }
  
  $.MsgBox_alter = {
		  	 Confirm: function( title, msg,num,u_date,u_address,u_name,u_artist,callback_update) {
		    GenerateHtml_alter_user("confirm", title, msg,num,u_date,u_address,u_name,u_artist);
		    btnOk_update(callback_update);
		    btnNo();
		     }
		  }
  $.MsgBox_reset = {
		  Confirm: function( title, msg,num,callback_reset) {
		    GenerateHtml_reset("confirm", title, msg,num);
		    btnOk_reset(callback_reset);
		    btnNo();
		     }
		  }
  //生成html
  var GenerateHtml = function (type, title, msg) {
 
    var _html = "";
 
    _html += '<div id="mb_box"></div><div id="mb_con"><span id="mb_tit">' + title + '</span>';
    _html += '<a id="mb_ico">x</a><div id="mb_msg">' + msg + '</div><div id="mb_btnbox">';
 
    if (type == "confirm") {
      _html += '<input id="mb_btn_ok" type="button" value="确定" />';
      _html += '<input id="mb_btn_no" type="button" value="取消" />';
    }
    _html += '</div></div>';
 
    //必须先将_html添加body，再设置css样式
    $("body").append(_html); GenerateCss();
  }
  
  //生成html
  var GenerateHtml_alter_user = function (type, title, msg,num,u_date,u_address,u_name,u_artist) {
	 
 
    var _html = "";
 
    _html += '<div id="mb_box"></div><div id="mb_con_update"><span id="mb_tit">' + title + '</span>';
    _html += '<a id="mb_ico">x</a><div id="mb_msg_update">' + msg + '</div><ul id="mb_ul"  修改用户信息：</ul><br/><br/><ul id="mb_ul">&nbsp;&nbsp;用户名：<label >'+num+'</label></ul><br/>';
    _html +='<br/><ul id="mb_ul">日期：<input id="u_date" type="text" value = "'+u_date+'" /></ul><br/>';
    _html +='<br/><ul id="mb_ul">地址：<input id="u_address" type="text" value = "'+u_address+'" /></ul><br/>';
    _html +='<br/><ul id="mb_ul">名称：<input id="u_name" type="text" value = "'+u_name+'"  /></ul><br/>'; 
    _html +='<br/><ul id="mb_ul">artist：<input id="u_artist" type="text" value = "'+u_artist+'"  /></ul><br/>'; 
    _html +='<br/><div id ="error_alter" style="color:#F00" >&nbsp;</div><div id="mb_btnbox">';
    
    
    if (type == "confirm") {
      _html += '<input id="mb_btn_ok_update" type="button" value="确定" />';
      _html += '<input id="mb_btn_no" type="button" value="取消" />';
    }
    _html += '</div></div>';
 
    //必须先将_html添加body，再设置css样式
    $("body").append(_html); GenerateCss();
  }
  //生成html
  var GenerateHtml_reset = function (type, title, msg,num) {
	 
 
    var _html = "";
 
    _html += '<div id="mb_box"></div><div id="mb_con_update"><span id="mb_tit">' + title + '</span>';
    _html += '<a id="mb_ico">x</a><div id="mb_msg_update">' + msg + '</div><ul id="mb_ul"  重置用户密码：</ul><br/><br/><ul id="mb_ul">&nbsp;&nbsp;用户名：<label >'+num+'</label></ul><br/>';
    _html +='<br/><ul id="mb_ul">输入重置密码：<input id="re_pwd" type="password"  /></ul><br/>';
    _html +='<br/><ul id="mb_ul">确认重置密码：<input id="re_checkpwd" type="password" /></ul><br/>';
    _html +='<br/><div id ="error_reset_pwd" style="color:#F00" >&nbsp;</div><div id="mb_btnbox">';
    
    
    if (type == "confirm") {
      _html += '<input id="mb_btn_ok_reset" type="button" value="确定" />';
      _html += '<input id="mb_btn_no" type="button" value="取消" />';
    }
    _html += '</div></div>';
 
    //必须先将_html添加body，再设置css样式
    $("body").append(_html); GenerateCss();
  }
  //Éú³ÉCss
  var GenerateCss = function () {
 
    $("#mb_box").css({ width: '100%', height: '100%', zIndex: '99999', position: 'fixed',
      filter: 'Alpha(opacity=60)', backgroundColor: 'black', top: '0', left: '0', opacity: '0.6'
    });
 
    $("#mb_con").css({ zIndex: '999999', width: '400px', position: 'fixed',
      backgroundColor: 'White', borderRadius: '15px',margin:'100px 0 0 0'
    });
    $("#mb_con_update").css({ zIndex: '999999', width: '400px', position: 'fixed',
        backgroundColor: 'White', borderRadius: '15px',margin:'100px 0 0 0'
      });
    $("#mb_tit").css({ display: 'block', fontSize: '14px', color: '#444', padding: '10px 15px',
      backgroundColor: '#DDD', borderRadius: '15px 15px 0 0',
      borderBottom: '3px solid #009BFE', fontWeight: 'bold'
    });
 
    $("#mb_msg").css({ padding: '15px', lineHeight:'20px',
      borderBottom: '1px dashed #DDD', fontSize: '12px',display:'block'
    });
    $("#mb_msg_update").css({ padding: '15px', lineHeight:'20px',
        borderBottom: '1px dashed #DDD', fontSize: '12px',display:'block'
      });
     $("#mb_ul").css({ display:'block',padding: '0 0 0 30px'
    });
     $("#mb_ul > li").css({display:'block',padding: '0 0 0 0' , margin: '3px'
    });
    $("#mb_ico").css({ display: 'block', position: 'absolute', right: '10px', top: '9px',
      border: '1px solid Gray', width: '18px', height: '18px', textAlign: 'center',
      lineHeight: '16px', cursor: 'pointer', borderRadius: '12px', fontFamily: 'Î¢ÈíÑÅºÚ'
    });
 
    $("#mb_btnbox").css({ margin: '15px 0 10px 0', textAlign: 'center' });
    $("#mb_btn_ok,#mb_btn_no,#mb_btn_ok_update,#mb_btn_ok_reset").css({ width: '85px', height: '30px', color: 'white', border: 'none' });
    $("#mb_btn_ok,#mb_btn_ok_update,#mb_btn_ok_reset").css({ backgroundColor: '#168bbb' });
    $("#mb_btn_no").css({ backgroundColor: 'gray', marginLeft: '20px' });
 
 
   
    $("#mb_ico").hover(function () {
      $(this).css({ backgroundColor: 'Red', color: 'White' });
    }, function () {
      $(this).css({ backgroundColor: '#DDD', color: 'black' });
    });
 
    var _widht = document.documentElement.clientWidth; //ÆÁÄ»¿í
    var _height = document.documentElement.clientHeight; //ÆÁÄ»¸ß
 
    var boxWidth = $("#mb_con").width();
    var boxHeight = $("#mb_con").height();
    
    var boxWidth_update = $("#mb_con_update").width();
    var boxHeight_update = $("#mb_con_update").height();
 
    //让提示框居中
    $("#mb_con").css({ top: (_height - boxHeight) / 2 + "px", left: (_widht - boxWidth) / 2 + "px" });
    $("#mb_con_update").css({ top: (_height - boxHeight_update) / 2 + "px", left: (_widht - boxWidth_update) / 2 + "px" });
  }
 
 
  //确定按钮事件
  var btnOk = function (callback) {
    $("#mb_btn_ok").click(function () {
      $("#mb_box,#mb_con").remove();
      if (typeof (callback) == 'function') {
        callback();
      }
    });
  }
 
  
  //确定x修改事件
  var btnOk_update = function (callback_update) {
    $("#mb_btn_ok_update").click(function () {
    	
    	var u_name = document.getElementById("u_name").value;
    	var u_date = document.getElementById("u_date").value;
    	var u_address = document.getElementById("u_address").value;
    	if(u_name.length == 0){
    		document.getElementById("error_alter").innerHTML="请输入名称!"; 
    		return;
    		}
    	if(u_date.length == 0){
    		document.getElementById("error_alter").innerHTML="请输入日期!"; 
    		return;
    		}
    	if(u_address.length == 0){
    		document.getElementById("error_alter").innerHTML="请输入地址!"; 
    		return;
    		}
    	//if(check_num(u_balance,"error_alter")){
	    		if (typeof (callback_update) == 'function') {
	    			//alert('sdfsaf');
	    			callback_update(u_name,u_date,u_address);
	    	        $("#mb_box,#mb_con_update").remove();
	    	     		 }
    	//}
    	
    });
  }
//确定采纳按钮事件
  var btnOk_reset = function (callback_reset) {
    $("#mb_btn_ok_reset").click(function () {
    	
    	var re_pwd = document.getElementById("re_pwd").value;
    	var re_checkpwd = document.getElementById("re_checkpwd").value;
    	
    	if(re_pwd.length == 0){
    		document.getElementById("error_reset_pwd").innerHTML="请输入重置密码!"; 
    		return;
    	}
    	if(re_checkpwd.length == 0){
    		document.getElementById("error_reset_pwd").innerHTML="请输入确认重置密码!"; 
    		return;
    	}
    	if(re_pwd.length < 6 || re_pwd > 20){
    		document.getElementById("error_reset_pwd").innerHTML="密码长度为6至20位!"; 
    		return;
    	}
    	if(re_pwd != re_checkpwd){
    		document.getElementById("error_reset_pwd").innerHTML="两次密码输入不一致"; 
    		document.getElementById("re_checkpwd").value = "";
    		return;
    	}else{
    		if (typeof (callback_reset) == 'function'){
    			callback_reset(re_pwd);
    	        $("#mb_box,#mb_con_update").remove();
    	      }
    	}
    });
  }
  
  //取消按钮事件
  var btnNo = function () {
    $("#mb_btn_no,#mb_ico").click(function () {
      $("#mb_box,#mb_con").remove();
      $("#mb_box,#mb_con_update").remove();
    });
  }
})();
