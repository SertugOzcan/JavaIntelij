package org.barisd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MusteriEkleme {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ad,soyad,telefon,cinsiyet;
        Long dtarih;
        System.out.println("**************************************");
        System.out.println("*************MÜŞTERİ EKLEME***********");
        System.out.println("**************************************");

        System.out.println();
        System.out.print("Müşteri adı:");
        ad=sc.nextLine();
        System.out.print("Müşteri soyad:");
        soyad=sc.nextLine();
        System.out.print("Müşteri telefon:");
        telefon=sc.nextLine();
        System.out.print("Müşteri cinsiyet:");
        cinsiyet=sc.nextLine();
        System.out.print("Müşteri dtarihi:");
        dtarih=sc.nextLong(); sc.nextLine();

        save(ad,soyad,telefon,cinsiyet,dtarih);
    }

    public static void save(String ad,String soyad,String telefon,String cinsiyet,Long dtarih) {
        String connectionString = "jdbc:postgresql://localhost:5432/Java12SatisVT?user=postgres&password=1234";
        String QUERY_MUSTERI_INSERT = "INSERT INTO tblmusteri(ad,soyad,telefon,cinsiyet,dtarih) VALUES (?,?,?,?,?)";
        try (
                Connection connection = DriverManager.getConnection(connectionString);
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_MUSTERI_INSERT);
        ) {
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, telefon);
            preparedStatement.setString(4, cinsiyet);
            preparedStatement.setLong(5, dtarih);
            //Sorgu çalıştırma:
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();
            if (etkilenenSatirSayisi > 0) System.out.println("Ekleme başarıyla gerçekleştirildi...");
            else System.out.println("Eklemede hata meydana geldi.");
        } catch (SQLException e) {
            System.out.println("save metodunda hata"+e);
        }
    }
}