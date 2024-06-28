package com.example.asm2.ripository;

import com.example.asm2.connert.connert;
import com.example.asm2.model.DanhMuc;
import com.example.asm2.model.HoaDon;
import com.example.asm2.model.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HoaDonChiTietRepository {
    public ArrayList<HoaDonChiTiet> getList(Integer idHoaDon){
        Session session = connert.getFACTORY().openSession();
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(idHoaDon);
        //truy van
        ArrayList<HoaDonChiTiet> list = (ArrayList<HoaDonChiTiet>) session.createQuery( "from HoaDonChiTiet where idHoaDon = :hoadon_1").setParameter("hoadon_1", hoaDon).list();
        session.close();
        return list;
    }

    public static void addHDCT(HoaDonChiTiet hoaDonChiTiet){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(hoaDonChiTiet);
            session.save(hoaDonChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
