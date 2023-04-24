package co.crisi.familygenogram.exception;

public class NoPeopleFoundToDeleteException extends RuntimeException {


    public NoPeopleFoundToDeleteException(Long id) {
        super(String.format("The person with id %d was not found!", id));
    }

}
