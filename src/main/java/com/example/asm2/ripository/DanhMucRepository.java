package com.example.asm2.ripository;

import com.example.asm2.connert.connert;
import com.example.asm2.model.DanhMuc;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucRepository {
    public ArrayList<DanhMuc> getList(){
        Session session = connert.getFACTORY().openSession();
        //truy van
        ArrayList<DanhMuc> list = (ArrayList<DanhMuc>) session.createQuery( "from DanhMuc").list();
        session.close();
        return list;
    }

    public static void addDanhmuc(DanhMuc danhMuc){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(danhMuc);
            session.save(danhMuc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public static DanhMuc getdetail(Integer id){
        Session session = connert.getFACTORY().openSession();
        DanhMuc detailDM = (DanhMuc) session.createQuery("from DanhMuc where id = :id_danh_muc").setParameter("id_danh_muc", id).getSingleResult();
        session.close();
        return detailDM;
    }
    public static void deleteDanhmuc(DanhMuc danhMuc){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(danhMuc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
