# ORM NEDİR?
## Object Relational Mapping : Nesne - ilişkisel Eşleştirme
OOP dillerle veritabanı arasındaki farklı yapıları eşleştirmekte kullanılan
bir tekniktir.
ORM ile vt'ı içindeki tablolar nesneler ile ilişkilendirilir.
Böylece vt işlemlerini nesne odaklı bir şekilde yapabiliriz.

ORM kullansak da yine Driver'a ihtiyacımız olacak.

Nesneler aracılığıyla vt'daki tablolara
* ekleme
* silme
* güncelleme
* listeleme
* tablolar arası ilişkiler
  * one-to-one
  * one-to-many
  * many-to-one
  * many-to-many
* PK, Sequence, 

PostgreSQL'de tek yapacağımız şey veritabanı açmak.

ORM araçları ile siz kolayca vt değiştirebilirsiniz. VT bağımsızlığı kazandırır.

## Avantajları
* Yazılım geliştirme sürecinizi kısaltır.
* VT sorguları ile ilgili detaylarla siz uğraşmak zorunda kalmazsınız.

## Dezavantajları
* Performansı JDBC'den bi tık yavaş.
* Öğrenme eğrisi karmaşık.
* Arka planda karmaşık bir yapısı var.

## JPA : Java Persistance API -> Jakarta Persistance API  (List)
JDO,JBAF

## ORM Araçları  (ArrayList-LinkedList)
* Hibernate ( Java için en popüler ORM aracı)
* EclipseLink
* OpenJPA


| JDBC                                        | Hibernate                                               |
|---------------------------------------------|---------------------------------------------------------|
| Low-level SQL komutlarını kullanır.         | Arka planda JDBC kullanır ve sizi o katmandan soyutlar. |
| SQL                                         | SQL + HQL + JPQL                                        |
| Nesne-Tablo ilişkiyi MANUEL olarak yapılır. | Otomatik yapılır.                          |
| Veritabanına direkt olarak bağlıdır.      | Veritabanı bağımlılığını ortadan kaldırır. |
| Cacheleme yok.                            | Cache yapısı var.                         |
| Kodlar SQL ile karmaşıklaşabilir.         | Çok daha basit sorgular yazılabilir. Veya metodlarını kullanılır.|

## ORM Aracı (Hibernate)
Sen bana bilgileri ver. (AdresBilgisi,port bilgisi,vt bilgisi,username ve password)
* Ben bağlantı kurarım.
* Bütün temel işlemlerini yapacak hazır metodlarımı kullanabilirsin.
* Bu yüzden hibernate için yapılandırma dosyaları çok önemlidir.
* list()

Hibernate 6 sürümünden öncesinde JPA (Java Persistance API) kullanır.
6 sürümü ve üzerinde Jakarta Persistance API kullanılmaktadır.

API? Application Programming Interface

## Javada direkt olarak JPA kullanılabilir mi?
Hayır, interface direkt olarak kullanamazsınız.


