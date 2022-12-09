package com.andela.assignment.ais.adaptor.api.exception;

import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.andela.assignment.ais.usecase.service.exception.LandPlotNotCapturedException;
import com.andela.assignment.ais.usecase.service.exception.LandPlotNotFoundException;

@ControllerAdvice
public class LandPlotApiExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> landPlotNotFoundHandler(LandPlotNotFoundException ex,
			HttpServletRequest req) {

		CustomErrorResponse error = new CustomErrorResponse(ZonedDateTime.now(), HttpStatus.NOT_FOUND.value(),
				req.getRequestURI(), ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> landPlotNotCreatedHandler(LandPlotNotCapturedException ex,
			HttpServletRequest req) {

		CustomErrorResponse error = new CustomErrorResponse(ZonedDateTime.now(), HttpStatus.NOT_MODIFIED.value(),
				req.getRequestURI(), ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> genericHandler(Exception ex, HttpServletRequest req) {
		CustomErrorResponse error = new CustomErrorResponse(ZonedDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				req.getRequestURI(), ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
