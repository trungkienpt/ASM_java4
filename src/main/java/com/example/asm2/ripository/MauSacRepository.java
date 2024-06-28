package com.example.asm2.ripository;

import com.example.asm2.connert.connert;
import com.example.asm2.model.DanhMuc;
import com.example.asm2.model.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class MauSacRepository {
    public ArrayList<MauSac> getList(){
        Session session = connert.getFACTORY().openSession();
        ArrayList<MauSac> listMS = (ArrayList<MauSac>) session.createQuery("from MauSac ").list();
        session.close();
        return listMS;
    }
    public static void addMauSac(MauSac mauSac){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(mauSac);
            session.save(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public static MauSac getdetail(Integer id){
        Session session = connert.getFACTORY().openSession();
        MauSac detailMS = (MauSac) session.createQuery("from MauSac where id = :id_mau").setParameter("id_mau", id).getSingleResult();
        session.close();
        return detailMS;
    }
    public static void deleteMauSac(MauSac mauSac){
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
