<%@ page language="java" pageEncoding="gb2312"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>UploadBean</title>
</head>

<form name="form1" method="post"
	action="AddModelBrandActionServlet">
	BrandId:&nbsp;&nbsp;<select name="brandId">
		<c:if test="${not empty brandList}">
			<c:forEach items="${brandList}" var="brand" varStatus="status">
				<option value="${brand.id}">${brand.brandName}</option>
			</c:forEach>
		</c:if>
	</select> <br> modelName: <input name="modelName" type="text"> <br>
	<input name="ok" type="submit" value="Ìá½» ">
</form>

</html>
