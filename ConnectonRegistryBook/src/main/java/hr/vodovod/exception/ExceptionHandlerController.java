package hr.vodovod.exception;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler({ ConstraintException.class })
	public void handleConstraintViolation(ConstraintException ex, HttpServletResponse response) {
		try {
			response.sendError(0, ex.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	
}
