package dao;

import java.util.List;

public interface Dao<T> {
    T add(T element);
    List<T> getAll();
    boolean delete(int id);
}
