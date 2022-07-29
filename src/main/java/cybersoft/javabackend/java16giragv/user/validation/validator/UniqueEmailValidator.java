package cybersoft.javabackend.java16giragv.user.validation.validator;

import cybersoft.javabackend.java16giragv.user.model.GiraUser;
import cybersoft.javabackend.java16giragv.user.repository.GiraUserRepository;
import cybersoft.javabackend.java16giragv.user.validation.annotation.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private String message;

    @Autowired
    private GiraUserRepository repository;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {
        message = uniqueEmail.message();
    }


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Optional<GiraUser> userOpt = repository.findByEmail(email);

        if (userOpt.isEmpty()) {
            return true;
        }

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }

}
