
// GlobalExceptionHandler.java
package bj.formation.demoprojet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        ValidationErrorResponse response = new ValidationErrorResponse();
        response.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        response.setStatus(HttpStatus.BAD_REQUEST.value());

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            response.getErrors().add(
                    new ValidationErrorResponse.ValidationError(
                            error.getField(),
                            error.getDefaultMessage()
                    )
            );
        });

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}