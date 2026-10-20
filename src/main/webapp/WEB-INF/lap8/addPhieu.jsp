<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/17/2026
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/phieu-giam-gia/add" method="post">
    Mã sản phẩm: <input type="text" name="ma" required><br><br>
    Tên sản phẩm: <input type="text" name="ten" required><br><br>
   So Luong: <input type="text" name="soLuong"><br><br>


    <button type="submit">Thêm</button>
    <a href="${pageContext.request.contextPath}/san-pham/hien-thi">Quay lại</a>
</form>
</body>
</html>
