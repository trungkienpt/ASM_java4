<%--
  Created by IntelliJ IDEA.
  User: Pico123
  Date: 3/28/2024
  Time: 1:27 AM
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
<form action="/ChitietSP/add" method="post">
    <div class="mb-3">
        <label  class="form-label">Ten san pham</label>
        <select  class="form-select" name="tenSanPham">
            <c:forEach items="${lopSP}" var="sp">
                <option value="${sp.id}">${sp.tenSanPham}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label  class="form-label">Ten mau sac</label>
        <select  class="form-select" name="tenMau">
            <c:forEach items="${lopMS}" var="ms">
                <option value="${ms.id}">${ms.tenMau}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label  class="form-label">Ten size</label>
        <select  class="form-select" name="tenSize">
            <c:forEach items="${lopSize}" var="size">
                <option value="${size.id}">${size.tenSize}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label  class="form-label">Gia ban</label>
        <input type="text" class="form-control" name="giaBan" >
    </div>
    <div class="mb-3">
        <label  class="form-label">So luong ton</label>
        <input type="text" class="form-control" name="soLuongTon" >
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
    <%--  <div class="mb-3">--%>
    <%--    <label for="disabledSelect" class="form-label">Ten danh muc</label>--%>
    <%--    <select id="disabledSelect" class="form-select" name="idDanhMuc">--%>
    <%--      <c:forEach items="${lopDM}" var="dm">--%>
    <%--        <option value="${dm.id}">${dm.tenDanhMuc}</option>--%>
    <%--      </c:forEach>--%>
    <%--    </select>--%>
    <%--  </div>--%>
    <button type="submit" class="btn btn" style="background-color: chocolate">Submit</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col"> STT</th>
        <th scope="col">ID </th>
        <th scope="col">Ten san pham</th>
        <th scope="col">Ten mau</th>
        <th scope="col">Ten size</th>
        <th scope="col">Gia ban</th>
        <th scope="col">So luong ton</th>
        <th scope="col">Trang thai</th>
        <th scope="col">Ngay tao</th>
        <th scope="col">Ngay sua</th>
        <th scope="col">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCTSP}" var="ctsp" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${ctsp.id}</td>
            <td>${ctsp.idSanPham.tenSanPham}</td>
            <td>${ctsp.idMauSac.tenMau}</td>
            <td>${ctsp.idSize.tenSize}</td>
            <td>${ctsp.giaBan}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.trangThai}</td>
            <td>${ctsp.ngayTao}</td>
            <td>${ctsp.ngaySua}</td>
            <td>
                <a href="/chi-tiet-sp/detail?id=${ctsp.id}" class="btn btn" style="background-color: darkorchid">Chi tiết</a>
                <a href="/chi-tiet-sp/delete?id=${ctsp.id}" class="btn btn" style="background-color: darkorchid">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
