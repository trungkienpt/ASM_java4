<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/26/2024
  Time: 10:04 PM
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
        <form action="/khach-hang/them-moi" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">Họ tên</span>
                <input type="text" class="form-control" name="hoTen">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Địa chỉ</span>
                <input type="text" class="form-control" name="diaChi">
            </div><div class="input-group mb-3">
            <span class="input-group-text">Số điện thoại</span>
            <input type="number" class="form-control" name="sDT">
        </div>

            <div class="input-group mb-3">
                <span style="margin-right: 50px">Trạng thái</span>
                <div class="form-check">
                    <div style="display: inline-block; margin-right: 40px">
                        <input class="form-check-input" type="radio" name="trangThai" checked value="Active"
                               id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                            Active
                        </label>
                    </div>
                    <div style="display: inline-block">
                        <input class="form-check-input" type="radio" name="trangThai" value="Inactive"
                               id="flexRadioDefault2">
                        <label class="form-check-label" for="flexRadioDefault2">
                            Inactive
                        </label>
                    </div>
                </div>
            </div>
            <div class="d-flex flex-row-reverse">
                <button type="submit" class="btn btn-primary">Lưu</button>
            </div>
        </form>
    </div>
    <table class="table" style="margin-bottom: 40px">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Họ tên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Ngày tạo</th>
            <th scope="col">Ngày sửa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${listKH}" varStatus="i">
            <tr class="table">
                <td>${s.id}</td>
                <td>${s.hoTen}</td>
                <td>${s.diaChi}</td>
                <td>${s.SDT}</td>
                <td>${s.trangThai}</td>
                <td>${s.ngayTao}</td>
                <td>${s.ngaySua}</td>
                <td>
                    <a href="/khach-hang/chi-tiet?id=${s.id}" class="btn btn-primary">Chi tiết</a>
                    <a href="/khach-hang/xoa?id=${s.id}" class="btn btn-primary">Xóa</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
