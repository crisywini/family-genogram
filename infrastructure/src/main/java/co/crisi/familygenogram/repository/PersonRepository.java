package co.crisi.familygenogram.repository;

import co.crisi.familygenogram.entity.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person, Long> {

    Optional<Person> findByPersonalId(Long personalId);

    List<Person> findAllByFatherPersonalId(Long fatherPersonalId);

    List<Person> findAllByMotherPersonalId(Long motherPersonalId);


}
