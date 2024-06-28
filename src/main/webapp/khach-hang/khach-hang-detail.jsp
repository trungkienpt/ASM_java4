<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2024
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div>
        <h2 class="text-center">Khách hàng</h2>
        <form action="/khach-hang/cap-nhat" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">id</span>
                <input type="text" class="form-control" name="id" value="${khachHang.id}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Họ tên</span>
                <input type="text" class="form-control" name="hoTen" value="${khachHang.hoTen}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Địa chỉ</span>
                <input type="text" class="form-control" name="diaChi" value="${khachHang.diaChi}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Số điện thoại</span>
                <input type="number" class="form-control" name="sDT" value="${khachHang.SDT}">
            </div>

            <div class="input-group mb-3">
                <span style="margin-right: 50px">Trạng thái</span>
                <div class="form-check">
                    <div style="display: inline-block; margin-right: 40px">
                        <input class="form-check-input" type="radio" name="trangThai" ${khachHang.trangThai == "Active" ? "checked" :""} checked value="Active"
                               id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                            Active
                        </label>
                    </div>
                    <div style="display: inline-block">
                        <input class="form-check-input" type="radio" name="trangThai" ${khachHang.trangThai == "Inactive" ? "checked" :""} value="Inactive"
                               id="flexRadioDefault2">
                        <label class="form-check-label" for="flexRadioDefault2">
                            Inactive
                        </label>
                    </div>
                </div>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Ngày Tạo</span>
                <input type="text" class="form-control" name="ngayTao" value="${khachHang.ngayTao}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Ngày sửa</span>
                <input type="text" class="form-control" name="ngaySua" value="${khachHang.ngaySua}">
            </div>
            <div class="d-flex flex-row-reverse">
                <button type="submit" class="btn btn-primary">Lưu</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
