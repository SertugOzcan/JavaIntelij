package com.example.util;

import com.example.controller.PersonController;
import com.example.entity.Person;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    private final PersonController personController;
    public Menu() {
        this.personController = new PersonController();
    }

    public void menu(){
        while(true){
            System.out.println("----DataBase İşlemleri-----");
            System.out.println("1- Data base veri ekle");

            System.out.println("2 --> Data base tum verileri goruntuleme.");
            System.out.println("3 --> Data base tum verileri silme.");
            System.out.println("4 --> Data base mail guncelleme.");
            System.out.println("5 --> Data basede id ile veri arama");
            System.out.println("6 --> Data basete id ile veri silme.");

            int secim = scanner.nextInt();
            scanner.nextLine();
            switch (secim){
                case 1:
                    System.out.println("İsim: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Soy İsim: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    Person person = new Person(firstName,lastName,email);
                    personController.register(person);
            }
        }
    }
}
