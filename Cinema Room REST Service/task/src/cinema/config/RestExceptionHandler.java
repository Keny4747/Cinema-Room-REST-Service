package cinema.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ErrorDTO> handlerIndexOfBoundException(){
        ErrorDTO error = ErrorDTO.builder()
                .error("The number of a row or a column is out of bounds!")
                .build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handlerSeatAvailableException(){
        ErrorDTO error = ErrorDTO.builder()
                .error("The ticket has been already purchased!")
                .build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ErrorDTO> handlerNoTicketException(){
        ErrorDTO error = ErrorDTO.builder()
                .error("Wrong token!")
                .build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDTO> handlerWrongPassword(){
        ErrorDTO error = ErrorDTO.builder()
                .error("The password is wrong!")
                .build();
        return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }
}
