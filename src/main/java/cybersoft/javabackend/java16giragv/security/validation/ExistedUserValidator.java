package cybersoft.javabackend.java16giragv.security.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java16giragv.user.model.GiraUser;
import cybersoft.javabackend.java16giragv.user.repository.GiraUserRepository;

public class ExistedUserValidator implements ConstraintValidator<ExistedUser, String> {
	private String message;
	
	@Autowired
	private GiraUserRepository repository;
	
	@Override
	public void initialize(ExistedUser existedUser) {
		message = existedUser.message();
	}
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(username == null)
			return false;
		
		Optional<GiraUser> userOpt = repository.findByUsername(username);
		
		if(userOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		return false;
	}
}
