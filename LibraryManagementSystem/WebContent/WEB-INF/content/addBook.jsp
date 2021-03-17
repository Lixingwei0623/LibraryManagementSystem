<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
		<c:set var="Exist"  value="Exist"/>
		<c:set var="Yes"  value="Yes"/>
		<c:if test="${infoAdd==Exist }" var="an">
			<div align="center" style="width:100%;background-color: red;">该图书已被在库，不能重复添加
			</div>			
		</c:if>		
		<c:if test="${infoAdd==Yes }" var="an2">
			<div align="center" style="width:100%;background-color: green;">图书添加成功
			</div>			
		</c:if>
	<div align="center" style="margin-top: 50px; margin-left: 20%;margin-right: 20%;">
		<form class="form-horizontal" role="form" onsubmit="return checkForm()">
			<h2  style="margin-top: 20px;">添加图书</h2>
			<div style="margin-top: -30px; margin-left: 45%;margin-bottom: 10px;">
				<a href="index" style="color: red;">取消添加</a>
			</div>							
			<input type="text" class="form-control" id="bname" name="bname" 
			   placeholder="书名" style="width: 50%;margin-top:30px;margin-bottom:20px;">				
			<input type="text" class="form-control" id="number" name="number" 
			   placeholder="书号" style="width: 50%;margin-top:20px;margin-bottom:10px;">
			<input type="text" class="form-control" id="author" name="author" 
			   placeholder="作者" style="width: 50%;margin-top:20px;margin-bottom:10px;">
			<input type="text" class="form-control" id="publisher" name="publisher" 
			   placeholder="出版社" style="width: 50%;margin-top:20px;margin-bottom:10px;">
			<input type="text" class="form-control" id="num" name="num" 
			   placeholder="数量" style="width: 50%;margin-top:20px;margin-bottom:20px;">	
			<div class="input-group" style="width:50%;margin-top:20px;margin-bottom:20px;">
				<span class="input-group-addon">类型</span>				
				<select class="form-control" name="category" >
					<option>报刊</option>
			      	<option>小说</option>
			        <option>教材</option>
			        <option>科技</option>			        				      
				</select>
						
			</div>
			
			<div class="input-group" style="width:50%;margin-top:20px;margin-bottom:20px;">
				<span class="input-group-addon">出版时间</span>
				<span class="input-group-addon">年：</span>
				<select class="form-control" name="year" >
					<script >
						for(var i=0;i<100;i++){
							var op="<option>"+(2020-i)+"</option>";
							document.write(op);
						}
					</script>				      
				</select>
				<span class="input-group-addon">月：</span>
				<select class="form-control" name="month">					
				      <script >
				      	for(var i=0;i<12;i++){
				      		var op="<option>"+(i+1)+"</option>";
				      		document.write(op);
				      	}
				      </script>
				</select>				
			</div>
			<textarea class="form-control" id="intro" name="intro" 
			   placeholder="简介" style="width: 50%;margin-top:20px;margin-bottom:10px;"></textarea> 
			<label class="radio-inline" style="margin-right:50px;margin-bottom:10px;">
				<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" checked> 推荐
			</label>
			<label class="radio-inline" style="margin-left:50px;margin-bottom:10px;">
				<input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="option2"> 暂不推荐
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