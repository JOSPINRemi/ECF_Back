package dao.impl;

import dao.Dao;
import entity.Classe;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClasseDaoImpl implements Dao<Classe> {
    private final Session session;
    private Transaction transaction;

    public ClasseDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean create(Classe element) {
        transaction = session.beginTransaction();
        session.save(element);
        transaction.commit();
        return true;
    }

    @Override
    public Classe findById(int id) {
        return session.get(Classe.class, id);
    }

    @Override
    public List<Classe> findAll() {
        Query<Classe> classeQuery = session.createQuery("from Classe ");
        return classeQuery.list();
    }

    @Override
    public boolean update(Classe element) {
        transaction = session.beginTransaction();
        session.merge(element);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Classe element) {
        transaction = session.beginTransaction();
        session.delete(element);
        transaction.commit();
        return true;
    }
}
