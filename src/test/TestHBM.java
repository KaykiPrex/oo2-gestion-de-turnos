package test;

import dao.HibernateUtil;
import org.hibernate.Session;

public class TestHBM {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();
        System.out.println("OK");
    }
}

