package com.example.lap8.util;

import com.example.lap8.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties p = new Properties();
        p.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2016Dialect");
        p.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        p.put(Environment.URL, "jdbc:sqlserver://localhost:1444;databaseName=JAV1011;encrypt=true;trustServerCertificate=true;");
        p.put(Environment.USER, "sa");
        p.put(Environment.PASS, "123456789"); // đổi mật khẩu của bạn
        p.put(Environment.SHOW_SQL, "true");

        conf.setProperties(p);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(reg);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
