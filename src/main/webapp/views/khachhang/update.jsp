<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<h3>Cập nhật khách hàng</h3>
<form method="post" action="${pageContext.request.contextPath}/khach-hang">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${kh.id}">

    <div class="mb-2">
        <label class="form-label">Mã</label>
        <input name="ma" class="form-control" value="${kh.ma}" required>
    </div>
    <div class="mb-2">
        <label class="form-label">Họ</label>
        <input name="ho" class="form-control" value="${kh.ho}">
    </div>
    <div class="mb-2">
        <label class="form-label">Tên đệm</label>
        <input name="tenDem" class="form-control" value="${kh.tenDem}">
    </div>
    <div class="mb-2">
        <label class="form-label">Tên</label>
        <input name="ten" class="form-control" value="${kh.ten}" required>
    </div>
    <div class="mb-2">
        <label class="form-label">SĐT</label>
        <input name="sdt" class="form-control" value="${kh.sdt}">
    </div>
    <div class="mb-2">
        <label class="form-label">Địa chỉ</label>
        <input name="diaChi" class="form-control" value="${kh.diaChi}">
    </div>
    <div class="mb-2">
        <label class="form-label">Thành phố</label>
        <input name="thanhPho" class="form-control" value="${kh.thanhPho}">
    </div>
    <div class="mb-2">
        <label class="form-label">Quốc gia</label>
        <input name="quocGia" class="form-control" value="${kh.quocGia}">
    </div>

    <button class="btn btn-warning">Cập nhật</button>
    <a href="${pageContext.request.contextPath}/khach-hang" class="btn btn-secondary">Hủy</a>
</form>

<%@ include file="../layout/footer.jsp" %>