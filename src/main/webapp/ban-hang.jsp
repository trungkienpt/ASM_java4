<%--
  Created by IntelliJ IDEA.
  User: Pico123
  Date: 4/3/2024
  Time: 11:13 PM
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
<div class="row">
    <div class="col-7">
        <h2>Danh sách hoá đơn</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten khach hang</td>
                <td>Ngay tao</td>
                <td>Tong tien</td>
                <td>Trang Thai</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHD}" var="hd" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${hd.id}</td>
                <td>${hd.idKhachHang.hoTen}</td>
                <td>${hd.ngayTao}</td>
                <td>${tongtien}</td>
                <td>${hd.trangThai}</td>
                <td><a href="/hoa-don/detail?id=${hd.id}" class="btn btn" style="background-color: cornflowerblue">Chon</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <h2>Danh sách hoá đơn chi tiết</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten san pham</td>
                <td>So luong</td>
                <td>Gia ban</td>
                <td>Tong tien</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHDCT}" var="hdct" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${hdct.id}</td>
                <td>${hdct.idCTSP.idSanPham.tenSanPham}</td>
                <td>${hdct.soLuongMua}</td>
                <td>${hdct.giaBan}</td>
                <td>${hdct.tongTien}</td>
                <td><a href="" class="btn btn" style="background-color: cornflowerblue">Chon</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-5">
        <h2>Tạo hoá đơn</h2>
        <form action="/hoa-don/them" method="post">
        <div class="row">
            <div>
                <div>
                    <label class="mb-3 col-3">Số điện thoại</label>
                    <input type="text" class="col-7">
                </div>
                <button  class="btn btn-primary">Search</button>
            </div>
            <div class="mb-3">
                <label class="col-3">Ten Khach hang</label>
                <input type="text" class="col-7"  value="${hoaDon.idKhachHang.hoTen}" readonly >
            </div>
            <div class="mb-3">
                <label class="col-3">ID Hoa don</label>
                <input type="text" class="col-7" name="idHoaDon" value="${hoaDon.id}" readonly>
            </div>
            <div class="mb-3">
                <label class="col-3">Tong tien</label>
                <input type="text" class="col-7" name="tongTien" value="${tongtien}" readonly>
            </div>
            <div>
                <button type="submit"  class="btn btn-primary">Tạo hoá đơn</button>
                <button type="submit" class="btn btn-primary">Thanh toán</button>
            </div>
        </div>
        </form>

    </div>
</div>
<div>
    <h2>Danh sách chi tiết sản phẩm</h2>
    <table class="table">
        <thead>
        <tr>
            <td>STT</td>
            <td>ID CTSP</td>
            <td>Ten san pham</td>
            <td>Mau sac</td>
            <td>Size</td>
            <td>Gia ban</td>
            <td>So luong ton</td>
            <td>Chuc nang</td>
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
            <td><a href="/hoa-don-CT/them?id=${ctsp.id}" class="btn btn-primary">Chọn mua</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
