package it.project.invoice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ElementAlreadyPresentException.class)
	public ResponseEntity entityAlreadyFound(ElementAlreadyPresentException ex) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
