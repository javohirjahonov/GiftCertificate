package uz.pdp.giftcertificate.exceptionControllerr;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.pdp.giftcertificate.exceptions.GiftNameNotTrueException;
@ControllerAdvice
public class GiftNameNotTrueController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = GiftNameNotTrueException.class)
    public ResponseEntity<Object> exception(GiftNameNotTrueException exception) {
        return new ResponseEntity<>("Name not found", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
