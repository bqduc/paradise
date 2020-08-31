/**
 * 
 */
package net.ecoparadise.framework.exception;

import java.text.MessageFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author ducbq
 *
 */
public class ExceptionFactory {
  private static final Logger LOG = LogManager.getLogger(ExceptionFactory.class);

  public static TekirRuntimeException create(final Throwable cause, final ExceptionType exceptionType, final Object... messageArguments) {
      LOG.error(MessageFormat.format(exceptionType.getMessage(), messageArguments), cause);
      return new TekirRuntimeException (exceptionType, cause, messageArguments);
  }

  public static TekirRuntimeException create(final ExceptionType exceptionType, final Object... messageArguments) {
      LOG.error(MessageFormat.format(exceptionType.getMessage(), messageArguments));
      return new TekirRuntimeException(exceptionType, messageArguments);
  }
}
