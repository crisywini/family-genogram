package co.crisi.familygenogram.data;

import java.time.LocalDate;
import java.util.Objects;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonInfo {


    private Long id;

    private PersonInfo father;

    private PersonInfo mother;

    private String name;

    private String lastName;

    private LocalDate birthDate;


    public String getLastNameFromParents() {
        var lastNameFromParents = "";
        if (Objects.nonNull(father) && Objects.nonNull(father.getLastName())) {
            lastNameFromParents += father.getLastName();
        }
        if (Objects.nonNull(mother) && Objects.nonNull(mother.getLastName())) {
            lastNameFromParents += " " + mother.getLastName();
        }
        return lastNameFromParents;
    }


}
