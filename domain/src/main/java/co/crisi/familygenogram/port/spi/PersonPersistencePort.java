package co.crisi.familygenogram.port.spi;

import co.crisi.familygenogram.data.PersonInfo;
import java.util.List;

public interface PersonPersistencePort extends BasePersistencePort<PersonInfo, Long> {


    List<PersonInfo> findAllByFatherId(Long fatherId);

    List<PersonInfo> findAllByMotherId(Long motherId);

}
