package sn.isi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {
     private final String message;
}
