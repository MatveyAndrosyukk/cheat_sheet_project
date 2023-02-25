package project_structure.exceptions;

public class SessionManagerException extends RuntimeException{
    public SessionManagerException(String message){
        super(message);
    }
    public SessionManagerException(Exception exception){
        super(exception);
    }
}
