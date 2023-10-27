# Hibernate ile Adım Adım Proje Oluşturma

1. Veritabanı sunucusunda bir vt oluştur. (Java12OrnekETicaret)
2. Packageları oluşturalım.
3. Resouces package içine config dosyasını at.
4. hibernate.cfg.xml'de gerekli değişiklikleri yap
5. build.gradle dosyasına dependencies ekle.
6. gerekli Entityleri ekle. (Sepet, Urun)
7. Entityler için
   1. boş constructor
   2. idsiz dolu constructor
   3. dolu constructor
   4. getter & Setter
   5. toString
8. hibernate.cfg.xml dosyasında mapping işlemini yap.
9. utility package içine HibernateUtility.java dosyasını ekle.

# Kullanma Adımları
1. Session oluştur.
   1. Session session= HibernateUtility.getSessionFactory().openSession(); 
   2. session.close();
2. Transaction oluştur ve başlat.
   1. Transaction transaction=session.beginTransaction();
   2. transaction.commit();
3. CRUD işlemlerini yap. 

# Türkçe karakter sorunu için ekle:
1. build.gradle içine: 
tasks.withType(JavaCompile).configureEach{
options.encoding='UTF-8'}

# Lombok kullanılan anotasyonlar
1. @NoArgsConstructor // boş constructor oluşturur.
2. @AllArgsConstructor // dolu constructor oluşturur.
3. @Data //Getter Setter ToString...

