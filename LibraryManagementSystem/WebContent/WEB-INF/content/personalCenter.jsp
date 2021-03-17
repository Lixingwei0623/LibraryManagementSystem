<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:set var="res"  value="Yes"/>
	<c:if test="${result==res }" var="an">
		<div align="center" style="width:100%;background-color: greenyellow;">密码修改成功
		</div>			
	</c:if>
	<c:if test="${reader==null }" var="an">
		<div align="center" style="width:100%;background-color: greenyellow;">当前处于未登录状态，个人中心无法进入，请登录或者返回首页
		<br><a href="index">点我返回首页</a>
		</div>			
	</c:if>
	<div class="container-fluid" style="height: 600px;" align="center">
	<c:if test="${reader!=null&&!reader.isAdmin()}" var="an">
		<img width="120px" height="120px" src="img/profile/profile1.jpg" class="img-circle img-thumbnail">
		<div class="form-group" style="margin-top:10px;">
		    <label class="control-label col-sm-1" style="padding-top: 7px;padding-bottom: 7px;text-align: right;margin-left: 35%;">账号</label>
		    <div>
		      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;"><c:out value="${reader.getAccount()}"></c:out></p>
		    </div>
	    </div>
	    <Br></Br>
	    <div class="form-group" style="margin-top:10px;">
		    <label class="control-label col-sm-1" style="padding-top: 8px;padding-bottom: 8px;text-align: right;margin-left: 35%;">姓名</label>
		    <div>
		      <p class="form-control-static col-sm-2" style="border: 1px solid black; text-align: left;margin-right: 35%;"><c:out value="${reader.getUname()}"></c:out></p>
		    </div>
	    </div>
	    <Br></Br>
	    <div class="form-group" style="margin-top:10px;">
		    <label class="control-label col-sm-1" style="padding-top: 8px;padding-bottom: 8px;text-align: right;margin-left: 35%;">性别</label>
		    <div>
		    <c:set var="sex1"  value="男"/>
		    <c:set var="sex2"  value="女"/>
		      <p class="form-control-static col-sm-2" style="border: 1px solid black; text-align: left;margin-right: 35%;"><c:out value="${reader.getSex()==1?sex1:sex2}"></c:out></p>
		    </div>
	    </div>
	    <Br></Br>
	    <div class="form-group" style="margin-top:10px;">
		    <label class="control-label col-sm-1" style="padding-top: 8px;padding-bottom: 8px;text-align: right;margin-left: 35%;">电话</label>
		    <div>
		      <p class="form-control-static col-sm-2" style="border: 1px solid black; text-align: left;margin-right: 35%;"><c:out value="${reader.getPhnumber()}"></c:out></p>
		    </div>
	    </div>
	    <Br></Br>
	    <div class="form-group" style="margin-top:10px;">
		    <label class="control-label col-sm-1" style="padding-top: 8px;padding-bottom: 8px;text-align: right;margin-left: 35%;">类型</label>
		    <div>
		      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;">读者</p>
		    </div>
	    </div>
	    <Br></Br>
	    <div class="button_div" style="margin-left:30px;width:20%">
				<button type="button" class="btn btn-success" style="width: 50%;algin:center;margin-top:10px;" onclick="reset()"><a href="modifiyInfo">编辑信息</a></button>
		</div>
		<div class="button_div" style="margin-left:30px;width:20%">
				<button type="button" class="btn btn-warning" style="width: 50%;algin:center;margin-top:10px;" onclick="reset()"><a href="modifyPsw">修改密码</a></button>
		</div>
										
	</c:if>
	<c:if test="${reader!=null&&reader.isAdmin()}">
		<img width="120px" height="120px" src="img/profile/profile1.jpg" class="img-circle img-thumbnail">
		<div class="form-group" style="margin-top:10px;">
		    <label class="control-label col-sm-1" style="padding-top: 7px;padding-bottom: 7px;text-align: right;margin-left: 35%;">账号</label>
		    <div>
		      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;"><c:out value="${reader.getAccount()}"></c:out></p>
		    </div>
	    </div>
	    <Br></Br>
	    <div class="form-group" style="margin-top:10px;">
		    <label class="control-label col-sm-1" style="padding-top: 8px;padding-bottom: 8px;text-align: right;margin-left: 35%;">密码</label>
		    <div>
		      <p class="form-control-static col-sm-2" style="border: 1px solid black; text-align: left;margin-right: 35%;"><c:out value="${reader.getPassword()}"></c:out></p>
		    </div>
	    </div>
	    <Br></Br>
	    <div class="form-group" style="margin-top:10px;">
		    <label class="control-label col-sm-1" style="padding-top: 8px;padding-bottom: 8px;text-align: right;margin-left: 35%;">类型</label>
		    <div>
		      <p class="form-control-static col-sm-2" style="text-align: left;margin-right: 35%;">管理员</p>
		    </div>
	    </div>
	    <Br></Br>
	    <div class="button_div" style="margin-left:30px;width:20%">
				<button type="button" class="btn btn-warning" style="width: 50%;algin:center;margin-top:10px;" onclick="reset()"><a href="modifyPsw">修改密码</a></button>
		</div>	
	</c:if>
	    
	</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>