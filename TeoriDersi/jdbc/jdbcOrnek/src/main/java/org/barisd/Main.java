package org.barisd;

/*
 VERİTABANI DRIVER:
 Bir programlama dili ile Veritabanı arasında iletişim kurmak için kullanılan bileşendir.
 Yapılabilecekler:
    VT Sunucusuna bağlanacağız
    Vt ile iletişim kurabilirsiniz.
    Sorgular gönderme
    Sonuçları alma bu tür temel işlemleri yapmakta yardımcı olur.
Driverleri vt üreticisi üretir.

PostgreSQL JDBC DRIVER
MSSQL JDBC DRIVER
Oracle JDBC DRIVER

-- Dependencies: Dışarıdan projeye dahil etmek ettiğimiz kütüphanelere olan Bağımlılıktır.
-- ANT-MAVEN-GRADLE
 */


import java.sql.*;
// JDBC kullanımında ilk yapılacak işlem 2 sistem arasında iletişimi sağlayacak DRIVER'i devreye almaktır.
//Java 1.6dan önce kullanılması gereken yapı:
// Driver.class.forName("org.postgresql.Driver");

// Driverla sunucuya bağlanabilmek için gerekli parametreler:
// 1. Veritabanı server'ının ip adresi
// 2. port numarası
// 3. İşlem yapılacak db adı

// 4. Yetkilendirme için username
// 5. Yetkilendirme için password

//   jdbc:postgresql://host:port/database
//  host: Veritabanını tutan yapı. Eğer uzak sunucudaysa ip adresi girilir.
//  localdeyse localhost veya 127.0.0.1 de yazılabilir.
public class Main {
    public static void main(String[] args) {
        //adresEklePrepared(80, "İstanbul", "Bakırköy", "Yeşilköy", "Çınar sk. No:3");
        //adresSil(5);
        //adresGuncelle(6,"Muğla","Fethiye");

        adresIleGoreListele("ank");
    }

    public static void adresEkle(int musteriid, String il, String ilce, String mahalle, String adres) throws Exception {

        // DriverManager aracılığı ile bir  Connection nesnesi oluşturulur.
        // Connection referansı oluşturabilmek için url,username ve password bilgilerini getConnection metoduna verdik.
        String connectionAdres = "jdbc:postgresql://localhost:5432/Java12SatisVT";
        String username = "postgres";
        String password = "1234";
        Connection connection = DriverManager.getConnection(connectionAdres, username, password);

        String adresEkleSql = "INSERT INTO public.tbladres(" +
                "musteriid, il, ilce, mahalle, adres)" +
                "VALUES (" + musteriid + ",'" + il + "','" + ilce + "','" + mahalle + "','" + adres + "')";
        // Bu yazdığımız sql Driver tarafından anlaşılamaz.
        // Driver'ın anlayabileceği yapıya getirmek için prepareStatement metodu kullanılır.
        PreparedStatement preparedStatement = connection.prepareStatement(adresEkleSql);

        preparedStatement.executeUpdate();
        connection.close();
    }

    public static void adresEklePrepared(int musteriid, String il, String ilce, String mahalle, String adres) {
        //bağlantı ile ilgili kodlar:
        String connectionAdres = "jdbc:postgresql://localhost:5432/Java12SatisVT";
        String username = "postgres";
        String password = "1234";
        //Sorgumuz:
        String adresEkleSql = "INSERT INTO tbladres(musteriid, il, ilce, mahalle, adres) VALUES (?,?,?,?,?)";
        //try-with-resources
        try (
                Connection connection = DriverManager.getConnection(connectionAdres, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(adresEkleSql);
        ) {
            preparedStatement.setInt(1, musteriid);
            preparedStatement.setString(2, il);
            preparedStatement.setString(3, ilce);
            preparedStatement.setString(4, mahalle);
            preparedStatement.setString(5, adres);
            //Sorgu çalıştırma:
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();
            if (etkilenenSatirSayisi > 0) System.out.println("Ekleme başarıyla gerçekleştirildi...");
            else System.out.println("Eklemede hata meydana geldi.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void adresSil(int id){
        //bağlantı ile ilgili kodlar:
        String connectionAdres = "jdbc:postgresql://localhost:5432/Java12SatisVT";
        String username = "postgres";
        String password = "1234";
        //Sorgumuz:
        String adresSilSql = "DELETE FROM tbladres WHERE id=?";
        try (
                Connection connection = DriverManager.getConnection(connectionAdres, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(adresSilSql);
        ) {
            preparedStatement.setInt(1,id);
            //Sorgu çalıştırma:
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();
            if (etkilenenSatirSayisi > 0) System.out.println("Silme başarıyla gerçekleştirildi...");
            else System.out.println("Silmede hata meydana geldi.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void adresGuncelle(int id, String il, String ilce){
        //bağlantı ile ilgili kodlar:
        String connectionAdres = "jdbc:postgresql://localhost:5432/Java12SatisVT";
        String username = "postgres";
        String password = "1234";
        //Sorgumuz:
        String adresGuncelleSql = "UPDATE tbladres SET il=?, ilce=? WHERE id=?";
        try (
                Connection connection = DriverManager.getConnection(connectionAdres, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(adresGuncelleSql);
        ) {
            preparedStatement.setString(1,il);
            preparedStatement.setString(2,ilce);
            preparedStatement.setInt(3,id);
            //Sorgu çalıştırma:
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();
            if (etkilenenSatirSayisi > 0) System.out.println("Güncelleme başarıyla gerçekleştirildi...");
            else System.out.println("Güncellemede hata meydana geldi.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void adresIleGoreListele(String ilargs){
        //bağlantı ile ilgili kodlar:
        String connectionString = "jdbc:postgresql://localhost:5432/Java12SatisVT?user=postgres&password=1234";

        //Sorgumuz:
        String adresListeleSql = "SELECT * FROM tbladres WHERE il ILIKE ? ORDER BY musteriid";
        try (
                Connection connection = DriverManager.getConnection(connectionString);
                PreparedStatement preparedStatement = connection.prepareStatement(adresListeleSql);
        ) {
            preparedStatement.setString(1,"%"+ilargs+"%");

            //Sorgu çalıştırma:
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int musteriid= resultSet.getInt("musteriid");
                String il=resultSet.getString("il");
                String ilce=resultSet.getString("ilce");
                System.out.println("Müşteri id: "+musteriid+ " il: "+il+" ilce: "+ilce);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
                        executeQuery()                       executeUpdate()                    execute()
 Geriye Dönen Tip       ResultSet(Tablo)                     Int(Etkilenen Satır Sayısı)
 Nerede kullanılır?     SELECT Sorguları                     INSERT,DELETE,UPDATE sorguları     Tüm sorgularda.

 execute()
 Eğer SQL INSERT UPDATE DELETE geçiyorsa geriye int döner.
 Eğer SQL SELECT geçiyorsa geriye resultSet döner.
 Eğer SQL ALTER,CREATE,DROP geriye true,false döner.

 */