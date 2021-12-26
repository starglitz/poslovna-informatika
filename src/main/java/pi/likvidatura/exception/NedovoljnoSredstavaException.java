package pi.likvidatura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NedovoljnoSredstavaException extends RuntimeException{

    public NedovoljnoSredstavaException(String message) {
        super(message);
    }
}
