package pi.likvidatura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Izabrana faktura je vec zatvorena")
public class FakturaVecZatvorenaException extends RuntimeException{
    public FakturaVecZatvorenaException(String message) {
        super(message);
    }
}
