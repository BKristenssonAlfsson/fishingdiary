package se.njord.fishingdiary.exception;

public class DuplicateException extends Exception {
    public DuplicateException(String errorMessage) {
        super(errorMessage);
    }
}
