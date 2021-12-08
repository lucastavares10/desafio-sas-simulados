package com.sas.desafio.exception;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sas.desafio.util.Erro;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request) {

		List<Erro> erros = getExceptionMessages(ex.toString(), "recurso.nao-encontrado");

		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {

		List<Erro> erros = getExceptionMessages(ex.toString(), "recurso.nao-encontrado");

		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

		List<Erro> erros = getExceptionMessages(ex.toString(), "recurso.incorreto");

		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> erros = getExceptionMessages(ex.toString(), "recurso.nao-encontrado");

		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

//	@Override
//	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//		List<Erro> erros = getExceptionMessages(ex.toString(), "recurso.nao-encontrado");
//
//		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//	}

	private List<Erro> getExceptionMessages(String ex, String message) {

		String mensagemUsuario = messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();

		return Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
	}

}
