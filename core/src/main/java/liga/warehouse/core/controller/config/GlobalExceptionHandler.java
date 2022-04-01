package liga.warehouse.core.controller.config;

import liga.warehouse.core.exception.EntityNotFoundException;
import liga.warehouse.core.exception.TooLowQuantityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({TooLowQuantityException.class, EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handle(RuntimeException e) {
        Map<String, Object> body = new HashMap<>(2);
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());
        return body;
    }
}
