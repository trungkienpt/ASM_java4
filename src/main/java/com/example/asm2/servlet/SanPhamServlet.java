package com.example.asm2.servlet;

import com.example.asm2.model.DanhMuc;
import com.example.asm2.model.SanPham;
import com.example.asm2.ripository.DanhMucRepository;
import com.example.asm2.ripository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "SanPhamServlet", value = {"/trang-chu/san-pham", "/SanPham/add", "/SanPham/delete", "/SanPham/detail", "/SanPham/update"})
public class SanPhamServlet extends HttpServlet {
    ArrayList<SanPham> sanpham = new ArrayList<>();
    ArrayList<DanhMuc> danhmuc = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/trang-chu/san-pham")){
            this.hienthi(request, response);
        } else if (uri.equals("/SanPham/delete")) {
            this.deleteSP(request, response);
        } else if (uri.equals("/SanPham/detail")) {
            this.chitietSP(request, response);
        }
    }

    private void chitietSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        //lay thong tin san pham
        SanPham sanphamDelete = SanPhamRepository.getdetail(id);
        request.setAttribute("sanpham", sanphamDelete);
        DanhMucRepository danhMucRepository = new DanhMucRepository();
        danhmuc = danhMucRepository.getList();
        request.setAttribute("lopDM", danhmuc);
        request.getRequestDispatcher("/san-pham/san-pham-detail.jsp").forward(request, response);
    }

    private void deleteSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        //lay thong tin san pham
        SanPham sanphamDelete = SanPhamRepository.getdetail(id);
        //xoa san pham vua tim duoc
        SanPhamRepository.deleteSanPham(sanphamDelete);
        response.sendRedirect("/trang-chu/san-pham");
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPhamRepository sanPhamRepository = new SanPhamRepository();
        sanpham = sanPhamRepository.getList();
        DanhMucRepository danhMucRepository = new DanhMucRepository();
        danhmuc = danhMucRepository.getList();
        request.setAttribute("listSP", sanpham);
        request.setAttribute("lopDM", danhmuc);
        request.getRequestDispatcher("/san-pham/trang-chu-SP.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/SanPham/add")){
            this.addSanPham(request, response);
        } else if (uri.equals("/SanPham/update")) {
            this.updateSP(request, response);
        }
    }

    private void updateSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("maSanPham");
        String ten = request.getParameter("tenSanPham");
        String tt = request.getParameter("trangThai");
        Date ngaytao = null;
        for (SanPham sp : sanpham){
            if (sp.getId() == id){
                ngaytao = sp.getNgayTao();
            }
        }
        Date ngaysua = new Date();
        Integer idDanhMuc = Integer.parseInt(request.getParameter("tenDanhMuc"));
        SanPham sanPham = new SanPham();
        sanPham.setMaSanPham(ma);
        sanPham.setTenSanPham(ten);
        sanPham.setTrangThai(tt);
        sanPham.setNgayTao(ngaytao);
        sanPham.setNgaySua(ngaysua);
        DanhMuc danhmuc = new DanhMuc();
        danhmuc.setId(idDanhMuc);
        sanPham.setIdDanhMuc(danhmuc);
        sanPham.setId(id);
        SanPhamRepository.addSanPham(sanPham);
        response.sendRedirect("/trang-chu/san-pham");
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maSanPham");
        String ten = request.getParameter("tenSanPham");
        String tt = request.getParameter("trangThai");
        Date ngaytao = new Date();
        Date ngaysua = new Date();
//        Integer danhMuc = Integer.parseInt(request.getParameter("tenDanhMuc"));
        Integer idDanhMuc = Integer.parseInt(request.getParameter("tenDanhMuc"));
        SanPham sanPham = new SanPham();
        sanPham.setMaSanPham(ma);
        sanPham.setTenSanPham(ten);
        sanPham.setTrangThai(tt);
        sanPham.setNgayTao(ngaytao);
        sanPham.setNgaySua(ngaysua);
//        sanPham.setIdDanhMuc(new DanhMuc(danhMuc));
        DanhMuc danhmuc = new DanhMuc();
        danhmuc.setId(idDanhMuc);
        sanPham.setIdDanhMuc(danhmuc);
        SanPhamRepository.addSanPham(sanPham);
        response.sendRedirect("/trang-chu/san-pham");
    }
}
