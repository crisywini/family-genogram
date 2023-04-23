package co.crisi.data;

import co.crisi.objectmother.PersonInfoMother;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonInfoTest {


    @Test
    void testCreatePersonWithBothParents_shouldGetCorrectLastNameFromThem() {

        val colonelAureliano = PersonInfoMother.randomSonWithBothParents();

        val lastNameFromParents = colonelAureliano.getLastNameFromParents();

        assertThat(lastNameFromParents)
                .isNotNull()
                .isEqualTo("Buendia Iguaran");

    }


}