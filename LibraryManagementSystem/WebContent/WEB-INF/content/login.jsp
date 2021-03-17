<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<link rel="stylesheet" type="text/css" href="./css/reg_left_div.css"/>
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
<script src="./js/formValidation.js"></script>
<script type="text/javascript">
//元素获取焦点时触发该函数
function onFoucs(){
	this.select();
	this.style.backgroundColor="#FFEC8B";
	this.style.color="#000000";
	
}
//元素失去焦点时触发该函数
function onBlur(){
	this.style.backgroundColor="#FFFFFF";
	this.style.color="#000000";
}
//验证用户名
function checkUserName(){
	var name=document.getElementById("name");
	if(name.value==""||name.value=="请输入用户名")	{
		alert("用户名不能为空");
		name.focus();
		return false;
	}else{
		return true;
	}
}

function checkPassword1(){
	var userPwd=document.getElementById("inputPassword1");	
	if(userPwd.value==""){
		alert("密码不能为空！");
		userPwd.focus();
		return false;
	}else if(userPwd.value.length<6||userPwd.value.length>20){
		 alert("密码长度为6~20位，请进行确认！");
		userPwd.focus();
		return false;
	}	
	return true;	
}
function checkForm2(){	
	
	return checkUserName()&&checkPassword1();
}
//窗口加载完毕时，完成事件绑定
window.onload = function () {
	
	//为表单绑定表单提交事件处理函数
	//var myform=document.forms[0];
	// myform.onsubmit=checkForm2;
	//为输入文本框绑定onfocus和onblur事件处理函数
	var inputs=document.getElementsByTagName("input");
	
	for(var i=0;i<inputs.length;i++){
		var type=inputs[i].type;
		if(type=="text"||type=="password"){
			inputs[i].onfocus=onFoucs;
			inputs[i].onblur=onBlur;
		}
	}
};
</script>
</head>
<body background="img/timg2.jpg" style="background-size: 100% 100%; background-attachment: fixed;">
		<jsp:include page="header.jsp"></jsp:include>
		<c:set var="info"  value="账号或密码错误，请重新登录"/>
		<c:if test="${infoLogin==info }" var="an">
			<div align="center" style="width:100%;background-color: red;">账号或密码错误，请重新登录
			</div>			
		</c:if>
		<c:if test="${message!=null }" var="an">
			<div align="center" style="width:100%;background-color: red;">${message }
			</div>			
		</c:if>
		
		<div align="center" style="margin-top: 50px; margin-left: 20%;margin-right: 20%;">
		<form class="form-horizontal" role="form" onsubmit="return checkForm2()">
			<h2  style="margin-top: 20px;">用户登录</h2>
			<div style="margin-top: -30px; margin-left: 45%;margin-bottom: 10px;">
				<a href="register" style="color: red;">尚无账号？前往注册</a>
			</div>							
			<input type="text" class="form-control" id="name" name="name" 
			   placeholder="用户名" style="width: 50%;margin-top:30px;margin-bottom:20px;">							
			<input type="password" class="form-control" id="inputPassword1" name="password" 
			   placeholder="请输入密码" style="width: 50%;margin-top:20px;margin-bottom:10px;">	
			<label class="radio-inline" style="margin-right:50px;margin-bottom:10px;">
				<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" checked> 读者
			</label>
			<label class="radio-inline" style="margin-left:50px;margin-bottom:10px;">
				<input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="option2"> 管理员
			</label>		
			<div class="button_div" style="margin-left:30px;">
				<button type="submit" class="btn btn-success" style="width: 50%;algin:center;">立即登录</button>
			</div>
			<div class="button_div" style="margin-left:30px;">
				<button type="button" class="btn btn-warning" style="width: 50%;algin:center;" onclick="reset()">重置输入</button>
			</div>
			
				
		</form>				
		</div>
			<jsp:include page="footer.jsp"></jsp:include>
			
	</body>
</html>