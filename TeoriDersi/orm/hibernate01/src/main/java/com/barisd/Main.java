package com.barisd;
//Java12HibernateDB

import com.barisd.entity.Musteri;
import com.barisd.utility.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session= HibernateUtility.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

//       Musteri m1=new Musteri("Berre","Gül","Dublin");
//       session.save(m1);
//       m1.setAd("Deneme10");

//        Musteri arananMusteri=session.get(Musteri.class,12);
//        arananMusteri.setAdres("Yozgat");
//        arananMusteri.setSoyad("Yoz");
//
//        session.update(arananMusteri);
//        Musteri silinecekMusteri=session.get(Musteri.class,12);
//        session.delete(silinecekMusteri);

        Criteria criteria=session.createCriteria(Musteri.class); // geri dönecek tipi yazıyoruz.
        List<Musteri> musteriList= criteria.list();

//        transaction.commit();
        session.close();

        musteriList.forEach(System.out::println);
    }
}