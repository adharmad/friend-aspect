package hg.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * "Friend" Annotation. 
 * Can be attached to methods and can specify on a per-method basis 
 * who the callers of the method can be.
 * 
 * Example:
 *  @Friend(callers = ("test.TestCaller"))
 * 	public void foo() {
 * 
 *  }
 *  
 * The above code means that only code from the class "test.TestCaller"
 * can invoke the foo() method.
 * If other methods try to invoke the foo() method, a RuntimeException is thrown
 * 
 * @author adharmad
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Friend {
	String[] allowedCallers();
}
