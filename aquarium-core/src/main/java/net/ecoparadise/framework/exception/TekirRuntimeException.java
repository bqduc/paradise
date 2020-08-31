/*
 * Copyleft 2007-2011 Ozgur Yazilim A.S.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 * http://www.gnu.org/licenses/lgpl.html
 *
 * www.tekir.com.tr
 * www.ozguryazilim.com.tr
 *
 */

package net.ecoparadise.framework.exception;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;

/**
 * @author ducbq
 *
 */
public class TekirRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ExceptionType exceptionType;

	public TekirRuntimeException(String message) {
		super(message);
		this.exceptionType = ExceptionType.HTTP_INTERNAL_SERVER_ERROR;
	}

	public TekirRuntimeException(Throwable cause) {
		super(cause);
		this.exceptionType = ExceptionType.HTTP_INTERNAL_SERVER_ERROR;
	}

	public TekirRuntimeException(ExceptionType exceptionType, Object... messageArguments) {
		super(MessageFormat.format(exceptionType.getMessage(), messageArguments));
		this.exceptionType = exceptionType;
	}

	public TekirRuntimeException(ExceptionType exceptionType, final Throwable cause, Object... messageArguments) {
		super(MessageFormat.format(exceptionType.getMessage(), messageArguments), cause);
		this.exceptionType = exceptionType;
	}

	public HttpStatus getHttpStatus() {
		return exceptionType.getStatus();
	}

	public ExceptionType getExceptionType() {
		return exceptionType;
	}
}
