package com.barisd;

import com.barisd.entity.Urun;
import com.barisd.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session= HibernateUtility.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        session.save(new Urun("Un",50));

        transaction.commit();
        session.close();
    }
}