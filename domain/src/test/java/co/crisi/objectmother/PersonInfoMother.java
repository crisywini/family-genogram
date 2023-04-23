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

    public PersonInfo randomSonWithGrandParents() {
        return PersonInfo.builder()
                .name("Colonel Aureliano")
                .father(PersonInfo.builder()
                        .name("Jose Arcadio")
                        .lastName("Buendia")
                        .father(randomFatherFather())
                        .mother(randomMotherFather())
                        .build())
                .mother(PersonInfo.builder()
                        .name("Ursula")
                        .lastName("Iguaran")
                        .father(randomFatherMother())
                        .mother(randomMotherMother())
                        .build())
                .build();
    }

    public PersonInfo randomFatherFather() {
        return PersonInfo.builder()
                .name("Arcadiano")
                .lastName("Buendia")
                .build();
    }

    public PersonInfo randomMotherFather() {
        return PersonInfo.builder()
                .name("Maria de los Santos")
                .lastName("Buenaventura")
                .build();
    }

    public PersonInfo randomFatherMother() {
        return PersonInfo.builder()
                .name("Neftaly")
                .lastName("Iguarán")
                .build();
    }

    public PersonInfo randomMotherMother() {
        return PersonInfo.builder()
                .name("Nicolasa")
                .lastName("Carabalí")
                .build();
    }


}
