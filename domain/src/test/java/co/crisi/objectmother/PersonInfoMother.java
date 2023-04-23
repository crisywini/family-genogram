package co.crisi.objectmother;

import co.crisi.data.PersonInfo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonInfoMother {

    public PersonInfo randomSonWithBothParents() {
        return PersonInfo.builder()
                .name("Colonel Aureliano")
                .father(PersonInfo.builder()
                        .name("Jose Arcadio")
                        .lastName("Buendia")
                        .build())
                .mother(PersonInfo.builder()
                        .name("Ursula")
                        .lastName("Iguaran")
                        .build())
                .build();
    }

}
