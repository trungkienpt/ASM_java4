package com.example.asm2.ripository;

import com.example.asm2.connert.connert;
import com.example.asm2.model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SanPhamRepository {
    public ArrayList<SanPham> getList(){
        Session session = connert.getFACTORY().openSession();
        ArrayList<SanPham> listSP = (ArrayList<SanPham>) session.createQuery("from SanPham ORDER BY ngayTao DESC " ).list();
        session.close();
        return listSP;
    }
    public static void addSanPham(SanPham sanPham){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public static SanPham getdetail(Integer idSanPham){
        Session session = connert.getFACTORY().openSession();
        SanPham detail = (SanPham) session.createQuery("from SanPham where id = :id_1").setParameter("id_1", idSanPham).getSingleResult();
        session.close();
        return detail;
    }

    public static void deleteSanPham(SanPham sanPham){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
