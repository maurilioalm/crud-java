package com.maurilioalm.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Obejto não encontrado id:" + id);
	}
}