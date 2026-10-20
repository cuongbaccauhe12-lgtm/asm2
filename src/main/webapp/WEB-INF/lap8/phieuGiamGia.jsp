<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/17/2026
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/phieu-giam-gia/add">+ Thêm sản phẩm</a>
<br><br>

<table border="1">

    <select name="phieuGiamGia">
        <c:forEach items="${Listpgg}" var="pgg">
            <option value="${pgg.id}">${pgg.ten} - ${pgg.ma}</option>
        </c:forEach>
    </select>

    <thead>
    <tr>
        <th>STT</th>
        <th>Mã phiếu</th>
        <th>Tên phiếu</th>
        <th>Số lượng</th>
    </tr>

    </thead>

    <tbody>
    <c:forEach items="${Listpgg}" var="pgg" varStatus="sta">
        <tr>
           <td>${sta.index + 1}</td>
            <td>${pgg.ma}</td>
            <td>${pgg.ten}</td>
            <td>${pgg.soLuong}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
