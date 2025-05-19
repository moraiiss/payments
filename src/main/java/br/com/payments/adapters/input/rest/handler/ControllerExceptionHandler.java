package br.com.payments.adapters.input.rest.handler;

import br.com.payments.core.domain.exceptions.BusinessException;
import br.com.payments.core.domain.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handlerIllegalArgumentException(final IllegalArgumentException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ProblemDetail handlerPersonNotFoundException(final PersonNotFoundException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ProblemDetail handlerBusinessException(final BusinessException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
