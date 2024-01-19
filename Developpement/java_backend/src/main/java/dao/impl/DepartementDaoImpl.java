package dao.impl;

import dao.Dao;
import entity.Departement;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DepartementDaoImpl implements Dao<Departement> {
    private final Session session;
    private Transaction transaction;

    public DepartementDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean create(Departement element) {
        transaction = session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Departement findById(int id) {
        return session.get(Departement.class, id);
    }

    @Override
    public List<Departement> findAll() {
        Query<Departement> departementQuery = session.createQuery("from Departement ");
        return departementQuery.list();
    }

    @Override
    public boolean update(Departement element) {
        transaction = session.beginTransaction();
        session.merge(element);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Departement element) {
        transaction = session.beginTransaction();
        session.delete(element);
        transaction.commit();
        return true;
    }
}
