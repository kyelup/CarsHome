<%@ page language="java" pageEncoding="gb2312"%>

<html>
<head>
<title>UploadBean</title>
</head>


<form name="form1" method="post" action="servlet/UpBrandServlet"
	enctype="multipart/form-data">
	
	<br />

	<div align="left">
	国家:	<select name="brandCountry">
			<option value="1">中国</option>
			<option value="2">美国</option>
			<option value="3">德国</option>
			<option value="4">日本</option>
			<option value="5">韩国</option>
			<option value="6">法国</option>
			<option value="7">英国</option>
			<option value="8">意大利</option>
			<option value="9">其他</option>


		</select>
	</div>
	<div align="left">
	品牌名称:<input name="brandName" type="text" id="brandName" size="50">
	<br>
	品牌首字母:<input name="brandFirstC" type="text" id="brandFirstC" size="50">
	<br>
	</div>
	<br />

	<div align="left">
		附件: <input name="brandIcon" type="file" id="brandIcon" size="50">
	</div>
	<br>
	<div align="left">
		<input name="ok" type="submit" value="提交 ">
	</div>
</form>

</html>
