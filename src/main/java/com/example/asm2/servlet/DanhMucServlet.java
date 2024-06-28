package com.example.asm2.servlet;

import com.example.asm2.model.DanhMuc;
import com.example.asm2.model.KhachHang;
import com.example.asm2.ripository.DanhMucRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "DanhMucServlet", value = {"/DanhMucServlet", "/Danh_muc/add", "/Danh-muc/delete", "/danh-muc/detail", "/danh-muc/update"})
public class DanhMucServlet extends HttpServlet {
    ArrayList<DanhMuc> danhmuc = new ArrayList<>();
    DanhMucRepository danhMucRepository = new DanhMucRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/DanhMucServlet")){
            this.hienthi(request, response);
        } else if (uri.equals("/Danh-muc/delete")) {
            this.deleteDM(request, response);
        } else if (uri.equals("/danh-muc/detail")) {
            this.chitietDM(request, response);
        }
    }

    private void chitietDM(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        DanhMuc danhMuc = danhMucRepository.getdetail(id);
        request.setAttribute("DM", danhMuc);
        request.getRequestDispatcher("/danh-muc/danh-muc-detail.jsp").forward(request, response);
    }

    private void deleteDM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        DanhMuc danhMuc = danhMucRepository.getdetail(id);
        danhMucRepository.deleteDanhmuc(danhMuc);
        response.sendRedirect("/DanhMucServlet");
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DanhMucRepository danhMucRepository = new DanhMucRepository();
        danhmuc = danhMucRepository.getList();
        request.setAttribute("listDM", danhmuc);
        request.getRequestDispatcher("/danh-muc/trang-chu-DM.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/Danh_muc/add")){
            this.add(request, response);
        } else if (uri.equals("/danh-muc/update")) {
            this.updateDM(request, response);
        }
    }

    private void updateDM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("maDanhMuc");
        String ten = request.getParameter("tenDanhMuc");
        String tt = request.getParameter("trangThai");
        Date ngaytao = null;
        for (DanhMuc dm : danhmuc) {
            if(dm.getId() == id) {
                ngaytao = dm.getNgayTao();
            }
        }
        Date ngaysua = new Date();
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setId(id);
        danhMuc.setMaDanhMuc(ma);
        danhMuc.setTenDanhMuc(ten);
        danhMuc.setTrangThai(tt);
        danhMuc.setNgayTao(ngaytao);
        danhMuc.setNgaySua(ngaysua);
        DanhMucRepository.addDanhmuc(danhMuc);
        response.sendRedirect("/DanhMucServlet");
    }


    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maDanhMuc");
        String ten = request.getParameter("tenDanhMuc");
        String tt = request.getParameter("trangThai");
        Date ngaytao = new Date();
        Date ngaysua = new Date();
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setMaDanhMuc(ma);
        danhMuc.setTenDanhMuc(ten);
        danhMuc.setTrangThai(tt);
        danhMuc.setNgayTao(ngaytao);
        danhMuc.setNgaySua(ngaysua);
        DanhMucRepository.addDanhmuc(danhMuc);
        response.sendRedirect("/DanhMucServlet");
    }
}
