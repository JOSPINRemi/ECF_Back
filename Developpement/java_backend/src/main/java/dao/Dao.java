package dao;

import java.util.List;

public interface Dao<T> {
    boolean create(T element);
    T findById(int id);
    List<T> findAll();
    boolean update(T element);
    boolean delete(T element);
}
