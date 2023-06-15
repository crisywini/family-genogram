package co.crisi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonInfo {


    private Long personalId;

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
