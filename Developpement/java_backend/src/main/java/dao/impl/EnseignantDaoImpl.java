package dao.impl;

import dao.Dao;
import entity.Enseignant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EnseignantDaoImpl implements Dao<Enseignant> {

    private final Session session;
    private Transaction transaction;

    public EnseignantDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean create(Enseignant element) {
        transaction = session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Enseignant findById(int id) {
        return session.get(Enseignant.class, id);
    }

    @Override
    public List<Enseignant> findAll() {
        Query<Enseignant> enseignantQuery = session.createQuery("from Enseignant ");
        return enseignantQuery.list();
    }

    @Override
    public boolean update(Enseignant element) {
        transaction = session.beginTransaction();
        session.merge(element);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Enseignant element) {
        transaction = session.beginTransaction();
        session.delete(element);
        transaction.commit();
        return true;
    }
}
