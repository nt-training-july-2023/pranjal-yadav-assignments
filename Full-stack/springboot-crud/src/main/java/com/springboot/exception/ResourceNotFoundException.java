package com.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Object resourceName = null;
	private String resoureName;
	private String fieldName;
	private long fieldValue;
	public ResourceNotFoundException(String resoureName, String fieldName, long id) {
		super( String.format( "%s not found with %s: '%s' ", resourceName, fieldName, id ));
		this.resoureName = resoureName;
		this.fieldName = fieldName;
		this.fieldValue =  id;
	}
	
	public void ResourceNotFoundException1(String resoureName2, String fieldName2, long id) {
		// TODO Auto-generated constructor stub
	}

	public String getResoureName() {
		return resoureName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public long getFieldValue() {
		return fieldValue;
	}
}
