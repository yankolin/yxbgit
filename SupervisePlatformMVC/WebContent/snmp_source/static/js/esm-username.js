/**
 * Created by rui on 2016/3/30.
 */

function btn_userman_addUser_submit(){
    var email = document.getElementById("emUMAddEmail");
    var name = document.getElementById("txtUMAddUsername");
    var pwd = document.getElementById("txtUMAddPwd");
    var repwd = document.getElementById("txtUMAddRepwd");
    var errorId = "lblUMAddErrortip";
    var type = document.getElementById("sltUMAddUsertype").value;
    var tag = document.getElementById("sltUMAddUsertag").value;
    alert(tag);
    if (checkAddUsername(name,errorId)&&checkAddPwd(pwd,errorId)&&checkAddRepwd(repwd,errorId)&&checkAddEmail(email,errorId)){
        alert("chenggong")
        //说明信息是完整的，那么可以提交数据
    }
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
            showlblErrorTip(errorId,"");
            return true;
        }
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

var num = 100;
var userId,userName,userType,userEmail,userReceiveMessage;

$("#table1").ingridaccount({

    url: 'useralter.php',
    height: 480,
    initialLoad: false,
    savedStateLoad: true,
    rowClasses: ['grid-row-style1','grid-row-style1','grid-row-style2','grid-row-style1','grid-row-style1','grid-row-style3'],
    sorting:false,
    paging:true,
    totalRecords: num,
    extraParams: {sessid : 'some_session_token_here'},
    onRowSelect: function(tr, selected,id){
        var tr_html	= $(tr).html();
        userId =$(tr).find("td[data-ingrid-colid  = '0']").text();
        userName = $(tr).find("td[data-ingrid-colid  = '1']").text();
        userType =$(tr).find("td[data-ingrid-colid  = '2']").text();
        userEmail =$(tr).find("td[data-ingrid-colid  = '3']").text();
        userReceiveMessage =$(tr).find("td[data-ingrid-colid  = '4']").text();
        //变量已经取出，并且是当前行的值

        if(id == 1)	{
            var tip = "当前修改用户："+userId;
            //alert(tip+"sdsd"+u_name);
            showAlterData(userId);
        }
        if(id == 2){
            var tip = "执行删除后将无法恢复，确定删除用户： "+num;
            showDelteData(userId,userName,userEmail);
        }
        if(id == 3){

        }

    }

});

function showDelteData(var1,var2,var3){
    $("#lbl_userman_delete_id").text(var1);
    $("#p_userman_delete_username").text(var2);
    $("#p_userman_delete_email").text(var3);
}

function showAlterData(num) {
    $("#tipNum").text(num);
    $("#slt_userman_alter_userTag").val(userReceiveMessage);
}

function btn_userman_alter_submit(){
    var txt_userman_alter_inputName=$("#txt_userman_alter_inputName").val();
    var txt_userman_alter_inputNameReturn=IlegalInput(txt_userman_alter_inputName);
    if (txt_userman_alter_inputNameReturn!="不允许为空"&&txt_userman_alter_inputNameReturn!=true){
        var txt_userman_alter_inputNameInfo=$("#txt_userman_alter_inputNameInfo");
        txt_userman_alter_inputNameInfo.text(txt_userman_alter_inputNameReturn);
        txt_userman_alter_inputNameInfo.css("display","");
        return false;
    }

    //处理新的密码
    var txt_userman_alter_newPasswordMess=$("#txt_userman_alter_newPassword").val();
    var txt_userman_alter_newPasswordReturn=IlegalInput(txt_userman_alter_newPasswordMess);
    if((txt_userman_alter_newPasswordReturn!="不允许为空")&&(txt_userman_alter_newPasswordReturn!=true)){
        var txt_userman_alter_newPasswordInfo=$("#txt_userman_alter_newPasswordInfo");
        txt_userman_alter_newPasswordInfo.text(txt_userman_alter_inputNameReturn);
        txt_userman_alter_newPasswordInfo.css("display","");
        return false;
    }

    //判断两次输入密码是否相同
    var txt_userman_alter_newPasswordRepeat=$("#txt_userman_alter_newPasswordRepeat");
    if (txt_userman_alter_newPasswordRepeat.val()!=txt_userman_alter_newPasswordMess){
        var txt_userman_alter_newPasswordRepeatInfo=$("#txt_userman_alter_newPasswordRepeatInfo");
        txt_userman_alter_newPasswordRepeatInfo.text("两次输入的密码不同");
        txt_userman_alter_newPasswordRepeatInfo.css("display","");
        return false;
    }

    var txt_userman_alter_email=$("#txt_userman_alter_email");
    var txt_userman_alter_emailReturn=checkEmail(txt_userman_alter_email);
    if (txt_userman_alter_emailReturn==false){
        return false;
    }

    if (txt_userman_alter_inputName==""&&txt_userman_alter_newPasswordMess==""&&txt_userman_alter_email.val()==""){
        //不提交任何数据
        return false;
    }

    var txt_userman_alter_oldPassword_js=$("#txt_userman_alter_oldPassword").val();
    //判断这个数据和数据库中的密码是否相同

}

function alterData() {
    var u_name = document.getElementById("inputName").value;
    var u_date = document.getElementById("inputDate").value;
    if(u_name.length == 0) {
        document.getElementById("errorId_alter").innerHTML="请输入名称!";
        return;
    }else {
        $.ajax({
            type: "post",//数据发送的方式（post 或者 get）
            url: "/doAlterJson",//要发送的后台地址
            data: {username:u_name},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType: "json",//后台处理后返回的数据格式
            success: function (data) {//ajax请求成功后触发的方法
                if(data == true){
                    alert('信息修改成功！');
                }
            },
            errorId: function (msg) {//ajax请求失败后触发的方法
                alert(msg);//弹出错误信息
            }
        });


        $("#alter_close").click();
    }
}