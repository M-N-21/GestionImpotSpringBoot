package sn.isi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class RequestException extends RuntimeException {
    private final String message;
    private final HttpStatus status;
}
