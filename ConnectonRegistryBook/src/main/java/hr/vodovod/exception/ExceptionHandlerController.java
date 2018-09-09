package hr.vodovod.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler({ ConstraintViolationException.class })
	public void handleConstraintViolation(
	  ConstraintViolationException ex, WebRequest request) {
      System.out.println(ex.getConstraintName().contains("REGISTRY_BOOK_MUNICIPALITY_UNIQUE"));
	}
}
