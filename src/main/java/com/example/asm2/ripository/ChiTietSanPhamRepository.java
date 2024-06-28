package com.example.asm2.ripository;

import com.example.asm2.connert.connert;
import com.example.asm2.model.ChiTietSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class ChiTietSanPhamRepository {
    public ArrayList<ChiTietSanPham> getList(){
        Session session = connert.getFACTORY().openSession();
        //truy van
        ArrayList<ChiTietSanPham> listCT = (ArrayList<ChiTietSanPham>) session.createQuery( "from ChiTietSanPham ").list();
        session.close();
        return listCT;
    }
    public static void addCTSP(ChiTietSanPham chiTietSanPham){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public static ChiTietSanPham getdetail(Integer idSPCT){
        Session session = connert.getFACTORY().openSession();
        ChiTietSanPham detail = (ChiTietSanPham) session.createQuery("from ChiTietSanPham where id = :id_1").setParameter("id_1", idSPCT).getSingleResult();
        session.close();
        return detail;
    }

    public static void deleteCTSP(ChiTietSanPham chiTietSanPham){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
