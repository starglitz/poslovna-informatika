package pi.likvidatura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Nedovoljno sredstava na stavci izvoda")
public class NedovoljnoSredstavaException extends RuntimeException{

    public NedovoljnoSredstavaException(String message) {
        super(message);
    }
}
