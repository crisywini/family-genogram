package co.crisi.objectmother;

import co.crisi.entity.Person;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonMother {

    public Person randomSavedWithFathers() {

        var person = new Person();
        person.setId(1L);
        person.setPersonalId(2L);
        person.setName("Aureliano");
        person.setLastName("Buendía");
        person.setMother(randomMotherSaved());
        person.setFather(randomFatherSaved());
        return person;
    }

    public Person randomMotherSaved() {
        var mother = new Person();
        mother.setId(2L);
        mother.setPersonalId(5L);
        mother.setName("Maria de Los Santos");
        mother.setLastName("Buenaventura");
        return mother;
    }

    public Person randomFatherSaved() {
        var father = new Person();
        father.setId(3L);
        father.setPersonalId(4L);
        father.setName("Arcadiano Buendia");
        father.setLastName("Buenaventura");
        return father;
    }

    public Person randomWithGreatGrandParents() {
        var person = randomSavedWithFathers();
        person.setMother(randomMotherWithParents());
        person.setFather(randomFatherWithParents());
        return person;
    }

    public Person randomMotherWithParents() {
        var mother = new Person();
        mother.setId(2L);
        mother.setPersonalId(5L);
        mother.setName("Alejandra María");
        mother.setLastName("Pulgarín");
        mother.setMother(randomMotherSaved());
        mother.setFather(randomFatherSaved());
        return mother;
    }

    public Person randomFatherWithParents() {
        var father = new Person();
        father.setId(3L);
        father.setPersonalId(4L);
        father.setMother(randomMotherSaved());
        father.setFather(randomFatherSaved());
        father.setName("Jose María");
        father.setLastName("Rubiano");
        return father;
    }

}
