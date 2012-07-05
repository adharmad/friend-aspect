package hg.examples;

import hg.annotation.Friend;

public class FriendExample {
	public FriendExample() {}
	
	@Friend(allowedCallers = ("hg.examples.FriendCaller"))
	public void doSomething() {
		System.out.println("doing something");
	}
	
	@Friend(allowedCallers = {"hg.examples.FriendCaller", "hg.examples.AnotherFriendCaller"})
	public void doSomethingElse(String s) {
		System.out.println("doing something else");
	}	
}
