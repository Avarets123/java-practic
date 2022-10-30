package realworld;

import java.util.List;

public interface EntityRepository<T> {
    List<T> findAll();
    List<T> findAllByAgeGreaterThan(int less);
    void save(T value);
}
