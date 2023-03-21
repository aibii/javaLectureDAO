package daos;

import java.util.List;

public interface Dao<T, PK> { //defining the generic type, T - type of entity we are passing, PK - data type for the primary key
    List<T> findAll();
    T findById(PK pk);
    void insert(T item);
    Boolean update(T item);
    Boolean delete(PK pk);
}
