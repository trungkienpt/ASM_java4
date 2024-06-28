package com.example.asm2.servlet;

import com.example.asm2.model.Size;
import com.example.asm2.ripository.SizeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "SizeServlet", value = {"/trang-chu/Size", "/Size/add", "/size/detail", "/size/delete", "/size/update"})
public class SizeServlet extends HttpServlet {
    ArrayList<Size> size = new ArrayList<>();
    SizeRepository sizeRepository = new SizeRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/trang-chu/Size")){
            this.hienthi(request, response);
        } else if (uri.equals("/size/detail")) {
            this.chitietS(request, response);
        } else if (uri.equals("/size/delete")) {
            this.deleteS(request, response);
        }
    }

    private void deleteS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Size size1 = sizeRepository.getdetail(id);
        sizeRepository.deleteSize(size1);
        response.sendRedirect("/trang-chu/Size");
    }

    private void chitietS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Size size1 = sizeRepository.getdetail(id);
        request.setAttribute("s", size1);
        request.getRequestDispatcher("/size/size-detail.jsp").forward(request, response);
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SizeRepository sizeRepository = new SizeRepository();
        size = sizeRepository.getList();
        request.setAttribute("listSize", size);
        request.getRequestDispatcher("/size/trang-chu-Size.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/Size/add")){
            this.addSize(request, response);
        } else if (uri.equals("/size/update")) {
            this.updateS(request, response);
        }
    }

    private void updateS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("maSize");
        String ten = request.getParameter("tenSize");
        String tt= request.getParameter("trangThai");
        Date ngayTao = null;
        for (Size ss : size){
            if (ss.getId() == id){
                ngayTao = ss.getNgayTao();
            }
        }
        Date ngaySua = new Date();
        Size s = new Size();
        s.setId(id);
        s.setMaSize(ma);
        s.setTenSize(ten);
        s.setTrangThai(tt);
        s.setNgayTao(ngayTao);
        s.setNgaySua(ngaySua);
        SizeRepository.addSize(s);
        response.sendRedirect("/trang-chu/Size");
    }

    private void addSize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maSize");
        String ten = request.getParameter("tenSize");
        String tt= request.getParameter("trangThai");
        Date ngayTao = new Date();
        Date ngaySua = new Date();
        Size s = new Size();
        s.setMaSize(ma);
        s.setTenSize(ten);
        s.setTrangThai(tt);
        s.setNgayTao(ngayTao);
        s.setNgaySua(ngaySua);
        SizeRepository.addSize(s);
        response.sendRedirect("/trang-chu/Size");
    }
}
