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
<form action="/chi-tiet-sp/update" method="post">
  <div class="mb-3">
    <label  class="form-label">ID</label>
    <input type="text" class="form-control" name="id" value="${listCTSP.id}">
  </div>
  <div class="mb-3">
    <label  class="form-label">Ten san pham</label>
    <select  class="form-select" name="tenSanPham">
      <c:forEach items="${lopSP}" var="sp">
        <option value="${sp.id}" <c:if test="${listCTSP.idSanPham.id == sp.id}">selected</c:if> >${sp.tenSanPham}</option>
      </c:forEach>
    </select>
  </div>
  <%--    <div class="input-group mb-3">--%>
  <%--        <span class="input-group-text">Sản phẩm</span>--%>
  <%--        <select class="form-control" name="sanPham">--%>
  <%--            <c:forEach items="${listSanPham}" var="s">--%>
  <%--                <option value="${s.id}" ${chiTietSanPham.sanPham.id == s.id ? "selected" : ""}>${s.tenSanPham}</option>--%>
  <%--            </c:forEach>--%>
  <%--        </select>--%>
  <%--    </div>--%>
  <div class="mb-3">
    <label  class="form-label">Ten mau sac</label>
    <select  class="form-select" name="tenMau">
      <c:forEach items="${lopMS}" var="ms">
        <option value="${ms.id}" <c:if test="${listCTSP.idMauSac.id == ms.id}">selected</c:if> >${ms.tenMau}</option>
      </c:forEach>
    </select>
  </div>
  <div class="mb-3">
    <label  class="form-label">Ten size</label>
    <select  class="form-select" name="tenSize">
      <c:forEach items="${lopSize}" var="size">
        <option value="${size.id}" <c:if test="${listCTSP.idSize.id == size.id}">selected</c:if> >${size.tenSize}</option>
      </c:forEach>
    </select>
  </div>
  <div class="mb-3">
    <label  class="form-label">Gia ban</label>
    <input type="text" class="form-control" name="giaBan" value="${listCTSP.giaBan}">
  </div>
  <div class="mb-3">
    <label  class="form-label">So luong ton</label>
    <input type="text" class="form-control" name="soLuongTon" value="${listCTSP.soLuongTon}">
  </div>
  <div class="row">
    <p class="col-4"> Trang thai
    </p>
    <div class="form-check col-4">
      <input class="form-check-input" type="radio" value="Active" name="trangThai" <c:if test="${listCTSP.trangThai == 'Active'}">checked</c:if>  >
      <label class="form-check-label">
        Active
      </label>
    </div>
    <div class="form-check col-4">
      <input class="form-check-input" type="radio" value="Inactive" name="trangThai" <c:if test="${listCTSP.trangThai == 'Inactive'}">checked</c:if> >
      <label class="form-check-label">
        Inactive
      </label>
    </div>
  </div>
  <button type="submit" class="btn btn" style="background-color: chocolate">Update</button>
</form>
</body>
</html>
