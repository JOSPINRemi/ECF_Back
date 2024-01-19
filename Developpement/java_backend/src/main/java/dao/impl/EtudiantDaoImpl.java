package dao.impl;

import dao.Dao;
import entity.Etudiant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EtudiantDaoImpl implements Dao<Etudiant> {

    private final Session session;
    private Transaction transaction;

    public EtudiantDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean create(Etudiant element) {
        transaction = session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Etudiant findById(int id) {
        return session.get(Etudiant.class, id);
    }

    @Override
    public List<Etudiant> findAll() {
        Query<Etudiant> etudiantQuery = session.createQuery("from Etudiant ");
        return etudiantQuery.list();
    }

    @Override
    public boolean update(Etudiant element) {
        transaction = session.beginTransaction();
        session.merge(element);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Etudiant element) {
        transaction = session.beginTransaction();
        session.delete(element);
        transaction.commit();
        return true;
    }
}
