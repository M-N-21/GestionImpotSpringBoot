package sn.isi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<APIExceptions> handleRequestException(RequestException e) {
        APIExceptions exception = new APIExceptions(e.getMessage(), e.getStatus(), LocalDateTime.now());
        return new ResponseEntity<>(exception, e.getStatus());
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<APIExceptions> handleEntityNotFoundException(EntityNotFoundException e) {
        APIExceptions exception = new APIExceptions(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<APIExceptions> handleNumberFormatException(NumberFormatException e) {
        APIExceptions exception = new APIExceptions(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIExceptions> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        APIExceptions exception = new APIExceptions("the input provided is invalid", HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = {LogiquePaiement.class})
    public ResponseEntity<APIExceptions> logiquePaiement(LogiquePaiement e) {
        APIExceptions exception = new APIExceptions(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

}