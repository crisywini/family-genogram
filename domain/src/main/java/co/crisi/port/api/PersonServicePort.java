package co.crisi.port.api;

import co.crisi.data.PersonInfo;
import java.util.List;

public interface PersonServicePort {

    Long save(PersonInfo personInfo);

    void delete(PersonInfo personInfo);

    List<PersonInfo> findAll();

    List<PersonInfo> findOnlyMotherFamily();

    List<PersonInfo> findOnlyFatherFamily();

    Long update(Long id, PersonInfo newPersonInfo);

}
