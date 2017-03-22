package io.github.bibekshakya35.ehealth.exception;

import io.github.bibekshakya35.ehealth.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * {Insert class description here}
 *
 * @author bibek
 */
@ControllerAdvice
public class ExceptionMapper {

    @ExceptionHandler(EhealthException.class)
    public ResponseEntity<Response> exceptionHandler(EhealthException ex) {
        return new ResponseEntity<>(Response.error(ex.getAppMessageType().getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
