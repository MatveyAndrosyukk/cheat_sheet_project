package project_structure.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OperationFailedException extends RuntimeException{
    @Serial
    private final static long serialVersionUID = 1L;

    public OperationFailedException(String message){
        super(message);
    }
}
