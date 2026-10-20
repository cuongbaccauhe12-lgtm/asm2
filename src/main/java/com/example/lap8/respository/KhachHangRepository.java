package com.example.lap8.repository;

import com.example.lap8.entity.KhachHang;
import com.example.lap8.util.HibernateUtil;
import lombok.var;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class KhachHangRepository {

    public List<KhachHang> getAll() {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            return s.createQuery("FROM KhachHang", KhachHang.class).list();
        }
    }

    public KhachHang getOne(UUID id) {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            return s.find(KhachHang.class, id);
        }
    }

    public void add(KhachHang kh) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            s.persist(kh);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void update(KhachHang kh) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            s.merge(kh);
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
            KhachHang kh = s.find(KhachHang.class, id);
            if (kh != null) s.remove(kh);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<KhachHang> search(String keyword) {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            String hql = "FROM KhachHang k WHERE 1=1";
            if (keyword != null && !keyword.trim().isEmpty()) {
                hql += " AND (k.ma LIKE :kw OR k.ten LIKE :kw OR k.sdt LIKE :kw OR k.ho LIKE :kw)";
            }
            Query<KhachHang> q = s.createQuery(hql, KhachHang.class);
            if (keyword != null && !keyword.trim().isEmpty()) {
                q.setParameter("kw", "%" + keyword + "%");
            }
            return q.list();
        }
    }

    public List<KhachHang> getPage(int page, int size) {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            return s.createQuery("FROM KhachHang", KhachHang.class)
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .list();
        }
    }

    public long countAll() {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            return s.createQuery("SELECT COUNT(k) FROM KhachHang k", Long.class)
                    .uniqueResult();
        }
    }

    public List<KhachHang> searchPage(String keyword, int page, int size) {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            String hql = "FROM KhachHang k WHERE 1=1";
            if (keyword != null && !keyword.trim().isEmpty()) {
                hql += " AND (k.ma LIKE :kw OR k.ten LIKE :kw OR k.sdt LIKE :kw OR k.ho LIKE :kw)";
            }
            var q = s.createQuery(hql, KhachHang.class);
            if (keyword != null && !keyword.trim().isEmpty()) {
                q.setParameter("kw", "%" + keyword + "%");
            }
            return q.setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .list();
        }
    }

    public long countSearch(String keyword) {
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT COUNT(k) FROM KhachHang k WHERE 1=1";
            if (keyword != null && !keyword.trim().isEmpty()) {
                hql += " AND (k.ma LIKE :kw OR k.ten LIKE :kw OR k.sdt LIKE :kw OR k.ho LIKE :kw)";
            }
            var q = s.createQuery(hql, Long.class);
            if (keyword != null && !keyword.trim().isEmpty()) {
                q.setParameter("kw", "%" + keyword + "%");
            }
            return q.uniqueResult();
        }
    }

    // ===== TEST CHẠY SQL =====
    public static void main(String[] args) {
        System.out.println(new KhachHangRepository().getAll());
    }
}