
//元素获取焦点时触发该函数
function onFoucs(){
	this.select();
	this.style.backgroundColor="#FFEC8B";
	this.style.color="#000000";
	alert("12");
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
//验证密码和确认密码
function checkPassword(){
	var userPwd=document.getElementById("inputPassword1");
	var userRePwd=document.getElementById("inputPassword2");
	if(userPwd.value==""){
		alert("密码不能为空！");
		userPwd.focus();
		return false;
	}else if(userPwd.value.length<6||userPwd.value.length>20){
		 alert("密码长度为6~20位，请进行确认！");
		userPwd.focus();
		return false;
	}else if(userPwd.value!=userRePwd.value){
		 alert("新密码和确认密码不一致！");
		userPwd.focus();
		return false;
	}
	// //密码由字母、数字和符号的两种以上组合
	// if(/\d/.test(userPwd.value)&&/[a-z]/i.test(userPwd.value)||
	// 	/\d/.test(userPwd.value)&&/[\@\#\$\%\&\*]/.test(userPwd.value)||
	// 	/[\@\#\$\%\&\*]/.test(userPwd.value)&&/[a-z]/i.test(userPwd.value)){
	// 	return true;	
	// }else{
	// 	alert("密码必须是由字母、数字和符号的两种以上组合!");
	// 	return false;	
	// }
	return true;	
}
//头像
function checkFile(){
	var file=document.getElementById("inputfile");
	if(file.value=="")	{
		alert("请上传头像");
		file.focus();
		return false;
	}
	return true;
}
//地区
function checkArea(){
	var area=document.getElementById("area");
	if(area.value==""||area.value=="请选择地区")	{
		alert("请选择地区");
		area.focus();
		return false;
	}
	return true;
}
//protocol 协议
function checkProtocol(){
	var protocol=document.getElementById("protocol");
	if(protocol.checked==false)	{
		alert("请阅读同意协议内容");
		protocol.focus();
		return false;
	}
	return true;
}

//表单提交时，触发该函数
function checkForm(){	
	return checkUserName()&&checkPassword()&&checkFile()&&checkArea()&&checkProtocol();
}
function checkForm2(){	
	
	return checkUserName()&&checkPassword1();
}

//重置信息reset()是现成的
function reset_info(){
	document.getElementById("name").value="123";
	document.getElementById("inputPassword1").value="";
	document.getElementById("inputPassword2").value="";
	document.getElementById("inputfile").value="";
	document.getElementById("area").value="请选择地区";
	document.getElementById("protocol").checked=false;
}

function reset_in(){
	document.getElementById("name").value="123";
	document.getElementById("inputPassword1").value="";	
}

//窗口加载完毕时，完成事件绑定
window.onload = function () {
	
	//为表单绑定表单提交事件处理函数
	var myform=document.forms[0];
	 myform.onsubmit=checkForm2;
	//为输入文本框绑定onfocus和onblur事件处理函数
	var inputs=document.getElementsByTagName("input");
	alert("123");
	for(var i=0;i<inputs.length;i++){
		var type=inputs[i].type;
		if(type=="text"||type=="password"){
			inputs[i].onfocus=onFoucs;
			inputs[i].onblur=onBlur;
		}
	}
};
