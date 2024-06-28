package com.example.asm2.servlet;

import com.example.asm2.model.MauSac;
import com.example.asm2.ripository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "MauSacServlet", value = {"/MauSacServlet", "/Mau-sac/add", "/mau-sac/detail", "/mau-sac/delete", "/mau-sac/update"})
public class MauSacServlet extends HttpServlet {
    ArrayList<MauSac> mausac = new ArrayList<>();
    MauSacRepository mauSacRepository = new MauSacRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/MauSacServlet")){
            this.hienthi(request, response);
        } else if (uri.equals("/mau-sac/delete")) {
            this.deleteMS(request, response);
        } else if (uri.equals("/mau-sac/detail")) {
            this.detailMS(request, response);
        }
    }

    private void detailMS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        MauSac mauSac = mauSacRepository.getdetail(id);
        request.setAttribute("MS", mauSac);
        request.getRequestDispatcher("/mau-sac/mau-sac-detail.jsp").forward(request, response);
    }

    private void deleteMS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        MauSac mauSac = mauSacRepository.getdetail(id);
        mauSacRepository.deleteMauSac(mauSac);
        response.sendRedirect("/MauSacServlet");
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSacRepository mauSacRepository = new MauSacRepository();
        mausac = mauSacRepository.getList();
        request.setAttribute("listMS", mausac);
        request.getRequestDispatcher("/mau-sac/trang-chu-MS.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/Mau-sac/add")){
            this.addMauSac(request, response);
        } else if (uri.equals("/mau-sac/update")) {
            this.updateMS(request, response);
        }
    }

    private void updateMS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("maMau");
        String ten = request.getParameter("tenMau");
        String tt = request.getParameter("trangThai");
        Date ngayTao = null;
        for (MauSac ms : mausac){
            if (ms.getId() == id){
                ngayTao = ms.getNgayTao();
            }
        }
        Date ngaySua = new Date();
        MauSac mauSac = new MauSac();
        mauSac.setId(id);
        mauSac.setMaMau(ma);
        mauSac.setTenMau(ten);
        mauSac.setTrangThai(tt);
        mauSac.setNgayTao(ngayTao);
        mauSac.setNgaySua(ngaySua);
        MauSacRepository.addMauSac(mauSac);
        response.sendRedirect("/MauSacServlet");
    }

    private void addMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maMau");
        String ten = request.getParameter("tenMau");
        String tt = request.getParameter("trangThai");
        Date ngayTao = new Date();
        Date ngaySua = new Date();
        MauSac mauSac = new MauSac();
        mauSac.setMaMau(ma);
        mauSac.setTenMau(ten);
        mauSac.setTrangThai(tt);
        mauSac.setNgayTao(ngayTao);
        mauSac.setNgaySua(ngaySua);
        MauSacRepository.addMauSac(mauSac);
        response.sendRedirect("/MauSacServlet");
    }
}
