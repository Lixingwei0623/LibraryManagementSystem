<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心-信息修改</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<link rel="stylesheet" type="text/css" href="./css/reg_left_div.css"/>
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
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

function checkPassword1(){
	var userPwd=document.getElementById("inputPassword1");	
	if(userPwd.value==""){
		alert("原密码不能为空！");
		userPwd.focus();
		return false;
	}else if(userPwd.value.length<6||userPwd.value.length>20){
		 alert("密码长度为6~20位，请进行确认！");
		userPwd.focus();
		return false;
	}	
	return true;	
}

function checkPassword2(){
	var userPwd=document.getElementById("inputPassword2");	
	if(userPwd.value==""){
		alert("新密码不能为空！");
		userPwd.focus();
		return false;
	}else if(userPwd.value.length<6||userPwd.value.length>20){
		 alert("密码长度为6~20位，请进行确认！");
		userPwd.focus();
		return false;
	}	
	return true;	
}
function checkForm(){	
	
	return checkPassword1()&&checkPassword2();
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
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:set var="psw"  value="psw"/>
	<c:set var="info"  value="info"/>
	<c:set var="res"  value="No"/>
	<c:if test="${result==res }" var="an">
		<div align="center" style="width:100%;background-color: red;">原密码错误，修改失败
		</div>			
	</c:if>
	<c:if test="${resultInfo==res }" var="an">
		<div align="center" style="width:100%;background-color: red;">姓名或电话号码错误，修改失败
		</div>			
	</c:if>
	<c:if test="${modifymessage==psw }" var="an">
	<div align="center" style="margin-top: 50px; margin-left: 20%;margin-right: 20%;">
		<form class="form-horizontal" role="form" onsubmit="return checkForm()">			
			<div style="margin-top: -30px; margin-left: 45%;margin-bottom: 10px;">
				<a href="personalCenter" style="color: red;">取消修改</a>
			</div>
			<img width="120px" height="120px" src="img/profile/profile1.jpg" class="img-circle img-thumbnail">
			<div class="form-group" style="margin:0px;">
			    <label class="control-label col-sm-1" style="padding-top: 7px;padding-bottom: 7px;text-align: right;margin-left: 35%;">账号</label>
			    <div>
			      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;"><c:out value="${reader.getAccount()}"></c:out></p>
			    </div>
		    </div>
		    <Br>
			<div class="form-group" style="margin:0px;">
			    <label class="control-label col-sm-1" style="padding-top: 7px;padding-bottom: 7px;text-align: right;margin-left: 35%;">原密码</label>
			    <div>
			      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;margin-top:-10px;">
		     		<input type="password" class="form-control" id="inputPassword1" name="password1"  placeholder="请输入原密码"">
			   		</p>
			    </div>
		    </div>
		    <Br>
		    <div class="form-group" style="margin:0px;">
			    <label class="control-label col-sm-1" style="padding-top: 7px;padding-bottom: 7px;text-align: right;margin-left: 35%;">新密码</label>
			    <div>
			      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;margin-top:-10px;">
		     		<input type="text" class="form-control" id="inputPassword2" name="password2"  placeholder="请输入新密码"">
			   		</p>
			    </div>
		    </div>
		    <Br>		
			<div class="button_div" style="margin-left:30px;">
				<button type="submit" class="btn btn-success" style="width: 50%;algin:center;">立即修改</button>
			</div>
			<div class="button_div" style="margin-left:30px;">
				<button type="button" class="btn btn-warning" style="width: 50%;algin:center;" onclick="reset()">重置输入</button>
			</div>	
				
		</form>	
	</div>									
	</c:if>
	<c:if test="${modifymessage==info }" var="an">
	<div align="center" style="margin-top: 50px; margin-left: 20%;margin-right: 20%;">
		<form class="form-horizontal" role="form" onsubmit="return checkForm()">			
			<div style="margin-top: -30px; margin-left: 45%;margin-bottom: 10px;">
				<a href="personalCenter" style="color: red;">取消修改</a>
			</div>
			<img width="120px" height="120px" src="img/profile/profile1.jpg" class="img-circle img-thumbnail">
			<div class="form-group" style="margin:0px;">
			    <label class="control-label col-sm-1" style="padding-top: 7px;padding-bottom: 7px;text-align: right;margin-left: 35%;">账号</label>
			    <div>
			      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;"><c:out value="${reader.getAccount()}"></c:out></p>
			    </div>
		    </div>
		    <Br>			
		    <div class="form-group" style="margin:0px;">
			    <label class="control-label col-sm-1" style="padding-top: 7px;padding-bottom: 7px;text-align: right;margin-left: 35%;">姓名</label>
			    <div>
			      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;margin-top:-10px;">
		     		<input type="text" class="form-control" id="uname" name="uname"  value=${reader.getUname() }>
			   		</p>
			    </div>
		    </div>
		    <Br>
		    <div class="form-group" style="margin:0px;">
			    <label class="control-label col-sm-1" style="padding-top: 7px;padding-bottom: 7px;text-align: right;margin-left: 35%;">性别</label>
			    <div>
			      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;margin-top:-10px;">
		     		<label class="radio-inline" style="margin-right:10px;margin-bottom:10px;">
						<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" <c:if test="${reader.getSex()==1 }" var="an"> checked</c:if>> 男
					</label>
					<label class="radio-inline" style="margin-left:10px;margin-bottom:10px;">
						<input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="option2" <c:if test="${reader.getSex()==0 }" var="an"> checked</c:if>> 女
					</label>
			   		</p>
			    </div>
		    </div>
		    <Br>
		    <div class="form-group" style="margin:0px;">
			    <label class="control-label col-sm-1" style="padding-top: 7px;padding-bottom: 7px;text-align: right;margin-left: 35%;">电话</label>
			    <div>
			      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;margin-top:-10px;">
		     		<input type="text" class="form-control" id="phnumber" name="phnumber"  value=${reader.getPhnumber() }>
			   		</p>
			    </div>
		    </div>
		    <Br>		
			<div class="button_div" style="margin-left:30px;">
				<button type="submit" class="btn btn-success" style="width: 50%;algin:center;">立即修改</button>
			</div>
			<div class="button_div" style="margin-left:30px;">
				<button type="button" class="btn btn-warning" style="width: 50%;algin:center;" onclick="reset()">重置输入</button>
			</div>	
				
		</form>	
	</div>
												
	</c:if>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>