<%@ page language="java" pageEncoding="gb2312"%>

<html>
<head>
<title>UploadBean</title>
</head>


<form name="form1" method="post" action="servlet/UpBrandServlet"
	enctype="multipart/form-data">
	
	<br />

	<div align="left">
	����:	<select name="brandCountry">
			<option value="1">�й�</option>
			<option value="2">����</option>
			<option value="3">�¹�</option>
			<option value="4">�ձ�</option>
			<option value="5">����</option>
			<option value="6">����</option>
			<option value="7">Ӣ��</option>
			<option value="8">�����</option>
			<option value="9">����</option>


		</select>
	</div>
	<div align="left">
	Ʒ������:<input name="brandName" type="text" id="brandName" size="50">
	<br>
	Ʒ������ĸ:<input name="brandFirstC" type="text" id="brandFirstC" size="50">
	<br>
	</div>
	<br />

	<div align="left">
		����: <input name="brandIcon" type="file" id="brandIcon" size="50">
	</div>
	<br>
	<div align="left">
		<input name="ok" type="submit" value="�ύ ">
	</div>
</form>

</html>
