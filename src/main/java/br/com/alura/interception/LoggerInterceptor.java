package br.com.alura.interception;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolationException;

@Interceptor
@Priority(1)
@Logger
public class LoggerInterceptor {

	@AroundInvoke
	public Object treatException(InvocationContext context) throws Exception {
		java.util.logging.Logger logger = java.util.logging.Logger.getLogger(context.getTarget().getClass().getName());
		
		try {
			return context.proceed();
		} catch (Exception e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				logger.info(e.getMessage());
			} else {
				logger.severe(e.getMessage());
			}
			throw e;
		}
	}
}
