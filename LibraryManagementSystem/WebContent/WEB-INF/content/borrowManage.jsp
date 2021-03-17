<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借阅</title>
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

	<div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:10%;">       
		<p class="list-group-item active" style="width:160px;">书名</p>
		<p class="list-group-item active">借阅者</p>         
        <p class="list-group-item active">图书分类</p>
        <p class="list-group-item active">借阅时间</p> 
        <p class="list-group-item active">应还时间</p>
        <p class="list-group-item active">是否归还</p> 
        <p class="list-group-item active">续借</p>
        <p class="list-group-item active">还书</p>         
    </div>
    <c:set var="Yes"  value="是"/>
	<c:set var="No"  value="否"/>
    <c:forEach items="${infosBw }" var="infoBw">
	    <div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:20%; margin-bottom:0px;">       
			<p class="list-group-item " style="width:160px;">${infoBw.getBname() }</p>
			<p class="list-group-item ">${infoBw.getUname() }</p>         
	        <p class="list-group-item ">${infoBw.getCategory() }</p>
	        <p class="list-group-item ">${infoBw.getBwtime() }</p> 
	        <p class="list-group-item ">${infoBw.getRetime() }</p>
	        <p class="list-group-item ">${infoBw.isFlag()?Yes:No }</p> 
	        <p class="list-group-item "><a href="borrowManage?bridC=${infoBw.brid }">续借</a></p>
	        <p class="list-group-item "><a href="borrowManage?bridR=${infoBw.brid }">还书</a></p>         
	    </div>
    
    </c:forEach>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>