package co.crisi.service;

import co.crisi.exception.NoPeopleFoundToDeleteException;
import co.crisi.exception.PersonNotFoundException;
import co.crisi.data.PersonInfo;
import co.crisi.exception.ParentNotFoundException;
import co.crisi.port.api.PersonServicePort;
import co.crisi.port.spi.PersonPersistencePort;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.val;

@AllArgsConstructor
public class PersonServicePortImpl implements PersonServicePort {

    private PersonPersistencePort personPersistencePort;

    @Override
    public Long save(PersonInfo personInfo) {
        return personPersistencePort.save(personInfo)
                .getPersonalId();
    }

    @Override
    public void delete(Long id) {
        val eliminatedRows = personPersistencePort.deleteById(id);
        if (eliminatedRows == 0) {
            throw new NoPeopleFoundToDeleteException(id);
        }
    }

    @Override
    public List<PersonInfo> findAll() {
        return personPersistencePort.findAll();
    }

    @Override
    public PersonInfo findOnlyMotherFamily(Long personId) {
        return Optional.ofNullable(findById(personId))
                .map(PersonInfo::getMother)
                .orElseThrow(
                        () -> new ParentNotFoundException(String.format("The mother of %d was not found", personId)));
    }

    @Override
    public PersonInfo findOnlyFatherFamily(Long personId) {
        return Optional.ofNullable(findById(personId))
                .map(PersonInfo::getFather)
                .orElseThrow(
                        () -> new ParentNotFoundException(String.format("The father of %d was not found", personId)));
    }

    @Override
    public List<PersonInfo> findChildren(Long personId) {
        var children = personPersistencePort.findAllByMotherId(personId);
        children.addAll(personPersistencePort.findAllByFatherId(personId));
        return children;
    }

    @Override
    public List<PersonInfo> findParents(Long personId) {
        val person = findById(personId);
        var parents = new ArrayList<PersonInfo>();
        if (Objects.nonNull(person.getMother())) {
            parents.add(person.getMother());
        } else if (Objects.nonNull(person.getFather())) {
            parents.add(person.getFather());
        }
        return parents;
    }

    @Override
    public Long update(Long id, PersonInfo newPersonInfo) {
        return personPersistencePort.update(id, newPersonInfo).getPersonalId();
    }

    @Override
    public PersonInfo findById(Long personId) {
        return personPersistencePort.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));
    }


}
