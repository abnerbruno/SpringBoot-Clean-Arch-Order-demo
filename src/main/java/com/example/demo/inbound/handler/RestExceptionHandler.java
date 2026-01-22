package com.example.demo.inbound.handler;


import com.example.demo.core.exceptions.DomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ResponseWithMessage> handlerDomainException(DomainException domainException) {
        log.error("Erro Domain : {}", domainException.getMessage());
        ResponseWithMessage responseWithMessage = new ResponseWithMessage(domainException);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseWithMessage);
    }

    @ExceptionHandler
    protected ResponseEntity<ResponseWithMessage> handleAnything(Exception exception) {
        log.error("Ocorreu um erro interno do servidor", exception);
        String message = "Ocorreu um erro interno do servidor ao processar a solicitação. Tente novamente mais tarde.";
        ResponseWithMessage responseWithMessage = ResponseWithMessage.builder().code("ERROR_001").message(message)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseWithMessage);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ResponseWithMessage> handleMessageNotReadable(
            HttpMessageNotReadableException notReadableException) {
        String message = "Não foi possível realizar a solicitação devido a um ou mais erros de sintaxe. Verifique a documentação da API, Corrija os erros e tente novamente.";
        ResponseWithMessage responseWithMessage = ResponseWithMessage.builder().code("HMNRXE-001").message(message)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseWithMessage);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<Void> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException notSupportedException) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
}
