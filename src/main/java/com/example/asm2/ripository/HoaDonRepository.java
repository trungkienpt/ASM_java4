package com.example.asm2.ripository;

import com.example.asm2.connert.connert;
import com.example.asm2.model.DanhMuc;
import com.example.asm2.model.HoaDon;
import com.example.asm2.model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HoaDonRepository {
    public ArrayList<HoaDon> getList(){
        Session session = connert.getFACTORY().openSession();
        //truy van
        ArrayList<HoaDon> list = (ArrayList<HoaDon>) session.createQuery( "from HoaDon where trangThai = 'Chua thanh toan' ").list();
        session.close();
        return list;

        //where trangThai = 'Chua thanh toan'
    }
    public static void addHoaDon(HoaDon hoaDon){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(hoaDon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public static HoaDon getdetail(Integer idHoaDon){
        Session session = connert.getFACTORY().openSession();
        HoaDon detail = (HoaDon) session.createQuery("from HoaDon where id = :id_1").setParameter("id_1", idHoaDon).getSingleResult();
        session.close();
        return detail;
    }
}
