package org.cafe.commons.exceptions.handler;

import lombok.extern.slf4j.Slf4j;
import org.cafe.commons.exceptions.ApiBusinessException;
import org.cafe.commons.exceptions.ApiValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@Component
@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    List<String> handle(ApiValidationException e) {
        log.error("ApiValidationException", e.getMessage());
        return  e.getMessages();
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    List<String> handle(ApiBusinessException e) {
        log.error("ApiBusinessException", e.getMessage());
        return List.of(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    List<String> handle(Exception e) {
        log.error("System Exception", e.getMessage());
        return List.of(e.getMessage());
    }

}
