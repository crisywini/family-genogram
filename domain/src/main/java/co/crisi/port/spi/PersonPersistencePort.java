package co.crisi.port.spi;

import co.crisi.data.PersonInfo;
import java.util.List;

public interface PersonPersistencePort extends BasePersistencePort<PersonInfo, Long> {


    List<PersonInfo> findAllByFatherId(Long fatherId);

    List<PersonInfo> findAllByMotherId(Long motherId);

}
