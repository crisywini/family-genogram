package co.crisi.port.api;

import co.crisi.data.PersonInfo;
import java.util.List;

public interface PersonServicePort {

    Long save(PersonInfo personInfo);

    void delete(Long id);

    List<PersonInfo> findAll();

    PersonInfo findOnlyMotherFamily(Long personId);

    PersonInfo findOnlyFatherFamily(Long personId);

    List<PersonInfo> findChildren(Long personId);

    List<PersonInfo> findParents(Long personId);

    Long update(Long id, PersonInfo newPersonInfo);

    PersonInfo findById(Long personId);

}
