package co.crisi.exception;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long personId) {
        super(String.format("The person with id %d was not found", personId));
    }

}
