package dao.impl;

import dao.Dao;
import entity.Matiere;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MatiereDaoImpl implements Dao<Matiere> {
    private final Session session;
    private Transaction transaction;

    public MatiereDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean create(Matiere element) {
        transaction = session.beginTransaction();
        session.save(element);
        transaction.commit();
        return true;
    }

    @Override
    public Matiere findById(int id) {
        return session.get(Matiere.class, id);
    }

    @Override
    public List<Matiere> findAll() {
        Query<Matiere> matiereQuery = session.createQuery("from Matiere ");
        return matiereQuery.list();
    }

    @Override
    public boolean update(Matiere element) {
        transaction = session.beginTransaction();
        session.merge(element);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Matiere element) {
        transaction = session.beginTransaction();
        session.delete(element);
        transaction.commit();
        return true;
    }
}
