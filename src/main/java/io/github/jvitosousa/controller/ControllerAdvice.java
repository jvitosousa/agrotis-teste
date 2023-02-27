package io.github.jvitosousa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.jvitosousa.controller.error.ApiErro;
import io.github.jvitosousa.exception.RegraDeNegocioException;

@RestControllerAdvice
public class ControllerAdvice {

	
	@ExceptionHandler(RegraDeNegocioException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiErro handleRegraDeNegocioException(RegraDeNegocioException ex) {
		String message = ex.getMessage();
		return new ApiErro(message);
	}
}
