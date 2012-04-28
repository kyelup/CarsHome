<%@ page language="java" pageEncoding="gb2312"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>UploadBean</title>
</head>


<form name="form1" method="post" action="AddCarWithNoPicServlet">
	<br />
	<br /> <br> 所属品牌:&nbsp;&nbsp;<select name="modelId">
		<c:if test="${not empty modelList}">
			<c:forEach items="${modelList}" var="model" varStatus="status">
				<option value="${model.id}">${model.modelName}</option>
			</c:forEach>
		</c:if>
	</select> <br> <br> <br> 车辆名称:<input name="carName" type="text"
		id="carName" size="50"> <br> <br> <br> <br>
	Min车辆价格:<input name="carPriceMin" type="text" id="carPriceMin" size="50">
	<br>
	<br>
	Max车辆价格:<input name="carPriceMax" type="text" id="carPriceMax" size="50">
	<br> <br> <br>
	<div align="left">
		<input name="ok" type="submit" value="提交 ">
	</div>
</form>

</html>
