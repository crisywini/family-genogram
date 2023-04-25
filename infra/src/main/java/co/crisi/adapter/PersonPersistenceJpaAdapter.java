package co.crisi.adapter;

import co.crisi.data.PersonInfo;
import co.crisi.entity.Person;
import co.crisi.exception.NoPeopleFoundToDeleteException;
import co.crisi.exception.PersonNotFoundException;
import co.crisi.mapper.PersonMapper;
import co.crisi.port.spi.PersonPersistencePort;
import co.crisi.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonPersistenceJpaAdapter implements PersonPersistencePort {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);

    @Override
    public PersonInfo save(PersonInfo personInfo) {
        var person = personMapper.mapToEntity(personInfo);
        return personMapper.mapToInfo(personRepository.save(person));
    }

    @Override
    public List<PersonInfo> findAll() {
        return personMapper.mapToInfos((List<Person>) personRepository.findAll());
    }

    @Override
    public Optional<PersonInfo> findById(Long id) {
        return personRepository.findByPersonalId(id)
                .map(personMapper::mapToInfo);
    }

    @Override
    public PersonInfo update(Long id, PersonInfo newInfo) {

        return personRepository.findByPersonalId(id)
                .map(person -> {
                    var newEntity = personMapper.mapToEntity(newInfo);
                    newEntity.setId(person.getId());
                    return save(personMapper.mapToInfo(newEntity));
                }).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public Long deleteById(Long id) {
        return personRepository.findByPersonalId(id)
                .map(person -> {
                    personRepository.deleteById(person.getId());
                    return person.getPersonalId();
                }).orElseThrow(() -> new NoPeopleFoundToDeleteException(id));
    }

    @Override
    public List<PersonInfo> findAllByFatherId(Long fatherId) {
        return personMapper.mapToInfos(personRepository.findAllByFatherPersonalId(fatherId));
    }

    @Override
    public List<PersonInfo> findAllByMotherId(Long motherId) {
        return personMapper.mapToInfos(personRepository.findAllByMotherPersonalId(motherId));
    }

}
