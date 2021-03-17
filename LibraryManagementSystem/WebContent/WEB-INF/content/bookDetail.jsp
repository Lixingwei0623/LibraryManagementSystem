<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="width: 60%;margin-left: 20%;margin-right: 20%;" >			
		
	        <div class="thumbnail" style="height:730px;" align="center">	            
            	<img height="25%" src="${book.picture }" alt="${book.bname }">
            	<div class="button_div" style="margin-bottom:10px;margin-right:-70%;margin-top:-32%;">
					<a href="borrow?bid=${book.bid }"><button type="button" class="btn btn-success" style="width: 80px;algin:center;">借阅</button></a>
				</div>
				<div class="button_div" style="margin-bottom:10px;margin-left:-70%;margin-top:-42px;">
					<a href="index"><button type="button" class="btn btn-warning" style="width: 80px;algin:center;">返回</button></a>
				</div>            	
	            <div class="caption" align="left" style="margin-left:35%;margin-top:27%;">
		            <div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">书名</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${book.bname}" disabled>							
					</div>
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">作者</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${book.author}" disabled>							
					</div>
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">书号</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${book.number}" disabled>							
					</div>
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">类别</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${book.category}" disabled>							
					</div>
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">数量</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${book.num}" disabled>							
					</div>
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">出版社</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${book.publisher}" disabled>							
					</div>
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">出版时间</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${book.pubtime}" disabled>							
					</div>
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">简介</span>									
						<textarea class="form-control" id="intro" name="intro" 
			   				 disabled>${book.intro}</textarea>							
					</div>
					
					
		            	
		                
	            </div>
	        </div>
	   		
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>