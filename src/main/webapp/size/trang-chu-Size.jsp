<%--
  Created by IntelliJ IDEA.
  User: Pico123
  Date: 3/29/2024
  Time: 11:50 PM
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
<form action="/Size/add" method="post">
    <div class="mb-3">
        <label  class="form-label">Ma size</label>
        <input type="text" class="form-control" name="maSize" >
    </div>
    <div class="mb-3">
        <label  class="form-label">Tên size</label>
        <input type="text" class="form-control" name="tenSize" >
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
    <button type="submit" class="btn btn" style="background-color: chocolate">Submit</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col"> STT</th>
        <th scope="col">ID </th>
        <th scope="col">Ma size</th>
        <th scope="col">Tên size</th>
        <th scope="col">trang thai</th>
        <th scope="col">Ngay tao</th>
        <th scope="col">Ngay sua</th>
        <th scope="col">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSize}" var="s" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${s.id}</td>
            <td>${s.maSize}</td>
            <td>${s.tenSize}</td>
            <td>${s.trangThai}</td>
            <td>${s.ngayTao}</td>
            <td>${s.ngaySua}</td>
            <td>
                <a href="/size/detail?id=${s.id}" class="btn btn" style="background-color: darkorchid">Chi tiết</a>
                <a href="/size/delete?id=${s.id}" class="btn btn" style="background-color: darkorchid">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
