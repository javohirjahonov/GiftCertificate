package uz.pdp.giftcertificate.exceptionControllerr;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.pdp.giftcertificate.exceptions.GiftPriceNotTrueException;
@ControllerAdvice
public class GiftPriceNotTrueExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = GiftPriceNotTrueException.class)
    public ResponseEntity<Object> exception(GiftPriceNotTrueException exception) {
        return new ResponseEntity<>("The price of the Gift was entered incorrectly", HttpStatus.BAD_REQUEST);
    }
}
