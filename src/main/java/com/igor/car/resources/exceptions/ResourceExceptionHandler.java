package com.igor.car.resources.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.igor.car.services.exceptions.DataIntegrityViolationException;
import com.igor.car.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex,
			HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"ObjectNotFound", ex.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex,
			HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Violaçao de Dados", ex.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationErros(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		ValidationError errors = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Validation Error", "Erro Na Validacao dos Campos", request.getRequestURI());

		for (FieldError x : ex.getBindingResult().getFieldErrors()) {
			errors.addError(x.getField(), x.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> constraintViolationException(ConstraintViolationException ex,
			HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Validation Error", "Cpf Invalido", request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<StandardError> transactionSystemException(TransactionSystemException ex,
			HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Validation Error", "Cpf Invalido", request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	

}
