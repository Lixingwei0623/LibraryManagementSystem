<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import="java.sql.*" %>
    <%@ page  import="java.util.ArrayList" %>
    <%@ page  import="bean.Book" %>
    <%@ page  import="dao.impl.IBookDaoImpl" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书清单</title>
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
<%

	IBookDaoImpl iBookDaoImpl=new IBookDaoImpl();	
	ArrayList<Book> books=iBookDaoImpl.getAllBooks();		
	request.setAttribute("books", books);

%>
<jsp:include page="header.jsp"></jsp:include>

	<div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:5%;">       
		<p class="list-group-item active" style="width:90px;">书号</p>
		<p class="list-group-item active" style="width:150px;">书名</p>         
        <p class="list-group-item active" style="width:100px;">作者</p>
        <p class="list-group-item active">出版社</p> 
        <p class="list-group-item active">出版日期</p>
        <p class="list-group-item active" style="width:100px;">图书分类</p> 
        <p class="list-group-item active" style="width:230px;">简介</p>
        <p class="list-group-item active" style="width:70px;">下单</p>
        <c:if test="${reader!=null&&reader.isAdmin()}">
        <p class="list-group-item active">推荐 &nbsp;&nbsp; 数量</p>        
        <p class="list-group-item active">修改 &nbsp;&nbsp; 删除</p>        
        </c:if>         
    </div>
    <c:set var="Yes"  value="是"/>
	<c:set var="No"  value="否"/>
    <c:forEach items="${books }" var="book">
	    <div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:5%;margin-bottom:0px;">       
			<p class="list-group-item " style="width:90px;">${book.getNumber() }</p>
			<p class="list-group-item " style="width:150px;"><a href="bookDetail?bid=${book.bid }">${book.getBname() }</a></p>         
	        <p class="list-group-item " style="width:100px;">${book.getAuthor() }</p>
	        <p class="list-group-item ">${book.getPublisher() }</p> 
	        <p class="list-group-item ">${book.getPubtime() }</p>	        
	        <p class="list-group-item " style="width:100px;">${book.getCategory() }</p> 
	        <p class="list-group-item " style="width:230px;">${book.getIntro() }</p>
	        <p class="list-group-item " style="width:70px;"><a href="borrow?bid=${book.bid }">借阅</a></p>
	        <c:if test="${reader!=null&&reader.isAdmin()}">
	        <p class="list-group-item "> ${book.getRecommed()==1?Yes:No}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.getNum() }  </p> 
	        <p class="list-group-item "><a href="modifiyBook?bid=${book.bid }">修改</a> &nbsp;&nbsp; <a href="bookList?bid=${book.bid }">删除</a></p>    
	        </c:if>   
	    </div>
    
    </c:forEach>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>