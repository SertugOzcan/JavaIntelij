package com.barisd.utility;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class JPAUtility {
    private static EntityManagerFactory ENTITYMANAGER_FACTORY;
    static{
        try {
            ENTITYMANAGER_FACTORY = new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            System.out.println("Hibernate SessionFactory'de hata! "+e.getMessage());
        }
    }
    public static EntityManagerFactory getSessionFactory(){
        return ENTITYMANAGER_FACTORY;
    }

}
