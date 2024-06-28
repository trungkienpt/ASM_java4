<%--
  Created by IntelliJ IDEA.
  User: Pico123
  Date: 4/4/2024
  Time: 2:05 AM
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
<form action="/danh-muc/update" method="post">
    <div class="mb-3">
        <label  class="form-label">ID</label>
        <input type="text" class="form-control" name="id" value="${DM.id}">
    </div>
    <div class="mb-3">
        <label  class="form-label">Ma danh muc</label>
        <input type="text" class="form-control" name="maDanhMuc" value="${DM.maDanhMuc}">
    </div>
    <div class="mb-3">
        <label  class="form-label">Tên danh muc</label>
        <input type="text" class="form-control" name="tenDanhMuc" value="${DM.tenDanhMuc}" >
    </div>
    <div class="row">
        <p class="col-4"> Trang thai
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Active" name="trangThai" <c:if test="${DM.trangThai == 'Active'}">checked</c:if> >
            <label class="form-check-label">
                Active
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Inactive" name="trangThai" <c:if test="${DM.trangThai == 'Inactive'}">checked</c:if> >
            <label class="form-check-label">
                Inactive
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn" style="background-color: chocolate">Update</button>
</form>
</body>
</html>
