package cinema.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ErrorDTO> handlerIndexOfBoundException(){
        ErrorDTO error = ErrorDTO.builder()
                .error("The number of a row or a column is out of bounds!")
                .build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
