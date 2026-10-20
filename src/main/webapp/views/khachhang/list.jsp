<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="../layout/header.jsp" %>

<h3>Quản lý Khách hàng</h3>

<form class="row g-2 mb-3" method="get" action="${pageContext.request.contextPath}/khach-hang">
    <div class="col-auto">
        <input type="text" name="keyword" class="form-control"
               placeholder="Tìm mã, tên, SĐT..." value="${keyword}">
    </div>
    <div class="col-auto">
        <button class="btn btn-primary">Tìm kiếm</button>
    </div>
    <div class="col-auto">
        <a href="${pageContext.request.contextPath}/khach-hang?action=view-add"
           class="btn btn-success">Thêm</a>
    </div>
</form>

<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>#</th>
        <th>Mã</th>
        <th>Họ tên</th>
        <th>SĐT</th>
        <th>Địa chỉ</th>
        <th>Thành phố</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="kh" varStatus="st">
        <tr>
            <td>${st.index + 1}</td>
            <td>${kh.ma}</td>
            <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>
                <a class="btn btn-sm btn-info"
                   href="${pageContext.request.contextPath}/khach-hang?action=detail&id=${kh.id}">Chi tiết</a>
                <a class="btn btn-sm btn-warning"
                   href="${pageContext.request.contextPath}/khach-hang?action=view-update&id=${kh.id}">Sửa</a>
                <a class="btn btn-sm btn-danger"
                   href="${pageContext.request.contextPath}/khach-hang?action=delete&id=${kh.id}"
                   onclick="return confirm('Xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="../layout/footer.jsp" %>