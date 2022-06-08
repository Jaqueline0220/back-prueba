package com.diaz.prueba.model;

import java.util.List;

public class ResultModel<T> {
	Integer Codigo;
	Boolean IsSuccess;
	String Message;
	String MessageExeption;
	String StackTrace;
	String InnerException;
	String Informacion;
	List<T> data;
	

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public ResultModel() {
	}

	public ResultModel(Integer codigo, Boolean isSuccess, String message, String messageExeption, String stackTrace,
			String innerException, String informacion) {
		super();
		Codigo = codigo;
		IsSuccess = isSuccess;
		Message = message;
		MessageExeption = messageExeption;
		StackTrace = stackTrace;
		InnerException = innerException;
		Informacion = informacion;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public Boolean getIsSuccess() {
		return IsSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		IsSuccess = isSuccess;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getMessageExeption() {
		return MessageExeption;
	}

	public void setMessageExeption(String messageExeption) {
		MessageExeption = messageExeption;
	}

	public String getStackTrace() {
		return StackTrace;
	}

	public void setStackTrace(String stackTrace) {
		StackTrace = stackTrace;
	}

	public String getInnerException() {
		return InnerException;
	}

	public void setInnerException(String innerException) {
		InnerException = innerException;
	}

	public String getInformacion() {
		return Informacion;
	}

	public void setInformacion(String informacion) {
		Informacion = informacion;
	}

}
