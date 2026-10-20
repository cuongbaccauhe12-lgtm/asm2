<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<h3>Chi tiết khách hàng</h3>
<table class="table table-bordered w-50">
    <tr><th>Mã</th><td>${kh.ma}</td></tr>
    <tr><th>Họ tên</th><td>${kh.ho} ${kh.tenDem} ${kh.ten}</td></tr>
    <tr><th>SĐT</th><td>${kh.sdt}</td></tr>
    <tr><th>Địa chỉ</th><td>${kh.diaChi}</td></tr>
    <tr><th>Thành phố</th><td>${kh.thanhPho}</td></tr>
    <tr><th>Quốc gia</th><td>${kh.quocGia}</td></tr>
</table>
<a href="${pageContext.request.contextPath}/khach-hang" class="btn btn-secondary">Quay lại</a>

<%@ include file="../layout/footer.jsp" %>