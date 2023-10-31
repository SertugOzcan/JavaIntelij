package com.barisd.utility;

import com.barisd.repository.entity.Musteri;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MyRepositoryFactory<T> implements ICrud<T>{
    private Session session;
    private Transaction transaction;
    private void openSession() {
        session= HibernateUtility.getSessionFactory().openSession();
        transaction=session.beginTransaction();
    }
    private void closeSession() {
        transaction.commit();
        session.close();
    }
    @Override
    public void save(T entity) {
        openSession();
        session.save(entity);
        closeSession();
    }

    @Override
    public void update(T entity) {
        openSession();
        session.update(entity);
        closeSession();
    }

    @Override
    public void delete(Long id) {
        openSession();
        //session.delete(session.get(Musteri.class,id));
        closeSession();
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(Long id) {
        return null;
    }
}
