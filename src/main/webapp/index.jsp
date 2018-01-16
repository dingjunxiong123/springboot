<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<body>
	<form method="POST" enctype="multipart/form-data" action="/upload">
		上传文件: <input type="file" name="file"><br /> 
		名字: <input type="text" name="name"><br /> <br /> 
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>
</body>
</html>
