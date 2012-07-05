## Friend Aspect

Implementing a c++ friend like functionality for java.

Many-a-times in a large java project, which is not well-designed to 
begin with, one component would like to invoke some code from another 
component. However, since the code will be exposed via a public method, 
the target component would like to control access to this method and 
prevent other callers from invoking the same piece of code. 

How to achieve this?

A sample implementation is in the current project, Using AspectJ and 
a custom annotation. Any method can be annotated with the @Friend, the
custom annotation, specifying who the caller classes can be at compile 
time. The associated aspect has advice that will check if the caller 
is actually in the list of allowed callers for that method and throw 
a RuntimeException if that is not the case.

Using this is as simple as:

<pre>
@Friend(callers = ("test.TestCaller"))
public void foo() {

}
</pre>

The above code means that only code from the class "test.TestCaller"
can invoke the foo() method. If other methods try to invoke the 
foo() method, a RuntimeException is thrown.

#To Do
* Allow indirect (i.e. via reflection) calls in addition to direct calls to the method
* Friend packages
* Friend methods

 
