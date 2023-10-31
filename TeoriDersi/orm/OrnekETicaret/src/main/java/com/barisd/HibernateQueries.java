package com.barisd;

import com.barisd.repository.entity.Urun;
import com.barisd.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateQueries {
    Session session;
    Transaction transaction;

CriteriaBuilder criteriaBuilder;
    public HibernateQueries() {
        this.session =  HibernateUtility.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        this.criteriaBuilder=session.getCriteriaBuilder();

    }

    public void saveUrunHibernate(Urun urun){
        session.save(urun);
    }

    public List<Urun> listUrunHibernate(){
        CriteriaQuery urunCriteriaQuery=criteriaBuilder.createQuery(Urun.class);
        urunCriteriaQuery.from(Urun.class);
        List<Urun> resultList = session.createQuery(urunCriteriaQuery).getResultList();
        return resultList;
    }
    public List<String> listUrunAdHibernate(){
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);

        criteriaQuery.select(root.get("ad"));

        List<String> resultList = session.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

}
