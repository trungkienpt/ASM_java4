package com.example.asm2.ripository;

import com.example.asm2.connert.connert;
import com.example.asm2.model.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class KhachHangRepository {
    public ArrayList<KhachHang> getList() {
        Session session = connert.getFACTORY().openSession();
        ArrayList<KhachHang> list = (ArrayList<KhachHang>) session.createQuery("from KhachHang  order by ngayTao desc ").list();
        session.close();
        return list;
    }
    public void add (KhachHang khachHang) {
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(khachHang);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public KhachHang detail (int id) {
        Session session = connert.getFACTORY().openSession();
        KhachHang khachHang = (KhachHang) session.createQuery("from KhachHang where  id = :id_khach_hang").setParameter("id_khach_hang", id).getSingleResult();
        session.close();
        return khachHang;
    }

    public void delete (KhachHang khachHang) {
        Session session = connert.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(khachHang);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
