<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FPOLY Shop - Lap8</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a class="nav-link text-warning" href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/khach-hang">FPOLY Shop</a>
        <div class="navbar-nav">
            <a class="nav-link" href="${pageContext.request.contextPath}/khach-hang">Khách hàng</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/nhan-vien">Nhân viên</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/san-pham">Sản phẩm</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/ban-hang">Bán hàng</a>
        </div>
    </div>
</nav>
<div class="container">