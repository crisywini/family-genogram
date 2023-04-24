package co.crisi.familygenogram.port.spi;

import java.util.List;
import java.util.Optional;

public interface BasePersistencePort<T, S> {

    T save(T entity);

    List<T> findAll();

    Optional<T> findById(S id);

    T update(S id, T newInfo);

    Long deleteById(S id);

}
