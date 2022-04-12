package cybersoft.javabackend.java16giragv.security.authorization;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.java16giragv.common.exception.UnauthorizedException;
import cybersoft.javabackend.java16giragv.common.util.ResponseHelper;

@RestControllerAdvice
public class AuthorizationHandler {
	private static final String MESSAGE = "You do not have permission to call this operation. Please contact admin to get suitable permission.";
	
	@ExceptionHandler(UnauthorizedException.class)
	public Object handlerUnauthorizedException () {
		return ResponseHelper.getErrorResponse(MESSAGE, HttpStatus.UNAUTHORIZED);
	}
}
