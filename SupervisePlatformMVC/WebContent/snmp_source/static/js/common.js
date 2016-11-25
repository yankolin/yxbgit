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
function showlblErrorTip(em,str) {
    document.getElementById(em).innerHTML=str;
}