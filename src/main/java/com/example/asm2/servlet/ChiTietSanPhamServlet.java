package com.example.asm2.servlet;

import com.example.asm2.model.ChiTietSanPham;
import com.example.asm2.model.MauSac;
import com.example.asm2.model.SanPham;
import com.example.asm2.model.Size;
import com.example.asm2.ripository.ChiTietSanPhamRepository;
import com.example.asm2.ripository.MauSacRepository;
import com.example.asm2.ripository.SanPhamRepository;
import com.example.asm2.ripository.SizeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ChiTietSanPhamServlet", value = {"/ChiTietSPServlet", "/ChitietSP/add", "/chi-tiet-sp/delete", "/chi-tiet-sp/update", "/chi-tiet-sp/detail"})
public class ChiTietSanPhamServlet extends HttpServlet {
    ArrayList<ChiTietSanPham> chitietSP = new ArrayList<>();
    ArrayList<SanPham> sanpham = new ArrayList<>();
    ArrayList<MauSac> mausac = new ArrayList<>();
    ArrayList<Size> size = new ArrayList<>();
    ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    SanPham sanPham = new SanPham();
    MauSac mauSac = new MauSac();
    Size size2 = new Size();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/ChiTietSPServlet")){
            this.hienthi(request, response);
        } else if (uri.equals("/chi-tiet-sp/delete")) {
            this.deleteCTSP(request, response);
        } else if (uri.equals("/chi-tiet-sp/detail")) {
            this.chitietCTSP(request, response);
        }
    }

    private void chitietCTSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ChiTietSanPham deleteCTSP = ChiTietSanPhamRepository.getdetail(id);
        request.setAttribute("listCTSP", deleteCTSP);
        SanPhamRepository sanPhamRepository = new SanPhamRepository();
        sanpham = sanPhamRepository.getList();
        request.setAttribute("lopSP", sanpham);
        MauSacRepository mauSacRepository = new MauSacRepository();
        mausac = mauSacRepository.getList();
        request.setAttribute("lopMS", mausac);
        SizeRepository sizeRepository = new SizeRepository();
        size = sizeRepository.getList();
        request.setAttribute("lopSize", size);
        request.getRequestDispatcher("/ctsp/CTSP-detail.jsp").forward(request, response);
    }

    private void deleteCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ChiTietSanPham deleteCTSP = ChiTietSanPhamRepository.getdetail(id);
        ChiTietSanPhamRepository.deleteCTSP(deleteCTSP);
        response.sendRedirect("/ChiTietSPServlet");
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
        chitietSP = chiTietSanPhamRepository.getList();
        request.setAttribute("listCTSP", chitietSP);
        SanPhamRepository sanPhamRepository = new SanPhamRepository();
        sanpham = sanPhamRepository.getList();
        request.setAttribute("lopSP", sanpham);
        MauSacRepository mauSacRepository = new MauSacRepository();
        mausac = mauSacRepository.getList();
        request.setAttribute("lopMS", mausac);
        SizeRepository sizeRepository = new SizeRepository();
        size = sizeRepository.getList();
        request.setAttribute("lopSize", size);
        request.getRequestDispatcher("/ctsp/trang-chu-CTSP.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/ChitietSP/add")){
            this.addCTSP(request, response);
        } else if (uri.equals("/chi-tiet-sp/update")) {
            this.updateCTSP(request, response);
        }
    }

    private void updateCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer idSP = Integer.parseInt(request.getParameter("tenSanPham"));
        Integer idMS = Integer.parseInt(request.getParameter("tenMau"));
        Integer idSize = Integer.parseInt(request.getParameter("tenSize"));
        Double donGia = Double.parseDouble(request.getParameter("giaBan"));
        Integer soluong = Integer.parseInt(request.getParameter("soLuongTon"));
        String trangThai = request.getParameter("trangThai");
        Date ngayTao = null;
        for (ChiTietSanPham ctsp : chitietSP){
            if (ctsp.getId().equals(id)){
                ngayTao = ctsp.getNgayTao();
            }
        }
        Date ngaySua = new Date();
        ChiTietSanPham chitietSP = new ChiTietSanPham();
        sanPham.setId(idSP);
        chitietSP.setIdSanPham(sanPham);
        mauSac.setId(idMS);
        chitietSP.setIdMauSac(mauSac);
        size2.setId(idSize);
        chitietSP.setIdSize(size2);
        chitietSP.setGiaBan(donGia);
        chitietSP.setSoLuongTon(soluong);
        chitietSP.setTrangThai(trangThai);
        chitietSP.setNgayTao(ngayTao);
        chitietSP.setNgaySua(ngaySua);
        chitietSP.setId(id);
        chiTietSanPhamRepository.addCTSP(chitietSP);
        response.sendRedirect("/ChiTietSPServlet");
    }

    private void addCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer idSP = Integer.parseInt(request.getParameter("tenSanPham"));
        Integer idMS = Integer.parseInt(request.getParameter("tenMau"));
        Integer idSize = Integer.parseInt(request.getParameter("tenSize"));
        Double donGia = Double.parseDouble(request.getParameter("giaBan"));
        Integer soluong = Integer.parseInt(request.getParameter("soLuongTon"));
        String trangThai = request.getParameter("trangThai");
        Date ngayTao = new Date();
        Date ngaySua = new Date();
        ChiTietSanPham chitietSP = new ChiTietSanPham();
        sanPham.setId(idSP);
        chitietSP.setIdSanPham(sanPham);
        mauSac.setId(idMS);
        chitietSP.setIdMauSac(mauSac);
        size2.setId(idSize);
        chitietSP.setIdSize(size2);
        chitietSP.setGiaBan(donGia);
        chitietSP.setSoLuongTon(soluong);
        chitietSP.setTrangThai(trangThai);
        chitietSP.setNgayTao(ngayTao);
        chitietSP.setNgaySua(ngaySua);
        ChiTietSanPhamRepository.addCTSP(chitietSP);
        response.sendRedirect("/ChiTietSPServlet");
    }
}
