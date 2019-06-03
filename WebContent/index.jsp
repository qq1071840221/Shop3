<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form enctype="multipart/form-data" action="UserServlet.do?method=save" method="post">
         name:<input type="text" name="name" /><br />
         birthday:<input type="text" name="birthday" /><br />
         money:<input type="text" name="money" /><br />
         photo:<input type="file" name="photo" /><br />
         <button type="submit">GO</button>
    </form>

</body>
</html>