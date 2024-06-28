package com.example.asm2.servlet;

import com.example.asm2.model.ChiTietSanPham;
import com.example.asm2.model.HoaDon;
import com.example.asm2.model.HoaDonChiTiet;
import com.example.asm2.model.KhachHang;
import com.example.asm2.ripository.ChiTietSanPhamRepository;
import com.example.asm2.ripository.HoaDonChiTietRepository;
import com.example.asm2.ripository.HoaDonRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "BanHangServlet", value = {"/BanHangServlet", "/hoa-don/them", "/hoa-don/detail", "/hoa-don-CT/them"})
public class BanHangServlet extends HttpServlet {
    ArrayList<HoaDon> listHD;
    ArrayList<HoaDonChiTiet> listHDCT;
    ArrayList<ChiTietSanPham> listCTSP;

    HoaDonRepository hoaDonRepository = new HoaDonRepository();
    HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();
    ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    Integer idHoaDon ;
    Double tongTien ;
    HoaDon hoaDon;

    public BanHangServlet() {
         listHD = new ArrayList<>();
         listHDCT = new ArrayList<>();
         listCTSP = new ArrayList<>();
         hoaDon = new HoaDon();
        idHoaDon = 1;
        tongTien = (double) 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/BanHangServlet")){
            this.hienthiBH(request, response);
        } else if (uri.equals("/hoa-don/detail")) {
            this.detailHD(request, response);
        } else if (uri.equals("/hoa-don-CT/them")) {
            this.chonmuaCTSP(request, response);
        }
    }

    private void chonmuaCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer idCTSP = Integer.parseInt(request.getParameter("id"));
//        Integer idHD = Integer.parseInt(request.getParameter("idHD"));
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.getdetail(idCTSP);
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(idHoaDon);
        hoaDonChiTiet.setIdHoaDon(hoaDon);
        hoaDonChiTiet.setIdCTSP(chiTietSanPham);
        hoaDonChiTiet.setGiaBan(chiTietSanPham.getGiaBan());
        hoaDonChiTiet.setSoLuongMua(1);
        hoaDonChiTiet.setNgaySua(new Date());
        hoaDonChiTiet.setNgayTao(new Date());
        hoaDonChiTiet.setTongTien(chiTietSanPham.getGiaBan());
        hoaDonChiTietRepository.addHDCT(hoaDonChiTiet);
        response.sendRedirect("/BanHangServlet");
    }


    private void detailHD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        idHoaDon = id;
        hoaDon = hoaDonRepository.getdetail(id);
        listHDCT = hoaDonChiTietRepository.getList(id);
        tongTien = (double) 0;
        for (HoaDonChiTiet hoaDonChiTiet : listHDCT){
            tongTien += hoaDonChiTiet.getTongTien();
        }
        response.sendRedirect("/BanHangServlet");
    }

    private void hienthiBH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCTSP = chiTietSanPhamRepository.getList();
        listHDCT = hoaDonChiTietRepository.getList(idHoaDon);
        listHD = hoaDonRepository.getList();
        request.setAttribute("tongtien", tongTien);
        request.setAttribute("listCTSP", listCTSP);
        request.setAttribute("listHDCT", listHDCT);
        request.setAttribute("listHD", listHD);
        request.setAttribute("hoaDon", hoaDon);
        request.getRequestDispatcher("/ban-hang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/hoa-don/them")){
            this.addHD(request, response);
        }
    }

    private void addHD(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Double tt = Double.parseDouble(request.getParameter("tongTien"));
        if (tt == 0){
            HoaDon hd = new HoaDon();
            KhachHang kh = new KhachHang();
            kh.setId(1);
            hd.setIdKhachHang(kh);
            hd.setNgayTao(new Date());
            hd.setNgaySua(new Date());
            hd.setTrangThai("Chua thanh toan");
            hoaDonRepository.addHoaDon(hd);
            response.sendRedirect("/BanHangServlet");
        }else {
            Integer id = Integer.parseInt(request.getParameter("idHoaDon"));
            HoaDon hoaDon2 = hoaDonRepository.getdetail(id);
            hoaDon2.setNgaySua(new Date());
            hoaDon2.setTrangThai("Da thanh toan");
            tongTien = (double) 0;
            hoaDonRepository.addHoaDon(hoaDon2);
            response.sendRedirect("/BanHangServlet");
        }
    }
}
