<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加读者</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
		<c:set var="Exist"  value="Exist"/>
		<c:set var="Yes"  value="Yes"/>
		<c:if test="${infoAdd==Exist }" var="an">
			<div align="center" style="width:100%;background-color: red;">该读者已存在，不能重复添加
			</div>			
		</c:if>		
		<c:if test="${infoAdd==Yes }" var="an2">
			<div align="center" style="width:100%;background-color: green;">读者添加成功
			</div>			
		</c:if>
	<div align="center" style="margin-top: 50px; margin-left: 20%;margin-right: 20%;">
		<form class="form-horizontal" role="form" onsubmit="return checkForm()">
			<h2  style="margin-top: 20px;">添加读者</h2>
			<div style="margin-top: -30px; margin-left: 45%;margin-bottom: 10px;">
				<a href="index" style="color: red;">取消添加</a>
			</div>							
						
			<input type="text" class="form-control" id="account" name="account" 
			   placeholder="账号" style="width: 50%;margin-top:20px;margin-bottom:10px;">
		    <input type="text" class="form-control" id="password" name="password" 
			   placeholder="密码" style="width: 50%;margin-top:20px;margin-bottom:10px;">
			<input type="text" class="form-control" id="uname" name="uname" 
			   placeholder="姓名" style="width: 50%;margin-top:20px;margin-bottom:10px;">
			<input type="text" class="form-control" id="phnumber" name="phnumber" 
			   placeholder="电话" style="width: 50%;margin-top:20px;margin-bottom:10px;">
			<input type="text" class="form-control" id="picture" name="picture" 
			   placeholder="头像路径" style="width: 50%;margin-top:20px;margin-bottom:10px;">
		    <label class="radio-inline" style="margin-right:50px;margin-bottom:10px;">
				<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" checked> 男
			</label>
			<label class="radio-inline" style="margin-left:50px;margin-bottom:10px;">
				<input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="option2"> 女
			</label>
			  					
			<div class="button_div" style="margin-bottom:10px;">
				<button type="submit" class="btn btn-success" style="width: 50%;algin:center;">立即添加</button>
			</div>
			<div class="button_div" style="margin-top:10px;">
				<button type="button" class="btn btn-warning" style="width: 50%;algin:center;" onclick="reset()">重置输入</button>
			</div>
			
				
		</form>
	</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>