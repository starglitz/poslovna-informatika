package pi.likvidatura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,
        reason = "Vasa verzija stavke izvoda nije up to date. Molim vas refresujte stranicu da upravljate ovom stavkom izvoda")
public class RazliciteVerzijeStavkeException extends RuntimeException {

    public RazliciteVerzijeStavkeException(String message) {
        super(message);
    }
}
