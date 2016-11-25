var code;
function init()
{
   
	if(window.top != window){
		
		   window.top.location.href = window.location.href;
		  
		}
	createCode();
}

function createCode()
{ 
 code = "";
 var codeLength =5;
 var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
        
 for(var i=0;i<codeLength;i++)
 {     
  var charIndex =Math.floor(Math.random()*20);
  code +=selectChar[charIndex];     
 }
 document.getElementById("admin_check_text").style.fontFamily="Fixedsys";  
 document.getElementById("admin_check_text").style.letterSpacing="5px";  
 document.getElementById("admin_check_text").style.color="#ff0000";   
 document.getElementById("admin_check_text").style.fontSize="14px"; 
 document.getElementById("admin_check_text").innerHTML=code;   
 //return code;  
}
function getBasePath(){
	var obj=window.location;
	var contextPath=obj.pathname.split("/")[1];
	var basePath=obj.protocol+"//"+obj.host;
	return basePath;
	}
var path = getBasePath();

function validate() {
	var inputCode = document.getElementById("admin_check").value.toUpperCase();
	var inputname = document.getElementById("admin_name").value;
	var inputpwd = document.getElementById("admin_pwd").value;

	if((inputname.length <=0)){
		document.getElementById("admin_error").innerHTML="请输入用户名";
		return false;
	}
	if((inputpwd.length <=0)){
		document.getElementById("admin_error").innerHTML="请输入密码";
		return false;
	}
	if((inputCode.length <=0)){
		document.getElementById("admin_error").innerHTML="请输入验证码";
		return false;
	}
	if(inputCode != code ){
		document.getElementById("admin_error").innerHTML="验证码输入错误，请重新输入";
		createCode();
		return false;
	}else{
		
		document.getElementById("admin_pwd").value = $.md5(inputpwd);
		return true;
	}
}
function checkInputName(em,errorId) {
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

function DiscodeCheck()
{
	var inputCode = document.getElementById("admin_check").value.toUpperCase();
	if(inputCode.length >= 5)
		{
		  if(inputCode != code )
		  {
			 document.getElementById("admin_error").innerHTML="验证码输入错误，请重新输入";
			  //return;
		   }
		   else
			{
			   //document.getElementById("errorDiscode").style.display="none";
			   //document.getElementById("OKDiscode").style.display="inline-block";
			   //document.getElementById("errorloginshow").style.display="none";
			   document.getElementById("admin_error").innerHTML="&nbsp;";
			}
		
		}
}

function DiscodeCheckss()
{
	var inputCode = document.getElementById("incode").value.toUpperCase();
	if(inputCode.length >= 5)
		{
		  if(inputCode != code )
		  {
			  document.getElementById("OKDiscode").style.display="none";
			  document.getElementById("errorDiscode").style.display="inline-block";
			  
		   }
		   else
			{
			   document.getElementById("errorDiscode").style.display="none";
			   document.getElementById("OKDiscode").style.display="inline-block";
			   //document.getElementById("errorloginshow").style.display="none";
			   document.getElementById("errorloginshow").innerHTML="&nbsp;";
			}
		
		}
}
/*看不清，换一张验证码*/
function changDiscode()
{
	 document.getElementById("admin_error").style.display="none";
	createCode();	
}

function resetClear(){
    document.getElementById("admin_error").innerHTML="";
}
