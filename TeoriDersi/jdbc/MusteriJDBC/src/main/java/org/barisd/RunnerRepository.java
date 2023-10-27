package org.barisd;

import org.barisd.repository.MusteriRepository;

public class RunnerRepository {
    public static void main(String[] args) {
        MusteriRepository repository=new MusteriRepository();
       // repository.save(new Musteri("Arda","Güler","6875412","Erkek",121212154));

       // repository.delete(1003);
      //  repository.findAll().forEach(System.out::println);
//        System.out.println("Update yapılmadan önce:");
//        System.out.println(repository.findById(1005));
//
//        Musteri m1=repository.findById(1005);
//        m1.setAd("Arda Jr.");
//        m1.setSoyad("Güler Jr.");
//        m1.setTelefon("11111");
//        repository.update(m1);
//        System.out.println("Update işleminden sonra:");
        System.out.println(repository.findById(1));

    }
}
