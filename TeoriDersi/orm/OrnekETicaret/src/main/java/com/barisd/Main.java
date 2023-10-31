package com.barisd;

import com.barisd.enums.ECinsiyet;
import com.barisd.repository.UrunRepository;
import com.barisd.repository.entity.*;
import com.barisd.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Session session;
        Transaction transaction;

        BaseEntity baseEntity=BaseEntity.builder()
                .durum(1)
                .olusturmaTarihi(System.currentTimeMillis())
                .guncellemeTarihi(System.currentTimeMillis())
                .build();

       Urun urunBilgisayar= Urun.builder()
               .ad("Bilgisayar")
               .fiyat(BigDecimal.valueOf(25000))
               .stok(5)
               .baseEntity(baseEntity)
               .build();


       new UrunRepository().save(urunBilgisayar);



//        Urun urunUn= Urun.builder()
//                .ad("Un")
//                .fiyat(BigDecimal.valueOf(40))
//                .stok(100)
//                .baseEntity(baseEntity)
//                .build();


//
//
//        session= HibernateUtility.getSessionFactory().openSession(); //bağlantı açıldı.
//        transaction=session.beginTransaction(); // transaction başaltıldı.
//        session.save(urunSeker);
//        session.save(urunUn);
//
//        Satis satis= Satis.builder()
//                .musteriid(1L)
//                .tarih(System.currentTimeMillis())
//                .baseEntity(baseEntity)
//                .toplamTutar(BigDecimal.valueOf(500))
//                .build();
//        session.save(satis);
//
//        SatisDetay satisDetaySeker= SatisDetay.builder()
//                .urunid(1L)
//                .fiyat(BigDecimal.valueOf(20))
//                .adet(5)
//                .toplamFiyat(BigDecimal.valueOf(100))
//                .baseEntity(baseEntity)
//                .satisId(1L)
//                .build();
//
//        SatisDetay satisDetayUn= SatisDetay.builder()
//                .urunid(2L)
//                .fiyat(BigDecimal.valueOf(40))
//                .adet(10)
//                .toplamFiyat(BigDecimal.valueOf(400))
//                .baseEntity(baseEntity)
//                .satisId(1L)
//                .build();
//
//       session.save(satisDetaySeker);
//       session.save(satisDetayUn);
//
//
//
//        //session.save(m1); //kayıt işlemi yapıldı.
//
//        // kimi güncelleyeceksin?
//        // update tblmusteri set ad="Tarkan" where id=2
////        Musteri musteriAranan=session.get(Musteri.class,2L);
////        musteriAranan.setAd("Tarkan");
////        session.update(musteriAranan);
//
//        // kimi sileceksin?
////        Musteri silinecekAranan=session.get(Musteri.class,3L);
////        session.delete(silinecekAranan);
//
//        transaction.commit(); // işlemi onayladık.
//        session.close(); // bağlantıyı sonlandırdık.
    }
}
