package com.example.lap8.repository;

import com.example.lap8.entity.NhanVien;
import com.example.lap8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class NhanVienRepository {

    public List<NhanVien> getAll() {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            // Join fetch để lấy luôn ChucVu, CuaHang
            return s.createQuery(
                    "SELECT n FROM NhanVien n LEFT JOIN FETCH n.chucVu LEFT JOIN FETCH n.cuaHang",
                    NhanVien.class
            ).list();
        }
    }

    public NhanVien getOne(UUID id) {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            return s.createQuery(
                    "SELECT n FROM NhanVien n LEFT JOIN FETCH n.chucVu LEFT JOIN FETCH n.cuaHang WHERE n.id = :id",
                    NhanVien.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    public NhanVien login(String ma, String matKhau) {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            return s.createQuery(
                    "SELECT n FROM NhanVien n LEFT JOIN FETCH n.chucVu LEFT JOIN FETCH n.cuaHang " +
                            "WHERE n.ma = :ma AND n.matKhau = :mk",
                    NhanVien.class)
                    .setParameter("ma", ma)
                    .setParameter("mk", matKhau)
                    .uniqueResult();
        }
    }

    public void add(NhanVien nv) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            s.persist(nv);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void update(NhanVien nv) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            s.merge(nv);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(UUID id) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            NhanVien nv = s.find(NhanVien.class, id);
            if (nv != null) s.remove(nv);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<NhanVien> search(String keyword) {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT n FROM NhanVien n LEFT JOIN FETCH n.chucVu LEFT JOIN FETCH n.cuaHang WHERE 1=1";
            if (keyword != null && !keyword.trim().isEmpty()) {
                hql += " AND (n.ma LIKE :kw OR n.ten LIKE :kw OR n.sdt LIKE :kw OR n.ho LIKE :kw)";
            }
            Query<NhanVien> q = s.createQuery(hql, NhanVien.class);
            if (keyword != null && !keyword.trim().isEmpty()) {
                q.setParameter("kw", "%" + keyword + "%");
            }
            return q.list();
        }
    }

    public List<NhanVien> getPage(int page, int size) {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            return s.createQuery(
                    "SELECT n FROM NhanVien n LEFT JOIN FETCH n.chucVu LEFT JOIN FETCH n.cuaHang",
                    NhanVien.class)
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .list();
        }
    }

    public long countAll() {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            return s.createQuery("SELECT COUNT(n) FROM NhanVien n", Long.class)
                    .uniqueResult();
        }
    }

    // ===== TEST =====
    public static void main(String[] args) {
        System.out.println(new NhanVienRepository().getAll());
    }
}