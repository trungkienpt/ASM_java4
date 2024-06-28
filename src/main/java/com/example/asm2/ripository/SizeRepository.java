package com.example.asm2.ripository;

import com.example.asm2.connert.connert;
import com.example.asm2.model.Size;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SizeRepository {
    public ArrayList<Size> getList(){
        Session session = connert.getFACTORY().openSession();
        ArrayList<Size> listSize = (ArrayList<Size>) session.createQuery("from Size ").list();
        session.close();
        return listSize;
    }
    public static void addSize(Size s) {
        Session session = connert.getFACTORY().openSession();;
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(s);
            session.save(s);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public static Size getdetail(Integer idSize){
        Session session = connert.getFACTORY().openSession();
        Size detailS = (Size) session.createQuery("from Size where id = :id_s").setParameter("id_s", idSize).getSingleResult();
        session.close();
        return detailS;
    }
    public static void deleteSize(Size s) {
        Session session = connert.getFACTORY().openSession();;
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(s);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
