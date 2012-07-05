package hg.annotation;

/**
 * Exception thrown when disallowed codebase attempts to
 * access a method that has a @Friend annotation
 * 
 * @author adharmad
 *
 */
public class NotFriendException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
