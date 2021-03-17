<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者列表</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
<style>
	.list-group-horizontal .list-group-item {
		display: inline-block;
	}
	.list-group-horizontal .list-group-item {
		margin-bottom: 0;
		margin-left:-4px;
		margin-right: 0;
		width:130px;	
		
	}	
	.list-group-horizontal .list-group-item:first-child {
		border-top-right-radius:0;
		border-bottom-left-radius:4px;
	}
	.list-group-horizontal .list-group-item:last-child {
		border-top-right-radius:4px;
		border-bottom-left-radius:0;
	}
	
	</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="margin-left:10%;margin-bottom:40px; width:60%;">
	<form class="bs-example bs-example-form" role="form">		
		<div class="input-group">
			<input type="text" class="form-control" name="wd"  placeholder="账号/姓名">
			<span class="input-group-btn">
				<button class="btn btn-default" type="submit">
					搜索
				</button>
			</span>
		</div>			
	</form>
</div>
	<c:if test="${readers!=null }">
		<div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:5%;">       
			<p class="list-group-item active" style="width:120px;">账号</p>
			<p class="list-group-item active" style="width:150px;">密码</p>         
	        <p class="list-group-item active" style="width:100px;">姓名</p>
	        <p class="list-group-item active" style="width:70px;">性别</p> 
	        <p class="list-group-item active">电话</p>
	        <p class="list-group-item active" style="width:250px;">头像图片路径</p> 
	        <p class="list-group-item active">修改 &nbsp;&nbsp; 删除</p>
	    </div>
    </c:if>
    <c:set var="man"  value="男"/>
	<c:set var="woman"  value="女"/>
    <c:forEach items="${readers }" var="reader">
	    <div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:5%;margin-bottom:0px;">       
			<p class="list-group-item " style="width:120px;">${reader.getAccount() }</p>
			<p class="list-group-item " style="width:150px;">${reader.getPassword() }</p>         
	        <p class="list-group-item " style="width:100px;">${reader.getUname() }</p>
	        <p class="list-group-item " style="width:70px;">${reader.getSex()==1?man:woman}</p> 
	        <p class="list-group-item ">${reader.getPhnumber() }</p>	        
	        <p class="list-group-item " style="width:250px;">${reader.getPicture() }</p> 
	        <p class="list-group-item "><a href="modifiyReader?uid=${reader.uid }">修改</a> &nbsp;&nbsp; <a href="readerList?uid=${reader.uid }">删除</a></p>
	    </div>
    
    </c:forEach>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>