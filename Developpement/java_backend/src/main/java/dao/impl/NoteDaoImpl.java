package dao.impl;

import dao.Dao;
import entity.Note;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class NoteDaoImpl implements Dao<Note> {
    private final Session session;
    private Transaction transaction;

    public NoteDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean create(Note element) {
        transaction = session.beginTransaction();
        session.save(element);
        transaction.commit();
        return true;
    }

    @Override
    public Note findById(int id) {
        return session.get(Note.class, id);
    }

    @Override
    public List<Note> findAll() {
        Query<Note> noteQuery = session.createQuery("from Note ");
        return noteQuery.list();
    }

    @Override
    public boolean update(Note element) {
        transaction = session.beginTransaction();
        session.merge(element);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Note element) {
        transaction = session.beginTransaction();
        session.delete(element);
        transaction.commit();
        return true;
    }
}
