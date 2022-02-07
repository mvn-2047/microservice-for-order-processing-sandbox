package mvn.sandbox.order.regular.exception;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class OrderControllerAdvice {

    @ExceptionHandler(value = {InvalidClientException.class})
    public ResponseEntity<ErrorMessage> invalidClientException(InvalidClientException e, WebRequest request) {
        ErrorMessage message = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
