package cybersoft.javabackend.java16giragv.security.authorization;

import cybersoft.javabackend.java16giragv.common.exception.UnauthorizedException;
import cybersoft.javabackend.java16giragv.role.repository.GiraProgramRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Aspect
public class AuthorizationAspect {
	/* define a pointcut
	
	@Pointcut("within(cybersoft.javabackend.java16giragv.role.controller.*)")
	public void withinPointcut () {};
	
	@Pointcut("execution(public cybersoft.javabackend.java16giragv.role.controller.GiraGroupController.*(..))")
	public void executionPointcut () {};
	
	@Pointcut("@annotation(cybersoft.javabackend.java16giragv.security.authorization.GiraProgram)")
	public void annotationPointcut () {};
	
	@Before("annotationPointcut()")
	public void beforeAdvice (JoinPoint point) {
		
	}
	
	@After("withinPointcut()")
	public void afterAdvice (JoinPoint point) {
		
	}
	
	@Around("executionPointcut()")
	public void aroundAdvice (ProceedingJoinPoint point) {
		
	}
	*/

    @Autowired
    private GiraProgramRepository programRepository;

    @Before("@annotation(giraProgram)")
    public void programAuthorizer(GiraProgram giraProgram) {
        log.info("=================================================================");
        log.info("AOP: Gira Program " + giraProgram.value() + " has been called.");
        log.info("=================================================================");
        String programName = giraProgram.value();
        String username = getCurrentUsername();

        boolean isAuthorized = checkPermission(programName, username);

        if (!isAuthorized)
            throw new UnauthorizedException();
    }

    @After("@annotation(giraProgram)")
    public void afterAuthorized(GiraProgram giraProgram) {
        log.info("=================================================================");
        log.info("AOP: Gira Program " + giraProgram.value() + " has been ended.");
        log.info("=================================================================");
    }

    private boolean checkPermission(String programName, String username) {
        List<cybersoft.javabackend.java16giragv.role.model.GiraProgram> programs = programRepository.findProgramByNameAndUsername(programName, username);
        return !programs.isEmpty();
    }

    private String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) {
            return null;
        }

        if (auth.getPrincipal() instanceof String principal) {
            return principal;
        }

        UserDetails currentAuditor = (UserDetails) auth.getPrincipal();
        return currentAuditor.getUsername();
    }
}
