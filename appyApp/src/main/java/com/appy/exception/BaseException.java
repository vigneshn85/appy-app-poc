package com.appy.exception;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.support.PropertiesLoaderUtils;

//TODO: Should be renamed as Error Response
public class BaseException {

	Logger LOGGER = Logger.getLogger(BaseException.class);
	private ExceptionCodes code;
	private String message;
	private static Properties messages;
	
	public BaseException(){
		super();
		try{
			if(messages == null)
				messages = PropertiesLoaderUtils.loadAllProperties("messages_en_US.properties"); //TODO: Internationalization
		}catch(IOException io){
			LOGGER.error("messages_en_US.properties not found in classpath", io);			
		}
	}

	public BaseException(ExceptionCodes code) {
		this();
		this.code = code;
		LOGGER.debug("Code:" + code.name());
		LOGGER.debug("message:" + messages.getProperty(code.name()));
		this.message = messages.getProperty(code.name());
	}

	public ExceptionCodes getCode() {
		return code;
	}

	public void setCode(ExceptionCodes code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return "[code: "+ this.code.name() + ", Message:" + this.message + "]";
	}
	
}
