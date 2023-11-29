package sn.isi.exception;

import lombok.AllArgsConstructor; 
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.http.HttpStatus;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class LogiquePaiement extends RuntimeException {
    private final String message;
    private final HttpStatus status;
}
