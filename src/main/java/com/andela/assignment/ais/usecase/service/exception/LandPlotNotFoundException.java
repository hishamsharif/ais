package com.andela.assignment.ais.usecase.service.exception;

public class LandPlotNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LandPlotNotFoundException(String message) {
		super(message);
	}

}