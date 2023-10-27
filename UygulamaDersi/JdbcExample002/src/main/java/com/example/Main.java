package com.example;

import com.example.util.Menu;


/*
        1- personDb oluşturalım --> id, firtsName, lastName, joinedDate

        2- Util paketinde JDBCHelper diye bir class oluşturalım
            getConnection() bu metotta bize connection nesnesi döenecek

        3- Burdaki databasebilgileri bunlarıda farklı bir sınıftan çekeleim
            yine util paketi içinde JDBCConstant sınıfından çekelim

        4-  register işlemi
            kullanıcıdan isim soy isim email alcaz ve database kaydedicez
            ilk repository katmanını yazıyoruz


 */
public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.menu();

    }
}