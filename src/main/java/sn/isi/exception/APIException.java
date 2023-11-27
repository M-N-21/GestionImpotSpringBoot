package sn.isi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIException {
    private final String message;
    private final HttpStatus status;
    private final LocalDateTime timestamp;
}
