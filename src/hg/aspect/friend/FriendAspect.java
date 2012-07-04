package hg.aspect.friend;

import hg.annotation.Friend;
import hg.annotation.NotFriendException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class FriendAspect {
	public static final String CALLERS = "callers";

	@Pointcut("execution(@hg.annotation.Friend * *(..))")
	public void checkFriend() {
	}

	@Before("checkFriend()")
	public void checkFriendAdvice(JoinPoint joinPoint) {
		Set<String> allowedCallers = new HashSet<>();
		
		Signature signature = joinPoint.getSignature();
		Method m = ((MethodSignature)signature).getMethod();

		Annotation[] annotations = m.getAnnotations();

		String[] val = null;
		boolean hasFriendAnnotation = false; // not required really
		for (int i=0 ; i<annotations.length ; i++) {
			Annotation a = annotations[i];
			
			if (a instanceof Friend) {
				hasFriendAnnotation = true;
				
				try {
					val = (String[])a.annotationType().getMethod("callers").invoke(a);
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
		
		// If the callers value is null or empty
		if (!hasFriendAnnotation || (val == null) || ((val != null) && (val.length == 0))) {
			throw new NotFriendException();
		}

		for (int i=0 ; i<val.length ; i++) {
			allowedCallers.add(val[i]);
		}
		
		String actualCallerClass = Thread.currentThread().getStackTrace()[3].getClassName();

		if (!allowedCallers.contains(actualCallerClass)) {
			throw new NotFriendException();
		}
		
		// allow pass through
		
	}
	
}
