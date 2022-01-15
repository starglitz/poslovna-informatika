package pi.likvidatura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Neispravan iznos")
public class NeispravanIznosException extends RuntimeException{

    public NeispravanIznosException(String message) {
        super(message);
    }
}
