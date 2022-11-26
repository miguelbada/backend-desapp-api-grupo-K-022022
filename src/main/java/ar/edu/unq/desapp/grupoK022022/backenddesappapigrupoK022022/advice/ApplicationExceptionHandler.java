package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.exception.EmailAlreadyUsedException;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.exception.PublishedPriceNotAllowed;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handlerInvalidArgument(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmailAlreadyUsedException.class)
	public Map<String, String> handleBusinessException(EmailAlreadyUsedException exception){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UsernameNotFoundException.class)
	public Map<String, String> handleBusinessException(UsernameNotFoundException exception){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PublishedPriceNotAllowed.class)
	public Map<String, String> handleBusinessException(PublishedPriceNotAllowed exception){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NoSuchElementException.class)
	public Map<String, String> handlerInvalidArgument(NoSuchElementException exception){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", "published cryptoactive is not allowed");
		return errorMap;
	}
	
}
