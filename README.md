Implementing a c++ friend like functionality for java.

Many-a-times in a large java project, which is not well-designed 
to begin with, one component would like to invoke some code from
another component. However, since the code will be exposed via
a public method, the target component would like to prevent anyone 
else from invoking the same piece of code. 

How to achieve this?

A sample implementation is in the current project, Using AspectJ 
and introducing a new annotation. Any method can be annotated with
the @Friend annotation, specifying who the caller classes can be
at compile time. The associated aspect has advice that will check
if the caller is actually in the list of allowed callers for 
that method and throw a RuntimeException if that is not the case.

Using this is as simple as:
 	@Friend(callers = ("test.TestCaller"))
 	public void foo() {
 
 	}
   
The above code means that only code from the class "test.TestCaller"
can invoke the foo() method. If other methods try to invoke the 
foo() method, a RuntimeException is thrown.

More features:
1. Allow indirect (i.e. via reflection) calls in addition to direct
   calls to the method
2. Friend packages
3. Friend methods

 