package dao.impl;

import dao.Dao;
import entity.EmploiDuTemps;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmploiDuTempsDaoImpl implements Dao<EmploiDuTemps> {
    private final Session session;
    private Transaction transaction;

    public EmploiDuTempsDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean create(EmploiDuTemps element) {
        transaction = session.beginTransaction();
        session.save(element);
        transaction.commit();
        return true;
    }

    @Override
    public EmploiDuTemps findById(int id) {
        return session.get(EmploiDuTemps.class, id);
    }

    @Override
    public List<EmploiDuTemps> findAll() {
        Query<EmploiDuTemps> emploiDuTempsQuery = session.createQuery("from EmploiDuTemps ");
        return emploiDuTempsQuery.list();
    }

    @Override
    public boolean update(EmploiDuTemps element) {
        transaction = session.beginTransaction();
        session.merge(element);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(EmploiDuTemps element) {
        transaction = session.beginTransaction();
        session.delete(element);
        transaction.commit();
        return true;
    }
}
