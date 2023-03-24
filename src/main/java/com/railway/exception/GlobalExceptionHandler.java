package com.railway.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.railway.util.AppResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<AppResponse> resourceNotFoundException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		AppResponse response = new AppResponse(message, false);
		return new ResponseEntity<AppResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<>();
		List<FieldError> list = ex.getBindingResult().getFieldErrors();
		for (FieldError error : list) {
			map.put(error.getField(), error.getDefaultMessage());
		}
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<AppResponse> constraintViolationException(ConstraintViolationException ex) {
		// String message = ex.getMessage();
		AppResponse response = new AppResponse("not a valid input", false);
		return new ResponseEntity<AppResponse>(response, HttpStatus.NOT_FOUND);
	}

}
