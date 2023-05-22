package uz.pdp.giftcertificate.exceptionControllerr;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.pdp.giftcertificate.exceptions.GiftNotFoundException;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GiftExceptionController extends ResponseEntityExceptionHandler {
//    @ExceptionHandler({AccessDeniedException.class})
//    public ResponseEntity<Object> handleAccessDeniedException(
//            Exception ex, WebRequest request
//    ) {
//        return new ResponseEntity<Object>(
//                "Access Denied", new HttpHeaders(), HttpStatus.NOT_FOUND
//        );
//    }


//    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
//    protected ResponseEntity<Object> handleConflict(
//            RuntimeException exception, WebRequest request
//    ) {
//        String bodyOfResponse = "Access denied";
//        return handleExceptionInternal(exception, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//    }

    @ExceptionHandler(value = GiftNotFoundException.class)
    public ResponseEntity<Object> exception(GiftNotFoundException exception) {
        return new ResponseEntity<>("Gift Not Found", HttpStatus.NOT_FOUND);
    }
}
