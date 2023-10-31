package com.barisd.repository.entity;

import com.barisd.enums.ECinsiyet;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Hibernate içinde birçok configuration @ anotasyonlarla yapıldığı için bunlar neler olduğu
 * ve ne işe yaradıklarını bilmek çok önemlidir.
 * @Entity: Bu sınıfın varlık sınıfı olduğunu belirtir. ORM aracı buradan bir tablo oluşturur.
 * @Table: üzerine eklendiği sınıfın DB'deki özelliklerini düzenlemek için kullanılır.
 * Her tablo için bir isim verilmesi önerilir. Eğer name verilmezse tablo adı sınıfın adı olarak belirlenir.
 * @Id: üzerinde bulunduğu alanı tabloda PK yapar.
 * @GeneratedValue(strategy = GenerationType.IDENTITY) : sequance oluşturur. serial gibi düşünülebilir.
 * 1den başlar 1er 1er otomatik artarak devam eder.

 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="tblmusteri")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    // Long ile long arasınadki fark nedir?
    // Long: -> null
    // long: -> 0

    @Column(name = "musteriAd", //tablodaki kolonun adını düzenlemeye yarar.
            length = 30,//kolonun boyutunu belirler.
            nullable = false, //bu alanın boş geçilemeyeceğini belirtmek için. false-> boş geçilemez. true->boş geçilebilir.
            unique = false, // bu alanın benzersiz olmasını istersek true yapaibliriz.
            insertable = true, // bu alanın ekleme sorgusunda bulunmasına karar veriyoruz.
            updatable = false //bu alanın güncelleme sorgusuna eklenmesini engelledik. Artık bu alan güncellenemez.
    )
    String ad;

    String soyad;
    /**
     * Bir kullanıcının birden çok telefon numarasını tutmak için list türünü kullanabiliriz.
     * Ancak List gibi Collection türlerini @Entity ile işaretlenmiş sınıfta tutmak istersek hata alırız.
     * Bu türün mutlaka @ElementCollection ile işaretlenmesi gereklidir.
     * Bu anotasyon ile işaretlenen alan için ayrı bir tablo oluşturulur.
     */
    @ElementCollection
    List<String> telefon;



    /**
    Zaman tanımlamaları için @Temporal kullanılır.
     Temporal(TemporalType.DATE) -> sadece tarih bilgisini tutar.
     Temporal(TemporalType.TIME) -> sadece zaman bilgisini tutar.
     Temporal(TemporalType.TIMESTAMP) -> hem tarih hem zaman bilgisini tutmak için
     */
    @Temporal(TemporalType.DATE)
    Date dogumTarihi;
    @Temporal(TemporalType.DATE)
    Date isGirisTarihi;
    @Temporal(TemporalType.TIMESTAMP)
    Date kayitTarihi;

    /**
     * Vtde kolon olarak tutulmasını istemediğimiz alanları @Transient ile işaretleriz.
     */
    @Transient
    String adsoyad;
    /**
     * Enum bilgiler 2 alandan oluşur.
     * Enum değeri inttir. görünen değeri Stringtir.
     * Hangi değerin vt'ye kaydedileceği burada belirlenebilir.(@Enumerated(EnumType.ORDINAL), @Enumerated(EnumType.STRING))
     */
    @Enumerated(EnumType.ORDINAL)
    ECinsiyet cinsiyet;

    @Embedded
    BaseEntity baseEntity;

    @Embedded
    Iletisim iletisim;

}
