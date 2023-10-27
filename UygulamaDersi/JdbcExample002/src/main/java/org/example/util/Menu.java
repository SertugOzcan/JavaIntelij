package org.example.util;

import org.example.controller.PersonController;
import org.example.entity.Person;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    private final PersonController personController;

    public Menu() {
        this.personController = new PersonController();
    }

    public void menu() {
        while (true) {
            System.out.println("----DataBase İşlemleri-----");
            System.out.println("1- Data base veri ekle");
            System.out.println("2 --> Data base tum verileri goruntuleme.");
            System.out.println("3 --> Data base tum verileri silme.");
            System.out.println("4 --> Data base mail guncelleme.");
            System.out.println("5 --> Data basede id ile veri arama");
            System.out.println("6 --> Data basete id ile veri silme.");
            System.out.println("0 --> Çıkış");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.println("İsim: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Soy İsim: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    Person person = new Person(firstName, lastName, email);
                    personController.register(person);
                    break;
                case 2:
                    personController.list();
                    break;
//                case 3:
//                    personController.deleteAll();
//                    break;
//                case 4:
//                    System.out.println("ID: ");
//                    int id = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.println("Yeni E-Posta: ");
//                    String newEmail = scanner.nextLine();
//                    personController.updateEmail(id, newEmail);
//                    break;
//                case 5:
//                    System.out.println("ID: ");
//                    int searchId = scanner.nextInt();
//                    scanner.nextLine();
//                    Person foundPerson = personController.getById(searchId);
//                    if (foundPerson!= null) {
//                        System.out.println(foundPerson);
//                    } else {
//                        System.out.println("Person not found.");
//                    }
//                    break;
//                case 6:
//                    System.out.println("ID: ");
//                    int deleteId = scanner.nextInt();
//                    scanner.nextLine();
//                    personController.deleteById(deleteId);
//                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor.");
                    return;
                default:
                    System.out.println("Geçersiz seçim.");
                    break;
            }
        }
    }
}
