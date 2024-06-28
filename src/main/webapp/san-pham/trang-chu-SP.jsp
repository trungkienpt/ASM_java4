<%--
  Created by IntelliJ IDEA.
  User: Pico123
  Date: 3/27/2024
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">
<form action="/SanPham/add" method="post">
    <div class="mb-3">
        <label  class="form-label">Ma san pham</label>
        <input type="text" class="form-control" name="maSanPham" >
    </div>
    <div class="mb-3">
        <label  class="form-label">Tên san pham</label>
        <input type="text" class="form-control" name="tenSanPham" >
    </div>
    <div class="row">
        <p class="col-4"> Trang thai
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Active" name="trangThai">
            <label class="form-check-label">
                Active
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Inactive" name="trangThai">
            <label class="form-check-label">
                Inactive
            </label>
        </div>
    </div>
    <div class="mb-3">
        <label for="disabledSelect" class="form-label">Ten danh muc</label>
        <select id="disabledSelect" class="form-select" name="tenDanhMuc">
            <c:forEach items="${lopDM}" var="dm">
                <option value="${dm.id}">${dm.tenDanhMuc}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn" style="background-color: chocolate">Submit</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col"> STT</th>
        <th scope="col">ID </th>
        <th scope="col">Ma san pham</th>
        <th scope="col">Tên san pham</th>
        <th scope="col">trang thai</th>
        <th scope="col">Ngay tao</th>
        <th scope="col">Ngay sua</th>
        <th scope="col">Ten danh muc</th>
        <th scope="col">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSP}" var="sp" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${sp.id}</td>
            <td>${sp.maSanPham}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.trangThai}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.ngaySua}</td>
            <td>${sp.idDanhMuc.tenDanhMuc}</td>
            <td>
                <a href="/SanPham/detail?id=${sp.id}" class="btn btn" style="background-color: darkorchid">Chi tiết</a>
                <a href="/SanPham/delete?id=${sp.id}" class="btn btn" style="background-color: darkorchid">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
