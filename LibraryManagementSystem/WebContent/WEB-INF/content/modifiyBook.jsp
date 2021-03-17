<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改图书</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div style="width: 80%;margin-left: 10%;margin-right: 10%;" >			
		<form class="form-horizontal" role="form" onsubmit="return checkForm()">
	        <div class="thumbnail" style="height:730px;" align="center">         
            	<div style=" margin-left: 70%;margin-bottom: 10px;">
					<a href="bookList" style="color: red;">返回图书列表</a>
				</div>
            	<input type="hidden" class="form-control" id="bid2" name="bid2" 
					   		value="${book.bid}" >            	
	            <div class="caption" align="left" style="margin-left:25%;">
		            <div class="input-group" style="width:70%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">书名</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${book.bname}">							
					</div>
					<div class="input-group" style="width:70%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">作者</span>									
						<input type="text" class="form-control" id="author" name="author" 
					   		value="${book.author}">							
					</div>
					<div class="input-group" style="width:70%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">书号</span>									
						<input type="text" class="form-control" id="number" name="number" 
					   		value="${book.number}">							
					</div>
					<div class="input-group" style="width:70%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">类别</span>									
						<input type="text" class="form-control" id="category" name="category" 
					   		value="${book.category}">							
					</div>
					<div class="input-group" style="width:70%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">数量</span>									
						<input type="text" class="form-control" id="num" name="num" 
					   		value="${book.num}">							
					</div>					
					<div class="input-group" style="width:70%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">出版社</span>									
						<input type="text" class="form-control" id="publisher" name="publisher" 
					   		value="${book.publisher}">							
					</div>
					<div class="input-group" style="width:70%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">封面路径</span>									
						<input type="text" class="form-control" id="picture" name="picture" 
					   		value="${book.picture}">							
					</div>
					<div class="input-group" style="width:70%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">出版时间</span>
						<span class="input-group-addon">年：</span>
						<select class="form-control" name="year">
						    <option selected="selected">${book.getPubtime().getYear()+1900 }</option>
							<script >
								for(var i=0;i<100;i++){
									var op="<option>"+(2020-i)+"</option>";
									document.write(op);
								}
							</script>				      
						</select>
						<span class="input-group-addon">月：</span>
						<select class="form-control" name="month">
						<option selected="selected">${book.getPubtime().getMonth()+1 }</option>					
						      <script >
						      	for(var i=0;i<12;i++){
						      		var op="<option>"+(i+1)+"</option>";
						      		document.write(op);
						      	}
						      </script>
						</select>
						<span class="input-group-addon">日：</span>
						<select class="form-control" name="date">
						<option selected="selected">${book.getPubtime().getDate() }</option>					
						      <script >
						      	for(var i=0;i<30;i++){
						      		var op="<option>"+(i+1)+"</option>";
						      		document.write(op);
						      	}
						      </script>
						</select>							
					</div>
					<div class="form-group" style="margin:0px;">
					   
					    <label class="radio-inline" style="margin-right:10px;margin-bottom:10px;">
							<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1"  <c:if test="${book.getRecommed()==1 }" var="an">checked</c:if>> 推荐
						</label>
						<label class="radio-inline" style="margin-left:10px;margin-bottom:10px;">
							<input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="option2" <c:if test="${book.getRecommed()==0 }" var="an">checked</c:if>> 不推荐
						</label>
					   		
				    </div>
					<div class="input-group" style="width:70%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">简介</span>									
						<textarea class="form-control" id="intro" name="intro" 
			   				 >${book.intro}</textarea>							
					</div>
					<div class="button_div" style="margin-bottom:10px;">
						<button type="submit" class="btn btn-success" style="width: 70%;algin:center;">提交修改</button>
					</div>
					<div class="button_div">
						<button type="button" class="btn btn-warning" style="width: 70%;algin:center;" onclick="reset()">重置输入</button>
					</div>	
					
					
		            	
		                
	            </div>
	        </div>
   		</form>
</div>
	


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>