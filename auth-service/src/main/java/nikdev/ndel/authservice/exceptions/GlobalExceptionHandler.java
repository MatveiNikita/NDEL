package nikdev.ndel.authservice.exceptions;

import nikdev.ndel.authservice.exceptions.reponses.OutExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<OutExceptionResponse> handleResponseStatusException(ResponseStatusException exception){
        OutExceptionResponse response = new OutExceptionResponse(exception.getReason());
        return ResponseEntity.status(exception.getStatusCode()).body(response);
    }
}
