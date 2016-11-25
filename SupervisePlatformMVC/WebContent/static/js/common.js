/**
 * Created by rui on 2016/3/30.
 */

//检查空格、非法字符、长度不够等问题,只能输入数字
/**
 * @return {boolean}
 */


function checkInputNull(em) {
    if(em == "" || em.length == 0) {
        return false;
    }
    return true;
}

function checkInputMinlen(em,num) {
    if(em.length < num) {
        return false;
    }
    return true;
}

function checkInputMaxlen(em,num) {
    if(em.length > num) {
        return false;
    }
    return true;
}

function checkInputEmail(em) {
    var filter  = /^\w+([-+.]\w+)*@\w+([-.]\\w+)*\.\w+([-.]\w+)*$/;
    if (!filter.test(em)){
        return false;
    }
    return true;
}

function checkInputIllegal(em) {
    var filter = /\'|\"|\/|\%|\+\$/;//new RegExp("[~'!@#$%^&*()-+_=:]");
    if(filter.test(em)) {
        return false;
    }
    return true;
}

function checkInputNum(em) {
	var filter = /^[0-9]*$/;
	if(filter.test(em)) {
		return true;
	}else {
		return false;
	}
}

function showlblErrorTip(em,str) {
    document.getElementById(em).innerHTML=str;
}

function IsIpValidate(ip) {
    var val = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
    var vald = val.exec(ip);
    if (vald == null) {
        return false;
    }

    return true;
}

/** 
 * 设置select选中 
 * @param selectId select的id值 
 * @param checkValue 选中option的值 
 * @author lqy 
 * @since 2015-08-21 
*/  
function setSelectChecked(selectId, checkValue){  
	var opts = document.getElementById(selectId).getElementsByTagName("option");  
	for (var i=0; i<opts.length; i++){  
	  if (opts[i].value == checkValue){  
	    opts[i].selected=true;  
	  }  
	} 
}