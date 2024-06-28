package com.example.asm2.servlet;

import com.example.asm2.model.KhachHang;
import com.example.asm2.ripository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "KhachHangServlet", value = {"/KhachHangServlet", "/khach-hang/them-moi", "/khach-hang/cap-nhat", "/khach-hang/chi-tiet", "/khach-hang/xoa"})
public class KhachHangServlet extends HttpServlet {
    ArrayList<KhachHang> listKH = new ArrayList<>();
    KhachHangRepository khachHangRepository = new KhachHangRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/KhachHangServlet")) {
            listKH =  khachHangRepository.getList();
            request.setAttribute("listKH", listKH);
            request.getRequestDispatcher("/khach-hang/trang-chu-KH.jsp").forward(request,response);
        } else if (uri.contains("/khach-hang/xoa")) {
            int id = Integer.parseInt(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.detail(id);
            khachHangRepository.delete(khachHang);
            response.sendRedirect("/KhachHangServlet");
        } else if (uri.contains("/khach-hang/chi-tiet")) {
            int id = Integer.parseInt(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.detail(id);
            request.setAttribute("khachHang", khachHang);
            request.getRequestDispatcher("/khach-hang/khach-hang-detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/khach-hang/them-moi")) {
            String hoTen = request.getParameter("hoTen");
            String diaChi = request.getParameter("diaChi");
            String sDT = request.getParameter("sDT");
            Date ngayTao = new Date();
            Date ngaySua = new Date();
            String trangThai = request.getParameter("trangThai");
            KhachHang khachHang = new KhachHang();
            khachHang.setHoTen(hoTen);
            khachHang.setSDT(sDT);
            khachHang.setNgayTao(ngayTao);
            khachHang.setNgaySua(ngaySua);
            khachHang.setDiaChi(diaChi);
            khachHang.setTrangThai(trangThai);
            khachHangRepository.add(khachHang);
            response.sendRedirect("/KhachHangServlet");
        } else if (uri.equals("/khach-hang/cap-nhat")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String hoTen = request.getParameter("hoTen");
            String diaChi = request.getParameter("diaChi");
            String sDT = request.getParameter("sDT");
            Date ngayTao = null;
            for (KhachHang kh : listKH) {
                if(kh.getId() == id) {
                    ngayTao = kh.getNgayTao();
                }
            }
            Date ngaySua = new Date();
            String trangThai = request.getParameter("trangThai");
            KhachHang khachHang = new KhachHang();
            khachHang.setId(id);
            khachHang.setHoTen(hoTen);
            khachHang.setSDT(sDT);
            khachHang.setNgayTao(ngayTao);
            khachHang.setNgaySua(ngaySua);
            khachHang.setDiaChi(diaChi);
            khachHang.setTrangThai(trangThai);
            khachHangRepository.add(khachHang);
            response.sendRedirect("/KhachHangServlet");
        }
    }
}
