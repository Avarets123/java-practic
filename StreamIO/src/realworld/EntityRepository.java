package realworld;

import java.util.List;

public interface EntityRepository<T> {
    List<T> findAll();
}
