package br.ifsp.contacts.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String,String>> handleResourceNotFoundException(ResourceNotFoundException exception){
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("erro", exception.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		Map<String, String> errorResponse = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			if(error instanceof FieldError) {
				errorResponse.put(((FieldError) error).getField(), error.getDefaultMessage());
			}
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String,String>> handleConstraintViolationException(ConstraintViolationException exception){
		Map<String, String> errorResponse = new HashMap<>();
		exception.getConstraintViolations().forEach((error) -> {
			errorResponse.put(error.getPropertyPath().toString(), error.getMessage());
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleDefaultException(Exception exception){
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("erro", "erro desconhecido. Vefique o código e trate corretamente o erro a seguir.");
		errorResponse.put("exception", exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
}

