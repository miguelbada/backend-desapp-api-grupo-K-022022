package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
