package sn.isi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class APIExceptions {
    private final String message;
    private final HttpStatus status;
    private final LocalDateTime timestamp;
}
